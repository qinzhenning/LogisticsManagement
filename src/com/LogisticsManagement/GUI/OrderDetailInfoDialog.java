/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.MoveMessageModel;
import com.LogisticsManagement.logic.Order;
import com.LogisticsManagement.logic.OrderListModel;

/**
 * @author qinzhenning
 * 2014-3-17下午2:36:13
 */
public class OrderDetailInfoDialog extends JDialog{

	public OrderDetailInfoDialog(JFrame frame,Order order){
		super(frame,false);
		setBounds(300, 200, 350, 400);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JLabel saddresslabel = new JLabel("发货地址: "+order.getSaddress());
		saddresslabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		saddresslabel.setBounds(5, 5, 300, 30);
		add(saddresslabel);
		JLabel caddresslabel = new JLabel("收货地址: "+order.getCaddress());
		caddresslabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		caddresslabel.setBounds(5, 35, 300, 30);
		add(caddresslabel);
		
		String pstr = "";
		for(int i = 0; i< order.getPlist().size();i++)
			pstr += order.getPlist().get(i).getPname() + "("+order.getPlist().get(i).getPnum()+"件,"
					+ order.getPlist().get(i).getSumpweight() +"kg)"+ ";";
		JTextArea ptext = new JTextArea(pstr);
		JScrollPane scroll = new JScrollPane(ptext); 
		ptext.setLineWrap(true);
		ptext.setBorder(BorderFactory.createTitledBorder("订单货物信息:"));
		ptext.setBounds(5, 70, 340, 100);
		add(ptext);
		
		JScrollPane oscrollpane = new JScrollPane();
		oscrollpane.setBounds(5, 170, 340, 200);
		add(oscrollpane);
		JTable otable = new JTable();
		otable.setModel(new MoveMessageModel(order.getMove_message()));
		otable.setFont(new Font("微软雅黑", Font.BOLD, 15));
		otable.setFillsViewportHeight(true);
		oscrollpane.setViewportView(otable);
	}
}
