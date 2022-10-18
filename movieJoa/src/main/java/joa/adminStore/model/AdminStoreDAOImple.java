package joa.adminStore.model;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.*;

public class AdminStoreDAOImple implements AdminStoreDAO{
	
	private SqlSessionTemplate sqlMap;
	
	public AdminStoreDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public int addProduct(AdminStoreDTO dto) {
		int result=sqlMap.insert("adminStoreInsert",dto);
		return result;
	}
	
	@Override
	public List<AdminStoreDTO> adminStoreList(Map map) {
		List<AdminStoreDTO> list=sqlMap.selectList("adminStoreList",map);
		return list;
	}
	
	@Override
	public List<AdminStoreDTO> storeCategoryList(AdminStoreDTO dto) {
		List<AdminStoreDTO> list=sqlMap.selectList("storeCategoryList",dto);
		return list;
	}
	
	@Override
	public AdminStoreDTO adminStoreContent(int idx) {
		AdminStoreDTO dto=sqlMap.selectOne("adminStoreContent",idx);
		return dto;
	}
	
	@Override
	public int adminStoreTotalCnt() {
		int count=sqlMap.selectOne("adminStoreTotalCnt");
		return count;
	}
	
	@Override
	public int productUpdate(AdminStoreDTO dto) {
		int count=sqlMap.update("productUpdate",dto);
		return count;
	}


}
