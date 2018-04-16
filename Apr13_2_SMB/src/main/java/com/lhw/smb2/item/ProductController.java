package com.lhw.smb2.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO pDAO;

	@RequestMapping(value = "/product.reg", method = RequestMethod.POST)
	public String reg(Item i, HttpServletRequest request, HttpServletResponse response) {
		pDAO.reg(i, request, response);
		pDAO.getAllItem(request, response);
		return "index";
	}
	
	@RequestMapping(value = "/product.delete", method = RequestMethod.GET)
	public String delete(Item i, HttpServletRequest request, HttpServletResponse response) {
		pDAO.delete(i, request, response);
		pDAO.getAllItem(request, response);
		return "index";
	}
}
