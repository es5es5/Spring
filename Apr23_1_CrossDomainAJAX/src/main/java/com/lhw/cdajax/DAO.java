package com.lhw.cdajax;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class DAO {
	public String getNaverMovieData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String q = request.getParameter("q");
			URL u = new URL("https://openapi.naver.com/v1/search/movie.xml?query=" + q);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

			huc.addRequestProperty("X-Naver-Client-Id", "gkXL6xjXGQqXV3z_kKPv");
			huc.addRequestProperty("X-Naver-Client-Secret", "7kpXc99CFu");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();

			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getKakaoImageData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String q = request.getParameter("q");
			
			URL u = new URL("https://dapi.kakao.com/v2/search/image?query=" + q);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 3b15814fc2d1477b69292699288ba7b6");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();

			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
