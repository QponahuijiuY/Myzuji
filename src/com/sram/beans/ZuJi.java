package com.sram.beans;

import java.util.Date;

public class ZuJi {
	private int id;
	private String title;//�㼣����
	private String jianjie;//�㼣���
	private Date date;//�㼣ʱ��
	private String url;//ͼƬ·��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ZuJi(int id, String title, String jianjie, Date date, String url) {
		super();
		this.id = id;
		this.title = title;
		this.jianjie = jianjie;
		this.date = date;
		this.url = url;
	}
	public ZuJi(String title, String jianjie, Date date, String url) {
		super();
		this.title = title;
		this.jianjie = jianjie;
		this.date = date;
		this.url = url;
	}
	
	
	public ZuJi() {
		
	}
	@Override
	public String toString() {
		return "ZuJi [id=" + id + ", title=" + title + ", jianjie=" + jianjie
				+ ", date=" + date + ", url=" + url + "]";
	}
}
