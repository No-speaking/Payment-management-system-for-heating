package com.flower.hot.model.zmm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shoufei")
public class ShoufeiModel {
	@Id
	@Column(name="shouid")
	private String shouid=null;
	private double feiyong=0;
	@JsonIgnore
	@OneToMany(mappedBy="shoufei")
	private Set<QunuanModel> qunuans=null;
	

	public Set<QunuanModel> getQunuans() {
		return qunuans;
	}
	public void setQunuans(Set<QunuanModel> qunuans) {
		this.qunuans = qunuans;
	}
	public String getShouid() {
		return shouid;
	}
	public void setShouid(String shouid) {
		this.shouid = shouid;
	}
	public double getFeiyong() {
		return feiyong;
	}
	public void setFeiyong(double feiyong) {
		this.feiyong = feiyong;
	}
	
	

}
