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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.Order;
import com.LogisticsManagement.logic.OrderListModel;

import dateTimeSelector.DateTimeSelector;

/**
 * @author qinzhenning
 * 2014-3-17下午4:07:01
 */
public class OrderUpdateDialog extends JDialog{
	private JComboBox statusbox;
	private DateTimeSelector dateSelector;
	private JTextField infotext,peopletext;
	private String[] statusstr;
	
	public OrderUpdateDialog(JFrame frame,final Order order,final JTable table,final ArrayList<Order> olist){
		super(frame,false);
		setBounds(300, 200, 340, 220);
		setLayout(null);
		setResizable(false);
		
		JLabel statuslabel = new JLabel("状态修改:");
		statuslabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		statuslabel.setBounds(5, 5, 88, 25);
		add(statuslabel);
		statusstr = new String[5];
		statusstr[0] = "未发货";
		statusstr[1] = "已经发货";
		statusstr[2] = "正在派送";
		statusstr[3] = "退回";
		statusstr[4] = "结束";
		statusbox = new JComboBox(statusstr);
		for(int i = 0;i < statusstr.length;i++)
		{
			if(statusstr[i].equals(order.getStatus()))
				statusbox.setSelectedIndex(i);
		}
		statusbox.setBounds(95, 5, 150, 25);
		statusbox.setEnabled(false);
		add(statusbox);
		JButton statusButton = new JButton("修改");
		statusButton.setBounds(245, 5, 50, 25);
		statusButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				statusbox.setEnabled(true);
			}
			
		});
		add(statusButton);
		
		JPanel movePanel = new JPanel();
		movePanel.setLayout(null);
		movePanel.setBounds(5, 40, 330, 120);
		movePanel.setBorder(BorderFactory.createTitledBorder("添加运转信息:"));
		add(movePanel);
		JLabel datelabel = new JLabel("处理时间:");
		datelabel.setBounds(20, 20, 88, 25);
		movePanel.add(datelabel);
		dateSelector = new DateTimeSelector();
		dateSelector.setTime(new Date());
		dateSelector.setBounds(110, 20, 192, 24);
		dateSelector.setBorder(null);
		movePanel.add(dateSelector);
		JLabel infolabel = new JLabel("处理信息:");
		infolabel.setBounds(20, 50, 88, 25);
		infotext = new JTextField();
		infotext.setBounds(110, 50, 192, 25);
		movePanel.add(infotext);
		movePanel.add(infolabel);
		JLabel peoplelabel = new JLabel("操 作 人 :");
		peoplelabel.setBounds(20, 80, 88, 25);
		movePanel.add(peoplelabel);
		peopletext = new JTextField();
		peopletext.setBounds(110, 80, 192, 25);
		movePanel.add(peopletext);
		
		JButton confirmbutton = new JButton("确认");
		//confirmbutton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		confirmbutton.setBounds(270, 160, 65, 35);
		confirmbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
			if(!(infotext.getText().equals("") || peopletext.getText().equals("")))
			{	
				if(statusbox.isEnabled()){
					order.setStatus(statusstr[statusbox.getSelectedIndex()]);
					String move = dateSelector.getDate()+","+infotext.getText()+","+peopletext.getText();
					order.addMove_message(move);
					if(statusstr[statusbox.getSelectedIndex()].equals("结束") || statusstr[statusbox.getSelectedIndex()].equals("退回") )
					order.setEdate(dateSelector.getDate());
					table.setModel(new OrderListModel(olist));
					new MessageUI(Color.green,"更新成功");
				}
				else{
					String move = dateSelector.getDate()+","+infotext.getText()+","+peopletext.getText();
					order.addMove_message(move);
					new MessageUI(Color.green,"更新成功");
				}
				dispose();
			}
			else{
				new MessageUI(Color.red,"信息不完整,更新失败!");
			}
		}
		});
		add(confirmbutton);
		
		setVisible(true);
	}
}
