package joa.pay.model;

import joa.adminStore.model.AdminStoreDAO;

public class JoaPayServiceImple implements JoaPayService {
	
	private JoaPayDAO joaPayDao;
	
	public JoaPayServiceImple(JoaPayDAO joaPayDao) {
		super();
		this.joaPayDao = joaPayDao;
	}

}
