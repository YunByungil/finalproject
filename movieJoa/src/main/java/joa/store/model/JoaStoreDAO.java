package joa.store.model;

import java.util.List;

import joa.adminStore.model.AdminStoreDTO;

public interface JoaStoreDAO {

	public List<AdminStoreDTO> storeCategoryList(String category);
	public AdminStoreDTO storeProductInfo(int pro_idx);
}
