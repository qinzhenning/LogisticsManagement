/**
 * 
 */
package com.LogisticsManagement.logic;

/**
 * @author qinzhenning
 * 2014-3-14下午8:37:06
 */
public class Product {
	private String pid;//货物编号
	private String pname;//货物名称
	private int pnum;//货物数量
	private double sumpweight;//货物总重量
	private boolean isSquashy;//是否易碎
	
	public Product(String string, String pname, int pnum, double sumpweight,
			boolean isSquashy) {
		super();
		this.pid = string;
		this.pname = pname;
		this.pnum = pnum;
		this.sumpweight = sumpweight;
		this.isSquashy = isSquashy;
	}

	public String getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public int getPnum() {
		return pnum;
	}

	public double getSumpweight() {
		return sumpweight;
	}

	public boolean isSquashy() {
		return isSquashy;
	}
	
	
	
}
