package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public BoardVo getBoard(int no){
		System.out.println("[BoardService.getBoard()]");
		System.out.println(no);
		
		//조회수 올리기
		int count = boardDao.updateHit(no);
		
		//게시판 정보 가져오기
	      BoardVo boardVo = boardDao.selectBoard(no);
		return boardVo;
	}
	
	public List<BoardVo> getList() {
		System.out.println("[BoardService.getList()]");

		List<BoardVo> boardVo = boardDao.getList();
		
		return boardVo;
	}
	
	public void getDelete(int no) {
		System.out.println("[BoardService.getDelete()]");

		boardDao.getDelete(no);
		
		return;
	}
	
	public BoardVo getWrite(BoardVo boardVo) {
		System.out.println("[BoardService.getWrite()]");

		boardDao.getWrite(boardVo);
		
		return boardVo;
	}

	
	public BoardVo getModifyForm(int no) {
		System.out.println("[BoardService.getModifyForm()]");
		System.out.println(no);
		BoardVo boardVo = boardDao.getModifyForm(no);
		System.out.println("----------------");
		System.out.println(boardVo);
		
		return boardVo;
	}

	public BoardVo getModify(BoardVo boardVo) {
		System.out.println("[BoardService.getModify()]");
		System.out.println(boardVo);
		
		boardDao.getmodify(boardVo);
		
		
		return boardVo;
	}



}
