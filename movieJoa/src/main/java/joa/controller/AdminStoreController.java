package joa.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import joa.adminStore.model.*;

import java.io.*;

@Controller
public class AdminStoreController {
	
	@Autowired
	private AdminStoreDAO adminStoreDao;
	
	/**파일 복사 관련 메서드*/
	public void copyInto(File f,MultipartFile upload) {
	
		System.out.println("파일명:"+upload.getOriginalFilename());
		
		try {
			byte bytes[]=upload.getBytes(); //원본
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);; //복사 행위
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
	}
	
	@RequestMapping("/adminStoreAdd.do")
	public String adminStoreAdd() {
		return "admin/adminStore/adminStore_store_add";
	}
	
	@RequestMapping(value="/addProduct.do",method = RequestMethod.POST)
	public ModelAndView addProduct(AdminStoreDTO dto,@RequestParam("img")MultipartFile img, HttpServletRequest req) {

		String path=req.getRealPath("/img/joaStore_img");
		String filename=img.getOriginalFilename();
		File f=new File(path+filename);		
		copyInto(f, img);
		System.out.println(img.getOriginalFilename());
		dto.setPro_filename(img.getOriginalFilename());

		int result=adminStoreDao.addProduct(dto);
		String msg=result>0?"상품 등록 성공":"상품 등록 실패";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminStore/adminStore_store_msg");
		return mav;
	}
	
	@Autowired
	private AdminStoreService bbsService;
	
	@RequestMapping("/adminStore.do")
	public ModelAndView adminStore(
			@RequestParam(value="cp",defaultValue = "1")int cp) {
		
		int totalCnt=bbsService.adminStoreTotalCnt();
		int listSize=5;
		int pageSize=5;
		String adminStorePageStr=joa.page.PageModule.makePage("adminStoreList.do", totalCnt, listSize, pageSize, cp);
		
		List<AdminStoreDTO> adminStoreList=bbsService.adminStoreList(cp,listSize);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("adminStoreList",adminStoreList);
		mav.addObject("adminStorePageStr",adminStorePageStr);
		mav.setViewName("admin/adminStore/adminStore_store");
		return mav;
	}
	
	@RequestMapping("/adminStoreContent.do")
	public ModelAndView adminStoreContent(
			@RequestParam(value="idx",defaultValue="0")int idx) {
		AdminStoreDTO dto=bbsService.adminStoreContent(idx);
		
		ModelAndView mav=new ModelAndView();
		if(dto==null) {
			mav.addObject("msg","잘못된 접근 또는 삭제된 게시글입니다.");
			mav.setViewName("admin/adminStore/adminStore_store_msg");
		}else {
			mav.addObject("dto",dto);
			mav.setViewName("admin/adminStore/adminStore_store_content");
		}
		return mav;
	}
	
	@RequestMapping("/editProduct.do")
	public ModelAndView empUpdate(AdminStoreDTO dto) {
		int result=adminStoreDao.productUpdate(dto);
		String msg=result>0?"정보변경성공(mybatis)":"정보변경실패(mybatis)";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminStore/adminStore_store_msg");
		return mav;		
	}
	

}



