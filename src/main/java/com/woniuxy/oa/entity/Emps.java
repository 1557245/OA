package com.woniuxy.oa.entity;

import java.io.Serializable;

public class Emps implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer eid;
	private String ename;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Emps [eid=" + eid + ", ename=" + ename + "]";
	}
	public Emps(Integer eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	public Emps() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
