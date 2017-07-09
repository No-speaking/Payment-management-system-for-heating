package com.flower.hot.model.zmm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="youhui")
public class YouhuiModel {
	@Id
	@Column(name="youid")
	private String youid=null;
	private double zhekou=0;
	private String descrip=null;
	@JsonIgnore
	@OneToMany(mappedBy="youhui")
	private Set<CostInfoModel> costs=null;
	
	public Set<CostInfoModel> getCosts() {
		return costs;
	}
	public void setCosts(Set<CostInfoModel> costs) {
		this.costs = costs;
	}
	public String getYouid() {
		return youid;
	}
	public void setYouid(String youid) {
		this.youid = youid;
	}
	public double getZhekou() {
		return zhekou;
	}
	public void setZhekou(double zhekou) {
		this.zhekou = zhekou;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	

}
