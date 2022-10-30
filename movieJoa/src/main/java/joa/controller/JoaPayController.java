package joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import joa.pay.model.*;
import joa.store.model.JoaStoreDTO;
import joa.store.model.JoaStoreService;
import joa.member.model.JoaMemberDTO;
import joa.movie.model.*;

@Controller
public class JoaPayController {
	
	@Autowired
	private JoaPayService joaPayService;
	
	public static String merchantUid() {
		
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 12;
	    Random random = new Random();
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	                                   .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	                                   .limit(targetStringLength)
	                                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	                                   .toString();
	    return generatedString;
	  }
	
	@RequestMapping("/joaStorePay.do")
	public ModelAndView joaStoreCartBuyNow(String idxsJson,String pay_discount,String pay_total_sum,HttpSession session) {

		JoaMemberDTO udto=(JoaMemberDTO)session.getAttribute("userInfo");
		String sid=udto.getMem_id();
		JSONArray jsonArr = new JSONArray(idxsJson);
		System.out.println(jsonArr.get(0));
		
		List<JoaPayCartListDTO> jpcList = new ArrayList<JoaPayCartListDTO>();
		JoaPayCartListDTO dto = new JoaPayCartListDTO();
		String car_pro_idx;
		
		for(int i=0;i<jsonArr.length();i++) {
			System.out.println("for:"+jsonArr.getString(i));
			car_pro_idx=jsonArr.getString(i);
			dto = joaPayService.storePayCartList(Integer.parseInt(car_pro_idx),sid);
			jpcList.add(dto);
		}

		ModelAndView mav=new ModelAndView();
		mav.addObject("pay_total_sum",pay_total_sum);
		mav.addObject("pay_discount",pay_discount);
		mav.addObject("jpcList",jpcList);
		mav.setViewName("joaStore/joaStore_pay");
		
		return mav;
	}
	
	@RequestMapping("/joaStoreKakaoPay.do")
	public ModelAndView joaStoreKakaoPay(
			String payPro_mem_id, String payPro_mem_name, String payPro_mem_email, String payPro_mem_tel, 
			String payPro_pg, String payPro_method, String payPro_pro_name,String payPro_price_sum,
			String payPro_discount, String payPro_total_price, String[] prs_mem_id,String[] prs_pro_filename,
			String[] prs_pro_name,String[] prs_pro_price,String[] prs_car_count) {
		String payPro_merchant_uid = merchantUid();
		JoaPayProDTO jppDto = new JoaPayProDTO();
		
		for(int i=0;i<prs_mem_id.length;i++) {
			JoaPayProResultDTO dto = new JoaPayProResultDTO();
			dto.setPrs_mem_id(prs_mem_id[i]);
			dto.setPrs_pro_filename(prs_pro_filename[i]);
			dto.setPrs_pro_name(prs_pro_name[i]);
			dto.setPrs_pro_price(prs_pro_price[i]);
			dto.setPrs_pro_count(prs_car_count[i]);
			dto.setPrs_order_idx(payPro_merchant_uid);
			joaPayService.payProductResultList(dto);
		}
		
		jppDto.setPayPro_mem_id(payPro_mem_id);
		jppDto.setPayPro_mem_name(payPro_mem_name);
		jppDto.setPayPro_mem_email(payPro_mem_email);
		jppDto.setPayPro_mem_tel(payPro_mem_tel);
		jppDto.setPayPro_pg(payPro_pg);
		jppDto.setPayPro_method(payPro_method);
		jppDto.setPayPro_pro_name(payPro_pro_name);
		jppDto.setPayPro_price_sum(Integer.parseInt(payPro_discount));
		jppDto.setPayPro_discount(Integer.parseInt(payPro_discount));
		jppDto.setPayPro_total_price(Integer.parseInt(payPro_total_price));
		jppDto.setPayPro_merchant_uid(payPro_merchant_uid);
		joaPayService.payProductResultAdd(jppDto);
		System.out.println("payPro_merchant_uid: "+payPro_merchant_uid);		

//		joaPayService.payProductResultAdd(dto);
		ModelAndView mav=new ModelAndView();
//		mav.addObject("payList",dto);
		mav.setViewName("joaStore/joaStore_pay_result");
		return mav;
	}	
	
	@RequestMapping("/joaBookPay.do")
	public ModelAndView joaBookPay(JoaPayMovDTO dto,
			@RequestParam(value = "payMov_sch_seat2", required = false)String payMov_sch_seat2) {
		if (payMov_sch_seat2 == null || payMov_sch_seat2.equals("")) {
			int result = joaPayService.joaBookPayAdd(dto);		
		}else {
			int result = joaPayService.joaBookPayAdd(dto);
			dto.setPayMov_sch_seat(payMov_sch_seat2);
			int result2 = joaPayService.joaBookPayAdd(dto);
		}
		//junsung writed
		List<JoaMovieDTO> aml=joaPayService.allMovieList();
		double allMovCnt=joaPayService.allMovCnt();
		for(int i=0;i<aml.size();i++) {
			double selMovCnt=joaPayService.selMovCnt(aml.get(i).getMov_title());
			double bookPer_d=selMovCnt/allMovCnt*100;
			String bookPer=String.format("%.1f", bookPer_d);
			Map map=new HashMap();
			map.put("mov_title", aml.get(i).getMov_title());
			map.put("mov_booking_percent", bookPer);
			joaPayService.updateBookPer(map);
		}
		String payMov_mov_title=dto.getPayMov_mov_title();
		double allBookCnt=joaPayService.allBookCnt(payMov_mov_title);
		double manBookCnt=joaPayService.manBookCnt(payMov_mov_title);
		double manPer_d=manBookCnt/allBookCnt*100;
		String manPer=String.format("%.1f", manPer_d);
		double womanBookCnt=joaPayService.womanBookCnt(payMov_mov_title);
		double womanPer_d=womanBookCnt/allBookCnt*100;
		String womanPer=String.format("%.1f", womanPer_d);
		double oneBookCnt=joaPayService.oneBookPer(payMov_mov_title);
		double onePer_d=oneBookCnt/allBookCnt*100;
		String onePer=String.format("%.1f", onePer_d);
		double twoBookCnt=joaPayService.twoBookPer(payMov_mov_title);
		double twoPer_d=twoBookCnt/allBookCnt*100;
		String twoPer=String.format("%.1f", twoPer_d);
		double threeBookCnt=joaPayService.threeBookPer(payMov_mov_title);
		double threePer_d=threeBookCnt/allBookCnt*100;
		String threePer=String.format("%.1f", threePer_d);
		double fourBookCnt=joaPayService.fourBookPer(payMov_mov_title);
		double fourPer_d=fourBookCnt/allBookCnt*100;
		String fourPer=String.format("%.1f", fourPer_d);
		double fiveBookCnt=joaPayService.fiveBookPer(payMov_mov_title);
		double fivePer_d=fiveBookCnt/allBookCnt*100;
		String fivePer=String.format("%.1f", fivePer_d);
		Map map=new HashMap();
		map.put("payMov_mov_title", payMov_mov_title);
		map.put("mov_gender_percent", manPer+","+womanPer);
		map.put("mov_age_percent", onePer+","+twoPer+","+threePer+","+fourPer+","+fivePer);
		joaPayService.updateGenderPer(map);
		joaPayService.updateAgePer(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaBook/joaBook_pay_result");		
		return mav;
	}
	
	

}
