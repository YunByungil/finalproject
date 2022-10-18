package joa.pay.model;

import org.mybatis.spring.SqlSessionTemplate;

public class JoaPayDAOImple implements JoaPayDAO {

	private SqlSessionTemplate sqlMap;

	public JoaPayDAOImple (SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
}
