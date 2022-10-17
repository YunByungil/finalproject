package joa.review.model;

import java.util.List;

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
	public List<JoaReviewDTO> commentList() {
		List<JoaReviewDTO> list=sqlMap.selectList("commentList");
		return list;
	}

}
