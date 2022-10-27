package joa.pay.model;

import java.util.Map;

public interface JoaPayService {
	
	public JoaPayCartListDTO storePayCartList(int car_pro_idx, String mem_id);
	public int payProductResultAdd(JoaPayProDTO dto);
	public int joaBookPayAdd(JoaPayMovDTO dto);

}
