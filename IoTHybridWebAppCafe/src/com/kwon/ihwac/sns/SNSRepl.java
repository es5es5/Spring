package com.kwon.ihwac.sns;

import java.util.Date;

public class SNSRepl {
	private int isr_no;
	private int isr_is_no;
	private String isr_owner;
	private String isr_txt;
	private Date isr_date;

	public SNSRepl() {
		// TODO Auto-generated constructor stub
	}

	public SNSRepl(int isr_no, int isr_is_no, String isr_owner, String isr_txt, Date isr_date) {
		super();
		this.isr_no = isr_no;
		this.isr_is_no = isr_is_no;
		this.isr_owner = isr_owner;
		this.isr_txt = isr_txt;
		this.isr_date = isr_date;
	}

	public int getIsr_no() {
		return isr_no;
	}

	public void setIsr_no(int isr_no) {
		this.isr_no = isr_no;
	}

	public int getIsr_is_no() {
		return isr_is_no;
	}

	public void setIsr_is_no(int isr_is_no) {
		this.isr_is_no = isr_is_no;
	}

	public String getIsr_owner() {
		return isr_owner;
	}

	public void setIsr_owner(String isr_owner) {
		this.isr_owner = isr_owner;
	}

	public String getIsr_txt() {
		return isr_txt;
	}

	public void setIsr_txt(String isr_txt) {
		this.isr_txt = isr_txt;
	}

	public Date getIsr_date() {
		return isr_date;
	}

	public void setIsr_date(Date isr_date) {
		this.isr_date = isr_date;
	}

}
