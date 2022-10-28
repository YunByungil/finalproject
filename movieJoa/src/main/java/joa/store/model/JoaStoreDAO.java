package joa.store.model;

import java.util.*;

import org.springframework.web.servlet.ModelAndView;

import joa.adminStore.model.AdminStoreDTO;
import joa.store.model.*;

public interface JoaStoreDAO {

	public List<AdminStoreDTO> storeCategoryList(String category);
	public AdminStoreDTO storeProductInfo(int pro_idx);
	public int storeCartLookup(Map map);
	public int storeCartAdd(JoaStoreCartDTO dto);
	public int storeCartUpdate(JoaStoreCartDTO dto);
	public int storeCartDelete(String car_idx);
	public List<JoaStoreDTO> storeCartList(String car_mem_id);
	public int storeCartUpdateCount(String car_idx);
}
