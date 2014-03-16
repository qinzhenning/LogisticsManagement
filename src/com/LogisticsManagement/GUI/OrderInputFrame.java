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
 * 2014-3-13����7:11:14
 */
public class OrderInputFrame {
	private ArrayList<Product> plist;
	private JTextField numolabel,weightolabel;
	private JTextField codtext,transtext,idtext,datetext,snametext,sphonetext,saddresstext,cnametext,cphonetext,caddresstext;
	private JTable ptable;
	private String time;
	
	public OrderInputFrame(final JFrame mainFrame,final JPanel mainPanel){
		//��ʼ������
		plist = new ArrayList();
		Date date = new Date();
		time = (date.getYear()+1900)+"-"+date.getMonth()+"-"+date.getDate();
		
		//�������ʼ��
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.setTitle("������Ӫ����ϵͳ-�˵�¼��");
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		//¼�����JPanel
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(BorderFactory.createTitledBorder("¼�����˵�:"));//�߽�
		inputPanel.setBounds(5, 5, 890, 120);
		mainPanel.add(inputPanel);
		
		//���ջ���
		JLabel codlabel = new JLabel("���ջ���:");
		codlabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		codlabel.setBounds(23, 13, 60, 25);
		inputPanel.add(codlabel);
		codtext = new JTextField("0.0");
		codtext.setBounds(90, 13, 110, 25);
		inputPanel.add(codtext);
		JLabel unitlabel = new JLabel("Ԫ");
		unitlabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		unitlabel.setBounds(200, 13, 30, 25);
		inputPanel.add(unitlabel);
		//�˷�
		JLabel translabel = new JLabel("�˷�:");
		translabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		translabel.setBounds(242, 13, 40, 25);
		inputPanel.add(translabel);
		transtext = new JTextField("0.0");
		transtext.setBounds(280,13,70,25);
		inputPanel.add(transtext);
		JLabel anotherunitlabel = new JLabel("Ԫ");
		anotherunitlabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		anotherunitlabel.setBounds(350, 13, 30, 25);
		inputPanel.add(anotherunitlabel);
		
		JLabel idLabel = new JLabel("�˵����:");
		idLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		idLabel.setBounds(530, 10, 60, 25);
		inputPanel.add(idLabel);
		idtext = new JTextField("0000000001");
		idtext.setBounds(590, 10, 120, 25);
		idtext.setEnabled(false);
		inputPanel.add(idtext);
		
		JLabel dateLabel = new JLabel("¼������:");
		dateLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		dateLabel.setBounds(710, 10, 60, 25);
		inputPanel.add(dateLabel);
		datetext = new JTextField(time);
		datetext.setBounds(770, 10, 110, 25);
		datetext.setEnabled(false);
		inputPanel.add(datetext);
		
		JLabel snameLabel = new JLabel("����������:");
		snameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		snameLabel.setBounds(10, 45, 80, 25);
		inputPanel.add(snameLabel);
		snametext = new JTextField();
		snametext.setBounds(90, 45, 110, 25);
		inputPanel.add(snametext);
		
		JLabel sphoneLabel = new JLabel("�����˵绰:");
		sphoneLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		sphoneLabel.setBounds(200, 45, 80, 25);
		inputPanel.add(sphoneLabel);
		sphonetext = new JTextField();
		sphonetext.setBounds(280, 45, 110, 25);
		inputPanel.add(sphonetext);
		
		JLabel saddressLabel = new JLabel("�����˵�ַ:");
		saddressLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		saddressLabel.setBounds(390, 45, 80, 25);
		inputPanel.add(saddressLabel);
		saddresstext = new JTextField();
		saddresstext.setBounds(470, 45, 410, 25);
		inputPanel.add(saddresstext);
		
		JLabel cnameLabel = new JLabel("�ջ�������:");
		cnameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		cnameLabel.setBounds(10, 85, 80, 25);
		inputPanel.add(cnameLabel);
		cnametext = new JTextField();
		cnametext.setBounds(90, 85, 110, 25);
		inputPanel.add(cnametext);
		
		JLabel cphoneLabel = new JLabel("�ջ��˵绰:");
		cphoneLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		cphoneLabel.setBounds(200, 85, 80, 25);
		inputPanel.add(cphoneLabel);
		cphonetext = new JTextField();
		cphonetext.setBounds(280, 85, 110, 25);
		inputPanel.add(cphonetext);
		
		JLabel caddressLabel = new JLabel("�ջ��˵�ַ:");
		caddressLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		caddressLabel.setBounds(390, 85, 80, 25);
		inputPanel.add(caddressLabel);
		caddresstext = new JTextField();
		caddresstext.setBounds(470, 85, 410, 25);
		inputPanel.add(caddresstext);
		
		
		//������
		JPanel propanel = new JPanel();
		propanel.setBounds(5, 108, 890, 370);
		mainPanel.add(propanel);
		JScrollPane pscrollpane = new JScrollPane();
		pscrollpane.setBounds(2, 15, 885, 355);
		propanel.add(pscrollpane);
		ptable = new JTable();
		ptable.setModel(new ProductModel(null));
		ptable.setFont(new Font("΢���ź�", Font.BOLD, 15));
		ptable.setFillsViewportHeight(true);
		pscrollpane.setViewportView(ptable);
		
		//��ǰ�ܼ���label
		numolabel = new JTextField("��ǰ�ܼ���:");
		numolabel.setEnabled(false);
		numolabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		numolabel.setBounds(4, 480, 150, 40);
		mainPanel.add(numolabel);
		//��ǰ������label
		weightolabel = new JTextField("������:");
		weightolabel.setEnabled(false);
		weightolabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		weightolabel.setBounds(160, 480, 150, 40);
		mainPanel.add(weightolabel);
		
		//��ӻ��ɾ�����ȷ�ϴ��� ��ť
		JButton addPbutton =  new JButton("��ӻ���");
		addPbutton.setBounds(620, 480, 80, 40);
		addPbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				new ProductDialog(mainFrame,plist,ptable,numolabel,weightolabel);
			}
			
		});
		JButton deletePPbutton =  new JButton("ɾ������");
		deletePPbutton.setBounds(705, 480, 80, 40);
		deletePPbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				try{
					int selectp = ptable.getSelectedRow();
					plist.remove(selectp);
					ptable.setModel(new ProductModel(plist));
					/*
					 * ����¼�붩��������ܼ�����������
					 */
					int num = 0;
					for(int i = 0;i < plist.size();i++)
						num += plist.get(i).getPnum();
					int weight = 0;
					for(int i = 0;i < plist.size();i++)
						weight += plist.get(i).getSumpweight();
					numolabel.setText("��ǰ�ܼ���: " + num +" ��");
					weightolabel.setText("������: "+ weight + "kg");
				}catch(Exception e){
					new MessageUI(Color.blue, "��ѡ��Ҫɾ���Ļ���ѽ");
				}
				
			}
			
		});
		JButton addObutton =  new JButton("ȷ�ϴ���");
		addObutton.setBounds(814, 480, 80, 40);
		addObutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				if(snametext.getText() != "" && sphonetext.getText() != ""
						&& saddresstext.getText() != "" && cnametext.getText() != ""
						&& cphonetext.getText() != "" && caddresstext.getText() != ""
						&& plist.size() == 0)
					new MessageUI(Color.BLUE,"��Ϣû����д����Ŷ��");
				else
				{
					MainFrame.getOrderList().add((new Order(Integer.parseInt(idtext.getText()),plist,
							Double.valueOf(transtext.getText()),snametext.getText(),sphonetext.getText(),
							saddresstext.getText(),cnametext.getText(),cphonetext.getText(),
							caddresstext.getText(),OrderStatus.NOTSEND,null,time,"",
							Double.valueOf(codtext.getText()))));
					new MessageUI(Color.green,"����¼��ɹ�");
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
