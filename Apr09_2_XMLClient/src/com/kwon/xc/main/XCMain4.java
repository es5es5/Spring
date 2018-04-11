package com.kwon.xc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class XCMain4 {

	public static void main(String[] args) {
		try {
			URL u = new URL("http://localhost/Apr09_1_XMLServer/GetProductJSON");
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			JSONParser jp = new JSONParser();
			JSONArray ja = (JSONArray) jp.parse(new InputStreamReader(is, "utf-8"));
			JSONObject jo = null;
			
			for (int i = 0; i < ja.size(); i++) {
				jo = (JSONObject) ja.get(i);
				System.out.println(jo.get("p_name"));
				System.out.println(jo.get("p_price"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
