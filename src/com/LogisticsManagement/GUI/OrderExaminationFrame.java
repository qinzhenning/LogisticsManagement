/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.OrderListModel;
import com.LogisticsManagement.logic.ProductModel;

/**
 * @author qinzhenning
 * 2014-3-15上午1:32:57
 */
public class OrderExaminationFrame {
	
	public OrderExaminationFrame(JFrame mainFrame,JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainFrame.setTitle("物流运营管理系统-运单查看");
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JTextField searchtext = new JTextField("请要搜索的输入运单编号");
		searchtext.setFont(new Font("微软雅黑",Font.ITALIC,13));
		searchtext.setBounds(650, 5, 190, 30);
		JButton searchbutton = new JButton("搜 索");
		searchbutton.setBounds(845, 5, 55, 32);
		mainPanel.add(searchtext);
		mainPanel.add(searchbutton);
		
		
		JScrollPane oscrollpane = new JScrollPane();
		oscrollpane.setBounds(5, 40, 890, 435);
		mainPanel.add(oscrollpane);
		JTable otable = new JTable();
		otable.setModel(new OrderListModel(null));
		otable.setFont(new Font("微软雅黑", Font.BOLD, 15));
		otable.setFillsViewportHeight(true);
		oscrollpane.setViewportView(otable);
		
		JButton exambutton = new JButton("详细信息");
		exambutton.setBounds(725, 480, 80, 40);
		JButton updatebutton = new JButton("运单更新");
		updatebutton.setBounds(815, 480, 80, 40);
		mainPanel.add(exambutton);
		mainPanel.add(updatebutton);
		
	}
}
