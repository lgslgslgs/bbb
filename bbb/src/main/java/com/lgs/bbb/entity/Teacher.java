package com.lgs.bbb.entity;

import java.io.Serializable;
import java.util.Date;
//教师实体类
public class Teacher implements Serializable{
	private int t_id;
	private String t_no;
	private String t_name;
	private String t_zip;
	private Date t_date;
	private int t_depno;
	private String dep_name;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_no() {
		return t_no;
	}
	public void setT_no(String t_no) {
		this.t_no = t_no;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_zip() {
		return t_zip;
	}
	public void setT_zip(String t_zip) {
		this.t_zip = t_zip;
	}
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	public int getT_depno() {
		return t_depno;
	}
	public void setT_depno(int t_depno) {
		this.t_depno = t_depno;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public Teacher(int t_id, String t_no, String t_name, String t_zip, Date t_date, int t_depno, String dep_name) {
		super();
		this.t_id = t_id;
		this.t_no = t_no;
		this.t_name = t_name;
		this.t_zip = t_zip;
		this.t_date = t_date;
		this.t_depno = t_depno;
		this.dep_name = dep_name;
	}
	public Teacher() {
		super();
	}
	
	
}
