package com.flower.hot.model.xq;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.flower.hot.model.yg.BuildModel;
import com.flower.hot.model.zmm.QunuanModel;
@Entity
@Table(name="users")
public class UserModel {
	@Id
	private int uno=0;
	private String uname=null;
	private int tel=0;
	@ManyToOne
	@JoinColumn(name="roomno")
	private RoomModel room=null;
	@ManyToOne
	@JoinColumn(name="quid")
	private QunuanModel qunuan=null;
	@ManyToOne
	@JoinColumn(name="bno")
	private BuildModel build=null;
	@ManyToOne
	@JoinColumn(name="tno")
	private TypeModel type=null;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public RoomModel getRoom() {
		return room;
	}
	public void setRoom(RoomModel room) {
		this.room = room;
	}
	public QunuanModel getQunuan() {
		return qunuan;
	}
	public void setQunuan(QunuanModel qunuan) {
		this.qunuan = qunuan;
	}
	public BuildModel getBuild() {
		return build;
	}
	public void setBuild(BuildModel build) {
		this.build = build;
	}
	public TypeModel getType() {
		return type;
	}
	public void setType(TypeModel type) {
		this.type = type;
	}
	
	

}
