package com.woniuxy.oa.entity;

import java.util.Date;

public class Work {
	private int wid;//id
	private int eid;//用户id
	private String name;//姓名
	private String summary;//总结
	private String problem;//问题
	private String plan;//下周计划
	private Date createdate;//计划创建时间
	
	
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Work [wid=" + wid + ", eid=" + eid + ", name=" + name + ", summary=" + summary + ", problem=" + problem
				+ ", plan=" + plan + ", createdate=" + createdate + "]";
	}
	public Work(int wid, int eid, String name, String summary, String problem, String plan, Date createdate) {
		super();
		this.wid = wid;
		this.eid = eid;
		this.name = name;
		this.summary = summary;
		this.problem = problem;
		this.plan = plan;
		this.createdate = createdate;
	}
	public Work( int eid, String name, String summary, String problem, String plan, Date createdate) {
		super();
		this.eid = eid;
		this.name = name;
		this.summary = summary;
		this.problem = problem;
		this.plan = plan;
		this.createdate = createdate;
	}
	
	
}
