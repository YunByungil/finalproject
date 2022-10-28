package joa.adminPay.model;

import java.util.List;
import java.util.Map;

import joa.pay.model.JoaPayMovDTO;
import joa.review.model.JoaReviewDTO;

public interface AdminPayDAO {
	public int adminPayTotalCnt(Map map);
	public List<JoaPayMovDTO> listAdminPay(Map map);
	public int deleteAdminPay(int payMov_idx);
	public JoaPayMovDTO detailAdminPay(int payMov_idx);
}  
