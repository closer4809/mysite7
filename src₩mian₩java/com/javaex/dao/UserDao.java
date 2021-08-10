package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자

	// 메소드gs

	// 메소드일반

	public UserVo selectUser(UserVo userVo) {
		System.out.println("[UserDao.selectUser]");
		System.out.println(userVo);

		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		System.out.println(authUser);
		return authUser;
	}

	public int insertUser(UserVo userVo) {
		System.out.println("[UserDao.insertUser()]");
		System.out.println(userVo);

		return sqlSession.insert("user.insertUser", userVo);
	}

	public UserVo getUserInfo(int no) {
		System.out.println("[UserDao.getUserInfo()]");

		return sqlSession.selectOne("user.getUserInfo", no);
	}

	public int modifyUser(UserVo userVo) {
		System.out.println("[UserDao.modifyUser()]");

		return sqlSession.update("modifyUser", userVo);
	}

	//회원정보 가져오기 --> 아이디체크
	public UserVo selectUser2(String id) {
		System.out.println("[UserDao.selectUser]");
		
		System.out.println(id);
		
		return sqlSession.selectOne("user.selectUSerById",id);
		
		
		
		 
	}
}
