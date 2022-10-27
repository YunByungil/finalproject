package joa.store.model;

import java.util.*;

import joa.adminStore.model.AdminStoreDTO;

public class JoaStoreServiceImple implements JoaStoreService{
	
	private JoaStoreDAO joaStoreDao;
	
	public JoaStoreServiceImple(JoaStoreDAO joaStoreDao) {
		super();
		this.joaStoreDao = joaStoreDao;
	}
	
	public int storeCartLookup(String car_mem_id,int car_pro_idx) {
		
		Map map=new HashMap();
		map.put("car_mem_id",car_mem_id);
		map.put("car_pro_idx",car_pro_idx);
		int result=joaStoreDao.storeCartLookup(map);
		
		return result; 
		
	}
	
	@Override
	public int storeCartAdd(JoaStoreCartDTO dto) {
		int result = joaStoreDao.storeCartAdd(dto);
		return result;
	}
	
	@Override
	public List<JoaStoreDTO> storeCartList(String car_mem_id) {
		List<JoaStoreDTO> list=joaStoreDao.storeCartList(car_mem_id);
		return list;
	}

	
	@Override
	public int storeCartUpdate(JoaStoreCartDTO dto) {
		int result=joaStoreDao.storeCartUpdate(dto);
		return result;
	}
	
	@Override
	public List<AdminStoreDTO> storeCategoryList(String category) {
		List<AdminStoreDTO> list=joaStoreDao.storeCategoryList(category);
		return list;
	}
	
	@Override
	public AdminStoreDTO storeProductInfo(int pro_idx) {
		AdminStoreDTO dto=joaStoreDao.storeProductInfo(pro_idx);
		return dto;
	}
	
	@Override
	public int storeCartDelete(JoaStoreDTO dto) {
		int result=joaStoreDao.storeCartDelete(dto);
		return result;
	}
	
	@Override
	public int storeCartUpdateCount(String car_idx) {
		int result=joaStoreDao.storeCartUpdateCount(car_idx);
		return result;
	}

}
