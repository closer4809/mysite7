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
	
	public int getDelete(GuestbookVo guestbookVo) {
		System.out.println("[GuestbookService.delete()]");
		System.out.println(guestbookVo);
		
		
		int count = guestbookDao.getdelete(guestbookVo);
		
		return count;
	}
	
	//방명록 글 저장_게시글 가져오기
	public GuestbookVo writeResultVo(GuestbookVo guestbookVo) {
		System.out.println("[GuestbookService.writeResultVo()]"); 
		
		//글 저장
		System.out.println(guestbookVo); // no x 
		
		
		int count = guestbookDao.insertGuestbookKey(guestbookVo);
		
		System.out.println(guestbookVo); // no o
		
		int no = guestbookVo.getNo(); //방금 저장한 글 번호
		//글가져오기(방금 등록한 번호)
		GuestbookVo resultVo = guestbookDao.selectGuestbook(no);
		System.out.println(resultVo); 
		return resultVo;
	}
	
}
