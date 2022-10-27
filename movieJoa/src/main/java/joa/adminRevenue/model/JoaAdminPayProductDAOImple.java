package joa.adminRevenue.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminStore.model.AdminStoreDTO;

public class JoaAdminPayProductDAOImple implements JoaAdminPayProductDAO {

	private SqlSessionTemplate sqlMap;

	public JoaAdminPayProductDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	@Override
	public int nowMonthProductRevenue() {
		int nowMonthProductRevenue=sqlMap.selectOne("nowMonthProductRevenueQuery");
		return nowMonthProductRevenue;
	}
	@Override
	public String nowMonthBestProduct() {
		String nowMonthBestProduct=sqlMap.selectOne("nowMonthBestProductQuery");
		return nowMonthBestProduct;
	}
	@Override
	public List<AdminStoreDTO> revenueStore() {
		List<AdminStoreDTO> list=sqlMap.selectList("revenueStoreQuery");
		return list;
	}
	@Override
	public int revenueStoreMoney(String pro_name) {
		int result=sqlMap.selectOne("revenueStoreMoneyQuery", pro_name);
		return result;
	}
	@Override
	public List<JoaAdminPayProductDTO> revenueProductDetail(String paypro_pro_name) {
		List<JoaAdminPayProductDTO> list=sqlMap.selectList("revenueProductDetailQuery", paypro_pro_name);
		return list;
	}
}
