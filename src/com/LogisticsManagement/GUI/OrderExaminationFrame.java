/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.Order;
import com.LogisticsManagement.logic.OrderListModel;
import com.LogisticsManagement.logic.ProductModel;

/**
 * @author qinzhenning
 * 2014-3-15����1:32:57
 */
public class OrderExaminationFrame {
	private JTable otable;
	public OrderExaminationFrame(final JFrame mainFrame,JPanel mainPanel,final ArrayList<Order> olist){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainFrame.setTitle("������Ӫ����ϵͳ-�˵��鿴");
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JTextField searchtext = new JTextField("��Ҫ�����������˵����");
		searchtext.setFont(new Font("΢���ź�",Font.ITALIC,13));
		searchtext.setBounds(650, 5, 190, 30);
		JButton searchbutton = new JButton("�� ��");
		searchbutton.setBounds(845, 5, 55, 32);
		mainPanel.add(searchtext);
		mainPanel.add(searchbutton);
		
		
		JScrollPane oscrollpane = new JScrollPane();
		oscrollpane.setBounds(5, 40, 890, 435);
		mainPanel.add(oscrollpane);
		otable = new JTable();
		otable.setModel(new OrderListModel(olist));
		otable.setFont(new Font("΢���ź�", Font.BOLD, 15));
		otable.setFillsViewportHeight(true);
		oscrollpane.setViewportView(otable);
		
		JButton exambutton = new JButton("��ϸ��Ϣ");
		exambutton.setBounds(725, 480, 80, 40);
		exambutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				try{	
					int select = otable.getSelectedRow();
					new OrderDetailInfoDialog(mainFrame,olist.get(select));
				}catch(Exception e){
					new MessageUI(Color.red,"��Ǹ����ûѡ�����");
				}
			}
			
		});
		JButton updatebutton = new JButton("�˵�����");
		updatebutton.setBounds(815, 480, 80, 40);
		updatebutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				try{
					int select = otable.getSelectedRow(); 
					new OrderUpdateDialog(mainFrame,olist.get(select),otable,olist);
				}catch(Exception e){
					new MessageUI(Color.red,"��Ǹ����ûѡ�����");
				}
			}
			
		});
		mainPanel.add(exambutton);
		mainPanel.add(updatebutton);
		
		
		
	}
}
