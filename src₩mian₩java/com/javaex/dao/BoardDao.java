package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
   
   @Autowired
   private SqlSession sqlSession; 
   
   
   public int updateHit(int no) {
      System.out.println("BoardDao.updateHit()");
      
      //쿼리문실행
      int count = sqlSession.update("board.updateHit", no);
      
      
      return count;
      
   }
   //게시판 1개정보 가져오기
   public BoardVo selectBoard(int no) {
	   System.out.println("BoardDao.selectBoard()");
	   System.out.println(no);
	   
	  BoardVo boardVo = sqlSession.selectOne("board.selectBoard", no);
	   System.out.println(boardVo);
   
	   return boardVo;
   }
   
}
	
	

