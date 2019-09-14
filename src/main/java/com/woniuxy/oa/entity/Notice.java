package com.woniuxy.oa.entity;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer nid;// 公告id
	private Integer n_eid;// 发布人id
	private Integer n_asid;// 状态  关联外键
	private String title;// 公告标题
	private String ncontent;// 公告内容
	private String accept;// 公告接收人
	private Date publishtime;// 公告发布时间
	private String annex;// 公告附件
	private Integer nstate;// 公告状态 0 待审批  1 已通过  2 已驳回
	private String fontstate;
	private Integer nflag;// 软删除 0显示 1删除
	private String publisher;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public Integer getN_eid() {
		return n_eid;
	}
	public void setN_eid(Integer n_eid) {
		this.n_eid = n_eid;
	}
	public Integer getN_asid() {
		return n_asid;
	}
	public void setN_asid(Integer n_asid) {
		this.n_asid = n_asid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public String getAnnex() {
		return annex;
	}
	public void setAnnex(String annex) {
		this.annex = annex;
	}
	public Integer getNstate() {
		return nstate;
	}
	public void setNstate(Integer nstate) {
		this.nstate = nstate;
	}
	public String getFontstate() {
		return fontstate;
	}
	public void setFontstate(String fontstate) {
		this.fontstate = fontstate;
	}
	public Integer getNflag() {
		return nflag;
	}
	public void setNflag(Integer nflag) {
		this.nflag = nflag;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", n_eid=" + n_eid + ", n_asid=" + n_asid + ", title=" + title + ", ncontent="
				+ ncontent + ", accept=" + accept + ", publishtime=" + publishtime + ", annex=" + annex + ", nstate="
				+ nstate + ", fontstate=" + fontstate + ", nflag=" + nflag + ", publisher=" + publisher + "]";
	}
	public Notice(Integer nid, Integer n_eid, Integer n_asid, String title, String ncontent, String accept,
			Date publishtime, String annex, Integer nstate, String fontstate, Integer nflag, String publisher) {
		super();
		this.nid = nid;
		this.n_eid = n_eid;
		this.n_asid = n_asid;
		this.title = title;
		this.ncontent = ncontent;
		this.accept = accept;
		this.publishtime = publishtime;
		this.annex = annex;
		this.nstate = nstate;
		this.fontstate = fontstate;
		this.nflag = nflag;
		this.publisher = publisher;
	}
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
