package joa.adminPay.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joa.pay.model.JoaPayMovDTO;
import joa.review.model.JoaReviewDTO;


public class AdminPayServiceImple implements AdminPayService {
	
	private AdminPayDAO adminPayDao;

	public AdminPayServiceImple(AdminPayDAO adminPayDao) {
		super();
		this.adminPayDao = adminPayDao;
	}
	
	@Override
	public int adminPayTotalCnt(String s_k, String s_v) {
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		int result=adminPayDao.adminPayTotalCnt(map);
	
		return result;
	}
	
	@Override
	public List<JoaPayMovDTO> listAdminPay(int cp, int ls, String s_k, String s_v) {
		// TODO Auto-generated method stub
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		List list=adminPayDao.listAdminPay(map);
		return list;
		
	}
	
	@Override
	public int deleteAdminPay(int payMov_idx) {
		int result=adminPayDao.deleteAdminPay(payMov_idx);
		return result;
	}
	
	@Override
	public JoaPayMovDTO detailAdminPay(int payMov_idx) {
		JoaPayMovDTO dto=adminPayDao.detailAdminPay(payMov_idx);
		return dto;
	}
	

}
