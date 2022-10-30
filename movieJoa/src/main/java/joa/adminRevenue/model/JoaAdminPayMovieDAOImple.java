package joa.adminRevenue.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminMem.model.JoaAdminMemberDTO;
import joa.adminMovie.model.AdminMovieDTO;
import joa.member.model.JoaMemberDTO;

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
	@Override
	public int pagingShopCount(String paymov_the_branch) {
		int result=sqlMap.selectOne("pagingShopCountQuery",paymov_the_branch);
		return result;
	}
	@Override
	public List<JoaAdminPayMovieDTO> pagingShopSelect(String paymov_the_branch, int ls, int cp) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map<String, Object> map=new HashMap<>();
		map.put("start",start);
		map.put("end",end);
		map.put("paymov_the_branch", paymov_the_branch);
		List<JoaAdminPayMovieDTO> list=sqlMap.selectList("pagingShopSelectQuery",map);
		return list;
	}
	@Override
	public int pagingMovieCount(String paymov_mov_title) {
		int result=sqlMap.selectOne("pagingMovieCountQuery",paymov_mov_title);
		return result;
	}
	@Override
	public List<JoaAdminPayMovieDTO> pagingMovieSelect(String paymov_mov_title, int ls, int cp) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map<String, Object> map=new HashMap<>();
		map.put("start",start);
		map.put("end",end);
		map.put("paymov_mov_title", paymov_mov_title);
		List<JoaAdminPayMovieDTO> list=sqlMap.selectList("pagingMovieSelectQuery",map);
		return list;
	}
}
