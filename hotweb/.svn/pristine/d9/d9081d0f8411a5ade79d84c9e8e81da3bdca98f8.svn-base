package com.flower.hot.model.dx;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel {
	@Id
	private int eno=0;
	private String ename=null;
	private String epassword=null;
	@ManyToOne
	@JoinColumn(name="idname")
	private IdentityModel identity=null;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	public IdentityModel getIdentity() {
		return identity;
	}
	public void setIdentity(IdentityModel identity) {
		this.identity = identity;
	}
	
	
	

}
