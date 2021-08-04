package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService; 
	
	//리스트 가져오기
	@RequestMapping(value = "/gbc/addlist", method = {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("[GuestbookController.getAddList()]");
		
		
		List<GuestbookVo> guestbookVo = guestbookService.getAddList();
		
		model.addAttribute("addList", guestbookVo);
		System.out.println("---------------------1");
		System.out.println(guestbookVo);
		
		return"guestbook/addList";
	}
	
	//리스트 등록
	@RequestMapping(value = "/gbc/add", method = {RequestMethod.POST, RequestMethod.GET})
	public String add(GuestbookVo guestbookVo) {
		System.out.println("[GuestbookController.add()]");
		System.out.println(guestbookVo);
		
		guestbookService.getAdd(guestbookVo);
		
		
		return "redirect:/gbc/addlist";

	}
	
	@RequestMapping(value = "/gbc/deleteform", method = {RequestMethod.POST, RequestMethod.GET})
	public String deleteform(@RequestParam("no") int no, Model model) {
		System.out.println("[GuestbookController.deleteform()]");
		System.out.println(no);
		
		GuestbookVo guestbookVo = guestbookService.getdeleteform(no);
		System.out.println("----------------");
		System.out.println(guestbookVo);
		
	 	model.addAttribute("guestbookVo", guestbookVo);
		
		return "guestbook/deleteform";
		
	}
	
	@RequestMapping(value = "/gbc/delete", method = {RequestMethod.POST, RequestMethod.GET})
	public String modify(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("[GuestbookController.delete()]");
		System.out.println(guestbookVo);
		
		guestbookService.getDelete(guestbookVo);
		
		
		
		return "redirect:/gbc/addlist";
	}
	
	//ajax방명록 메인페이지 
	@RequestMapping(value = "/gbc/ajaxMain", method = {RequestMethod.POST, RequestMethod.GET})
	public String ajaxMain() {
		System.out.println("[GuestbookController.ajaxMain()]");		
		
		return"guestbook/ajaxList";
	}
	
	
	
	
	
	
	
	
}
