package joa.adminRevenue.model;

import java.util.List;

import joa.adminStore.model.AdminStoreDTO;

public interface JoaAdminPayProductDAO {

	int nowMonthProductRevenue();
	String nowMonthBestProduct();
	List<AdminStoreDTO> revenueStore();
	int revenueStoreMoney(String pro_name);
	List<JoaAdminPayProductDTO> revenueProductDetail(String paypro_pro_name);
}
