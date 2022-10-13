package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoaMemberJoinController {
	
	@RequestMapping("/memberJoin.do")
	public String memberJoin() {
		return "joaMemberJoin/joaMemberJoin_memberJoin";
	}

}
