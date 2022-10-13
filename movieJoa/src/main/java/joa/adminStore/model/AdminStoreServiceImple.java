package joa.adminStore.model;

import java.util.*;

public class AdminStoreServiceImple implements AdminStoreService{
	
	private AdminStoreDAO adminStoreDao;
	
	public AdminStoreServiceImple(AdminStoreDAO adminStoreDao) {
		super();
		this.adminStoreDao = adminStoreDao;
	}

	@Override
	public List<AdminStoreDTO> adminStoreList(int cp, int ls) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		List<AdminStoreDTO> list=adminStoreDao.adminStoreList(map);
		return list;
	}

	@Override
	public AdminStoreDTO adminStoreContent(int idx) {
		AdminStoreDTO dto=adminStoreDao.adminStoreContent(idx);
		return dto;
	}
	
	@Override
	public int adminStoreTotalCnt() {
		int count=adminStoreDao.adminStoreTotalCnt();
		return count;
	}
	
	@Override
	public int adminStoreUpdate(AdminStoreDTO dto) {
		int result=adminStoreDao.adminStoreUpdate(dto);
		return result;
	}
	
	@Override
	public int adminStoreDelete(String pro_idx) {
		int result=adminStoreDao.adminStoreDelete(pro_idx);
		return result;
	}

}
