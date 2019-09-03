package com.youlove.common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileNameUUId {

	
	
	public static String convert(MultipartFile file,String path,HttpServletRequest request) throws Exception{
		
		System.out.println(request.getSession().getServletContext().getRealPath("resources") + "  파일 경로");
		
		//업로드된 파일이 없으면 NotImage 리턴
		String saveName = "NotImage";
		
		
		if(!file.getOriginalFilename().equals("")) {
		
		UUID uuid = UUID.randomUUID();
		
		//파일 확장자 추출
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		File f;
		saveName = uuid+"."+ext;
		if(path.equals("planner")) {
			f = new File(request.getSession().getServletContext().getRealPath("resources")+"//images//"+path+"//"+saveName);
				
		}else {
			f = new File(request.getSession().getServletContext().getRealPath("resources")+"\\images\\"+path+"\\"+saveName);	
		}
		
	    f.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(f); 
	    fos.write(file.getBytes());
	    fos.close(); 
		}
	    return saveName;
	}
	
	
	public static String convertMINI(MultipartFile file,String path,HttpServletRequest request) throws Exception{
		
		System.out.println(request.getSession().getServletContext().getRealPath("resources") + "  파일 경로");
		
		//업로드된 파일이 없으면 NotImage 리턴
		String saveName = "alternative_image.png";
		
		
		if(!file.getOriginalFilename().equals("")) {
		
		UUID uuid = UUID.randomUUID();
		
		//파일 확장자 추출
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		saveName = uuid+"."+ext;
		
		File f = new File(request.getSession().getServletContext().getRealPath("resources")+"//images//"+path+"//"+saveName);
				
		
	    f.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(f); 
	    fos.write(file.getBytes());
	    fos.close(); 
		}
	    return saveName;
	}
	
}


