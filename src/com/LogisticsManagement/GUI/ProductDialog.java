/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.Product;
import com.LogisticsManagement.logic.ProductModel;

/**
 * @author qinzhenning
 * 2014-3-15����8:01:00
 */
public class ProductDialog extends JDialog{
	private JTextField idtext,nametext,numtext,weighttext,squashytext;
	private JRadioButton yesbutton,nobutton;
	
	public ProductDialog (JFrame mainFrame,final ArrayList<Product> plist,
			final JTable ptable,final JTextField numolabel,final JTextField weightolabel){
		super(mainFrame,false);
		setBounds(300, 200, 300, 270);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JLabel idlabel = new JLabel("������");
		idlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		idlabel.setBounds(5, 5, 88, 40);
		add(idlabel);
		JLabel namelabel = new JLabel("��������");
		namelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		namelabel.setBounds(5, 45, 88, 40);
		add(namelabel);
		JLabel numlabel = new JLabel("��������");
		numlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		numlabel.setBounds(5, 85, 88, 40);
		add(numlabel);
		JLabel weightlabel = new JLabel("��������");
		weightlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		weightlabel.setBounds(5, 125, 88, 40);
		JLabel squashylabel = new JLabel("�Ƿ�����");
		squashylabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		squashylabel.setBounds(5, 165, 88, 40);
		add(idlabel);
		add(namelabel);
		add(numlabel);
		add(weightlabel);
		add(squashylabel);
		
		idtext = new JTextField();
		idtext.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		idtext.setBounds(85, 5, 210, 40);
		nametext = new JTextField();
		nametext.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		nametext.setBounds(85, 45, 210, 40);
		numtext = new JTextField();
		numtext.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		numtext.setBounds(85, 85, 210, 40);
		weighttext = new JTextField();
		weighttext.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		weighttext.setBounds(85, 125, 210, 40);
		yesbutton = new JRadioButton("��");
		yesbutton.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		yesbutton.setBounds(85, 165, 100, 40);
		nobutton = new JRadioButton("��");
		nobutton.setSelected(true);
		nobutton.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		nobutton.setBounds(185, 165, 100, 40);
		ButtonGroup group = new ButtonGroup();
		group.add(yesbutton);
		group.add(nobutton);
		add(idtext);
		add(nametext);
		add(numtext);
		add(weighttext);
		add(yesbutton);
		add(nobutton);
		
		JButton confirmbutton = new JButton("ȷ��");
		confirmbutton.setBounds(215, 205, 80, 40);
		confirmbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				// TODO �Զ����ɵķ������
				if(yesbutton.isSelected()){
					plist.add(new Product(idtext.getText(),nametext.getText(),
							Integer.parseInt(numtext.getText()),Double.valueOf(weighttext.getText()),true));
					dispose();
					ptable.setModel(new ProductModel(plist));
				}
				else{
					plist.add(new Product(idtext.getText(),nametext.getText(),
							Integer.parseInt(numtext.getText()),Double.valueOf(weighttext.getText()),false));
					dispose();
					ptable.setModel(new ProductModel(plist));
				}
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
			}
			
		});
		JButton canclebutton = new JButton("ȡ��");
		canclebutton.setBounds(130, 205, 80, 40);
		add(confirmbutton);
		add(canclebutton);
	}
	
	
}
