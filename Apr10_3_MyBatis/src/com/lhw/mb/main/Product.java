package com.lhw.mb.main;

import java.math.BigDecimal;

// DB필드명 = 멤버변수명
// (Oracle한정) = BigDecimal형으로


public class Product {
	private String p_name;
	private BigDecimal p_price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String p_name, BigDecimal p_price) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}
	
}
