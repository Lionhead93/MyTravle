package com.youlove.common.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class NaverCaptcha {
	
	
    
    
	public static StringBuffer createKey(String clientId, String clientSecret) {
		
		StringBuffer response =  new StringBuffer();
        
        try {
            String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            
            //System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
	}
	
	public static String requestImage(String clientId, String clientSecret, String key,HttpServletRequest request) {
		
		
		String tempname = "";
       try {
          
           String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
           URL url = new URL(apiURL);
           HttpURLConnection con = (HttpURLConnection)url.openConnection();
           con.setRequestMethod("GET");
           con.setRequestProperty("X-Naver-Client-Id", clientId);
           con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
           int responseCode = con.getResponseCode();
           BufferedReader br;
           if(responseCode==200) { // 정상 호출
               InputStream is = con.getInputStream();
               int read = 0;
               byte[] bytes = new byte[1024];
               // 랜덤한 이름으로  파일 생성
               tempname = Long.valueOf(new Date().getTime()).toString();
               File f = new File(request.getSession().getServletContext().getRealPath("resources")+"\\images\\captcha\\"+tempname + ".jpg");
               f.createNewFile();
               OutputStream outputStream = new FileOutputStream(f);
               while ((read =is.read(bytes)) != -1) {
                   outputStream.write(bytes, 0, read);
               }
               is.close();
           } else {  // 에러 발생
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
               String inputLine;
               StringBuffer response = new StringBuffer();
               while ((inputLine = br.readLine()) != null) {
                   response.append(inputLine);
               }
               br.close();
               System.out.println(response.toString());
           }
       } catch (Exception e) {
           System.out.println(e);
       }
       return tempname+".jpg";
	}
	
	public static StringBuffer compareCaptcha(String clientId, String clientSecret, String key, String value) {
		 StringBuffer response = new StringBuffer();
		 
        try {
            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
           
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
           
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
	}
	

}
