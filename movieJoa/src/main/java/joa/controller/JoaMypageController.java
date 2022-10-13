package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoaMypageController {
	
	@RequestMapping("/myPage.do")
	public String myPage() {
		return "joaMyPage/joaMyPage_myPage";
	}

}
