package com.kwon.ihwac.vote;

public class VoteItem {
	private int ivi_no;
	private String ivi_item;
	private int ivi_count;
	private double ivi_percent;

	public VoteItem() {
		// TODO Auto-generated constructor stub
	}

	public VoteItem(int ivi_no, String ivi_item, int ivi_count, double ivi_percent) {
		super();
		this.ivi_no = ivi_no;
		this.ivi_item = ivi_item;
		this.ivi_count = ivi_count;
		this.ivi_percent = ivi_percent;
	}

	public int getIvi_no() {
		return ivi_no;
	}

	public void setIvi_no(int ivi_no) {
		this.ivi_no = ivi_no;
	}

	public String getIvi_item() {
		return ivi_item;
	}

	public void setIvi_item(String ivi_item) {
		this.ivi_item = ivi_item;
	}

	public int getIvi_count() {
		return ivi_count;
	}

	public void setIvi_count(int ivi_count) {
		this.ivi_count = ivi_count;
	}

	public double getIvi_percent() {
		return ivi_percent;
	}

	public void setIvi_percent(double ivi_percent) {
		this.ivi_percent = ivi_percent;
	}

}
