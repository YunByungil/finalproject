package joa.adminStore.model;

import java.util.*;

public interface AdminStoreService {

	public List<AdminStoreDTO> adminStoreList(int cp, int ls);
	public List<AdminStoreDTO> storeCategoryList(AdminStoreDTO dto);
	public AdminStoreDTO adminStoreContent(int idx);
	public int adminStoreTotalCnt();

}
