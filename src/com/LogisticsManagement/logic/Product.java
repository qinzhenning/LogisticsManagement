/**
 * 
 */
package com.LogisticsManagement.logic;

/**
 * @author qinzhenning
 * 2014-3-14����8:37:06
 */
public class Product {
	private int pid;//������
	private String pname;//��������
	private int pnum;//��������
	private double sumpweight;//����������
	private boolean isSquashy;//�Ƿ�����
	
	public Product(int pid, String pname, int pnum, double sumpweight,
			boolean isSquashy) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pnum = pnum;
		this.sumpweight = sumpweight;
		this.isSquashy = isSquashy;
	}

	public int getPid() {
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
