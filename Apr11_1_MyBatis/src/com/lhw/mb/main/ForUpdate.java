package com.lhw.mb.main;

import java.math.BigDecimal;

public class ForUpdate {
	private BigDecimal search;
	private BigDecimal increase;
	
	public ForUpdate() {
		// TODO Auto-generated constructor stub
	}

	public ForUpdate(BigDecimal search, BigDecimal increase) {
		super();
		this.search = search;
		this.increase = increase;
	}

	public BigDecimal getSearch() {
		return search;
	}

	public void setSearch(BigDecimal search) {
		this.search = search;
	}

	public BigDecimal getIncrease() {
		return increase;
	}

	public void setIncrease(BigDecimal increase) {
		this.increase = increase;
	}
	
}
