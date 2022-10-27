package joa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import joa.adminSchedule.model.ScheduleDAO;
import joa.adminSchedule.model.ScheduleDTO;
import joa.adminTheater.model.TheaterDAO;
import joa.adminTheater.model.TheaterDTO;
import joa.adminMem.model.JoaAdminMemberDTO;

@Controller
public class AdminTheaterController {
	
	@Autowired
	private TheaterDAO theaterDao;
	@Autowired
	private ScheduleDAO scheduleDao;

	@RequestMapping("/theaterAddForm.do")
	public String theaterAddForm() {
		return "admin/adminTheater/adminTheater_theaterAdd";
	}
	
	@RequestMapping("/theaterAdd.do")
	public String seat(@RequestParam(value="width",defaultValue = "-1") int width , @RequestParam(value="height",defaultValue = "-1") int height,Map map,String choice_seat,@RequestParam(value="seats",required = false)String[][] seats,@RequestParam(value="seats_s",required = false)String seats_s,String theater) {
		String[] rows = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		if(seats_s==null) {
			seats = new String[height][width];
			for (int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					String temp=rows[i]+(j+1)+"N";
					seats[i][j] = temp;
				}
			}
		}else if(seats_s!=null){
			int start=0;
			int le=0;
			int ri=0;
			seats=new String[height][width];
			for(int i=0;i<seats_s.length();i++) {
				if(seats_s.charAt(i)==',') {
					if(ri==0 && le==0) {
						seats[le][ri]=seats_s.substring(0,i);
						start=i+1;
					}else {
						seats[le][ri]=seats_s.substring(start,i);
						start=i+1;
					}
					ri++;
					if(ri==width) {
						le++;
						ri=0;
					}
				}
			}
			for(int i=0;i<seats.length;i++) {
				for(int j=0;j<seats[i].length;j++) {
					if(seats[i][j].equals(choice_seat)) {
						if(seats[i][j].charAt(seats[i][j].length()-1)!='N') {
							seats[i][j]+="N";
						}else if(seats[i][j].charAt(seats[i][j].length()-1)=='N'){
							seats[i][j]=seats[i][j].substring(0,seats[i][j].length()-1);
						}
					}
				}
			}
		}
		map.put("rows", rows);
		map.put("seats", seats);
		map.put("width",width);
		map.put("height",height);
		map.put("theater",theater);
		return "admin/adminTheater/adminTheater_theaterAddView";
	}
	
	@RequestMapping("/theaterAddSubmit.do")
	public ModelAndView theaterAddSubmit(String seats_s,TheaterDTO dto) {
		String[] rows = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		int start=0;
		int le=0;
		int ri=0;
		String[][] seats=new String[dto.getThe_height()][dto.getThe_width()];
		for(int i=0;i<seats_s.length();i++) {
			if(seats_s.charAt(i)==',') {
				if(ri==0 && le==0) {
					seats[le][ri]=seats_s.substring(0,i);
					start=i+1;
				}else {
					seats[le][ri]=seats_s.substring(start,i);
					start=i+1;
				}
				ri++;
				if(ri==dto.getThe_width()) {
					le++;
					ri=0;
				}
			}
		}
		int ch=0;
		for (int i=0; i<dto.getThe_height(); i++) {
			for(int j=0; j<dto.getThe_width(); j++) {
				ch=0;
				if(i==0) {
					if(seats[i][j].charAt(seats[i][j].length()-1)=='N') {
						for(int y=0;y<dto.getThe_height();y++) {
							if(seats[y][j].charAt(seats[y][j].length()-1)!='N') {
								ch=1;
								break;
							}
						}
						if(ch==0) {
							for(int z=0;z<dto.getThe_height();z++) {
								for(int x=j+1;x<dto.getThe_width();x++) {
									if(seats[z][x].charAt(seats[z][x].length()-1)!='N') {
										int num=Integer.parseInt(seats[z][x].substring(1,seats[z][x].length()));
										seats[z][x]=rows[z]+(num-1);
									}else if(seats[z][x].charAt(seats[z][x].length()-1)=='N'){
										int num=Integer.parseInt(seats[z][x].substring(1,seats[z][x].length()-1));
										seats[z][x]=rows[z]+(num-1)+"N";
									}
								}
							}
						}
					}
				}
			}
		}
		String result="";
		for (int i=0; i<dto.getThe_height(); i++) {
			for(int j=0; j<dto.getThe_width(); j++) {
				result+=seats[i][j]+",";
			}
		}
		dto.setThe_seat(result);
		String msg="";
		String gt=dto.getThe_theater();
		ModelAndView mav=new ModelAndView();
		JoaAdminMemberDTO jdto=theaterDao.adminIdSearch("admin_test");
		Map timap=new HashMap();
		timap.put("gt",gt);
		timap.put("city",jdto.getAdmin_area());
		timap.put("branch",jdto.getAdmin_shop());
		
		List ch_theater=theaterDao.theaterCheck(timap);
		if(ch_theater==null || ch_theater.size()==0) {
			dto.setThe_city(jdto.getAdmin_area());
			dto.setThe_branch(jdto.getAdmin_shop());
			int total=theaterDao.theaterAdd(dto);
			msg=total>0?"좌석 등록 성공":"좌석 등록 실패";
		}else {
			msg="이미 등록된 상영관입니다.";
			mav.addObject("check","c");
		}
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminTheater/adminTheater_theaterAdd_ok");
		return mav;
	}
	
	@RequestMapping("/scheduleAddForm.do")
	public String scheduleAddForm(Map map,Map ad) {
		Date now = new Date();	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nDate=format.format(now);
		JoaAdminMemberDTO jdto=theaterDao.adminIdSearch("admin_test");
		ad.put("city",jdto.getAdmin_area());
		ad.put("branch",jdto.getAdmin_shop());
		List<String> list=scheduleDao.theaterChoice(ad);
		map.put("nDate", nDate);
		map.put("tList",list);
		return "admin/adminTheater/adminTheater_schedule_add";
	}
	
	@RequestMapping("/scheduleAdd.do")
	public ModelAndView scheduleAdd(ScheduleDTO dto,Map map,String start_time,HttpSession session){
		//session id city branch add
		int runtime=scheduleDao.runtimeCheck(dto.getSch_mov_title());
		int hour=Integer.parseInt(start_time.substring(0,start_time.length()-3));
		int min=Integer.parseInt(start_time.substring(start_time.length()-2,start_time.length()));
		int min2=min+runtime;
		int hour2=hour+(min2/60);
		min2=min2%60;
		Map seatInfo=new HashMap();
		String sid="admin_test";
		JoaAdminMemberDTO jdto=theaterDao.adminIdSearch(sid);
		map.put("hour", hour);
		map.put("hour2", hour2);
		map.put("city", jdto.getAdmin_area());
		map.put("branch", jdto.getAdmin_shop());
		map.put("theater", dto.getSch_theater());
		map.put("day", dto.getSch_day());
		List<ScheduleDTO> blist=scheduleDao.branchCheck(map);
		ModelAndView mav=new ModelAndView();
		List list=new ArrayList();
		int count=0;
		if(blist==null || blist.size()==0) {
			System.out.println(blist.get(0));
		}else {
			for(int i=0;i<blist.size();i++) {
				int start=Integer.parseInt(blist.get(i).getSch_start_hour());
				int end=Integer.parseInt(blist.get(i).getSch_end_hour());
				if((start<=hour && end>=hour) || (start<=hour2 && end>=hour2)) {
					count++;
					break;
				}
			}
		}
		
		if(count==0) {
			if(Integer.toString(hour).length()==1) {
				dto.setSch_start_hour("0"+hour);
			}else {
				dto.setSch_start_hour(""+hour);
			}
			if(Integer.toString(min).length()==1) {
				dto.setSch_start_min("0"+min);
			}else {
				dto.setSch_start_min(""+min);
			}
			if(Integer.toString(hour2).length()==1) {
				dto.setSch_end_hour("0"+hour2);
			}else {
				dto.setSch_end_hour(""+hour2);
			}
			if(Integer.toString(min2).length()==1) {
				dto.setSch_end_min("0"+min2);
			}else {
				dto.setSch_end_min(""+min2);
			}
			dto.setSch_dayD(dto.getSch_day());
			dto.setSch_city(jdto.getAdmin_area());
			dto.setSch_branch(jdto.getAdmin_shop());
			seatInfo.put("city", jdto.getAdmin_area());
			seatInfo.put("branch", jdto.getAdmin_shop());
			seatInfo.put("theater",dto.getSch_theater());
			TheaterDTO tdto=scheduleDao.seatSearch(seatInfo);
			dto.setSch_seat(tdto.getThe_seat());
			dto.setSch_height(tdto.getThe_height());
			dto.setSch_width(tdto.getThe_width());
			
			int result=scheduleDao.scheduleInsert(dto); 
			String msg=result>0?"스케줄 등록 성공":"스케줄 등록 실패";
			mav.addObject("msg",msg);
		}else {
			mav.addObject("msg","이미 등록된 스케줄입니다.");
			mav.addObject("check","c");
		}
		mav.setViewName("admin/adminTheater/adminTheater_schedule_addOk");
		return mav;	
	}
	
	@RequestMapping("/dayChoice2.do")
	public String dayChoice2(String day,Map map,String theater) {
		List list=scheduleDao.dayChoice(day);
		map.put("list", list);
		map.put("theater", theater);
		map.put("day",day);
		return "admin/adminTheater/adminTheater_schedule_addView";
	}
	
	@RequestMapping("/scheduleList.do")
	public String scheduleList() {
		return "admin/adminTheater/adminTheater_schedule_list"; 
	}
	
	@RequestMapping("/scheduleListView.do")
	public ModelAndView scheduleListView(String day,@RequestParam(value="cp",defaultValue = "1") int cp) {
		int totalCnt=scheduleDao.scheduleCount(day);
		int listSize=10;
		int pageSize=10;
		String pageStr=joa.page.SchedulePageModule.makePage("scheduleListView.do", totalCnt, listSize, pageSize, cp,day);
		List<ScheduleDTO> list=scheduleDao.scheduleList(cp,listSize,day);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("pageStr",pageStr);
		mav.addObject("day",day);
		mav.setViewName("admin/adminTheater/adminTheater_schedule_listView");
		return mav;
	}
	
	@RequestMapping("/theaterList.do")
	public ModelAndView theaterList(Map map) {
		String sid="admin_test";
		JoaAdminMemberDTO jdto=theaterDao.adminIdSearch(sid);
		map.put("city", jdto.getAdmin_area());
		map.put("branch", jdto.getAdmin_shop());
		System.out.println(jdto.getAdmin_shop());
		List<TheaterDTO> list=theaterDao.theaterListView(map);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("admin/adminTheater/adminTheater_theater_list");
		return mav;
	}
	
	@RequestMapping("/scheduleDelete.do")
	public ModelAndView scheduleDelete(int sch_idx) {
		int result=scheduleDao.scheduleDelete(sch_idx);
		String msg=result>0?"스케줄 삭제 완료":"스케줄 삭제 실패";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("page","scheduleList.do");
		mav.setViewName("admin/adminTheater/adminTheater_DeleteMsg");
		return mav;
	}
	
	@RequestMapping("/theaterDelete.do")
	public ModelAndView theaterDelete(int the_idx) {
		int result=theaterDao.theaterDelete(the_idx);
		String msg=result>0?"상영관 삭제 완료":"상영관 삭제 실패";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("page","theaterList.do");
		mav.setViewName("admin/adminTheater/adminTheater_DeleteMsg");
		return mav;
	}
}
