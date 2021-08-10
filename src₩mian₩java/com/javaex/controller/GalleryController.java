package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Autowired
	 private  GalleryService galleryService; 
	
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("[GalleryController.list]");
	
		
		List<GalleryVo> galleryVo  = galleryService.getImgList();
		model.addAttribute("galleryList", galleryVo);
		
		System.out.println(1);
		System.out.println(galleryVo);
		
		
		
		return "gallery/list";
	}
	
	
	@RequestMapping(value="/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String imgWrite(Model model, @RequestParam("file") MultipartFile file) {
		System.out.println("[GalleryController.write]");
		
		
			String saveName = galleryService.imgWrite(file);
			System.out.println(saveName);
			model.addAttribute("saveName", saveName);

		return"";
	}
}
