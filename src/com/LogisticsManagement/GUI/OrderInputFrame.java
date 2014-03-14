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
 * 2014-3-13����7:11:14
 */
public class OrderInputFrame {

	public OrderInputFrame(JFrame mainFrame,JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		//¼�����JPanel
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(BorderFactory.createTitledBorder("¼�����˵�:"));//�߽�
		inputPanel.setBounds(5, 5, 890, 120);
		mainPanel.add(inputPanel);
		
		
		
		JLabel idLabel = new JLabel("�˵����:");
		idLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		idLabel.setBounds(530, 10, 60, 25);
		inputPanel.add(idLabel);
		JTextField idtext = new JTextField("0000000001");
		idtext.setBounds(590, 10, 120, 25);
		idtext.setEnabled(false);
		inputPanel.add(idtext);
		
		JLabel dateLabel = new JLabel("¼������:");
		dateLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		dateLabel.setBounds(710, 10, 60, 25);
		inputPanel.add(dateLabel);
		JTextField datetext = new JTextField("2014-03-14");
		datetext.setBounds(770, 10, 110, 25);
		datetext.setEnabled(false);
		inputPanel.add(datetext);
		
		JLabel snameLabel = new JLabel("����������:");
		snameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		snameLabel.setBounds(10, 45, 80, 25);
		inputPanel.add(snameLabel);
		JTextField snametext = new JTextField();
		snametext.setBounds(90, 45, 110, 25);
		inputPanel.add(snametext);
		
		JLabel sphoneLabel = new JLabel("�����˵绰:");
		sphoneLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		sphoneLabel.setBounds(200, 45, 80, 25);
		inputPanel.add(sphoneLabel);
		JTextField sphonetext = new JTextField();
		sphonetext.setBounds(280, 45, 110, 25);
		inputPanel.add(sphonetext);
		
		JLabel saddressLabel = new JLabel("�����˵�ַ:");
		saddressLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		saddressLabel.setBounds(390, 45, 80, 25);
		inputPanel.add(saddressLabel);
		JTextField saddresstext = new JTextField();
		saddresstext.setBounds(470, 45, 410, 25);
		inputPanel.add(saddresstext);
		
		JLabel cnameLabel = new JLabel("�ջ�������:");
		cnameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		cnameLabel.setBounds(10, 85, 80, 25);
		inputPanel.add(cnameLabel);
		JTextField cnametext = new JTextField();
		cnametext.setBounds(90, 85, 110, 25);
		inputPanel.add(cnametext);
		
		JLabel cphoneLabel = new JLabel("�ջ��˵绰:");
		cphoneLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		cphoneLabel.setBounds(200, 85, 80, 25);
		inputPanel.add(cphoneLabel);
		JTextField cphonetext = new JTextField();
		cphonetext.setBounds(280, 85, 110, 25);
		inputPanel.add(cphonetext);
		
		JLabel caddressLabel = new JLabel("�ջ��˵�ַ:");
		caddressLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		caddressLabel.setBounds(390, 85, 80, 25);
		inputPanel.add(caddressLabel);
		JTextField caddresstext = new JTextField();
		caddresstext.setBounds(470, 85, 410, 25);
		inputPanel.add(caddresstext);
		
		
		//������
		JPanel propanel = new JPanel();
		propanel.setBounds(5, 108, 890, 370);
		mainPanel.add(propanel);
		JScrollPane pscrollpane = new JScrollPane();
		pscrollpane.setBounds(2, 15, 885, 355);
		propanel.add(pscrollpane);
		JTable ptable = new JTable();
		ptable.setModel(new ProductModel(null));
		ptable.setFont(new Font("΢���ź�", Font.BOLD, 15));
		ptable.setFillsViewportHeight(true);
		pscrollpane.setViewportView(ptable);
		
		//��ӻ��ɾ�����ȷ�ϴ��� ��ť
		JButton addPbutton =  new JButton("��ӻ���");
		addPbutton.setBounds(620, 480, 80, 40);
		JButton deletePPbutton =  new JButton("ɾ������");
		deletePPbutton.setBounds(705, 480, 80, 40);
		JButton addObutton =  new JButton("ȷ�ϴ���");
		addObutton.setBounds(814, 480, 80, 40);
		mainPanel.add(addPbutton);
		mainPanel.add(deletePPbutton);
		mainPanel.add(addObutton);
		
		
		
		
		
		mainPanel.setVisible(true);
	}

}
