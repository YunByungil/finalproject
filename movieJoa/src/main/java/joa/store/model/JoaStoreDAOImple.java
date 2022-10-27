package joa.store.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.servlet.ModelAndView;

import joa.adminStore.model.AdminStoreDTO;
import joa.store.model.*;

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
	
	@Override
	public int storeCartLookup(Map map) {
		int result=sqlMap.selectOne("storeCartLookup", map);
		return result;
	}
	
	@Override
	public int storeCartAdd(JoaStoreCartDTO dto) {
		int result=sqlMap.insert("storeCartAdd",dto);
		return result;
	}
	
	@Override
	public int storeCartUpdate(JoaStoreCartDTO dto) {
		int result=sqlMap.update("storeCartUpdate",dto);
		return result;
	}
	
	@Override
	public List<JoaStoreDTO> storeCartList(String car_mem_id) {
		List<JoaStoreDTO> list=sqlMap.selectList("storeCartList",car_mem_id);
		System.out.println("test4"+list.size());
		return list;
	}
	
	@Override
	public int storeCartDelete(JoaStoreDTO dto) {
		int result=sqlMap.delete("storeCartDelete", dto);
		return result;
	}
	
	@Override
	public int storeCartUpdateCount(String car_idx) {
		int result=sqlMap.update("storeCartUpdateCount",car_idx);
		return result;
	}

	

}
