package joa.pay.model;

import java.util.HashMap;
import java.util.Map;

import joa.adminStore.model.AdminStoreDAO;

public class JoaPayServiceImple implements JoaPayService {
	
	private JoaPayDAO joaPayDao;
	
	public JoaPayServiceImple(JoaPayDAO joaPayDao) {
		super();
		this.joaPayDao = joaPayDao;
	}
	
	@Override
	public JoaPayCartListDTO storePayCartList(int car_pro_idx, String mem_id) {
		System.out.println("joaPayService:"+mem_id);
		Map map=new HashMap();
		map.put("mem_id",mem_id);
		map.put("car_pro_idx",car_pro_idx);
		JoaPayCartListDTO dto=joaPayDao.storePayCartList(map);
		return dto;
	}

	
}
