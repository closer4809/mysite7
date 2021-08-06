package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileupService {
	
	
	
	public String restore(MultipartFile file) {
	
		
		
		System.out.println("[FileupService.restore]");		
		/*    /Users/benedict/Java_Study/upload     */
		
		String SaveDir = "/Users/benedict/Java_Study/upload/";
		
		//파일 서버하드디스크에 저장
		//파일정보를 db에 저장?
		
		//원파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:"+orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName:"+exName);	
			
	
		//저장파일이름(관리때문에 겹치지 않는 새이름 부여, 랜덤으로 이름부여 uuid)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+ exName;
		System.out.println("saveName:"+saveName);
		
		//파일패스
		String filePath = SaveDir + saveName;
		System.out.println("filePath:"+filePath);
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:"+fileSize);
		
	
		
		//파일을 서버의 하드디스크에 저장
		//file restore on hdd
	      try {
	         byte[] fileData = file.getBytes();
	         OutputStream out = new FileOutputStream(filePath);
	         BufferedOutputStream bout = new BufferedOutputStream(out);
	         
	         bout.write(fileData);
	         bout.close();
	         
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		
	      
			
			return saveName;
		}
	
	
	//2. 파일정보를 db에 저장 -- 과제
	
	
	//return svaeName;
	
}
