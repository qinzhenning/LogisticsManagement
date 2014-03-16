/**
 * 
 */
package com.LogisticsManagement.logic;

import java.util.ArrayList;
import java.util.Date;



/**
 * @author qinzhenning
 * 2014-3-12下午1:15:05
 */
public class Order {
	private int 				oid;//运单编号
	private ArrayList<Product> 	plist;//货物编号列表
	private double 				trans_price;//运输费用
	private String				sname;//发货人姓名
	private String				sphone;//发货人电话
	private String				saddress;//发货人地址
	private String 				cname;//收货人姓名
	private String				cphone;//收货人电话
	private String				caddress;//收货地址
	private OrderStatus 		status; //运单状态
	private ArrayList<ArrayList<String>> 	move_message;//流转信息列表 二维列表，指定3列：时间、地点、操作人；行数不限制
	private String				sdate;//订单创建时间
	private String				edate;//订单结束时间
	private double				COD;//代收货款
	
	public Order(int oid, ArrayList<Product> plist, double trans_price,
			String sname, String sphone, String saddress, String cname,
			String cphone, String caddress, OrderStatus status,
			ArrayList<ArrayList<String>> move_message, String sdate, String edate,
			double cOD) {
		super();
		this.oid = oid;
		this.plist = plist;
		this.trans_price = trans_price;
		this.sname = sname;
		this.sphone = sphone;
		this.saddress = saddress;
		this.cname = cname;
		this.cphone = cphone;
		this.caddress = caddress;
		this.status = status;
		this.move_message = move_message;
		this.sdate = sdate;
		this.edate = edate;
		COD = cOD;
	}

	public int getOid() {
		return oid;
	}

	public ArrayList<Product> getPlist() {
		return plist;
	}

	public double getTrans_price() {
		return trans_price;
	}

	public String getSname() {
		return sname;
	}

	public String getSphone() {
		return sphone;
	}

	public String getSaddress() {
		return saddress;
	}

	public String getCname() {
		return cname;
	}

	public String getCphone() {
		return cphone;
	}

	public String getCaddress() {
		return caddress;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ArrayList<ArrayList<String>> getMove_message() {
		return move_message;
	}

	public String getSdate() {
		return sdate;
	}

	public String getEdate() {
		return edate;
	}

	public double getCOD() {
		return COD;
	}
	
	
	
}
