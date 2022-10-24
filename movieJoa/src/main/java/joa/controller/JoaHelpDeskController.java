
package joa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView manyHelp(@RequestParam(value =  "cp", defaultValue = "1")int cp){
		String backA_color = "background-color: #F05650";
		int totalCnt=joaMHService.manyHelpListTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("manyHelp.do", totalCnt, listSize, pageSize, cp);
		
		
		List<JoaManyHelpDTO> list = joaMHService.ManyHelpList(cp, listSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("backA_color",backA_color);
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp");
		return mav;
	}
	
	@RequestMapping("/serchManyHelp.do")
	public ModelAndView serchManyHelp(HttpServletRequest request, @RequestParam(value =  "cp", defaultValue = "1")int cp) {

		String type = request.getParameter("type");
		
		int totalCnt=joaMHService.manyHelpTypeTotalCnt(type);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("serchManyHelp.do?type="+type, totalCnt, listSize, pageSize, cp);
		List<JoaManyHelpDTO> list = joaMHService.manyHelpType(type, cp, listSize);
		ModelAndView mav = new ModelAndView();

		if(type.equals("예매/매표")) {
			String backB_color = "background-color: #F05650";
			mav.addObject("backB_color", backB_color);
		}else if(type.equals("결제수단")) {
			String backC_color = "background-color: #F05650";
			mav.addObject("backC_color", backC_color);
		}else if(type.equals("포인트/쿠폰")) {
			String backD_color = "background-color: #F05650";
			mav.addObject("backD_color", backD_color);
		}else if(type.equals("할인혜택")) {
			String backE_color = "background-color: #F05650";
			mav.addObject("backE_color", backE_color);
		}else if(type.equals("스토어샵")) {
			String backF_color = "background-color: #F05650";
			mav.addObject("backF_color", backF_color);
		}else if(type.equals("홈페이지")) {
			String backG_color = "background-color: #F05650";
			mav.addObject("backG_color", backG_color);
		}
		mav.addObject("pageStr", pageStr);
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp");
		return mav;
	}
	@RequestMapping("/manyHelpSerch.do")
	public ModelAndView manyHelpSerch(@RequestParam(value="keyword", required=false)String keyword, @RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		
		int totalCnt=joaMHService.serchManyHelpListTotalCnt(keyword);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("manyHelpSerch.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav = new ModelAndView();
		List<JoaManyHelpDTO> list = joaMHService.serchManyHelpList(keyword, cp, listSize);
		mav.addObject("pageStr", pageStr);
		mav.addObject("backA_color",backA_color);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp");
		return mav;
	}
	
	@RequestMapping("/manyHelpBorder.do")
	public ModelAndView ManyHelpBorder(@RequestParam(value="idx")int idx) {
		JoaManyHelpDTO dto = joaMHService.ManyHelpBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_manyHelp_border");
		return mav;
	}
	
	//관리자 자주찾는 질문
	
	@RequestMapping("/adminHelpDesk.do")
	public ModelAndView adminHelpDesk(@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		int totalCnt=joaMHService.manyHelpListTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("adminHelpDesk.do", totalCnt, listSize, pageSize, cp);
		
		
		List<JoaManyHelpDTO> list = joaMHService.ManyHelpList(cp, listSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("backA_color",backA_color);
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp");
		return mav;
	}
	
	@RequestMapping("/adminManyHelp.do")
	public ModelAndView adminManyHelp(HttpServletRequest request,@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String type = request.getParameter("type");
		
		int totalCnt=joaMHService.manyHelpTypeTotalCnt(type);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("adminManyHelp.do?type="+type, totalCnt, listSize, pageSize, cp);
		List<JoaManyHelpDTO> list = joaMHService.manyHelpType(type, cp, listSize);
		ModelAndView mav = new ModelAndView();

		if(type.equals("예매/매표")) {
			String backB_color = "background-color: #F05650";
			mav.addObject("backB_color", backB_color);
		}else if(type.equals("결제수단")) {
			String backC_color = "background-color: #F05650";
			mav.addObject("backC_color", backC_color);
		}else if(type.equals("포인트/쿠폰")) {
			String backD_color = "background-color: #F05650";
			mav.addObject("backD_color", backD_color);
		}else if(type.equals("할인혜택")) {
			String backE_color = "background-color: #F05650";
			mav.addObject("backE_color", backE_color);
		}else if(type.equals("스토어샵")) {
			String backF_color = "background-color: #F05650";
			mav.addObject("backF_color", backF_color);
		}else if(type.equals("홈페이지")) {
			String backG_color = "background-color: #F05650";
			mav.addObject("backG_color", backG_color);
		}
		mav.addObject("pageStr", pageStr);
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp");
		return mav;
	}
	
	@RequestMapping("/adminSerchManyHelp.do")
	public ModelAndView adminSerchManyHelp(@RequestParam(value="keyword")String keyword, @RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		
		int totalCnt=joaMHService.serchManyHelpListTotalCnt(keyword);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("adminSerchManyHelp.do?keword="+keyword, totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav = new ModelAndView();
		List<JoaManyHelpDTO> list = joaMHService.serchManyHelpList(keyword, cp, listSize);
		mav.addObject("pageStr", pageStr);
		mav.addObject("backA_color",backA_color);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp");
		return mav;
	}
	
	@RequestMapping("/adminManyHelpBorder.do")
	public ModelAndView adminManyHelpBorder(@RequestParam(value="idx")int idx) {
		JoaManyHelpDTO dto = joaMHService.ManyHelpBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp_border");
		return mav;
	}
	
	@RequestMapping("/manyWrite.do")
	public ModelAndView manyWrite(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp_border_write");
		return mav;
	}
	
	@RequestMapping("/manyBorderWrite.do")
	public ModelAndView manyBorderWrite(JoaManyHelpDTO dto) {
		int result = joaMHService.addManyHelp(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result>0?"자주찾는 질문 게시글이 정상적으로 등록되었습니다.":"자주찾는 질문 게시글 등록이 실패했습니다. 관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/manyBorderReWriteMove.do")
	public ModelAndView manyBorderReWriteMove(@RequestParam(value="idx")int idx) {
		JoaManyHelpDTO dto = joaMHService.ManyHelpBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMManyHelp_border_ReWrite");
		return mav;
	}
	
	@RequestMapping("/manyBorderReWrite.do")
	public ModelAndView manyBorderReWrite(JoaManyHelpDTO dto) {
		int result = joaMHService.rewriteManyHelp(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result>0?"자주찾는 질문 게시글이 정상적으로 수정되었습니다.":"자주찾는 질문 게시글 수정이 실패했습니다. 관리자에게 문의바랍니다.";
		mav.addObject("msg",msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	@RequestMapping("/manyBorderDelete.do")
	public ModelAndView manyBorderDelete(@RequestParam(value="idx", defaultValue = "1")int idx) {
		int result = joaMHService.deleteManyHelp(idx);
		String msg = result>0?"자주찾는 질문 게시글이 정상적으로 삭제되었습니다.":"자주찾는 질문 게시글 삭제에 실패했습니다. 관리자에게 문의바랍니다.";
		ModelAndView mav =new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	//공지게시판
	
	@RequestMapping("/notice.do")
	public ModelAndView helpQuestion(@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		int totalCnt=joaNTService.noticeTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("notice.do", totalCnt, listSize, pageSize, cp);
		
		List<JoaNoticeDTO> list = joaNTService.NoticeList(cp, listSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("backA_color", backA_color);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice");
		return mav;
	}
	
	@RequestMapping("/noticeType.do")
	public ModelAndView noticeType(HttpServletRequest request,@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String type = request.getParameter("type");
		ModelAndView mav = new ModelAndView();
		int totalCnt=joaNTService.noticeTypeTotalCnt(type);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("noticeType.do?type="+type, totalCnt, listSize, pageSize, cp);
		List<JoaNoticeDTO> list = joaNTService.noticeType(type, cp, pageSize);
		if(type.equals("시스템점검")) {
			String backB_color = "background-color: #F05650";
			mav.addObject("backB_color", backB_color);
		}else if(type.equals("극장")) {
			String backC_color = "background-color: #F05650";
			mav.addObject("backC_color", backC_color);
		}else if(type.equals("기타")) {
			String backD_color = "background-color: #F05650";
			mav.addObject("backD_color", backD_color);
		}
		
		mav.addObject("pageStr", pageStr);
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice");
		return mav;
	}
	
	@RequestMapping("/serchNotice.do")
	public ModelAndView serchHelpQuestion(@RequestParam(value="keyword", required = false)String keyword, @RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		
		int totalCnt=joaNTService.serchNoticeTotalCnt(keyword);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("serchNotice.do?"+keyword, totalCnt, listSize, pageSize, cp);
		
		List<JoaNoticeDTO> list = joaNTService.serchNoticeList(keyword, cp, pageSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice");
		return mav;
	}
	
	@RequestMapping("/noticeBorder.do")
	public ModelAndView noticeBorder(@RequestParam(value="idx", defaultValue = "1")int idx) {
		JoaNoticeDTO dto = joaNTService.noticeBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_notice_border");
		return mav;
	}
	
	// 공지게시판 관리자
	
	@RequestMapping("/adminNotice.do")
	public ModelAndView adminNotice(@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		int totalCnt=joaNTService.noticeTotalCnt();
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("adminNotice.do", totalCnt, listSize, pageSize, cp);
		
		List<JoaNoticeDTO> list = joaNTService.NoticeList(cp, listSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("backA_color", backA_color);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice");
		return mav;
	}
	
	@RequestMapping("/noticeAdminType.do")
	public ModelAndView noticeAdminType(HttpServletRequest request,@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String type = request.getParameter("type");
		ModelAndView mav = new ModelAndView();
		if(type.equals("예매/매표")) {
			String backB_color = "background-color: #F05650";
			mav.addObject("backB_color", backB_color);
		}else if(type.equals("결제수단")) {
			String backC_color = "background-color: #F05650";
			mav.addObject("backC_color", backC_color);
		}else if(type.equals("포인트/쿠폰")) {
			String backD_color = "background-color: #F05650";
			mav.addObject("backD_color", backD_color);
		}
		
		int totalCnt=joaNTService.noticeTypeTotalCnt(type);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("noticeAdminType.do?type="+type, totalCnt, listSize, pageSize, cp);
		
		List<JoaNoticeDTO> list = joaNTService.noticeType(type, cp, pageSize);
		
		mav.addObject("pageStr", pageStr);
		mav.addObject("list",list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice");
		return mav;
	}

	
	@RequestMapping("/serchAdminNotice.do")
	public ModelAndView serchAdminNotice(@RequestParam(value="keyword", required = false)String keyword, @RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		
		int totalCnt=joaNTService.serchNoticeTotalCnt(keyword);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("serchAdminNotice.do?"+keyword, totalCnt, listSize, pageSize, cp);
		
		List<JoaNoticeDTO> list = joaNTService.serchNoticeList(keyword, cp, pageSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice");
		return mav;
	}
	
	@RequestMapping("/adminNoticeBorder.do")
	public ModelAndView adminNoticeBorder(@RequestParam(value="idx", defaultValue = "1")int idx) {
		JoaNoticeDTO dto = joaNTService.noticeBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice_border");
		return mav;
	}
	
	@RequestMapping("/noticeWriteMove.do")
	public ModelAndView noticeWriteMove(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice_border_write");
		return mav;
	}
	
	@RequestMapping("/noticeWrite.do")
	public ModelAndView noticeWrite(JoaNoticeDTO dto) {
		int result = joaNTService.addNotice(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result>0?"공지게시판에 게시글이 등록되었습니다.":"공지게시판 게시글 등록에 실패하였습니다. 관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	@RequestMapping("/reNoticeWriteMove.do")
	public ModelAndView reNoticeWriteMove(@RequestParam(value="idx")int idx) {
		JoaNoticeDTO dto = joaNTService.noticeBorder(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMNotice_border_ReWrite");
		return mav;
	}
	
	@RequestMapping("/reNoticeWrite.do")
	public ModelAndView reNoticeWrite(JoaNoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = joaNTService.rewriteNotice(dto);
		String msg = result>0?"공지게시판에 게시글이 수정되었습니다.":"공지게시판 게시글 수정에 실패하였습니다. 관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/noticeDelete.do")
	public ModelAndView noticeDelete(@RequestParam(value="idx", defaultValue = "1") int idx) {
		ModelAndView mav = new ModelAndView();
		int result = joaNTService.deleteNotice(idx);
		String msg = result>0?"공지게시판에 게시글이 삭제되었습니다.":"공지게시판 게시글 삭제에 실패하였습니다.관리자에게 문의바랍니다.";
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
		dto.setHqt_state("미답변");
		if(dto.getHqt_cinema()==null) {
			dto.setHqt_cinema("온라인");
		}
		if(dto.getHqt_region()==null) {
			dto.setHqt_region("온라인");
		}
		
		int result = joaHQService.addEmailQuestion(dto);
		String msg = result>0?"문의가 정상적으로 등록되었습니다.":"문의 등록에 실패하였습니다. 1:1문의를 이용해주세요.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_msg");
		return mav;
	
	}
	
	//관리자 이메일 문의
	
	@RequestMapping("/adminEmailHelp.do")
	public ModelAndView adminEmailHelp(@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		String state = "미답변";
		ModelAndView mav = new ModelAndView();
		int totalCnt=joaHQService.emailTotalCnt(state);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("adminEmailHelp.do", totalCnt, listSize, pageSize, cp);
		
		List<JoaHelpQuestionDTO> list = joaHQService.emailList(state, cp, pageSize);
		mav.addObject("backA_color",backA_color);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp");
		return mav;
	}
	
	@RequestMapping("/adminEmailType.do")
	public ModelAndView adminEmailType(@RequestParam(value =  "cp", defaultValue = "1")int cp,@RequestParam(value="hqt_type", required = false)String hqt_type) {
		
		ModelAndView mav = new ModelAndView();
		
		if(hqt_type.equals("편의")) {
			String backB_color = "background-color: #F05650";
			mav.addObject("backB_color", backB_color);
		}else if(hqt_type.equals("결제")) {
			String backC_color = "background-color: #F05650";
			mav.addObject("backC_color", backC_color);
		}else if(hqt_type.equals("이벤트")) {
			String backD_color = "background-color: #F05650";
			mav.addObject("backD_color", backD_color);
		}else if(hqt_type.equals("분실")) {
			String backE_color = "background-color: #F05650";
			mav.addObject("backE_color", backE_color);
		}else if(hqt_type.equals("서비스")) {
			String backF_color = "background-color: #F05650";
			mav.addObject("backF_color", backF_color);
		}
		
		String state="미답변";
		int totalCnt=joaHQService.emailTypeTotalCnt(hqt_type,state);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("adminEmailType.do?hqt_type="+hqt_type, totalCnt, listSize, pageSize, cp);
		
		List<JoaHelpQuestionDTO> list = joaHQService.emailTypeList(state, hqt_type, cp, pageSize);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp");
		return mav;
	}
	
	@RequestMapping("/adminEmailSerch.do")
	public ModelAndView adminEmailSerch(@RequestParam(value =  "cp", defaultValue = "1")int cp, @RequestParam(value="hqt_type", required = false)String hqt_type, @RequestParam(value="hqt_region", required = false)String hqt_region, @RequestParam(value="hqt_cinema", required = false)String hqt_cinema) {
		String state ="미답변";
		ModelAndView mav = new ModelAndView();
		String pagename=null;
		if(hqt_type==null||hqt_type.equals("")) {
			
			String backA_color = "background-color: #F05650";
			mav.addObject("backA_color", backA_color);
			
			hqt_type="hqt_type is not null";
		}else{
			
			if(hqt_type.equals("편의")) {
				String backB_color = "background-color: #F05650";
				mav.addObject("backB_color", backB_color);
			}else if(hqt_type.equals("결제")) {
				String backC_color = "background-color: #F05650";
				mav.addObject("backC_color", backC_color);
			}else if(hqt_type.equals("이벤트")) {
				String backD_color = "background-color: #F05650";
				mav.addObject("backD_color", backD_color);
			}else if(hqt_type.equals("분실")) {
				String backE_color = "background-color: #F05650";
				mav.addObject("backE_color", backE_color);
			}else if(hqt_type.equals("서비스")) {
				String backF_color = "background-color: #F05650";
				mav.addObject("backF_color", backF_color);
			}
			
			pagename="adminEmailSerch.do?hqt_type="+hqt_type;
			hqt_type="hqt_type='"+hqt_type+"'";
		}
		if(hqt_region==null||hqt_region.equals("")||hqt_region.equals("지역선택")) {
			hqt_region="hqt_region is not null";
		}else {
			
			if(hqt_type.equals("hqt_type is not null")) {
				pagename="adminEmailSerch.do?hqt_region="+hqt_region;
			}else {
				pagename+="&hqt_region="+hqt_region;
			}
			hqt_region="hqt_region='"+hqt_region+"'";
		}
		if(hqt_cinema==null||hqt_cinema.equals("")||hqt_cinema.equals("영화관선택")) {
			hqt_cinema="hqt_cinema is not null";
		}else {
			pagename+="&hqt_cinema="+hqt_cinema;
			hqt_cinema="hqt_cinema='"+hqt_cinema+"'";
		}
		
		int totalCnt=joaHQService.emailSerchTotalCnt(state, hqt_type, hqt_region, hqt_cinema);
		int listSize=5;
		int pageSize=5;
		String pageStr=null;
		if(hqt_type.equals("hqt_type is not null") && hqt_region.equals("hqt_region is not null") && hqt_cinema.equals("hqt_cinema is not null")) {
			pageStr=joa.page.PageModule.makePage("adminEmailHelp.do", totalCnt, listSize, pageSize, cp);
		}else {
			pageStr=joa.page.Sub_PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
		}

		List<JoaHelpQuestionDTO> list = joaHQService.emailSerchList(state, hqt_type, hqt_region, hqt_cinema, cp, pageSize);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp");
		return mav;
	}
	
	@RequestMapping("/adminEmailBorder.do")
	public ModelAndView adminEmailBorder(@RequestParam(value="idx",defaultValue = "1")int idx) {
		ModelAndView mav = new ModelAndView();
		JoaHelpQuestionDTO dto = joaHQService.questionBorder(idx);
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMEmailHelp_border");
		return mav;
	}
	
	@RequestMapping("/answerEmailHelp.do")
	public ModelAndView answerEmailHelp(JoaHelpQuestionDTO dto) {
		dto.setHqt_state("답변완료");
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
		dto.setHqt_state("미답변");
		if(dto.getHqt_cinema()==null) {
			dto.setHqt_cinema("온라인");
		}
		if(dto.getHqt_region()==null) {
			dto.setHqt_region("온라인");
		}
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.addQuestion(dto);
		String msg = result>0?"1:1문의 등록이 완료되었습니다.":"1:1문의 등록이 실패하였습니다.아래 전화번호로 상담 및 문의를 해주세요.02-7777-7777";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/memberHelp/joaHelpDek_msg");
		return mav;
	}
	
	//1:1 문의 관리자 페이지
	
	@RequestMapping("/memberHelp.do")
	public ModelAndView serchMemberHelp(@RequestParam(value="cp",defaultValue = "1") int cp) {
		
		String backA_color = "background-color: #F05650";
		String state = "미답변";
		ModelAndView mav = new ModelAndView();
		int totalCnt=joaHQService.questionTotalCnt(state);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("adminEmailHelp.do", totalCnt, listSize, pageSize, cp);
		
		List<JoaHelpQuestionDTO> list = joaHQService.questionList(state, cp, pageSize);
		mav.addObject("backA_color",backA_color);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp");
		return mav;
	}
		@RequestMapping("/adminQuestionType.do")
		public ModelAndView adminQuestionType(@RequestParam(value =  "cp", defaultValue = "1")int cp,@RequestParam(value="hqt_type", required = false)String hqt_type) {
		
		ModelAndView mav = new ModelAndView();
		
		if(hqt_type.equals("편의")) {
			String backB_color = "background-color: #F05650";
			mav.addObject("backB_color", backB_color);
		}else if(hqt_type.equals("결제")) {
			String backC_color = "background-color: #F05650";
			mav.addObject("backC_color", backC_color);
		}else if(hqt_type.equals("이벤트")) {
			String backD_color = "background-color: #F05650";
			mav.addObject("backD_color", backD_color);
		}else if(hqt_type.equals("분실")) {
			String backE_color = "background-color: #F05650";
			mav.addObject("backE_color", backE_color);
		}else if(hqt_type.equals("서비스")) {
			String backF_color = "background-color: #F05650";
			mav.addObject("backF_color", backF_color);
		}
		
		String state="미답변";
		int totalCnt=joaHQService.questionTypeTotalCnt(hqt_type,state);
		int listSize=5;
		int pageSize=5;
		String pageStr=joa.page.Sub_PageModule.makePage("adminQuestionType.do?hqt_type="+hqt_type, totalCnt, listSize, pageSize, cp);
		
		List<JoaHelpQuestionDTO> list = joaHQService.questionTypeList(state, hqt_type, cp, pageSize);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp");
		return mav;
	}
		
		@RequestMapping("/adminSerchList.do")
		public ModelAndView adminSerchList(@RequestParam(value =  "cp", defaultValue = "1")int cp, @RequestParam(value="hqt_type", required = false)String hqt_type, @RequestParam(value="hqt_region", required = false)String hqt_region, @RequestParam(value="hqt_cinema", required = false)String hqt_cinema) {
			String state ="미답변";
			ModelAndView mav = new ModelAndView();
			String pagename=null;
			if(hqt_type==null||hqt_type.equals("")) {
				
				String backA_color = "background-color: #F05650";
				mav.addObject("backA_color", backA_color);
				
				hqt_type="hqt_type is not null";
			}else{
				
				if(hqt_type.equals("편의")) {
					String backB_color = "background-color: #F05650";
					mav.addObject("backB_color", backB_color);
				}else if(hqt_type.equals("결제")) {
					String backC_color = "background-color: #F05650";
					mav.addObject("backC_color", backC_color);
				}else if(hqt_type.equals("이벤트")) {
					String backD_color = "background-color: #F05650";
					mav.addObject("backD_color", backD_color);
				}else if(hqt_type.equals("분실")) {
					String backE_color = "background-color: #F05650";
					mav.addObject("backE_color", backE_color);
				}else if(hqt_type.equals("서비스")) {
					String backF_color = "background-color: #F05650";
					mav.addObject("backF_color", backF_color);
				}
				
				pagename="adminSerchList.do?hqt_type="+hqt_type;
				hqt_type="hqt_type='"+hqt_type+"'";
			}
			if(hqt_region==null||hqt_region.equals("")||hqt_region.equals("지역선택")) {
				hqt_region="hqt_region is not null";
			}else {
				
				if(hqt_type.equals("hqt_type is not null")) {
					pagename="adminSerchList.do?hqt_region="+hqt_region;
				}else {
					pagename+="&hqt_region="+hqt_region;
				}
				hqt_region="hqt_region='"+hqt_region+"'";
			}
			if(hqt_cinema==null||hqt_cinema.equals("")||hqt_cinema.equals("영화관선택")) {
				hqt_cinema="hqt_cinema is not null";
			}else {
				pagename+="&hqt_cinema="+hqt_cinema;
				hqt_cinema="hqt_cinema='"+hqt_cinema+"'";
			}
			
			int totalCnt=joaHQService.serchQuestionTotalCnt(state, hqt_type, hqt_region, hqt_cinema);
			int listSize=5;
			int pageSize=5;
			String pageStr=null;
			if(hqt_type.equals("hqt_type is not null") && hqt_region.equals("hqt_region is not null") && hqt_cinema.equals("hqt_cinema is not null")) {
				pageStr=joa.page.PageModule.makePage("adminSerchList.do", totalCnt, listSize, pageSize, cp);
			}else {
				pageStr=joa.page.Sub_PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
			}

			List<JoaHelpQuestionDTO> list = joaHQService.serchQuestionList(state, hqt_type, hqt_region, hqt_cinema, cp, pageSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("list", list);
			mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp");
			return mav;
		}	
		
	@RequestMapping("/memberHelpBorder.do")
	public ModelAndView memberHelpBorder(@RequestParam(value="idx",defaultValue = "1") int idx) {
		ModelAndView mav = new ModelAndView();
		JoaHelpQuestionDTO dto = joaHQService.questionBorder(idx);
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_border");
		return mav;
	}
	
	@RequestMapping("/answerMemberHelp.do")
	public ModelAndView answerMemberHelp(JoaHelpQuestionDTO dto) {
		dto.setHqt_state("답변완료");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.answerQuestion(dto);
		String msg = result>0?"1:1문의 답변이 정상적으로 등록됬습니다.":"1:1문의 답변 등록에 실패했습니다. 관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	@RequestMapping("/reAnswerMemberHelp.do")
	public ModelAndView reAnswerMemberHelp(JoaHelpQuestionDTO dto) {
		dto.setHqt_state("답변완료");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.reanswerQuestion(dto);
		String msg = result>0?"1:1문의 답변이 정상적으로 등록됬습니다.":"1:1문의 답변 등록에 실패했습니다. 관리자에게 문의바랍니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
	
	//지점관리자 답변열람 페이지
	
	@RequestMapping("/topAdmin.do")
	public ModelAndView topAdmin(@RequestParam(value =  "cp", defaultValue = "1")int cp) {
		String backA_color = "background-color: #F05650";
		
		int totalCnt=joaHQService.topQuestionTotalCnt();
		int listSize=5;	
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("topAdmin.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav = new ModelAndView();
		List<JoaHelpQuestionDTO>list = joaHQService.topQuestionList(cp, listSize); 
		mav.addObject("backA_color", backA_color);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_TopAdmin");
		return mav;
	}
	
	@RequestMapping("/topAdminQuestionType.do")
	public ModelAndView topAdminQuestionType(@RequestParam(value =  "cp", defaultValue = "1")int cp,@RequestParam(value="hqt_type", required = false)String hqt_type) {
	
	ModelAndView mav = new ModelAndView();
	
	if(hqt_type.equals("편의")) {
		String backB_color = "background-color: #F05650";
		mav.addObject("backB_color", backB_color);
	}else if(hqt_type.equals("결제")) {
		String backC_color = "background-color: #F05650";
		mav.addObject("backC_color", backC_color);
	}else if(hqt_type.equals("이벤트")) {
		String backD_color = "background-color: #F05650";
		mav.addObject("backD_color", backD_color);
	}else if(hqt_type.equals("분실")) {
		String backE_color = "background-color: #F05650";
		mav.addObject("backE_color", backE_color);
	}else if(hqt_type.equals("서비스")) {
		String backF_color = "background-color: #F05650";
		mav.addObject("backF_color", backF_color);
	}
	int totalCnt=joaHQService.topQuestionTypeTotalCnt(hqt_type);
	int listSize=5;
	int pageSize=5;
	String pageStr=joa.page.Sub_PageModule.makePage("topAdminQuestionType.do?hqt_type="+hqt_type, totalCnt, listSize, pageSize, cp);
	
	List<JoaHelpQuestionDTO> list = joaHQService.topQuestionTypeList(hqt_type, cp, pageSize);
	mav.addObject("pageStr", pageStr);
	mav.addObject("list", list);
	mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_TopAdmin");
	return mav;
}
	
	@RequestMapping("/topAdminSerchList.do")
	public ModelAndView topAdminSerchList(@RequestParam(value =  "cp", defaultValue = "1")int cp,@RequestParam(value="hqt_state", required = false)String hqt_state, @RequestParam(value="hqt_type", required = false)String hqt_type, @RequestParam(value="hqt_region", required = false)String hqt_region, @RequestParam(value="hqt_cinema", required = false)String hqt_cinema) {
		ModelAndView mav = new ModelAndView();
		String pagename=null;
		if(hqt_type==null||hqt_type.equals("")) {
			
			String backA_color = "background-color: #F05650";
			mav.addObject("backA_color", backA_color);
			
			hqt_type="hqt_type is not null";
		}else{
			
			if(hqt_type.equals("편의")) {
				String backB_color = "background-color: #F05650";
				mav.addObject("backB_color", backB_color);
			}else if(hqt_type.equals("결제")) {
				String backC_color = "background-color: #F05650";
				mav.addObject("backC_color", backC_color);
			}else if(hqt_type.equals("이벤트")) {
				String backD_color = "background-color: #F05650";
				mav.addObject("backD_color", backD_color);
			}else if(hqt_type.equals("분실")) {
				String backE_color = "background-color: #F05650";
				mav.addObject("backE_color", backE_color);
			}else if(hqt_type.equals("서비스")) {
				String backF_color = "background-color: #F05650";
				mav.addObject("backF_color", backF_color);
			}
			
			pagename="topAdminSerchList.do?hqt_type="+hqt_type;
			hqt_type="hqt_type='"+hqt_type+"'";
		}
		if(hqt_region==null||hqt_region.equals("")||hqt_region.equals("지역선택")) {
			hqt_region="hqt_region is not null";
		}else {
			
			if(hqt_type.equals("hqt_type is not null")) {
				pagename="topAdminSerchList.do?hqt_region="+hqt_region;
			}else {
				pagename+="&hqt_region="+hqt_region;
			}
			hqt_region="hqt_region='"+hqt_region+"'";
		}
		if(hqt_cinema==null||hqt_cinema.equals("")||hqt_cinema.equals("영화관선택")) {
			hqt_cinema="hqt_cinema is not null";
		}else {
			pagename+="&hqt_cinema="+hqt_cinema;
			hqt_cinema="hqt_cinema='"+hqt_cinema+"'";
		}
		if(hqt_state==null||hqt_state.equals("")) {
			hqt_state="hqt_state is not null";
		}else {
			pagename+="&hqt_state="+hqt_state;
			hqt_state="hqt_state='"+hqt_state+"'";
		}
		
		int totalCnt=joaHQService.topSerchQuestionTotalCnt(hqt_type, hqt_region, hqt_cinema,hqt_state);
		int listSize=5;
		int pageSize=5;
		String pageStr=null;
		if(hqt_type.equals("hqt_type is not null") && hqt_region.equals("hqt_region is not null") && hqt_cinema.equals("hqt_cinema is not null") && hqt_state.equals("hqt_state is not null")) {
			pageStr=joa.page.PageModule.makePage("topAdminSerchList.do", totalCnt, listSize, pageSize, cp);
		}else {
			pageStr=joa.page.Sub_PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
		}

		List<JoaHelpQuestionDTO> list = joaHQService.topSerchQuestionList(hqt_type, hqt_region, hqt_cinema,hqt_state, cp, pageSize);
		mav.addObject("pageStr", pageStr);
		mav.addObject("list", list);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_TopAdmin");
		return mav;
	}	
	
	
	@RequestMapping("/topAdminBorder.do")
	public ModelAndView topAdminBorder(@RequestParam(value="idx",defaultValue = "1") int idx) {
		ModelAndView mav = new ModelAndView();
		JoaHelpQuestionDTO dto = joaHQService.questionBorder(idx);
		mav.addObject("dto", dto);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_ADMMemberHelp_TopAdmin_border");
		return mav;
	}
	
	@RequestMapping("/reAnswerSet.do")
	public ModelAndView reAnswerSet(JoaHelpQuestionDTO dto) {
		dto.setHqt_state("재답변");
		ModelAndView mav = new ModelAndView();
		int result = joaHQService.reanswerQuestion(dto);
		String msg = result>0?"재답변 설정이 완료되었습니다.":"재답변 설정이 실패했습니다.";
		mav.addObject("msg", msg);
		mav.setViewName("joaHelpDesk/adminHelp/joaHelpDek_MSG");
		return mav;
	}
}
