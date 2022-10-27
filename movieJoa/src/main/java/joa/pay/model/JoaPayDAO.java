package joa.pay.model;

import java.util.*;
import joa.movie.model.*;

import joa.adminStore.model.AdminStoreDTO;
import joa.pay.model.*;
import joa.store.model.JoaStoreCartDTO;

public interface JoaPayDAO {	

	public JoaPayCartListDTO storePayCartList(Map map);
	public int payProductResultAdd(JoaPayProDTO dto);
	public int joaBookPayAdd(JoaPayMovDTO dto);

}
