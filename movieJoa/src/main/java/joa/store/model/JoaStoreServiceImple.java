package joa.store.model;

import java.util.*;

public class JoaStoreServiceImple implements JoaStoreService{
	
	private JoaStoreDAO joaStoreDao;
	
	public JoaStoreServiceImple(JoaStoreDAO joaStoreDao) {
		super();
		this.joaStoreDao = joaStoreDao;
	}
	
	public int storeCartLookup(String car_mem_id,int car_pro_idx) {
		
		Map map=new HashMap();
		map.put("id",car_mem_id);
		map.put("idx",car_pro_idx);
		int result=joaStoreDao.storeCartLookup(map);
		
		return result; 
		
	}

}
