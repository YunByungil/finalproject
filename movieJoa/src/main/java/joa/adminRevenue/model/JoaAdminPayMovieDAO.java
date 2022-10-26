package joa.adminRevenue.model;

import java.util.List;
import java.util.Map;

import joa.adminmember.model.JoaAdminMemberDTO;

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
	public int revenueShopMoney(String paymov_merchant_uid );
}
