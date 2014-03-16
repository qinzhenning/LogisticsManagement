/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.Order;
import com.LogisticsManagement.logic.OrderStatus;
import com.LogisticsManagement.logic.Product;
import com.LogisticsManagement.logic.ProductModel;


/**
 * @author qinzhenning
 * 2014-3-13下午7:11:14
 */
public class OrderInputFrame {
	private ArrayList<Product> plist;
	private JTextField numolabel,weightolabel;
	private JTextField codtext,transtext,idtext,datetext,snametext,sphonetext,saddresstext,cnametext,cphonetext,caddresstext;
	private JTable ptable;
	private String time;
	
	public OrderInputFrame(final JFrame mainFrame,final JPanel mainPanel){
		//初始化数据
		plist = new ArrayList();
		Date date = new Date();
		time = (date.getYear()+1900)+"-"+date.getMonth()+"-"+date.getDate();
		
		//主界面初始化
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.setTitle("物流运营管理系统-运单录入");
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		//录入表单的JPanel
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(BorderFactory.createTitledBorder("录入新运单:"));//边界
		inputPanel.setBounds(5, 5, 890, 120);
		mainPanel.add(inputPanel);
		
		//代收货款
		JLabel codlabel = new JLabel("代收货款:");
		codlabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		codlabel.setBounds(23, 13, 60, 25);
		inputPanel.add(codlabel);
		codtext = new JTextField("0.0");
		codtext.setBounds(90, 13, 110, 25);
		inputPanel.add(codtext);
		JLabel unitlabel = new JLabel("元");
		unitlabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		unitlabel.setBounds(200, 13, 30, 25);
		inputPanel.add(unitlabel);
		//运费
		JLabel translabel = new JLabel("运费:");
		translabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		translabel.setBounds(242, 13, 40, 25);
		inputPanel.add(translabel);
		transtext = new JTextField("0.0");
		transtext.setBounds(280,13,70,25);
		inputPanel.add(transtext);
		JLabel anotherunitlabel = new JLabel("元");
		anotherunitlabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		anotherunitlabel.setBounds(350, 13, 30, 25);
		inputPanel.add(anotherunitlabel);
		
		JLabel idLabel = new JLabel("运单编号:");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		idLabel.setBounds(530, 10, 60, 25);
		inputPanel.add(idLabel);
		idtext = new JTextField("0000000001");
		idtext.setBounds(590, 10, 120, 25);
		idtext.setEnabled(false);
		inputPanel.add(idtext);
		
		JLabel dateLabel = new JLabel("录单日期:");
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		dateLabel.setBounds(710, 10, 60, 25);
		inputPanel.add(dateLabel);
		datetext = new JTextField(time);
		datetext.setBounds(770, 10, 110, 25);
		datetext.setEnabled(false);
		inputPanel.add(datetext);
		
		JLabel snameLabel = new JLabel("发货人姓名:");
		snameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		snameLabel.setBounds(10, 45, 80, 25);
		inputPanel.add(snameLabel);
		snametext = new JTextField();
		snametext.setBounds(90, 45, 110, 25);
		inputPanel.add(snametext);
		
		JLabel sphoneLabel = new JLabel("发货人电话:");
		sphoneLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sphoneLabel.setBounds(200, 45, 80, 25);
		inputPanel.add(sphoneLabel);
		sphonetext = new JTextField();
		sphonetext.setBounds(280, 45, 110, 25);
		inputPanel.add(sphonetext);
		
		JLabel saddressLabel = new JLabel("发货人地址:");
		saddressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		saddressLabel.setBounds(390, 45, 80, 25);
		inputPanel.add(saddressLabel);
		saddresstext = new JTextField();
		saddresstext.setBounds(470, 45, 410, 25);
		inputPanel.add(saddresstext);
		
		JLabel cnameLabel = new JLabel("收货人姓名:");
		cnameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cnameLabel.setBounds(10, 85, 80, 25);
		inputPanel.add(cnameLabel);
		cnametext = new JTextField();
		cnametext.setBounds(90, 85, 110, 25);
		inputPanel.add(cnametext);
		
		JLabel cphoneLabel = new JLabel("收货人电话:");
		cphoneLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cphoneLabel.setBounds(200, 85, 80, 25);
		inputPanel.add(cphoneLabel);
		cphonetext = new JTextField();
		cphonetext.setBounds(280, 85, 110, 25);
		inputPanel.add(cphonetext);
		
		JLabel caddressLabel = new JLabel("收货人地址:");
		caddressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		caddressLabel.setBounds(390, 85, 80, 25);
		inputPanel.add(caddressLabel);
		caddresstext = new JTextField();
		caddresstext.setBounds(470, 85, 410, 25);
		inputPanel.add(caddresstext);
		
		
		//货物表格
		JPanel propanel = new JPanel();
		propanel.setBounds(5, 108, 890, 370);
		mainPanel.add(propanel);
		JScrollPane pscrollpane = new JScrollPane();
		pscrollpane.setBounds(2, 15, 885, 355);
		propanel.add(pscrollpane);
		ptable = new JTable();
		ptable.setModel(new ProductModel(null));
		ptable.setFont(new Font("微软雅黑", Font.BOLD, 15));
		ptable.setFillsViewportHeight(true);
		pscrollpane.setViewportView(ptable);
		
		//当前总件数label
		numolabel = new JTextField("当前总件数:");
		numolabel.setEnabled(false);
		numolabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		numolabel.setBounds(4, 480, 150, 40);
		mainPanel.add(numolabel);
		//当前总重量label
		weightolabel = new JTextField("总重量:");
		weightolabel.setEnabled(false);
		weightolabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		weightolabel.setBounds(160, 480, 150, 40);
		mainPanel.add(weightolabel);
		
		//添加货物、删除货物、确认创建 按钮
		JButton addPbutton =  new JButton("添加货物");
		addPbutton.setBounds(620, 480, 80, 40);
		addPbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new ProductDialog(mainFrame,plist,ptable,numolabel,weightolabel);
			}
			
		});
		JButton deletePPbutton =  new JButton("删除货物");
		deletePPbutton.setBounds(705, 480, 80, 40);
		deletePPbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				try{
					int selectp = ptable.getSelectedRow();
					plist.remove(selectp);
					ptable.setModel(new ProductModel(plist));
					/*
					 * 更新录入订单界面的总件数和总重量
					 */
					int num = 0;
					for(int i = 0;i < plist.size();i++)
						num += plist.get(i).getPnum();
					int weight = 0;
					for(int i = 0;i < plist.size();i++)
						weight += plist.get(i).getSumpweight();
					numolabel.setText("当前总件数: " + num +" 件");
					weightolabel.setText("总重量: "+ weight + "kg");
				}catch(Exception e){
					new MessageUI(Color.blue, "请选择要删除的货物呀");
				}
				
			}
			
		});
		JButton addObutton =  new JButton("确认创建");
		addObutton.setBounds(814, 480, 80, 40);
		addObutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(snametext.getText() != "" && sphonetext.getText() != ""
						&& saddresstext.getText() != "" && cnametext.getText() != ""
						&& cphonetext.getText() != "" && caddresstext.getText() != ""
						&& plist.size() == 0)
					new MessageUI(Color.BLUE,"信息没有填写完整哦！");
				else
				{
					MainFrame.getOrderList().add((new Order(Integer.parseInt(idtext.getText()),plist,
							Double.valueOf(transtext.getText()),snametext.getText(),sphonetext.getText(),
							saddresstext.getText(),cnametext.getText(),cphonetext.getText(),
							caddresstext.getText(),OrderStatus.NOTSEND,null,time,"",
							Double.valueOf(codtext.getText()))));
					new MessageUI(Color.green,"订单录入成功");
					mainPanel.removeAll();
					new OrderInputFrame(mainFrame, mainPanel);
					mainPanel.repaint();
				}
			}
		});
		mainPanel.add(addPbutton);
		mainPanel.add(deletePPbutton);
		mainPanel.add(addObutton);
		
		
		
		
		
		mainPanel.setVisible(true);
	}
	


}
