package joa.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import joa.mypage.model.JoaMypageService;
import joa.mypage.model.JoaMypageServiceDTO;
import joa.adminStore.model.AdminStoreDTO;
import joa.mypage.model.JoaMyPagePayMovieDTO;
import joa.mypage.model.JoaMypageEventDTO;
import joa.mypage.model.JoaMypageMemberDTO;
import joa.mypage.model.JoaMypageOwnCouDTO;
import joa.mypage.model.JoaMypagePayProDTO;
import joa.mypage.model.JoaMypageProfileDTO;
import joa.mypage.model.JoaMypageRivewDTO;
@Controller
public class JoaMypageController {
	
	@Autowired
	private JoaMypageService JoaMypageService;
	
	@RequestMapping("/myPageReview.do")
	public ModelAndView myPageReview(@RequestParam(value="sid")String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypageRivewDTO>list = JoaMypageService.memberReview(sid);
		mav.addObject("list", list);
		mav.setViewName("joaMyPage/joaMyPage_myReview");
		return mav;
	}
	
	
	@RequestMapping("/myPage.do")
	public ModelAndView myPage(@RequestParam(value="sid")String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		mav.setViewName("joaMyPage/joaMyPage_myPage");
		return mav;
	}

	@RequestMapping("/myPage_SawMovie.do")
	public ModelAndView myPage_SawMovie(@RequestParam(value="sid")String sid) {
		List<JoaMyPagePayMovieDTO> swm_list =JoaMypageService.memberPayMovie(sid);
		
		List<JoaMypageOwnCouDTO> list = JoaMypageService.memberCoupon(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("swm_list", swm_list);
		mav.addObject("m_grade", m_grade);
		mav.addObject("list", list);
		mav.addObject("dto", dto);
		mav.setViewName("joaMyPage/joa_Mypage_SawMovie");
		return mav;
	}
	
	@RequestMapping("/myPage_tiket.do")
	public ModelAndView myPage_tiket(@RequestParam(value="sid")String sid) {
		List<JoaMyPagePayMovieDTO> swm_list =JoaMypageService.memberPayMovie(sid);
		
		List<JoaMypageOwnCouDTO> list = JoaMypageService.memberCoupon(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("swm_list", swm_list);
		mav.addObject("m_grade", m_grade);
		mav.addObject("list", list);
		mav.addObject("dto", dto);	
		mav.setViewName("joaMyPage/joa_Mypage_ticketing");
		return mav;
	}

	@RequestMapping("/myPage_cancle_Coupon.do")
	public ModelAndView myPage_cancle_Coupon(@RequestParam(value="sid", required=false)String sid, @RequestParam(value="idx",  defaultValue = "1")int idx) {
		ModelAndView mav = new ModelAndView();
		int result = JoaMypageService.deleteCoupon(sid, idx);
		mav.addObject("result", result);
		mav.setViewName("joaMyPage/joa_Mypage_cancelCoupon");
		return mav;
	}
	
	@RequestMapping("/myPage_coupon.do")
	public ModelAndView myPage_coupon(@RequestParam(value="sid")String sid) {
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypageOwnCouDTO> list = JoaMypageService.memberCoupon(sid);
		
		mav.addObject("list", list);
		mav.setViewName("joaMyPage/joa_Mypage_coupon");
		return mav;
	}
	
	@RequestMapping("/myPage_usedCoupon.do")
	public ModelAndView myPage_usedCoupon(@RequestParam(value="sid", required=false)String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypageOwnCouDTO> list = JoaMypageService.memberUsedCoupon(sid);
		mav.addObject("list", list);
		mav.setViewName("joaMyPage/joa_Mypage_usedCoupon");
		return mav;
	}
	
	@RequestMapping("/myPage_GuidePoint.do")
	public ModelAndView myPage_GuidePoint() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_GuidePoint");
		return mav;
	}
	
	@RequestMapping("/myPage_Point.do")
	public ModelAndView myPage_Point(@RequestParam(value="sid", required=false)String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		String plusPoint="5%";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
			plusPoint="7%";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
			plusPoint="9%";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
			plusPoint="10%";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("plusPoint", plusPoint);
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		mav.setViewName("joaMyPage/joa_Mypage_Point");
		return mav;
	}
	
	@RequestMapping("/myPage_Event.do")
	public ModelAndView myPage_Event(@RequestParam(value="sid", required=false)String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypageEventDTO> list = JoaMypageService.memberEventList(sid);

		mav.addObject("list", list);
		mav.setViewName("joaMyPage/joa_Mypage_Event");
		return mav;
	}
	@RequestMapping("/myPage_EndEvent.do")
	public ModelAndView myPage_EndEvent(@RequestParam(value="sid", required=false)String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypageEventDTO> list = JoaMypageService.endEventList();

		mav.addObject("list", list);
		
		mav.setViewName("joaMyPage/joa_Mypage_Event");
		return mav;
	}
	
	@RequestMapping("/myPage_Store.do")
	public ModelAndView myPage_Store(@RequestParam(value="sid", required=false)String sid) {
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypagePayProDTO>list = JoaMypageService.memberStore(sid);
		mav.addObject("list", list);
		mav.setViewName("joaMyPage/joa_Mypage_myStore");
		return mav;
	}
	
	@RequestMapping("/myPage_Store_Payment.do")
	public ModelAndView myPage_Store_Payment(@RequestParam(value="sid", required=false)String sid) {
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypagePayProDTO>list = JoaMypageService.memberStore(sid);
		List<JoaMypagePayProDTO>pricelist = JoaMypageService.memberPrice(sid);
		mav.addObject("pricelist", pricelist);
		mav.setViewName("joaMyPage/joa_Mypage_myStore_Payment");
		return mav;
	}
	
	@RequestMapping("/myPage_PW_Check_P.do")
	public ModelAndView myPage_PW_Check_P() {
		String subject = "프로필 관리";
		String content = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프로필 정보를 열람 시 비밀번호가 필요합니다.";
		String action = "myPage_Nname.do";
		ModelAndView mav = new ModelAndView();
		mav.addObject("action",action);
		mav.addObject("content", content);
		mav.addObject("subject", subject);
		mav.setViewName("joaMyPage/joa_Mypage_PW_Check");
		return mav;
	}
	
	@RequestMapping("/myPage_PW_Check_E.do")
	public ModelAndView myPage_PW_Check_E() {
		String subject = "회원탈퇴";
		String content = "회원 탈퇴하시려면 비밀번호가 필요합니다.<br>탈퇴 후 <d>1개월간</d> 같은 개인정보로 회원가입이 불가능합니다.<br><br>";
		String action = "myPage_secession.do";
		ModelAndView mav = new ModelAndView();
		mav.addObject("action",action);
		mav.addObject("content", content);
		mav.addObject("subject", subject);
		mav.setViewName("joaMyPage/joa_Mypage_PW_Check");
		return mav;
	}
	
	@RequestMapping("/myPage_PW_Check_M.do")
	public ModelAndView myPage_PW_Check_M() {
		String subject = "개인정보변경";
		String content = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원 정보를 수정하시려면 비밀번호가 필요합니다.";
		String action = "myPage_Profile.do";
		ModelAndView mav = new ModelAndView();
		mav.addObject("action",action);
		mav.addObject("content", content);
		mav.addObject("subject", subject);
		mav.setViewName("joaMyPage/joa_Mypage_PW_Check");
		return mav;
	}
	
	@RequestMapping("/myPage_myService.do")
	public ModelAndView myPage_myService(@RequestParam(value="sid", required=false)String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		List<JoaMypageServiceDTO> list = JoaMypageService.memberService(sid);
		mav.addObject("list", list);
		mav.setViewName("joaMyPage/joa_Mypage_myService");
		return mav;
	}
	
	@RequestMapping("/myPage_Profile.do")
	public ModelAndView myPage_Profile(@RequestParam(value="sid", required=false)String sid) {

		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		mav.setViewName("joaMyPage/joa_Mypage_myProfile");
		return mav;
	}
	
	@RequestMapping("/myPage_secession.do")
	public ModelAndView myPage_secession(@RequestParam(value="sid", required=false)String sid) {
		
		List<JoaMypageOwnCouDTO> datelist = JoaMypageService.memberCouponDate(sid);
		
		int couponCount = JoaMypageService.memberCouponCnt(sid);
		
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		String m_grade = "일반";
		if(dto.getMem_grade()>=10000 && dto.getMem_grade()<25000) {
			m_grade = "VIP";
		}
		if(dto.getMem_grade()>=25000 && dto.getMem_grade()<40000) {
			m_grade = "SVIP";
		}
		if(dto.getMem_grade()>=40000) {
			m_grade = "VVIP";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_grade", m_grade);
		mav.addObject("datelist", datelist);
		mav.addObject("couponCount", couponCount);
		mav.addObject("dto", dto);
		
		
		int result = JoaMypageService.memberDelete(sid);
		String msg = result>0?"회원탈퇴가 정상적으로 진행되었습니다.":"회원탈퇴가 실패했습니다. 관리자에게 문의바랍니다.";
		boolean link_tf=true;
		mav.addObject("link_tf", link_tf);
		mav.addObject("msg",msg);
		
		mav.setViewName("joaMyPage/joa_Mypage_msg");
		return mav;
	}
	
	@RequestMapping("/myPage_Nname.do")
	public ModelAndView myPage_Nname(@RequestParam(value="sid", required=false)String sid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_myNname");
		return mav;
	}
	
	@RequestMapping("/addProfile.do")
	public ModelAndView addProduct(JoaMypageProfileDTO dto,@RequestParam("img")MultipartFile img, HttpServletRequest req) {

		String path=req.getRealPath("/img/joaPofiel_img");
		String filename=img.getOriginalFilename();
		File f=new File(path+filename);		
		dto.setPro_image(img.getOriginalFilename());

		int result= JoaMypageService.memberProfile(dto);
		String msg=result>0?"프로필 등록 성공":"프로필 등록 실패";
		ModelAndView mav=new ModelAndView();
		boolean link_tf=true;
		mav.addObject("msg",msg);
		mav.addObject("link_tf", link_tf);
		mav.setViewName("joaMypage/joa_Mypage_msg");
		return mav;
	}
	
	@RequestMapping("/self_ATNTCN.do")
	public ModelAndView self_ATNTCN() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_self_ATNTCN");
		return mav;
	}
}
