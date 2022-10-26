package joa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import joa.adminEvent.model.AdminApplycantDTO;
import joa.adminEvent.model.AdminEventDTO;
import joa.adminEvent.model.AdminEventService;
import joa.adminEvent.model.EventValidator;
import joa.adminMovie.model.AdminMovieDTO;
import joa.adminMovie.model.MovieValidator;

@Controller
public class AdminEventController {
	
	@Autowired
	private AdminEventService adminEventService;
	
	@ModelAttribute("eo") 
	public AdminEventDTO initCommand() {
		return new AdminEventDTO();
	} 
	
	public void copyInto(File f,MultipartFile upload) {
		
		try {
			byte bytes[]=upload.getBytes();
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);;
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
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
	public ModelAndView addEvent(@Valid @ModelAttribute("eo") AdminEventDTO dto, BindingResult errorResult,
			@RequestParam("event_main_img")MultipartFile event_main_img, HttpServletRequest req,
			@RequestParam("event_thumb_img")MultipartFile event_thumb_img) {
		
	   	ModelAndView mav=new ModelAndView();
		int result=0;
	    String msg="";
	    
	    String path=req.getRealPath("/img/joaEvent_img");
	    
	    String filename1=event_main_img.getOriginalFilename();
	    File f=new File(path+filename1);		
		copyInto(f, event_main_img);
		
		 String filename2=event_thumb_img.getOriginalFilename();
		    File f2=new File(path+filename2);		
			copyInto(f2, event_thumb_img);
		 
		 String eve_main_img=event_main_img.getOriginalFilename();
		 dto.setEve_main_img(eve_main_img);
		 
		 String eve_thumb_img=event_thumb_img.getOriginalFilename();
		 dto.setEve_thumb_img(eve_thumb_img);
		 
		 new EventValidator().validate(dto, errorResult);
		 if(errorResult.hasErrors()) {
			 System.out.println("errorResult:"+errorResult);
			 String[] cateList = new String[4];
				cateList[0]="유형 선택"; cateList[1]="현장 참여형"; cateList[2]="즉시발급형"; cateList[3]="응모형"	;
				mav.addObject("cateList",cateList);
				mav.setViewName("admin/adminEvent/adminEvent_addEvent");
		 }else {
			   	result = adminEventService.addEvent(dto);
				msg=result>0?"이벤트 등록에 성공하였습니다.":"이벤트 등록에 실패하였습니다.";
				mav.addObject("msg",msg);
				mav.addObject("nextPage","/movieJoa/listEvent.do");
				mav.setViewName("admin/adminEvent/msg");
		 }
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
	public ModelAndView updateEvent(@Valid @ModelAttribute("eo") AdminEventDTO dto, BindingResult errorResult,
			@RequestParam("event_main_img")MultipartFile event_main_img, HttpServletRequest req,
			@RequestParam("event_thumb_img")MultipartFile event_thumb_img) {
		
		ModelAndView mav=new ModelAndView();
		String path=req.getRealPath("/img/joaEvent_img");
	    
	    String filename1=event_main_img.getOriginalFilename();
	    File f=new File(path+filename1);		
		copyInto(f, event_main_img);
		
		 String filename2=event_thumb_img.getOriginalFilename();
		    File f2=new File(path+filename2);		
			copyInto(f2, event_thumb_img);
		 
		 String eve_main_img=event_main_img.getOriginalFilename();
		 dto.setEve_main_img(eve_main_img);
		 
		 String eve_thumb_img=event_thumb_img.getOriginalFilename();
		 dto.setEve_thumb_img(eve_thumb_img);
		 
		
		 new MovieValidator().validate(dto, errorResult);
		 if(errorResult.hasErrors()) {
			 String[] cateList = new String[3];
				cateList[0]="현장 참여형"; cateList[1]="즉시발급형"; cateList[2]="응모형"	;
				mav.addObject("cateList",cateList);
				mav.setViewName("admin/adminEvent/adminEvent_addEvent");
		 }else {
				int result = adminEventService.updateEvent(dto);
				String msg=result>0?"이벤트 정보 수정에 성공하였습니다.":"이벤트 정보 수정에 실패하였습니다.";
				
				mav.addObject("msg",msg);
				mav.addObject("nextPage","/movieJoa/listEvent.do");
				mav.setViewName("admin/adminEvent/msg");
		 }
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
	
	@RequestMapping(value="/listSystemEvent.do")
	public ModelAndView listSystemEvent() {
		ModelAndView mav= new ModelAndView();
		int f=111;
		int fst = adminEventService.systemEventTotalCnt(f);
		if (fst>0) {
			mav.addObject("firstStatus","비활성화");
		}else {
			mav.addObject("firstStatus","활성화");
		}
	
		int s=222;
		int sst = adminEventService.systemEventTotalCnt(s);
		if (sst>0) {
			mav.addObject("secondStatus","비활성화");
		}else {
			mav.addObject("secondStatus","활성화");
		}
		
		int t=333;
		int tst = adminEventService.systemEventTotalCnt(t);
		if (tst>0) {
			mav.addObject("thirdStatus","비활성화");
		}else {
			mav.addObject("thirdStatus","활성화");
		}
		
		mav.setViewName("admin/adminEvent/adminEvent_listSystemEvent");
		return mav;
		
	}
	
	@RequestMapping("/switchEvent.do")
	public ModelAndView switchEvent(
			@RequestParam(value="btnValue", required=true)String btnValue,
			@RequestParam(value="eidx", required=true)int eidx) {
		System.out.println("스위치메서드 위여기까진 들어옴");
		ModelAndView mav= new ModelAndView();
		String msg="";
		int state = adminEventService.systemEventTotalCnt(eidx);
		System.out.println("state:"+state);
		if(state==0) {
			int result = adminEventService.addSysEve(eidx);
			mav.addObject("state","활성화");
			if(result==2) {
				msg="시스템 이벤트 활성화 성공";
			}else {
				msg="시스템 이벤트 활성화 실패";
			}
		}else if(state>0) {
			int delresult = adminEventService.delSysEve(eidx);
			mav.addObject("state","비활성화");
			System.out.println("delResult:"+delresult);
			if(delresult==2) {
				msg="시스템 이벤트 비활성화 성공";
			}else {
				msg="시스템 이벤트 비활성화 실패";
			}
		}
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listSystemEvent.do");
		mav.setViewName("admin/adminEvent/msg");
		return mav;
	}
	
	@RequestMapping(value={"/listEvent.do","/searchEvent.do"})
	public ModelAndView listEvent(
			@RequestParam(value="cp", defaultValue="1")int cp,
			@RequestParam(value="s_k",  defaultValue="--")String s_k,
			@RequestParam(value="s_v", defaultValue="--")String s_v)  {
		
		int totalCnt=adminEventService.adminEventTotalCnt(s_k, s_v);
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("listEvent.do", totalCnt, listSize, pageSize, cp);
		
		List<AdminEventDTO> eventList=adminEventService.listEvent(cp, listSize, s_k, s_v);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("eventList",eventList);
		mav.addObject("s_k",s_k);
		mav.addObject("s_v",s_v);
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
	
	@RequestMapping(value={"/listApplycant.do","/searchApplycant.do"})
	public ModelAndView listApplycant(
			@RequestParam(value="cp", defaultValue="1")int cp,
			@RequestParam(value="s_k",  defaultValue="--")String s_k,
			@RequestParam(value="s_v", defaultValue="--")String s_v) {
		int totalCnt=adminEventService.adminApplycantTotalCnt(s_k,s_v);
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("listApplycant.do", totalCnt, listSize, pageSize, cp);
		List<AdminApplycantDTO> applyMember=adminEventService.listApplycant(cp, listSize, s_k, s_v);
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("applyMember",applyMember);
		mav.addObject("s_k",s_k);
		mav.addObject("s_v",s_v);
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
