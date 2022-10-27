package joa.adminRevenue.model;

import java.util.List;
import java.util.Map;

import joa.adminMem.model.JoaAdminMemberDTO;
import joa.adminMovie.model.AdminMovieDTO;

public interface JoaAdminPayMovieDAO {

	public int nowMonthMovieRevenue();
	public int nowMonth();
	public int nowYear();
	public int nowMonthSpectator();
	public int mangender();
	public int allgender();
	public int[] payAgeCount();
	public String nowMonthBestMovie();
	public List<JoaAdminMemberDTO> revenueShop();
	public int revenueShopMoney(String paymov_the_branch );
	public List<AdminMovieDTO> revenueMovie();
	public int revenueMovieMoney(String mov_title);
	public List<JoaAdminPayMovieDTO> revenueShopDetail(String paymov_the_branch);
	public List<JoaAdminPayMovieDTO> revenunMovieDetail(String paymov_mov_title);
	public int movieSpectatorCount(String mov_title);
}
