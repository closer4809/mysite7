package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	
	public int selectTotalCnt(String keyword) {
		System.out.println("BoardDao.selectTotlaCnt()");
		
		return sqlSession.selectOne("board.selectTotalCnt", keyword);
	};
	
	
	
	
	//게시판 페이징 연습용 리스트
	
	
	public List<BoardVo> selectList2(int startRnum, int endRnum, String keyword){
		System.out.println("BoardDao.selectList2()");
		
		
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("startRnum", startRnum);
		pMap.put("endRnum", endRnum);
		pMap.put("keyword", keyword);
		
		System.out.println(pMap);
				
		return sqlSession.selectList("board.selectList2", pMap);
	}

	
	public int updateHit(int no) {
		System.out.println("BoardDao.updateHit()");

		// 쿼리문실행
		int count = sqlSession.update("board.updateHit", no);

		return count;

	}

	// 게시판 1개정보 가져오기
	public BoardVo selectBoard(int no) {
		System.out.println("BoardDao.selectBoard()");
		System.out.println(no);

		BoardVo boardVo = sqlSession.selectOne("board.selectBoard", no);
		System.out.println(boardVo);

		return boardVo;
	}

	// 게시판 리스트 가져오기
	public List<BoardVo> getList() {
		System.out.println("BoardDao.getList()");

		List<BoardVo> boardVo =sqlSession.selectList("board.getList" );
		

		
		System.out.println(boardVo);

		return boardVo;
	}
	
	public void getDelete(int no) {
		System.out.println("BoardDao.getDelete()");
		System.out.println(no);
		sqlSession.delete("board.getDelete", no);
		
		return;
	}
	
	public BoardVo getWrite(BoardVo boardVo) {
		System.out.println("BoardDao.getWrite()");
		
		System.out.println(boardVo);
		sqlSession.insert("board.getWrite", boardVo);
		
		return boardVo;
	}
	
	public BoardVo getModifyForm(int no) {
		System.out.println("[BoardDao.getModifyForm()]");
		System.out.println(no);
		BoardVo boardVo = sqlSession.selectOne("board.selectBoard", no);
		
		System.out.println(boardVo);
		
		return boardVo;
	}

	public BoardVo getmodify(BoardVo boardVo) {
		System.out.println("[BoardDao.getModify()]");
		System.out.println(boardVo);
		
		sqlSession.selectOne("board.getmodify", boardVo);
		
		
		return boardVo;
	}
	
	
}
