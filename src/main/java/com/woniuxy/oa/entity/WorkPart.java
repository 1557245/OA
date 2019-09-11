package com.woniuxy.oa.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkPart<T> {
	private List<T> work;
	private int curent;//当前页
	private int total;//总数
	private int totalPage;//总页数
	private int num;//每页显示个数
	private int beginPage;//开始页码
	private int endPage;//结束页码
	private String url;//封装请求路径参数,Servlet赋值
	private List<Integer> pages;
	
	@Override
	public String toString() {
		return "WorkPart [work=" + work + ", curent=" + curent + ", total=" + total + ", totalPage=" + totalPage
				+ ", num=" + num + ", beginPage=" + beginPage + ", endPage=" + endPage + ", url=" + url + ", pages="
				+ pages + "]";
	}
	public WorkPart(List<T> work, int curent, int total, int totalPage, int num, int beginPage, int endPage, String url,
			List<Integer> pages) {
		super();
		this.work = work;
		this.curent = curent;
		this.total = total;
		this.totalPage = totalPage;
		this.num = num;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.url = url;
		this.pages = pages;
	}
	public WorkPart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<T> getWork() {
		return work;
	}
	public void setWork(List<T> work) {
		this.work = work;
	}
	public int getCurent() {
		return curent;
	}
	public void setCurent(int curent) {
		this.curent = curent;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		this.totalPage = total%num==0?total/num:total/num+1;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setBeginPageANDEndPage() {
		if(totalPage<=10){
			beginPage=1;
			endPage=totalPage;
		}
		if(totalPage>10){
			beginPage=curent-5;
			endPage=curent+4;
			if(beginPage<1){
				beginPage=1;
				endPage=10;
			}
			if(endPage>totalPage){
				beginPage=totalPage-9;
				endPage=totalPage;
			}
			
		}
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages() {
		List<Integer> pages=new ArrayList<Integer>();
		for(int i =beginPage;i<=endPage;i++) {
			pages.add(i);
		}
		this.pages = pages;
	}
	
	
	
}
