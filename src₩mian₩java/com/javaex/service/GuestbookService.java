package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired 
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getAddList() {
		System.out.println("[GuestbookService.getAddList()]");
		
		List<GuestbookVo> guestbookVo = guestbookDao.getAddList();
		
		System.out.println("---------------------2");
		System.out.println(guestbookVo);
		
		return guestbookVo;
	}
	
	public GuestbookVo  getAdd(GuestbookVo guestbookVo) {
		System.out.println("[GuestbookService.getAdd()]");
		System.out.println(guestbookVo);
		
		guestbookDao.getAdd(guestbookVo);
		
		return null;
	} 
	
	public GuestbookVo getdeleteform(int no) {
		System.out.println("[GuestbookService.deleteform()]");
		System.out.println(no);
		
		GuestbookVo guestbookVo = guestbookDao.getdeleteform(no);
		System.out.println("----------------");
		System.out.println(guestbookVo);
		
		
		return guestbookVo;
	}
	
	public GuestbookVo getDelete(GuestbookVo guestbookVo) {
		System.out.println("[BoardService.delete()]");
		System.out.println(guestbookVo);
		
		
		guestbookDao.getdelete(guestbookVo);
		
		return guestbookVo;
	}
	
	
}
