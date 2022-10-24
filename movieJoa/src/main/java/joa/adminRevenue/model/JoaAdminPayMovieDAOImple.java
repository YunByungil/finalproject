package joa.adminRevenue.model;

import org.mybatis.spring.SqlSessionTemplate;

public class JoaAdminPayMovieDAOImple implements JoaAdminPayMovieDAO {

	private SqlSessionTemplate sqlMap;

	public JoaAdminPayMovieDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	@Override
	public int nowMonthMovieRevenue() {
		int nowMonthRevenue=sqlMap.selectOne("nowMonthMovieRevenueQuery");
		return nowMonthRevenue;
	}
	@Override
	public int nowYear() {
		int nowYear=sqlMap.selectOne("nowYearQuery");
		return nowYear;
	}
	@Override
	public int nowMonth() {
		int nowMonth=sqlMap.selectOne("nowMonthQuery");
		return nowMonth;
	}
	@Override
	public int nowMonthSpectator() {
		int nowMonthSpectator=sqlMap.selectOne("nowMonthSpectatorQuery");
		return nowMonthSpectator;
	}
}
