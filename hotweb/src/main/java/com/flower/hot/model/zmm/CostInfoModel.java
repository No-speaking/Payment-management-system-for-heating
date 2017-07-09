package com.flower.hot.model.zmm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="costinfo")
public class CostInfoModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="costno")
	private int costno=0;
	@Column(name="totalcost")
	private double totalcost=0;
	@Column(name="youcost")
	private double youcost=0;
	@ManyToOne
	@JoinColumn(name="youid")
	private YouhuiModel youhui=null;
	public int getCostno() {
		return costno;
	}
	public void setCostno(int costno) {
		this.costno = costno;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	
	public double getYoucost() {
		return youcost;
	}
	public void setYoucost(double youcost) {
		this.youcost = youcost;
	}
	public YouhuiModel getYouhui() {
		return youhui;
	}
	public void setYouhui(YouhuiModel youhui) {
		this.youhui = youhui;
	}
	

}
