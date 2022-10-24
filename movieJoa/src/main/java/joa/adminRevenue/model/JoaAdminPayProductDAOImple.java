package joa.adminRevenue.model;

import org.mybatis.spring.SqlSessionTemplate;

public class JoaAdminPayProductDAOImple implements JoaAdminPayProductDAO {

	private SqlSessionTemplate sqlMap;

	public JoaAdminPayProductDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	@Override
	public int nowMonthProductRevenue() {
		int nowMonthProductRevenue=sqlMap.selectOne("nowMonthProductRevenueQuery");
		return nowMonthProductRevenue;
	}
	
}
