package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoaStoreController {
	
	@RequestMapping("joaStore.do")
	public String joaStore() {
		return "joaStore/joaStore_store";
	}
	
	@RequestMapping("joaStoreCombo.do")
	public String joaStoreCombo() {
		return "joaStore/joaStore_combo";
	}
	
	@RequestMapping("joaStorePopcorn.do")
	public String joaStorePopcorn() {
		return "joaStore/joaStore_popcorn";
	}
	
	@RequestMapping("joaStoreDrink.do")
	public String joaStoreDrink() {
		return "joaStore/joaStore_drink";
	}
	
	@RequestMapping("joaStoreSnack.do")
	public String joaStoreSnack() {
		return "joaStore/joaStore_snack";
	}
	
	@RequestMapping("joaStoreProduct.do")
	public String joaStoreProduct() {
		return "joaStore/joaStore_product";
	}

}