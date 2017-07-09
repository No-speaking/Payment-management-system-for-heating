package com.flower.hot.model.yg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.flower.hot.model.xq.DistrictModel;
@Entity
@Table(name="build")
public class BuildModel {
	
	@Id
	private int bno=0;
	private String bcontent=null;
	@ManyToOne
	@JoinColumn(name="dno")
	private DistrictModel district=null;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public DistrictModel getDistrict() {
		return district;
	}
	public void setDistrict(DistrictModel district) {
		this.district = district;
	}
	
	

}
