package joa.review.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

import joa.movie.model.JoaMovieDTO;

public class JoaReviewDAOImple implements JoaReviewDAO {

	private SqlSessionTemplate sqlMap;
	
	public JoaReviewDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public int commentWrite(JoaReviewDTO dto) {
		int result=sqlMap.insert("commentWrite", dto);
		updateScore(dto.rev_movie_title);
		return result;
	}@Override
	public List<JoaReviewDTO> commentList(int ot, Map map) {
		List<JoaReviewDTO> list=null;
		if(ot==0) {
			list=sqlMap.selectList("commentList0", map);
		}else {
			list=sqlMap.selectList("commentList1", map);
		}
		return list;
	}
	@Override
	public List<JoaReviewDTO> updateList(Map map) {
		List<JoaReviewDTO> list=sqlMap.selectList("commentUpdateList", map);
		return list;
	}
	@Override
	public int commentUpdate(JoaReviewDTO dto) {
		int result=sqlMap.update("commentUpdate", dto);
		updateScore(dto.rev_movie_title);
		return result;
	}
	@Override
	public int commentDelete(Map map) {
		int result=sqlMap.delete("commentDelete", map);
		updateScore((String)map.get("rev_movie_title"));
		return result;
	}
	@Override
	public int totalCnt(int mov_idx) {
		int result=sqlMap.selectOne("totalCnt", mov_idx);
		return result;
	}
	@Override
	public void updateScore(String rev_movie_title) {
		sqlMap.update("updateScore", rev_movie_title);
	}
	@Override
	public int addLike(int rev_idx, Map map) {
		int checkLike(map);
		int result=sqlMap.update("addLike", rev_idx);
		return result;
	}
	public int checkLike(Map map) {
		int result=sqlMap.selectOne("checkLike", map);
		System.out.println(result);
		return result;
	}
}
