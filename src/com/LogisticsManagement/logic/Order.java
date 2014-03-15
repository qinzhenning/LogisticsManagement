/**
 * 
 */
package com.LogisticsManagement.logic;

import java.util.ArrayList;
import java.util.Date;



/**
 * @author qinzhenning
 * 2014-3-12����1:15:05
 */
public class Order {
	private int 				oid;//�˵����
	private ArrayList<Integer> 	pid;//�������б�
	private double 				trans_price;//�������
	private String				sid;//����������
	private String				sphone;//�����˵绰
	private String				saddress;//�����˵�ַ
	private String 				cid;//�ջ�������
	private String				caddress;//�ջ��˵绰
	private String				address;//�ջ���ַ
	private OrderStatus 		status; //�˵�״̬
	private ArrayList<ArrayList<String>> 	move_message;//��ת��Ϣ�б� ��ά�б�ָ��3�У�ʱ�䡢�ص㡢�����ˣ�����������
	private Date				sdate;//��������ʱ��
	private Date				edate;//��������ʱ��
	private double				COD;//���ջ���
	
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
