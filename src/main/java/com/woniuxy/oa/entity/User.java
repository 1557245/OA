package com.woniuxy.oa.entity;

public class User {
	private int uid;
	private int eid;
	private String account;
	private String saltpassword;
	private String salt;
	private int hashIterations;
	private String power;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSaltpassword() {
		return saltpassword;
	}
	public void setSaltpassword(String saltpassword) {
		this.saltpassword = saltpassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getHashIterations() {
		return hashIterations;
	}
	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", eid=" + eid + ", account=" + account + ", saltpassword=" + saltpassword
				+ ", salt=" + salt + ", hashIterations=" + hashIterations + ", power=" + power + "]";
	}
	public User(int uid, int eid, String account, String saltpassword, String salt, int hashIterations, String power) {
		super();
		this.uid = uid;
		this.eid = eid;
		this.account = account;
		this.saltpassword = saltpassword;
		this.salt = salt;
		this.hashIterations = hashIterations;
		this.power = power;
	}
	public User() {
		super();
	}
	
}
