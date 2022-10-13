package joa.adminStore.model;

import java.util.*;

public interface AdminStoreService {

	public List<AdminStoreDTO> adminStoreList(int cp, int ls);
	public AdminStoreDTO adminStoreContent(int idx);
	public int adminStoreTotalCnt();
	public int adminStoreUpdate(AdminStoreDTO dto);
	public int adminStoreDelete(String pro_idx);

}
