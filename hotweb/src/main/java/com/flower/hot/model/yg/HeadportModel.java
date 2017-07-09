package com.flower.hot.model.yg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Headport")
public class HeadportModel {
   @Id
   private int portno=0;
   private String portname=null;
   private String scope=null;
   private String portaddr=null;
   private int    porttel=0;
public int getPortno() {
	return portno;
}
public void setPortno(int portno) {
	this.portno = portno;
}
public String getPortname() {
	return portname;
}
public void setPortname(String portname) {
	this.portname = portname;
}
public String getScope() {
	return scope;
}
public void setScope(String scope) {
	this.scope = scope;
}
public String getPortaddr() {
	return portaddr;
}
public void setPortaddr(String portaddr) {
	this.portaddr = portaddr;
}
public int getPorttel() {
	return porttel;
}
public void setPorttel(int porttel) {
	this.porttel = porttel;
}
   
   
   
}
