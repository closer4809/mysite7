package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GalleryVo> getImgList() {
		System.out.println("[GalleryDao.getImgList]");
		List<GalleryVo> galleryVo = sqlSession.selectList("gallery.getImgList");
		System.out.println(galleryVo);
		
		return galleryVo;
	}
	
	
	public GalleryVo imgWrite() {
		
		sqlSession.insert("gallery.imgWrite");
		
		
		return null;
	}	
	
	
}
