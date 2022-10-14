package joa.store.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminStore.model.AdminStoreDTO;

public class JoaStoreDAOImple implements JoaStoreDAO {
	
	private SqlSessionTemplate sqlMap;
	
	public JoaStoreDAOImple (SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public List<AdminStoreDTO> storeCategoryList(String category) {
		List<AdminStoreDTO> list=sqlMap.selectList("storeCategoryList",category);			
		return list;
	}
	
	@Override
	public AdminStoreDTO storeProductInfo(int pro_idx) {
		AdminStoreDTO dto=sqlMap.selectOne("storeProductInfo",pro_idx);
		return dto;
	}
	
	

}
