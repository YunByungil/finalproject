package joa.pay.model;

import java.util.*;
import joa.movie.model.*;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminStore.model.AdminStoreDTO;
import joa.pay.model.*;

public class JoaPayDAOImple implements JoaPayDAO {

	private SqlSessionTemplate sqlMap;

	public JoaPayDAOImple (SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public JoaPayCartListDTO storePayCartList(Map map) {
		JoaPayCartListDTO dto=sqlMap.selectOne("storePayCartList",map);
		return dto;
	}
	
	@Override
	public int payProductResultAdd(JoaPayProDTO dto) {
		int result=sqlMap.insert("payProductResultAdd",dto);
		return result;
	}
	
	@Override
	public int joaBookPayAdd(JoaPayMovDTO dto) {
		int result=sqlMap.insert("joaBookPayAdd",dto);
		return result;
	}

}
