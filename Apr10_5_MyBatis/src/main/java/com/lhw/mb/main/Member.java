package com.lhw.mb.main;

import java.math.BigDecimal;
import java.util.Date;

// DB필드명 = 멤버변수명
// 숫자 = BigDecimal형으로
public class Member {
	private String m_name;
	private BigDecimal m_age;
	private BigDecimal m_eye;
	private Date m_birthday;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String m_name, BigDecimal m_age, BigDecimal m_eye, Date m_birthday) {
		super();
		this.m_name = m_name;
		this.m_age = m_age;
		this.m_eye = m_eye;
		this.m_birthday = m_birthday;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public BigDecimal getM_age() {
		return m_age;
	}

	public void setM_age(BigDecimal m_age) {
		this.m_age = m_age;
	}

	public BigDecimal getM_eye() {
		return m_eye;
	}

	public void setM_eye(BigDecimal m_eye) {
		this.m_eye = m_eye;
	}

	public Date getM_birthday() {
		return m_birthday;
	}

	public void setM_birthday(Date m_birthday) {
		this.m_birthday = m_birthday;
	}
	
	
	
}
