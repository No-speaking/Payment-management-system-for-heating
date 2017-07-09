package com.flower.hot.model.zmm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="qunuan")
public class QunuanModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quid")
	private int quid=0;
	@Column(name="qufangshi")
	private String qufangshi=null;
	@ManyToOne
	@JoinColumn(name="shouid")
	private ShoufeiModel shoufei=null;
	public int getQuid() {
		return quid;
	}
	public void setQuid(int quid) {
		this.quid = quid;
	}
	public String getQufangshi() {
		return qufangshi;
	}
	public void setQufangshi(String qufangshi) {
		this.qufangshi = qufangshi;
	}
	public ShoufeiModel getShoufei() {
		return shoufei;
	}
	public void setShoufei(ShoufeiModel shoufei) {
		this.shoufei = shoufei;
	}
	

}
