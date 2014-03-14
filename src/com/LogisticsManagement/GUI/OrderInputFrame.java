/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.ProductModel;


/**
 * @author qinzhenning
 * 2014-3-13下午7:11:14
 */
public class OrderInputFrame {

	public OrderInputFrame(JFrame mainFrame,JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		//录入表单的JPanel
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(BorderFactory.createTitledBorder("录入新运单:"));//边界
		inputPanel.setBounds(5, 5, 890, 120);
		mainPanel.add(inputPanel);
		
		
		
		JLabel idLabel = new JLabel("运单编号:");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		idLabel.setBounds(530, 10, 60, 25);
		inputPanel.add(idLabel);
		JTextField idtext = new JTextField("0000000001");
		idtext.setBounds(590, 10, 120, 25);
		idtext.setEnabled(false);
		inputPanel.add(idtext);
		
		JLabel dateLabel = new JLabel("录单日期:");
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		dateLabel.setBounds(710, 10, 60, 25);
		inputPanel.add(dateLabel);
		JTextField datetext = new JTextField("2014-03-14");
		datetext.setBounds(770, 10, 110, 25);
		datetext.setEnabled(false);
		inputPanel.add(datetext);
		
		JLabel snameLabel = new JLabel("发货人姓名:");
		snameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		snameLabel.setBounds(10, 45, 80, 25);
		inputPanel.add(snameLabel);
		JTextField snametext = new JTextField();
		snametext.setBounds(90, 45, 110, 25);
		inputPanel.add(snametext);
		
		JLabel sphoneLabel = new JLabel("发货人电话:");
		sphoneLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sphoneLabel.setBounds(200, 45, 80, 25);
		inputPanel.add(sphoneLabel);
		JTextField sphonetext = new JTextField();
		sphonetext.setBounds(280, 45, 110, 25);
		inputPanel.add(sphonetext);
		
		JLabel saddressLabel = new JLabel("发货人地址:");
		saddressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		saddressLabel.setBounds(390, 45, 80, 25);
		inputPanel.add(saddressLabel);
		JTextField saddresstext = new JTextField();
		saddresstext.setBounds(470, 45, 410, 25);
		inputPanel.add(saddresstext);
		
		JLabel cnameLabel = new JLabel("收货人姓名:");
		cnameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cnameLabel.setBounds(10, 85, 80, 25);
		inputPanel.add(cnameLabel);
		JTextField cnametext = new JTextField();
		cnametext.setBounds(90, 85, 110, 25);
		inputPanel.add(cnametext);
		
		JLabel cphoneLabel = new JLabel("收货人电话:");
		cphoneLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cphoneLabel.setBounds(200, 85, 80, 25);
		inputPanel.add(cphoneLabel);
		JTextField cphonetext = new JTextField();
		cphonetext.setBounds(280, 85, 110, 25);
		inputPanel.add(cphonetext);
		
		JLabel caddressLabel = new JLabel("收货人地址:");
		caddressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		caddressLabel.setBounds(390, 85, 80, 25);
		inputPanel.add(caddressLabel);
		JTextField caddresstext = new JTextField();
		caddresstext.setBounds(470, 85, 410, 25);
		inputPanel.add(caddresstext);
		
		
		//货物表格
		JPanel propanel = new JPanel();
		propanel.setBounds(5, 108, 890, 370);
		mainPanel.add(propanel);
		JScrollPane pscrollpane = new JScrollPane();
		pscrollpane.setBounds(2, 15, 885, 355);
		propanel.add(pscrollpane);
		JTable ptable = new JTable();
		ptable.setModel(new ProductModel(null));
		ptable.setFont(new Font("微软雅黑", Font.BOLD, 15));
		ptable.setFillsViewportHeight(true);
		pscrollpane.setViewportView(ptable);
		
		//添加货物、删除货物、确认创建 按钮
		JButton addPbutton =  new JButton("添加货物");
		addPbutton.setBounds(620, 480, 80, 40);
		JButton deletePPbutton =  new JButton("删除货物");
		deletePPbutton.setBounds(705, 480, 80, 40);
		JButton addObutton =  new JButton("确认创建");
		addObutton.setBounds(814, 480, 80, 40);
		mainPanel.add(addPbutton);
		mainPanel.add(deletePPbutton);
		mainPanel.add(addObutton);
		
		
		
		
		
		mainPanel.setVisible(true);
	}

}
