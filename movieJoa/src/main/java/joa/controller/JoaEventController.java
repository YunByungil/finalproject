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
	
	String msg="";
	String nextPage="";
	
	@Autowired
	private Joa_EventService joa_EventService;
	
	@RequestMapping("/joaEventMain.do")
	public ModelAndView joaEventMain() {
		ModelAndView mav= new ModelAndView();
		List<AdminEventDTO> systemEvent=joa_EventService.listSystemEvent();
		List<AdminEventDTO> userEvent=joa_EventService.listEvent();
		mav.addObject("systemEvent",systemEvent);
		mav.addObject("userEvent",userEvent);
		mav.setViewName("joaEvent/joaEvent_main");
		return mav;
	}
	
	@RequestMapping("/joaEventEnded.do")
	public ModelAndView joaEventEndedList(
		@RequestParam(value="cp", defaultValue="1")int cp) {
		int totalCnt=joa_EventService.endedEventTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("joaEventEnded.do", totalCnt, listSize, pageSize, cp);
		List<AdminEventDTO> endedEvent=joa_EventService.endedEvent();
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("endedEvent",endedEvent);
		mav.setViewName("joaEvent/joaEvent_endedEvent");
		return mav;
	}
	
	
	
	@RequestMapping("/joaEventInfo.do")
	public ModelAndView joaEventInfo( //일반 관리자 이벤트 접속 메서드
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
	
	@RequestMapping("/111.do")
	public ModelAndView joaEventNewJoin() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("joaEvent/joaEvent_newJoin");
		return mav;
	}
	@RequestMapping("/joaEventGetNewJoin.do")
	public ModelAndView joaEventGetNewJoin(
		//HttpServletRequest req, 연동시 받아올 세션 아이디
		@RequestParam(value="sid", required=true)String sid,
		@RequestParam(value="event_code", required=true)int event_code,
		@RequestParam(value="event_subject", required=true)String event_subject,
		@RequestParam(value="cou_idx", required=true)int cou_idx
		) {
			/* 연동 시 받아올 세션 아이디
			 * HttpSession session=req.getSession(); String sid =
			 * (String)session.getAttribute("sid");
			 */
		ModelAndView mav=new ModelAndView();
		if(sid!=null) {
			int applyCheck = joa_EventService.checkApply(sid, event_code);
			if (applyCheck<=0) {
				int totalResult = joa_EventService.addCoupon(sid, cou_idx, event_subject, event_code);//두가지 메서드 동시 실행
				if (totalResult==2) {//두 메서드 전부 수행된 경우
					 msg="신규고객 환영 쿠폰이 부여되었습니다.";
					 nextPage="/movieJoa/joaEventNewJoin.do";
				}else {
					msg="알 수 없는 이유로 포인트 부여에 실패했습니다.";
					nextPage="/movieJoa/joaEventNewJoin.do";
				}
			}else if(applyCheck>0){// 이벤트 참여기록이 존재하는 경우
				msg="이미 참여한 계정입니다.";
				nextPage="/movieJoa/joaEventNewJoin.do";
			}
		}else{
			msg="로그인 시 이용 가능합니다.";
			nextPage="/movieJoa/joaEventNewJoin.do";//차후 확인시 경로 수정
		}
		mav.addObject("msg",msg);
		mav.addObject("nextPage",nextPage);
		mav.setViewName("joaEvent/msg");
		return mav;
		
	}
	
	@RequestMapping("/222.do")
	public ModelAndView joaEventPoint() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("joaEvent/joaEvent_point");
		return mav;
	}
	  @RequestMapping("/joaEventGetPoint.do")
	  public ModelAndView  joaEventGetPoint(
				@RequestParam(value="sid", required=true)String sid,
				@RequestParam(value="event_code", required=true)int event_code,
				@RequestParam(value="event_subject", required=true)String event_subject)  {
		  ModelAndView mav=new ModelAndView();
		  if(sid!=null) {
			  int applyCheck = joa_EventService.checkApply(sid, event_code);
				  if(applyCheck<=0) {//(이벤트 참여 이력이 없다면)
					  int pointMethodResult = joa_EventService.getPoint(sid,  event_subject, event_code);
					
					  if(pointMethodResult==2) { // 포인트 부여 메서드, 참여 기록 남기는 메서드 둘 다 실행되었다면
						  msg="포인트가 부여되었습니다.";
						  nextPage="/movieJoa/joaEventPoint.do";
					  	}else {
						  msg="포인트 부여에 실패했습니다.";
						  nextPage="/movieJoa/joaEventPoint.do";
					  	}
				  }else if(applyCheck>0){ // 조회 기록이 존재한다면
					  msg="이미 참여한 계정입니다.";
					  nextPage="/movieJoa/joaEventPoint.do";
				  }
		  }else{
				msg="로그인 시 이용 가능합니다.";
				nextPage="/movieJoa/joaEventPoint.do";//차후 확인시 경로 수정
			}
		  mav.addObject("msg",msg);
		  mav.addObject("nextPage",nextPage);
		  mav.setViewName("joaEvent/msg");
		  return mav;
	  }
	
	@RequestMapping("/333.do" )
	public ModelAndView joaEventApply() {
		ModelAndView mav=new ModelAndView();
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
		if(sid!=null) {
			  int applyCheck = joa_EventService.checkApply(sid, event_code);
			  if(applyCheck==0) {
					int applyResult = joa_EventService.addApply(sid, event_code, event_subject);
					if(applyResult==1) {
						  msg="이벤트 응모에 성공했습니다.";
						  nextPage="/movieJoa/joaEventApply.do";
					}else {
						msg="알 수 없는 오류로 인해, 이벤트 응모에 실패했습니다.";
						nextPage="/movieJoa/joaEventApply.do";
					}
			  }else {
				  msg="이미 응모한 계정입니다.";
				  nextPage="/movieJoa/joaEventApply.do";
			  }
		}else {
			  msg="로그인시 참여 가능한 이벤트입니다.";
			  nextPage="/movieJoa/joaEventApply.do";
		}
		  
		mav.addObject("msg",msg);
		mav.addObject("nextPage",nextPage);
		mav.setViewName("joaEvent/msg");
		return mav;
		
	}

}
