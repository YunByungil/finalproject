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
		return result;
	}@Override
	public List<JoaReviewDTO> commentList(int ot) {
		List<JoaReviewDTO> list=null;
		if(ot==0) {
			list=sqlMap.selectList("commentList0");
		}else {
			list=sqlMap.selectList("commentList1");
		}
		return list;
	}
	@Override
	public List<JoaReviewDTO> updateList(Map map) {
		List<JoaReviewDTO> list=sqlMap.selectList("commentUpdateList", map);
		return list;
	}
	@Override
	public int commentDelete(Map map) {
		int result=sqlMap.delete("commentDelete", map);
		return result;
	}
}
