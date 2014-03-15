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
	private ArrayList<Integer> 	pid;//货物编号列表
	private double 				trans_price;//运输费用
	private String				sid;//发货人姓名
	private String				sphone;//发货人电话
	private String				saddress;//发货人地址
	private String 				cid;//收货人姓名
	private String				caddress;//收货人电话
	private String				address;//收货地址
	private OrderStatus 		status; //运单状态
	private ArrayList<ArrayList<String>> 	move_message;//流转信息列表 二维列表，指定3列：时间、地点、操作人；行数不限制
	private Date				sdate;//订单创建时间
	private Date				edate;//订单结束时间
	private double				COD;//代收货款
	
	public Order(int oid, ArrayList<Integer> pid, double trans_price,
			String sid, String sphone, String saddress, String cid,
			String caddress, String address, OrderStatus status,
			ArrayList<ArrayList<String>> move_message, Date sdate, Date edate,
			double cOD) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.trans_price = trans_price;
		this.sid = sid;
		this.sphone = sphone;
		this.saddress = saddress;
		this.cid = cid;
		this.caddress = caddress;
		this.address = address;
		this.status = status;
		this.move_message = move_message;
		this.sdate = sdate;
		this.edate = edate;
		COD = cOD;
	}

	public int getOid() {
		return oid;
	}

	public ArrayList<Integer> getPid() {
		return pid;
	}

	public double getTrans_price() {
		return trans_price;
	}

	public String getSid() {
		return sid;
	}

	public String getSphone() {
		return sphone;
	}

	public String getSaddress() {
		return saddress;
	}

	public String getCid() {
		return cid;
	}

	public String getCaddress() {
		return caddress;
	}

	public String getAddress() {
		return address;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ArrayList<ArrayList<String>> getMove_message() {
		return move_message;
	}

	public Date getSdate() {
		return sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public double getCOD() {
		return COD;
	}
	
	
	
}
