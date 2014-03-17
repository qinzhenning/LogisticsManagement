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
 * 2014-3-17����4:07:01
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
		
		JLabel statuslabel = new JLabel("״̬�޸�:");
		statuslabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		statuslabel.setBounds(5, 5, 88, 25);
		add(statuslabel);
		statusstr = new String[5];
		statusstr[0] = "δ����";
		statusstr[1] = "�Ѿ�����";
		statusstr[2] = "��������";
		statusstr[3] = "�˻�";
		statusstr[4] = "����";
		statusbox = new JComboBox(statusstr);
		for(int i = 0;i < statusstr.length;i++)
		{
			if(statusstr[i].equals(order.getStatus()))
				statusbox.setSelectedIndex(i);
		}
		statusbox.setBounds(95, 5, 150, 25);
		statusbox.setEnabled(false);
		add(statusbox);
		JButton statusButton = new JButton("�޸�");
		statusButton.setBounds(245, 5, 50, 25);
		statusButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				statusbox.setEnabled(true);
			}
			
		});
		add(statusButton);
		
		JPanel movePanel = new JPanel();
		movePanel.setLayout(null);
		movePanel.setBounds(5, 40, 330, 120);
		movePanel.setBorder(BorderFactory.createTitledBorder("�����ת��Ϣ:"));
		add(movePanel);
		JLabel datelabel = new JLabel("����ʱ��:");
		datelabel.setBounds(20, 20, 88, 25);
		movePanel.add(datelabel);
		dateSelector = new DateTimeSelector();
		dateSelector.setTime(new Date());
		dateSelector.setBounds(110, 20, 192, 24);
		dateSelector.setBorder(null);
		movePanel.add(dateSelector);
		JLabel infolabel = new JLabel("������Ϣ:");
		infolabel.setBounds(20, 50, 88, 25);
		infotext = new JTextField();
		infotext.setBounds(110, 50, 192, 25);
		movePanel.add(infotext);
		movePanel.add(infolabel);
		JLabel peoplelabel = new JLabel("�� �� �� :");
		peoplelabel.setBounds(20, 80, 88, 25);
		movePanel.add(peoplelabel);
		peopletext = new JTextField();
		peopletext.setBounds(110, 80, 192, 25);
		movePanel.add(peopletext);
		
		JButton confirmbutton = new JButton("ȷ��");
		//confirmbutton.setFont(new Font("΢���ź�", Font.BOLD, 16));
		confirmbutton.setBounds(270, 160, 65, 35);
		confirmbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				
			if(!(infotext.getText().equals("") || peopletext.getText().equals("")))
			{	
				if(statusbox.isEnabled()){
					order.setStatus(statusstr[statusbox.getSelectedIndex()]);
					String move = dateSelector.getDate()+","+infotext.getText()+","+peopletext.getText();
					order.addMove_message(move);
					if(statusstr[statusbox.getSelectedIndex()].equals("����") || statusstr[statusbox.getSelectedIndex()].equals("�˻�") )
					order.setEdate(dateSelector.getDate());
					table.setModel(new OrderListModel(olist));
					new MessageUI(Color.green,"���³ɹ�");
				}
				else{
					String move = dateSelector.getDate()+","+infotext.getText()+","+peopletext.getText();
					order.addMove_message(move);
					new MessageUI(Color.green,"���³ɹ�");
				}
				dispose();
			}
			else{
				new MessageUI(Color.red,"��Ϣ������,����ʧ��!");
			}
		}
		});
		add(confirmbutton);
		
		setVisible(true);
	}
}
