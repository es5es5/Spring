package com.kwon.ihwac.sns;

import java.util.ArrayList;
import java.util.Date;

public class SNSMsg {
	private int is_no;
	private String is_owner;
	private String is_txt;
	private Date is_date;
	private String im_img;

	private ArrayList<SNSRepl> is_repls; // ´ñ±Ûµé

	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(int is_no, String is_owner, String is_txt, Date is_date, String im_img, ArrayList<SNSRepl> is_repls) {
		super();
		this.is_no = is_no;
		this.is_owner = is_owner;
		this.is_txt = is_txt;
		this.is_date = is_date;
		this.im_img = im_img;
		this.is_repls = is_repls;
	}

	public int getIs_no() {
		return is_no;
	}

	public void setIs_no(int is_no) {
		this.is_no = is_no;
	}

	public String getIs_owner() {
		return is_owner;
	}

	public void setIs_owner(String is_owner) {
		this.is_owner = is_owner;
	}

	public String getIs_txt() {
		return is_txt;
	}

	public void setIs_txt(String is_txt) {
		this.is_txt = is_txt;
	}

	public Date getIs_date() {
		return is_date;
	}

	public void setIs_date(Date is_date) {
		this.is_date = is_date;
	}

	public String getIm_img() {
		return im_img;
	}

	public void setIm_img(String im_img) {
		this.im_img = im_img;
	}

	public ArrayList<SNSRepl> getIs_repls() {
		return is_repls;
	}

	public void setIs_repls(ArrayList<SNSRepl> is_repls) {
		this.is_repls = is_repls;
	}

}
