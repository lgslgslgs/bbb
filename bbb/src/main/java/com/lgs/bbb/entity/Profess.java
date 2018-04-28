package com.lgs.bbb.entity;

import java.io.Serializable;

//专业实体类
public class Profess implements Serializable{
	private int pro_id;
	private String pro_no;
	private String pro_name;
	private int pro_depid;
	private String pro_state;
	private String dep_name;
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_no() {
		return pro_no;
	}
	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_depid() {
		return pro_depid;
	}
	public void setPro_depid(int pro_depid) {
		this.pro_depid = pro_depid;
	}
	public String getPro_state() {
		return pro_state;
	}
	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public Profess(int pro_id, String pro_no, String pro_name, int pro_depid, String pro_state, String dep_name) {
		super();
		this.pro_id = pro_id;
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_depid = pro_depid;
		this.pro_state = pro_state;
		this.dep_name = dep_name;
	}
	public Profess() {
		super();
	}
	
}
