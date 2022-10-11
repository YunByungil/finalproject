package joa.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminTheaterController {

	@RequestMapping("theatherAddForm.do")
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
					String temp=rows[i]+(j+1);
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
	public String theaterAddSubmit(String seats_s,String theater,@RequestParam(value="width",defaultValue = "-1") int width , @RequestParam(value="height",defaultValue = "-1") int height) {
		int start=0;
		int le=0;
		int ri=0;
		String[][] seats=new String[height][width];
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
		for (int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				
			}
		}
		return "";
	}
}
