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
	private String 				oid;//�˵����
	private ArrayList<Product> 	plist;//�������б�
	private double 				trans_price;//�������
	private String				sname;//����������
	private String				sphone;//�����˵绰
	private String				saddress;//�����˵�ַ
	private String 				cname;//�ջ�������
	private String				cphone;//�ջ��˵绰
	private String				caddress;//�ջ���ַ
	private String 				status; //�˵�״̬
	private ArrayList<String> 	move_message;//��ת��Ϣ�б� ��ά�б�ָ��3�У�ʱ�䡢�ص㡢�����ˣ�����������
	private String				sdate;//��������ʱ��
	private String				edate;//��������ʱ��
	private double				COD;//���ջ���
	
	public Order(String oid, ArrayList<Product> plist, double trans_price,
			String sname, String sphone, String saddress, String cname,
			String cphone, String caddress, String status,
			ArrayList<String> move_message, String sdate, String edate,
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

	public String getOid() {
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

	public String getStatus() {
		return status;
	}

	public ArrayList<String> getMove_message() {
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

	public void setStatus(String status) {
		this.status = status;
	}

	public void addMove_message(String move_message) {
		this.move_message.add(move_message);
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	
	
}
