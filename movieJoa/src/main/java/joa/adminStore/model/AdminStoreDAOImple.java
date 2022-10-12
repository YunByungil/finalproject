package joa.adminStore.model;

import org.mybatis.spring.SqlSessionTemplate;

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

}
