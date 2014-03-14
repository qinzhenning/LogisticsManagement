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
	
}
