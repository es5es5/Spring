package com.lhw.mvc3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	public void calc(MyBean mb, HttpServletRequest request, HttpServletResponse response) {

		int hab = mb.getXx() + mb.getYy();
		int cha = mb.getXx() - mb.getYy();
		int gob = mb.getXx() * mb.getYy();
		int moks = mb.getXx() / mb.getYy();

		mb.setHab(hab);
		mb.setCha(cha);
		mb.setMoks(moks);
		mb.setGob(gob);
		
		request.setAttribute("mb", mb);
	}
}
