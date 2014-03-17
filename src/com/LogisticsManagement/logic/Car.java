/**
 * 
 */
package com.LogisticsManagement.logic;


import java.util.ArrayList;
import java.util.Date;

/**
 * @author qinzhenning
 * 2014-3-13ÏÂÎç2:02:18
 */
public class Car {
	private int cid;//Æû³µ±àºÅ
	private String clicense;//Æû³µÅÆÕÕ
	private Date cbuy;//¹ºÂòÊ±¼ä
	private CarsStatus cstatus;//Æû³µ×´Ì¬
	private String cuser;//¼İÊ»Ô±
	private ArrayList<Order> orlist;//¶©µ¥±àºÅÁĞ±í
	
	public void setCid(int id){
		cid=id;
	}
	public int getCid(){
		return cid;
	}
	
	public void setClicense(String  s){
		clicense=s;
	}
	public String getClicense(){
		return clicense;
	}
	
	public void setCbuy(Date d){
		cbuy=d;
	}
	public Date getCbuy(){
		return cbuy;
	}
	
	public void setCstatus(CarsStatus cs){
		cstatus=cs;
	}
	public CarsStatus getCarsStatus(){
		return cstatus;
	}
	
	public void setCuser(String u){
		cuser=u;
	}
	public String getCuser(){
		return cuser;
	}
	
	
	public ArrayList<Order> getOrlist(){
		return orlist;
	}
	
	public void setOrlist(ArrayList<Order> o){
		orlist=o;
	}
	
}
