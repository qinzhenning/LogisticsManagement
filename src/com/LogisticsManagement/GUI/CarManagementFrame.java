package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.LogisticsManagement.logic.Car;
import com.LogisticsManagement.logic.OrderListModel;


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
public class CarManagementFrame {
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton3;
	private JButton jButton2;
	private JTable jTable1;
	public CarManagementFrame(final JFrame mainFrame,final JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainFrame.setTitle("车辆管理-车辆信息管理");
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		
			mainPanel.setBounds(0, 0, 905, 527);
			mainPanel.setPreferredSize(new java.awt.Dimension(905, 527));
			mainPanel.setLayout(null);
			
				jScrollPane1 = new JScrollPane();
				mainPanel.add(jScrollPane1);
				jScrollPane1.setBounds(53, 35, 796, 372);
				
				int i=MainFrame.getCarList().size();
				String [][] s=new String[i][5];
				int k=0;
				for(Car c:MainFrame.getCarList()){
					s[k][0]=Integer.toString(c.getCid());
					s[k][1]=c.getClicense();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
					s[k][2]=sdf.format(c.getCbuy());
					s[k][3]=c.getCuser();
					if(c.getCarsStatus()!=null)
						s[k][4]=c.getCarsStatus().toString();
					else
						s[k][4]="";
					k++;
				}
					TableModel jTable1Model = 
							new DefaultTableModel(
									//new String[][]  { {"One" },{  "Three"}}  ,
									s,
									new String[] { "汽车编号", "车牌号码" ,"购买时间","驾驶员","状态"});
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setPreferredSize(new java.awt.Dimension(793, 348));
				
			
			
				jButton1 = new JButton();
				mainPanel.add(jButton1);
				jButton1.setText("\u589e\u52a0");
				jButton1.setBounds(113, 445, 102, 28);
				jButton1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						new CarDialog(mainFrame,mainPanel);
						}
					}
				);
			
			
				jButton2 = new JButton();
				mainPanel.add(jButton2);
				jButton2.setText("\u4fee\u6539");
				jButton2.setBounds(376, 446, 108, 27);
			
			
				jButton3 = new JButton();
				mainPanel.add(jButton3);
				jButton3.setText("\u5220\u9664");
				jButton3.setBounds(657, 449, 100, 24);
				
	}
}
				
			
		
		
		
		
	
	
	
	
	


