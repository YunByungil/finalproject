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
		sqlMap.delete("deleteLike2", map);
		updateScore((String)map.get("lik_movie_title"));
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
		int result=sqlMap.selectOne("checkLike", map);
		int result2=0;
		if(result==0) {
			sqlMap.update("addLike", rev_idx);
			sqlMap.insert("insertLike", map);
			result2=1;
		}else {
			sqlMap.update("remLike", rev_idx);
			sqlMap.delete("deleteLike", map);
			result2=-1;
		}
		return result2;
	}
	@Override
	public List<JoaLikeDTO> likes(Map map) {
		List<JoaLikeDTO> list=sqlMap.selectList("likes", map);
		return list;
	}
	@Override
	public int checkId(Map map) {
		int result=sqlMap.selectOne("checkId", map);
		return result;
	}
}
