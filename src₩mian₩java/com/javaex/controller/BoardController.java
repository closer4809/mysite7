package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 페이징 연습용 리스트
	@RequestMapping(value = "/board/list2", method = {RequestMethod.POST, RequestMethod.GET})
	public String list2(Model model, 	//crtpage 벨류가 있든 없든 디폴트값 1페이지 표츌
						@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage,
						@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
		System.out.println("[BoardController.list2]"); 
		
		
		
		
		
		Map<String, Object> listMap = boardService.getList2(crtPage, keyword);
		
		
		model.addAttribute("listMap" ,listMap);
		
		return "board/list2";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/board/read", method = {RequestMethod.POST, RequestMethod.GET})
	public String read(Model model, @RequestParam("no") int no) {
		System.out.println("[BoardController.read]");
		//System.out.println(no);
		
		BoardVo boardVo = boardService.getBoard(no); 
		System.out.println(boardVo);
		
		model.addAttribute("boardVo", boardVo);
		
		
		return"board/read";
	}
	
	@RequestMapping(value = "/board/list", method = {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("[BoardController.list]"); 
		
		
		List<BoardVo> boardVo = boardService.getList();
		
		model.addAttribute("boardList", boardVo);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/board/delete", method = {RequestMethod.POST, RequestMethod.GET})
	public String delete(@RequestParam("no") int no) {
		System.out.println("[BoardController.delete]");
		System.out.println(no);
		
		boardService.getDelete(no);
		
		return "redirect:/board/list";
		
		
	}
	
	@RequestMapping(value = "/board/write", method = {RequestMethod.POST, RequestMethod.GET})
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("[BoardController.getWrite()]");
		System.out.println(boardVo);
		boardService.getWrite(boardVo);
		
		
		
		return "redirect:/board/list";	
		
	}
	
	@RequestMapping(value = "/board/writeform", method = {RequestMethod.POST, RequestMethod.GET})
	public String writeForn(){
		System.out.println("[BoardController.WriteForm()]");
		
	
		
		
		
		return "board/writeForm";
	}

	
	
	
	
	@RequestMapping(value = "/board/modifyform", method = {RequestMethod.POST, RequestMethod.GET})
	public String modifyForm(@RequestParam("no") int no, Model model){
		System.out.println("[BoardController.modifyForm()]");
		System.out.println(no);
		
		BoardVo boardVo = boardService.getModifyForm(no);
		
		System.out.println("----------------");

		System.out.println(boardVo);
		
		model.addAttribute("boardVo", boardVo);
		
		return "board/modifyForm";
	}
	
	@RequestMapping(value = "/board/modify", method = {RequestMethod.POST, RequestMethod.GET})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("[BoardController.modify()]");
		System.out.println(boardVo);
		
		boardService.getModify(boardVo);
		
		
		
		return"redirect:/board/list";
	}










}

