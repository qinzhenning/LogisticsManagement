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
	
}
