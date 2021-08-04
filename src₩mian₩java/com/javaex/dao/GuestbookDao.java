package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GuestbookVo> getAddList() {
		System.out.println("[GuestbookDao.getAddList()]");
		
		
		
		List<GuestbookVo> guestbookVo = sqlSession.selectList("guestbook.getAddList");
		
		System.out.println("---------------------3");
		System.out.println(guestbookVo);
		
		return guestbookVo;
	}
	
	public GuestbookVo getAdd(GuestbookVo guestbookVo) {
		System.out.println("[GuestbookDao.getAdd()]");
		System.out.println(guestbookVo);
		sqlSession.insert("guestbook.getAdd", guestbookVo);
		
		return null;
	}
	
	public GuestbookVo getdeleteform(int no) {
		System.out.println("[GuestbookDao.deleteform()]");
		System.out.println(no);
		
		GuestbookVo guestbookVo = sqlSession.selectOne("guestbook.selectBook", no);
		System.out.println("----------------");
		System.out.println(guestbookVo);
		return guestbookVo;
	}

	public int getdelete(GuestbookVo guestbookVo) {
		System.out.println("[BoardDao.delete()]");
		System.out.println(guestbookVo);
		
		
		int count = sqlSession.delete("getDeletebook", guestbookVo);
		
		return count;
	}
	
	//방명록 글 저장 - ajax
	public int insertGuestbookKey(GuestbookVo guestbookVo) {
		System.out.println("[GuestbookDao.insertGuestbookKey()]");

		
		
		return sqlSession.insert("guestbook.insertGuestbookKey", guestbookVo);
		
	}
	
	//방명록 글 가져오기 - ajax
	public GuestbookVo selectGuestbook(int no) {
		System.out.println("[GuestbookDao.selectGuestbook()]");
		
		
		System.out.println(no);
		return sqlSession.selectOne("guestbook.selectGuestbook", no);

		
	}
	
	
}
