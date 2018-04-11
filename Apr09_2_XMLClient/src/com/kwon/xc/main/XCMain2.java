package com.kwon.xc.main;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class XCMain2 {
	public static void main(String[] args) {
		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("가격 : ");
			int p = keyboard.nextInt();
			
			URL u = new URL("http://localhost/Apr09_1_XMLServer/SearchProduct?p_price=" + p);

			HttpURLConnection huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream(); // 요청&응답받기

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int type = xpp.getEventType(); // 현재 커서 위치에 있는게 뭔지
										// 시작 or <xxx> or yyy or </xxx> or 끝
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					// System.out.println(xpp.getName());
				} else if (type == XmlPullParser.TEXT) {
					System.out.println(xpp.getText());
				} else if (type == XmlPullParser.END_TAG) {
					// System.out.println(xpp.getName());
				}

				xpp.next(); // 커서를 뒤로
				type = xpp.getEventType();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
