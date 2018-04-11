package com.lhw.mb.main;

import java.math.BigDecimal;

public class MinMax {

	private BigDecimal min;
	private BigDecimal max;

	public MinMax() {
		// TODO Auto-generated constructor stub
	}

	public MinMax(BigDecimal min, BigDecimal max) {
		super();
		this.min = min;
		this.max = max;
	}

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

}
