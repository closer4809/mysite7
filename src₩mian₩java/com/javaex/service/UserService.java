package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// 로그인 사용자정보 가져오기
	public UserVo getUser(UserVo userVo) {
		System.out.println("[UserService.getUser()]");

		UserVo authUser = userDao.selectUser(userVo);

		return authUser;
	}

	// 회원가입
	public int insertUser(UserVo userVo) {
		System.out.println("[UserService.insertUser()]");

		return userDao.insertUser(userVo);
	}

	// 회원정보수정용 한명 정보 가져오기
	public UserVo getUserInfo(int no) {
		System.out.println("[UserService.getUserInfo()]");

		return userDao.getUserInfo(no);
	}

	// 회원정보 수정
	public int modifyUser(UserVo userVo) {
		System.out.println("[UserService.modifyUser()]");

		return userDao.modifyUser(userVo);
	}

	//회원가입폼 id사용유무체크
	public boolean getUser2(String id) {
		System.out.println("[UserService.getUser2()]");

		
		UserVo userVo =  userDao.selectUser2(id);
		
		if(userVo == null) { // db에 없는경우 사용가능 id
			return true;
		}else {				// db에 있는경우 사용불가능 id
			return false; 
		}
		


		
	}
}
