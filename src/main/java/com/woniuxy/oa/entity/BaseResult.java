package com.woniuxy.oa.entity;

public class BaseResult {
	private String  typeNum;
	private String  typeFont;
	public BaseResult(String typeNum, String typeFont) {
		super();
		this.typeNum = typeNum;
		this.typeFont = typeFont;
	}
	@Override
	public String toString() {
		return "BaseResult [typeNum=" + typeNum + ", typeFont=" + typeFont + "]";
	}
	public String getTypeFont() {
		return typeFont;
	}
	public void setTypeFont(String typeFont) {
		this.typeFont = typeFont;
	}
	public BaseResult() {
		super();
		// TODO Auto-generated constructor stub
	}

}
