/**
 * 
 */
package com.LogisticsManagement.logic;

import java.util.ArrayList;

/**
 * @author qinzhenning
 * 2014-3-15ÉÏÎç1:40:01
 */
public class OrderList {
	private static ArrayList<Order> orderlist;
	
	public OrderList(){
		orderlist = new ArrayList();
	}
	
	public ArrayList<Order> getOrderList(){
		return orderlist;
	}
	
	public void addOrder(Order order){
		orderlist.add(order);
	}
	
	public void removeOrder(Order order){
		orderlist.remove(order);
	}
	
	
}
