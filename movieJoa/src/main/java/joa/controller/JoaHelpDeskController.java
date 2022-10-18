package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.helpdesk.model.JoaHQService;
import joa.helpdesk.model.JoaHelpQuestionDTO;
import joa.helpdesk.model.JoaMHService;
import joa.helpdesk.model.JoaManyHelpDTO;
import joa.helpdesk.model.JoaNTService;
import joa.helpdesk.model.JoaNoticeDTO;

@Controller
public class JoaHelpDeskController {
	
	@Autowired
	private JoaHQService joaHQService;
	
	@Autowired
	private JoaMHService joaMHService;
	
	@Autowired
	private JoaNTService joaNTService; 
	
	@RequestMapping("/helpDesk.do")
	public String helpDesk() {
		return "joaHelpDesk/joaHelpDesk_helpDesk";
	}
	
	//자주 찾는 질문
	@RequestMapping("/manyHelp.do")
	public ModelAndView manyHelp(){
		
		List<JoaManyHelpDTO> list = joaMHService.ManyHelpList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp");
		return mav;
	}
	
	@RequestMapping("/serchManyHelp.do")
	public ModelAndView serchManyHelp(String type) {
		List<JoaManyHelpDTO> list = joaMHService.serchManyHelpList(type);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp");
		return mav;
	}
	
	//관리자 자주찾는 질문
	
	@RequestMapping("/adminHelpDesk.do")
	public ModelAndView adminHelpDesk() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/joaHelpDesk_ADMHelpDesk");
		return mav;
	}
	
	@RequestMapping("/adminManyHelp.do")
	public ModelAndView adminManyHelp() {
		List<JoaManyHelpDTO> list = joaMHService.ManyHelpList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp");
		mav.addObject("list",list);
		return mav;
	}
	
	@RequestMapping("/adminSerchManyHelp")
	public ModelAndView adminSerchManyHelp(String type) {
		List<JoaManyHelpDTO> list = joaMHService.serchManyHelpList(type);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp");
		mav.addObject("list",list);
		return mav;
	}
	
	@RequestMapping("/manyHelpBorder.do")
	public ModelAndView ManyHelpBorder(int idx) {
		JoaManyHelpDTO dto = joaMHService.ManyHelpBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp_border");
		return mav;
	}
	
	@RequestMapping("/adminManyHelpBorder.do")
	public ModelAndView adminManyHelpBorder(int idx) {
		JoaManyHelpDTO dto = joaMHService.ManyHelpBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp_border");
		return mav;
	}
	
	@RequestMapping("/manyBorderWrite.do")
	public ModelAndView manyBorderWrite(JoaManyHelpDTO dto) {
		int result = joaMHService.addManyHelp(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result>0?"자주찾는 질문 게시글이\n정상적으로 등록되었습니다.":"자주찾는 질문 게시글 등록이 실패했습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/manyBorderReWrite.do")
	public ModelAndView manyBorderReWrite(JoaManyHelpDTO dto) {
		int result = joaMHService.rewriteManyHelp(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result>0?"자주찾는 질문 게시글이\n정상적으로 수정되었습니다.":"자주찾는 질문 게시글 수정이 실패했습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg",msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	@RequestMapping("/manyBorderDelete.do")
	public ModelAndView manyBorderDelete(int idx) {
		int result = joaMHService.deleteManyHelp(idx);
		String msg = result>0?"자주찾는 질문 게시글이\n정상적으로 삭제되었습니다.":"자주찾는 질문 게시글 삭제에 실패했습니다.\n관리자에게 문의바랍니다.";
		ModelAndView mav =new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	//공지게시판
	
	@RequestMapping("/notice.do")
	public ModelAndView helpQuestion() {
		List<JoaNoticeDTO> list = joaNTService.NoticeList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice");
		return mav;
	}
	
	@RequestMapping("/serchNotice.do")
	public ModelAndView serchHelpQuestion(String type) {
		List<JoaNoticeDTO> list = joaNTService.serchNoticeList(type);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice");
		return mav;
	}
	
	@RequestMapping("/noticeBorder.do")
	public ModelAndView helpQuestionBorder(int idx) {
		JoaNoticeDTO dto = joaNTService.noticeBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice_border");
		return mav;
	}
	
	// 공지게시판 관리자
	
	@RequestMapping("/adminNotice.do")
	public ModelAndView adminNotice() {
		List<JoaNoticeDTO> list = joaNTService.NoticeList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice");
		return mav;
	}
	
	@RequestMapping("/serchAdminNotice.do")
	public ModelAndView serchAdminNotice(String type) {
		List<JoaNoticeDTO> list = joaNTService.serchNoticeList(type);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice");
		return mav;
	}
	
	@RequestMapping("/noticeWrite.do")
	public ModelAndView noticeWrite(JoaNoticeDTO dto) {
		int result = joaNTService.addNotice(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result>0?"공지게시판에 게시글이\n등록되었습니다.":"공지게시판 게시글 등록에 실패하였습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/reNoticeWrite.do")
	public ModelAndView reNoticeWrite(JoaNoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = joaNTService.rewriteNotice(dto);
		String msg = result>0?"공지게시판에 게시글이\n수정되었습니다.":"공지게시판 게시글 수정에 실패하였습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/noticeDelete.do")
	public ModelAndView noticeDelete(int idx) {
		ModelAndView mav = new ModelAndView();
		int result = joaNTService.deleteNotice(idx);
		String msg = result>0?"공지게시판에 게시글이\n삭제되었습니다.":"공지게시판 게시글 삭제에 실패하였습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	//이메일문의
	
	@RequestMapping("/emailHelp.do")
	public ModelAndView emailHelp() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_emailHelp");
		return mav;
	}
	
	@RequestMapping("/emailHelpWrite.do")
	public ModelAndView emailHelpWrite(JoaHelpQuestionDTO dto) {
		dto.setState("미답변");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.addEmailQuestion(dto);
		String msg = result>0?"문의가 정상적으로\n등록되었습니다.":"문의 등록에 실패하였습니다.\n1:1문의를 이용해주세요.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_msg");
		return mav;
	
	}
	
	//관리자 이메일 문의
	
	@RequestMapping("/adminEmailHelp.do")
	public ModelAndView adminEmailHelp(String type) {
		
		ModelAndView mav = new ModelAndView();
		List<JoaHelpQuestionDTO> list = joaHQService.serchQuestionList(type, "답", "[", "점");
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp");
		return mav;
	}
	
	@RequestMapping("/serchAdminEmialHelp.do")
	public ModelAndView serchAdminEmialHelp(String type, String region, String cinema) {
		
		ModelAndView mav = new ModelAndView();
		List<JoaHelpQuestionDTO> list = joaHQService.serchQuestionList(type, "답", region, cinema);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp");
		return mav;
	}
	
	@RequestMapping("/adminEmailBorder.do")
	public ModelAndView adminEmailBorder(int idx) {
		ModelAndView mav = new ModelAndView();
		JoaHelpQuestionDTO dto = joaHQService.QuestionBorder(idx);
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp_border");
		return mav;
	}
	
	@RequestMapping("/answerEmailHelp.do")
	public ModelAndView answerEmailHelp(JoaHelpQuestionDTO dto) {
		dto.setState("답변완료");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.answerQuestion(dto);
		String msg = result>0?"이메일 답변완료 설정이 등록되었습니다":"이메일 답변완료 설정 등록에 실패했습니다";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	//1:1문의
	
	@RequestMapping("/oneByOneHelp.do")
	public ModelAndView oneByOneHelp() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_oneByOneHelp");
		return mav;
	}
	
	@RequestMapping("/oneByOneHelpWrite.do")
	public ModelAndView oneByOneHelpWrite(JoaHelpQuestionDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.addQuestion(dto);
		String msg = result>0?"1:1문의 등록이 완료되었습니다.":"1:1문의 등록이 실패하였습니다.\n아래 전화번호로 상담 및 문의를 해주세요.\n02-7777-7777";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_msg");
		return mav;
	}
	
	//1:1 문의 관리자 페이지
	
	@RequestMapping("/memberHelp.do")
	public ModelAndView memberHelp(String type,String state, String region, String cinema) {
		
		if(type.equals("전체")) {
			type="[";
		}
		region = "미답변";
		if(region.equals("전체")) {
			region="[";
		}
		if(cinema.equals("전체")) {
			cinema="[";
		}
		
		ModelAndView mav = new ModelAndView();
		List<JoaHelpQuestionDTO>list = joaHQService.serchQuestionList(type, state, region, cinema);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp");
		return mav;
	}
	
	@RequestMapping("/serchMemberHelp.do")
	public ModelAndView serchMemberHelp(String type,String state, String region, String cinema) {
		
		if(type.equals("전체")) {
			type="[";
		}
		region = "미답변";
		if(region.equals("전체")) {
			region="[";
		}
		if(cinema.equals("전체")) {
			cinema="[";
		}
		
		ModelAndView mav = new ModelAndView();
		List<JoaHelpQuestionDTO>list = joaHQService.serchQuestionList(type, state, region, cinema);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp");
		return mav;
	}
	
	@RequestMapping("/memberHelpBorder.do")
	public ModelAndView memberHelpBorder(int idx) {
		ModelAndView mav = new ModelAndView();
		JoaHelpQuestionDTO dto = joaHQService.QuestionBorder(idx);
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_border");
		return mav;
	}
	
	@RequestMapping("/answerMemberHelp.do")
	public ModelAndView answerMemberHelp(JoaHelpQuestionDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.answerQuestion(dto);
		String msg = result>0?"1:1문의 답변이\n정상적으로 등록됬습니다.":"1:1문의 답변 등록에 실패했습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/reAnswerMemberHelp.do")
	public ModelAndView reAnswerMemberHelp(JoaHelpQuestionDTO dto) {
		dto.setState("답변완료");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.reanswerQuestion(dto);
		String msg = result>0?"1:1문의 답변이\n정상적으로 등록됬습니다.":"1:1문의 답변 등록에 실패했습니다.\n관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	//지점관리자 답변열람 페이지
	
	@RequestMapping("/topAdmin.do")
	public ModelAndView topAdmin() {
		ModelAndView mav = new ModelAndView();
		List<JoaHelpQuestionDTO>list = joaHQService.QuestionList(); 
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_TopAdmin");
		return mav;
	}
	
	@RequestMapping("/topAdminBorder.do")
	public ModelAndView topAdminBorder(int idx) {
		ModelAndView mav = new ModelAndView();
		JoaHelpQuestionDTO dto = joaHQService.QuestionBorder(idx);
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_TopAdmin_border");
		return mav;
	}
	
	@RequestMapping("/reAnswerSet.do")
	public ModelAndView reAnswerSet(JoaHelpQuestionDTO dto) {
		dto.setState("재답변");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.reanswerQuestion(dto);
		String msg = result>0?"재답변 설정이 완료되었습니다.":"재답변 설정이 실패했습니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
}
