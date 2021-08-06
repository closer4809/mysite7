package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//게시판 페이징 연습용 리스트
	public Map<String, Object> getList2(int crtPage, String keyword){
		System.out.println("[BoardService.getList2()]");
		
		///////////////////////////////////////////////
		//				리스트가져오기					///
		///////////////////////////////////////////////
		
		int listCnt = 10;
		
		//crtPage 계산 (-값일때 1page 처리)
		if(crtPage > 0) {
			//crtPage = crtPage;
		}else {
			crtPage = 1;
		}
		
		
		crtPage = (crtPage>0) ? crtPage : (crtPage = 1);
		
		//시작번호 계산하기
		int startRnum =  (crtPage-1)*listCnt+1;
		//끝번호 계산하기
		int endRnum = (startRnum+listCnt)-1;
				
		
		
		
		List<BoardVo> boardList = boardDao.selectList2(startRnum, endRnum, keyword);
		
		///////////////////////////////////////////////
		//				페이지 개수세기					///
		///////////////////////////////////////////////
		
		
		//전체글 갯수
		int totalCount = boardDao.selectTotalCnt(keyword);
		System.out.println(totalCount);
	
		
		//페이지당 버튼갯수 *****
		int pageBtnCount = 5;
		
		
		//마지막 버튼 번호
		// 1 ---> 1-5
		// 2 ---> 1-5
		// 3 ---> 1-5
		// 6 ---> 6-10
		// 7---> 6-10
		// 10 ---> 6-10
		
		
		int endPageBtnNo = (int)Math.ceil((crtPage/(double)pageBtnCount))*pageBtnCount;
								
		//시작버튼번호
		int startPageBtnNo = endPageBtnNo - pageBtnCount + 1;
								
								
		// 다음 화살표 표현 유무
		boolean next = false;			
		if((endPageBtnNo*listCnt) < totalCount) {
			next = true;
			
		}else {
			//다음 화살표 버튼이 없을떄 endPageBtnNo를 다시 계산해야된다
			//전체 글 갯수/페이지의 글갯수
			
			endPageBtnNo = (int)Math.ceil(totalCount/(double)listCnt) ;
							//		
		}
		
		
		
		//이전 화살표 표현유무
		boolean prev = false;
		if(startPageBtnNo !=1) {
			prev = true;
		}
		
		
		//리턴하기 
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("boardList", boardList);
		listMap.put("prev", prev);
		listMap.put("startPageBtnNo", startPageBtnNo);
		listMap.put("endPageBtnNo", endPageBtnNo);
		listMap.put("next", next);
		
		
		return listMap;
	}
	
	
	
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
	
	public int getWrite(BoardVo boardVo) {
		System.out.println("[BoardService.getWrite()]");

		boardDao.getWrite(boardVo);
		
		for(int i = 0; i<127; i++) {
			boardVo.setTitle(i+"번째 제목입니다.");
			boardVo.setContent(i+"번째 내용입니다.");
			boardDao.getWrite(boardVo);
		}
		return 1;
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
