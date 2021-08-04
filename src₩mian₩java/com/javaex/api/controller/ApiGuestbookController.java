package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/api/guestbook")
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//ajax 리스트 가져오기
	@ResponseBody
	@RequestMapping(value="/list",  method = {RequestMethod.POST, RequestMethod.GET})
	public List<GuestbookVo> List() {
		System.out.println("[ApiGuestbookController.list]");
		
		List<GuestbookVo> guestbookList = guestbookService.getAddList();
		
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
	
	 //ajax 방명록 저장
	   
	   @ResponseBody
	   @RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	   public GuestbookVo write(@ModelAttribute GuestbookVo guestbookVo) {
	      System.out.println("ApiGuestbookController.write()");
	      System.out.println(guestbookVo);
	      
	     GuestbookVo resultVo = guestbookService.writeResultVo(guestbookVo);
	      
	     System.out.println(resultVo);
	      
	      return resultVo;
	   }
	   
	 //ajax remove
	   @ResponseBody
	   @RequestMapping(value = "/remove", method = { RequestMethod.GET, RequestMethod.POST })
	   public int remove(@ModelAttribute GuestbookVo guestbookVo) {
	      System.out.println("[ApiGuestbookController.remove]");
	      
	      
		     System.out.println(guestbookVo);

		     int count = guestbookService.getDelete(guestbookVo);
		     System.out.println(guestbookVo);
		     System.out.println(count);
		     
	      return count;
	   }

	
	
}
