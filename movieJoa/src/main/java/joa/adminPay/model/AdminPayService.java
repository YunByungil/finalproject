package joa.adminPay.model;

import java.util.List;

import joa.pay.model.JoaPayMovDTO;
import joa.review.model.JoaReviewDTO;

public interface AdminPayService {

	public int adminPayTotalCnt(String s_k, String s_v);
	public List<JoaPayMovDTO> listAdminPay(int cp, int ls,  String s_k, String s_v);
	public int deleteAdminPay(int payMov_idx);
	public JoaPayMovDTO detailAdminPay(int payMov_idx);

}
