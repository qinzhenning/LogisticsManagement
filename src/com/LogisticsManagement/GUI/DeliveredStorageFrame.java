package com.LogisticsManagement.GUI;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.LogisticsManagement.logic.Order;

/**
* mainPanel code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* mainPanel MACHINE, SO JIGLOO OR mainPanel CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DeliveredStorageFrame{
	private JTextField jTextField1;
	private JButton jButton1;
	private JButton jButton2;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	//已经完成运输  待收取库存
	public DeliveredStorageFrame(JFrame mainFrame,JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainFrame.setTitle("库存管理-出库库存");
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		mainPanel.setBounds(0, 0, 905, 527);
		mainPanel.setPreferredSize(new java.awt.Dimension(905, 527));
		mainPanel.setLayout(null);
		
			jTextField1 = new JTextField();
			mainPanel.add(jTextField1);
			jTextField1.setText("\u8bf7\u8f93\u5165\u8fd0\u5355\u7f16\u53f7");
			jTextField1.setBounds(584, 22, 138, 24);
		
			jButton1 = new JButton();
			mainPanel.add(jButton1);
			jButton1.setText("\u641c\u7d22");
			jButton1.setBounds(764, 22, 68, 24);
		
			jScrollPane1 = new JScrollPane();
			mainPanel.add(jScrollPane1);
			jScrollPane1.setBounds(45, 77, 824, 372);
			
			ArrayList<Order> list1=new ArrayList<Order>();
			for(Order o:MainFrame.getOrderList()){
				if(o.getStatus().equals("结束"))
					list1.add(o);
			}
			int i=list1.size();
			String [][] s=new String[i][5];
			int k=0;
			for(Order o:list1){
				s[k][0]=o.getOid();
				s[k][1]=o.getSdate();
				s[k][2]=o.getCname();
				s[k][3]=o.getCphone();
				s[k][4]=Double.toString(o.getCOD());
				k++;
			}
			
				TableModel jTable1Model = 
						new DefaultTableModel(
								//new String[][] { { "One", "Two" }, { "Three", "Four" } },
								s,
								new String[] { "运单编号", "创建时间","收货人姓名","收货人电话","代收货款" });
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(jTable1Model);
		
			jButton2 = new JButton();
			mainPanel.add(jButton2);
			jButton2.setText("\u8be6\u7ec6\u4fe1\u606f");
			jButton2.setBounds(708, 481, 94, 24);
		
	}
	
	

}
