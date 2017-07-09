package com.flower.hot.model.zmm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tongzhi")
public class TongZhiModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tongid")
	private int tongid=0;
	private String tongcontext=null;
	private String tongtype=null;

	public int getTongid() {
		return tongid;
	}
	public void setTongid(int tongid) {
		this.tongid = tongid;
	}
	public String getTongcontext() {
		return tongcontext;
	}
	public void setTongcontext(String tongcontext) {
		this.tongcontext = tongcontext;
	}
	public String getTongtype() {
		return tongtype;
	}
	public void setTongtype(String tongtype) {
		this.tongtype = tongtype;
	}
	

}
