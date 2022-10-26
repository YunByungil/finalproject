package joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.book.model.*;
import joa.theater.model.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class JoaTheaterController {
	
	@Autowired
	private JoaBookService joaBookService;
	
	@Autowired
	private TheaterTimeService theaterTimeService;

	@RequestMapping("/joaTheater.do")
	public ModelAndView base(@RequestParam(value = "sch_branch",defaultValue = "신촌")String sch_branch,
			@RequestParam(value = "sch_city",defaultValue = "서울")String sch_city) {
		ModelAndView mav = new ModelAndView();
		String mm = "";
		String yoil = "";
		String[] testCity = {"서울","경기","인천","대전/충청","강원","대구","부산/울산","경상","광주/전라/제주"};
		List<JoaBookDTO> branchList = joaBookService.theaterBranchList(sch_city);
		List<JoaBookDTO> goyangList = joaBookService.theaterBranchList("경기");
		List<JoaBookDTO> dayList = joaBookService.theaterDay(sch_city, sch_branch);
		for (int i=0; i<dayList.size(); i++) {
			if (i==0) {
				mm += "<li id="+dayList.get(i).getSch_dayD().substring(0, 10)+" class=checkYoils>"
						+ "<a href=javascript:checkYoil('"+dayList.get(i).getSch_dayD().substring(0, 10)+"')>"+
						dayList.get(i).getSch_dayD().substring(5, 10)+"</a></li> &nbsp;";
				yoil = dayList.get(i).getSch_dayD().substring(5, 10);
			}else {
				mm += "<li id="+dayList.get(i).getSch_dayD().substring(0, 10)+" class=>"
						+ "<a href=javascript:checkYoil('"+dayList.get(i).getSch_dayD().substring(0, 10)+"')>"+
						dayList.get(i).getSch_dayD().substring(5, 10)+"</a></li> &nbsp;";
			}
		}
		System.out.println("yoil : " +yoil);
		List<TheaterTimeDTO> timeList = theaterTimeService.timeList("2022-"+yoil, sch_branch);
		System.out.println("timeList.size() : "+timeList.size());
//		System.out.println("timeList : " +timeList.get(0).getRate());
		
		List<JoaBookDTO> realTimeList = joaBookService.realTimeList("2022-"+yoil, sch_branch);
		
		System.out.println("branchList.size() : "+branchList.size());
		mav.addObject("testCity", testCity);
		mav.addObject("sch_city", sch_city);
		mav.addObject("sch_branch",sch_branch);
		mav.addObject("branchList", branchList);
		mav.addObject("goyangList", goyangList);
		//////////////////dayList
		mav.addObject("dayList", dayList); 
		mav.addObject("mm", mm);
		System.out.println(mm);
		mav.addObject("yoil", yoil);
		/////////////////timeList
		mav.addObject("timeList", timeList);
		mav.addObject("realTimeList", realTimeList);
		
		mav.setViewName("joaTheater/joaTheater_theater");
		return mav;
	}
}
