package joa.adminStore.model;

import java.util.*;

public interface AdminStoreDAO {
	
	public int addProduct(AdminStoreDTO dto);
	public List<AdminStoreDTO> adminStoreList(Map map);
	public List<AdminStoreDTO> storeCategoryList(AdminStoreDTO dto);
	public AdminStoreDTO adminStoreContent(int idx);
	public int adminStoreTotalCnt();
	public int productUpdate(AdminStoreDTO dto);
}
