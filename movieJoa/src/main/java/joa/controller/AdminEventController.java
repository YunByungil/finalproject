package joa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import joa.adminEvent.model.AdminApplycantDTO;
import joa.adminEvent.model.AdminEventDTO;
import joa.adminEvent.model.AdminEventService;

@Controller
public class AdminEventController {
	
	@Autowired
	private AdminEventService adminEventService;
	
	   private void insertImg(MultipartFile eve_img) {
	      try {
	         byte realPosterFile[] = eve_img.getBytes();
	         File poster = new File("c:/work_space/movieJoa/movieJoa/src/main/webapp/img/joaEvent_img/" + eve_img.getOriginalFilename());
	         FileOutputStream stream = new FileOutputStream(poster); 
	         stream.write(realPosterFile); 
	         stream.close(); 
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	
		
	@RequestMapping("/searchEvent.do")
	public ModelAndView searchEvent(String sc_t, String sc_k) {
		ModelAndView mav=new ModelAndView();
		List sc_v = adminEventService.searchEvent(sc_t,sc_k);
		return mav;
	}
		
	   
	@RequestMapping(value="/addEventForm.do", method=RequestMethod.GET)
	public ModelAndView addEvent() {
		ModelAndView mav=new ModelAndView();
		String[] cateList = new String[4];
		cateList[0]="유형 선택"; cateList[1]="현장 참여형"; cateList[2]="즉시발급형"; cateList[3]="응모형"	;
		mav.addObject("cateList",cateList);
		mav.setViewName("admin/adminEvent/adminEvent_addEvent");
		return mav;
		
	}
	
   @RequestMapping(value="/addEvent.do" ,method=RequestMethod.POST)
	public ModelAndView addEvent(AdminEventDTO dto, MultipartHttpServletRequest req) {
		
		 MultipartFile event_main_img = req.getFile("event_main_img");
		 insertImg(event_main_img);
		 
		 MultipartFile event_thumb_img = req.getFile("event_thumb_img");
		 insertImg(event_thumb_img);
		 
		 String eve_main_img=event_main_img.getOriginalFilename();
		 dto.setEve_main_img(eve_main_img);
		 
		 String eve_thumb_img=event_thumb_img.getOriginalFilename();
		 dto.setEve_thumb_img(eve_thumb_img);
		 
	   	int result = adminEventService.addEvent(dto);
		String msg=result>0?"이벤트 등록에 성공하였습니다.":"이벤트 등록에 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","movieJoa/listEvent.do");
		mav.setViewName("admin/adminEvent/msg");
		return mav;
		
   }

	@RequestMapping(value="/updateEventForm.do" ,method=RequestMethod.GET)
	public ModelAndView updateEvent(
			@RequestParam(value="eve_idx", defaultValue="0")int eve_idx) {
			AdminEventDTO dto= adminEventService.detailEvent(eve_idx);
			ModelAndView mav=new ModelAndView();
			if (dto==null) {
				mav.addObject("msg","잘못된 접근입니다.");
				mav.addObject("goPage","movieJoa/adminEvent_listEvent.do");
				mav.setViewName("admin/adminEvent/msg");
			}else {
				String[] cateList = new String[3];
				cateList[0]="현장 참여형"; cateList[1]="즉시발급형"; cateList[2]="응모형";
				mav.addObject("cateList",cateList);
				mav.addObject("dto",dto);
				mav.setViewName("admin/adminEvent/adminEvent_updateEvent");
			}
			return mav;
	}
	
	@RequestMapping(value="/updateEvent.do" ,method=RequestMethod.POST)
	public ModelAndView updateEvent(AdminEventDTO dto, MultipartHttpServletRequest req) {
		
		 MultipartFile event_main_img = req.getFile("event_main_img");
		 insertImg(event_main_img);
		 
		 MultipartFile event_thumb_img = req.getFile("event_thumb_img");
		 insertImg(event_thumb_img);
		 
		 String eve_main_img=event_main_img.getOriginalFilename();
		 dto.setEve_main_img(eve_main_img);
		 
		 String eve_thumb_img=event_thumb_img.getOriginalFilename();
		 dto.setEve_thumb_img(eve_thumb_img);
		
		int result = adminEventService.updateEvent(dto);
		String msg=result>0?"이벤트 정보 수정에 성공하였습니다.":"이벤트 정보 수정에 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/listEvent.do");
		mav.setViewName("admin/adminEvent/msg");
		return mav;
	}
	
	
	@RequestMapping("/detailEvent.do")
	public ModelAndView eventDetail(
			@RequestParam(value="eve_idx", defaultValue="0")int eve_idx) {
		AdminEventDTO dto= adminEventService.detailEvent(eve_idx);
		ModelAndView mav=new ModelAndView();
		if (dto==null) {
			mav.addObject("msg","잘못된 접근입니다.");
			mav.setViewName("admin/adminEvent/msg");
		}else {
			mav.addObject("dto",dto);
			mav.setViewName("admin/adminEvent/adminEvent_eventDetail");
		}
		return mav;
	}
	
	@RequestMapping("/listEvent.do")
	public ModelAndView listEvent(
			@RequestParam(value="cp", defaultValue="1")int cp) {
		
		int totalCnt=adminEventService.adminEventTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("listEvent.do", totalCnt, listSize, pageSize, cp);
		
		List<AdminEventDTO> eventList=adminEventService.listEvent(cp, listSize);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("eventList",eventList);
		mav.setViewName("admin/adminEvent/adminEvent_listEvent");
		return mav;
	}
	
	@RequestMapping("/deleteEvent.do")
	public ModelAndView deleteEvent(
			@RequestParam(value="eve_idx", defaultValue="0")int eve_idx) {
		int result = adminEventService.deleteEvent(eve_idx);
		String msg=result>0?"해당 이벤트 정보 삭제에 성공했습니다.":"해당 이벤트 정보 삭제에 실패했습니다.";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listEvent.do");
		mav.setViewName("admin/adminEvent/msg");
		return mav;
	}
	
	@RequestMapping("/listApplycant.do")
	public ModelAndView listApplycant(
			@RequestParam(value="cp", defaultValue="1")int cp) {
		
		int totalCnt=adminEventService.adminApplycantTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("listApplycant.do", totalCnt, listSize, pageSize, cp);
		
		List<AdminApplycantDTO> applyMember=adminEventService.listApplycant(cp, listSize);
		
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("applyMember",applyMember);
		mav.setViewName("admin/adminEvent/adminEvent_listApplycant");
		return mav;
	}

	@RequestMapping("/deleteApplycant.do")
	public ModelAndView deleteApplycant(
			@RequestParam(value="app_idx", defaultValue="0")int app_idx) {
		int result = adminEventService.deleteApplycant(app_idx);
		String msg=result>0?"해당 이벤트 참여 내역 삭제에 성공했습니다.":"해당 이벤트 참여 내역 삭제에 실패했습니다.";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listEvent.do");
		mav.setViewName("admin/adminEvent/msg");
		return mav;
	}
	
	
}
