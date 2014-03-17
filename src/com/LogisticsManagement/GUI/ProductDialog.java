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
 * 2014-3-15下午8:01:00
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
		
		JLabel idlabel = new JLabel("货物编号");
		idlabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		idlabel.setBounds(5, 5, 88, 40);
		add(idlabel);
		JLabel namelabel = new JLabel("货物名称");
		namelabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		namelabel.setBounds(5, 45, 88, 40);
		add(namelabel);
		JLabel numlabel = new JLabel("货物数量");
		numlabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		numlabel.setBounds(5, 85, 88, 40);
		add(numlabel);
		JLabel weightlabel = new JLabel("货总重量");
		weightlabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		weightlabel.setBounds(5, 125, 88, 40);
		JLabel squashylabel = new JLabel("是否易碎");
		squashylabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		squashylabel.setBounds(5, 165, 88, 40);
		add(idlabel);
		add(namelabel);
		add(numlabel);
		add(weightlabel);
		add(squashylabel);
		
		idtext = new JTextField();
		idtext.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		idtext.setBounds(85, 5, 210, 40);
		nametext = new JTextField();
		nametext.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		nametext.setBounds(85, 45, 210, 40);
		numtext = new JTextField();
		numtext.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		numtext.setBounds(85, 85, 210, 40);
		weighttext = new JTextField();
		weighttext.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		weighttext.setBounds(85, 125, 210, 40);
		yesbutton = new JRadioButton("是");
		yesbutton.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		yesbutton.setBounds(85, 165, 100, 40);
		nobutton = new JRadioButton("否");
		nobutton.setSelected(true);
		nobutton.setFont(new Font("微软雅黑", Font.ITALIC, 20));
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
		
		JButton confirmbutton = new JButton("确认");
		confirmbutton.setBounds(215, 205, 80, 40);
		confirmbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				// TODO 自动生成的方法存根
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
			}
			
		});
		JButton canclebutton = new JButton("取消");
		canclebutton.setBounds(130, 205, 80, 40);
		add(confirmbutton);
		add(canclebutton);
	}
	
	
}
