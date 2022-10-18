package joa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.adminEvent.model.AdminEventDTO;
import joa.event.model.Joa_EventService;


@Controller
public class JoaEventController {
	
	@Autowired
	private Joa_EventService joa_EventService;
	
	@RequestMapping("/joaEventMain.do")
	public ModelAndView joaEventMain() {
		
		List<AdminEventDTO> userEvent=joa_EventService.listEvent();
		ModelAndView mav= new ModelAndView();
		mav.addObject("userEvent",userEvent);
		mav.setViewName("joaEvent/joaEvent_main");
		return mav;
	}
	
	@RequestMapping("/joaEventInfo.do")
	public ModelAndView joaEventInfo(
		@RequestParam(value="eve_idx", defaultValue="0")int eve_idx) {
		AdminEventDTO dto= joa_EventService.infoEvent(eve_idx);
		
		ModelAndView mav=new ModelAndView();
		if (dto==null) {
			mav.addObject("msg","잘못된 접근입니다.");
			mav.setViewName("admin/adminEvent/msg");
		}else {
			mav.addObject("dto",dto);
			mav.setViewName("joaEvent/joaEvent_info");
		}
		return mav;
	}
	
	@RequestMapping("/joaEventNewJoin.do" )
	public ModelAndView joaEventNewJoin(HttpServletRequest req) {
		/*
		 * HttpSession session=req.getSession(); String sid =
		 * (String)session.getAttribute("sid");
		 */
		String sid="syseyear";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("sid",sid);
		mav.setViewName("joaEvent/joaEvent_newJoin");
		
		return mav;
	}
	
	@RequestMapping("/joaEventGetNewJoin.do")
	public ModelAndView joaEventGetNewJoin(
		@RequestParam(value="sid", required=true)String sid,
		@RequestParam(value="event_code", required=true)int event_code,
		@RequestParam(value="event_subject", required=true)String event_subject,
		@RequestParam(value="cou_idx", required=true)int cou_idx
		) 
		{
		ModelAndView mav=new ModelAndView();
		String msg="";
		int applyCheck = joa_EventService.checkApply(sid, event_code);
		
		if (applyCheck<=0) {
			
			int totalResult = joa_EventService.addCoupon(sid, cou_idx, event_subject, event_code);//두가지 메서드 동시 실행
			
			if (totalResult==2) {//두 메서드 전부 수행된 경우
				 msg="신규고객 환영 쿠폰이 부여되었습니다.";
			}else {
				msg="알 수 없는 이유로 포인트 부여에 실패했습니다.";
			}
			
		}else if(applyCheck>0){// 이벤트 참여기록이 존재하는 경우
			msg="이미 참여한 계정입니다.";
			
		}
		
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/joaEventNewJoin.do");
		mav.setViewName("joaEvent/msg");
		return mav;
		
	}
	
	@RequestMapping("/joaEventPoint.do")
	public ModelAndView joaEventRandom(HttpServletRequest req) {
		/*
		 * HttpSession session=req.getSession(); String sid =
		 * (String)session.getAttribute("sid");
		 */
		//String sid="syseyear";
		
		ModelAndView mav=new ModelAndView();
		//mav.addObject("sid",sid);
		mav.setViewName("joaEvent/joaEvent_point");
		
		return mav;
	}
	
	
	  @RequestMapping("/joaEventGetPoint.do")
	  public ModelAndView  joaEventGetPoint(
				@RequestParam(value="sid", required=true)String sid,
				@RequestParam(value="event_code", required=true)int event_code,
				@RequestParam(value="event_subject", required=true)String event_subject)  {
		  ModelAndView mav=new ModelAndView();
		 
		  String msg="";
		  
		  int applyCheck = joa_EventService.checkApply(sid, event_code);
		  System.out.println("checkApply 메서드 실행 결과"+applyCheck);
		  if(applyCheck<=0) {//(이벤트 참여 이력이 없다면)
			  int pointMethodResult = joa_EventService.getPoint(sid,  event_subject, event_code);
			
			  if(pointMethodResult==2) { // 포인트 부여 메서드, 참여 기록 남기는 메서드 둘 다 실행되었다면
				  msg="포인트가 부여되었습니다.";
			  	}else {
				  msg="포인트 부여에 실패했습니다.";
			  	}
		  }else if(applyCheck>0){ // 조회 기록이 존재한다면
			  msg="이미 참여한 계정입니다.";
			  
		  }

		  mav.addObject("msg",msg);
		  mav.addObject("nextPage","/movieJoa/joaEventPoint.do");
		  mav.setViewName("joaEvent/msg");
		  return mav;
	  
	  }
	
	@RequestMapping("/joaEventApply.do" )
	public ModelAndView joaEventApply(HttpServletRequest req) {

		ModelAndView mav=new ModelAndView();
		/*
		 * HttpSession session=req.getSession(); String sid =
		 * (String)session.getAttribute("sid");
		 */
		//String sid="syseyear";
		
		//mav.addObject("sid",sid);
		mav.setViewName("joaEvent/joaEvent_apply");
		
		return mav;
	}
	
	@RequestMapping("/joaEventGetApply.do")
	public ModelAndView joaEventApply(
		@RequestParam(value="sid", required=true)String sid,
		@RequestParam(value="event_code", required=true)int event_code,
		@RequestParam(value="event_subject", required=true)String event_subject) 
		{
		ModelAndView mav=new ModelAndView();
		  String msg="";
		  
		  int applyCheck = joa_EventService.checkApply(sid, event_code);
		  System.out.println("checkApply 메서드 실행 결과"+applyCheck);
		  
		  if(applyCheck==0) {
				int applyResult = joa_EventService.addApply(sid, event_code, event_subject);
				if(applyResult==1) {
					  msg="이벤트 응모에 성공했습니다.";
				}else {
					msg="알 수 없는 오류로 인해, 이벤트 응모에 실패했습니다.";
				}
		  }else {
			  msg="이미 응모한 계정입니다.";
		  }
		  
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/joaEventApply.do");
		mav.setViewName("joaEvent/msg");
		return mav;
		
	}

}
