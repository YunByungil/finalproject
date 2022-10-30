package joa.adminRevenue.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminMem.model.JoaAdminMemberDTO;
import joa.adminMovie.model.AdminMovieDTO;

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
	@Override
	public int mangender() {
		int mangender=sqlMap.selectOne("mangenderQuery");
		return mangender;
	}
	@Override
	public int allgender() {
		int allgender=sqlMap.selectOne("allgenderQuery");
		return allgender;
	}
	@Override
	public int[] payAgeCount() {
		int arr[]=new int[5];
		for(int i=0; i<5; i++) {
			int result=sqlMap.selectOne("payAgeQuery"+(i+1));
			arr[i]=result;
		}
		return arr;
	}
	@Override
	public String nowMonthBestMovie() {
		String nowMonthBestMovie=sqlMap.selectOne("nowMonthBestMovieQuery");
		return nowMonthBestMovie;
	}
	@Override
	public List<JoaAdminMemberDTO> revenueShop() {
		List<JoaAdminMemberDTO> list=sqlMap.selectList("revenueShopQuery");
		return list;
	}
	@Override
	public int revenueShopMoney(String paymov_the_branch ) {
		int result=sqlMap.selectOne("revenueShopMoneyQuery",paymov_the_branch );
		return result;
	}
	@Override
	public List<AdminMovieDTO> revenueMovie() {
		List<AdminMovieDTO> list=sqlMap.selectList("revenueMovieQuery");
		return list;
	}
	@Override
	public int revenueMovieMoney(String mov_title) {
		int result=sqlMap.selectOne("revenueMovieMoneyQuery", mov_title);
		return result;
	}
	@Override
	public List<JoaAdminPayMovieDTO> revenueShopDetail(String paymov_the_branch) {
		List<JoaAdminPayMovieDTO> list=sqlMap.selectList("revenueShopDetailQuery", paymov_the_branch);
		return list;
	}
	@Override
	public List<JoaAdminPayMovieDTO> revenunMovieDetail(String paymov_mov_title) {
		List<JoaAdminPayMovieDTO> list=sqlMap.selectList("revenueMovieDetailQuery", paymov_mov_title);
		return list;
	}
	@Override
	public int movieSpectatorCount(String mov_title) {
		int result=sqlMap.selectOne("movieSpectatorCountQuery", mov_title);
		return result;
	}
}
