package com.flower.hot.model.xq;

import javax.persistence.*;

import com.flower.hot.model.yg.HeadportModel;

@Entity
@Table(name="district")
public class DistrictModel {
	@Id
	private int dno=0;
	@ManyToOne
	@JoinColumn(name="portno")
	private HeadportModel headport=null;
	private String dname=null;
	private String daddr=null;
	private String wuye=null;
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public HeadportModel getHeadport() {
		return headport;
	}
	public void setHeadport(HeadportModel headport) {
		this.headport = headport;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDaddr() {
		return daddr;
	}
	public void setDaddr(String daddr) {
		this.daddr = daddr;
	}
	public String getWuye() {
		return wuye;
	}
	public void setWuye(String wuye) {
		this.wuye = wuye;
	}
	
	

}
