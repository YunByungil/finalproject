package joa.store.model;

import java.util.*;

import joa.adminStore.model.AdminStoreDTO;

public interface JoaStoreService {

	public List<AdminStoreDTO> storeCategoryList(String category);
	public AdminStoreDTO storeProductInfo(int pro_idx);
	public int storeCartLookup(String car_mem_id,int car_pro_idx);
	public int storeCartAdd(JoaStoreCartDTO dto);
	public int storeCartUpdate(JoaStoreCartDTO dto);
	public int storeCartDelete(String car_idx);	
	public List<JoaStoreDTO> storeCartList(String car_mem_id);
	public int storeCartUpdateCount(String car_idx);
}
