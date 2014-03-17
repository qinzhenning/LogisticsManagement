package com.LogisticsManagement.GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.LogisticsManagement.logic.Car;

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
public class TransManagementFrame{
	private JTextField jTextField1;
	private JButton jButton1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	String [][] s;
	public TransManagementFrame(final JFrame mainFrame,JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainFrame.setTitle("车辆管理-运输管理");
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		mainPanel.setBounds(0, 0, 905, 527);
		mainPanel.setPreferredSize(new java.awt.Dimension(905, 527));
		mainPanel.setLayout(null);
		
			jTextField1 = new JTextField();
			mainPanel.add(jTextField1);
			jTextField1.setText("\u8bf7\u8f93\u5165\u8ba2\u5355\u53f7\u6216\u8005\u6c7d\u8f66\u7f16\u53f7");
			jTextField1.setBounds(505, 25, 202, 24);
		
			jButton1 = new JButton();
			mainPanel.add(jButton1);
			jButton1.setText("\u641c\u7d22");
			jButton1.setBounds(763, 25, 75, 24);
		
			jScrollPane1 = new JScrollPane();
			mainPanel.add(jScrollPane1);
			jScrollPane1.setBounds(17, 74, 870, 400);
			
			int i=MainFrame.getCarList().size();
			s=new String[i][4];
			int k=0;
			for(Car c:MainFrame.getCarList()){
				s[k][0]=Integer.toString(c.getCid());
				s[k][1]=c.getClicense();
				s[k][2]=c.getCuser();
				if(c.getCarsStatus()!=null)
					s[k][3]=c.getCarsStatus().toString();
				else
					s[k][3]="";
				k++;
			}
				TableModel jTable1Model = 
						new DefaultTableModel(
								//new String[][] { { "One", "Two" }, { "Three", "Four" } },
								s,
								new String[] { "汽车编号","车牌号","驾驶员","状态" });
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(jTable1Model);
			
				JButton jButton2 = new JButton();
				mainPanel.add(jButton2);
				jButton2.setText("添加运单");
				jButton2.setBounds(550, 480, 120, 24);
				jButton2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						int i=jTable1.getSelectedRow();
						if(i<0){
							new MessageUI(Color.red,"请选择要查看的车辆");
							//JOptionPane.showMessageDialog(null,"请选择要查看的车辆");
						}
						else if(s[i][3]!="Ready"){
							new MessageUI(Color.red,"该车不处于未发货状态，无法添加运单");
							//JOptionPane.showMessageDialog(null,"该车不处于未发货状态，无法添加运单");
						}
						else{
							new AddOrderDialog(mainFrame,Integer.parseInt(s[i][0]));
						}
						
					}
					
				});
				
				JButton jButton3 = new JButton();
				mainPanel.add(jButton3);
				jButton3.setText("查看运单列表");
				jButton3.setBounds(700, 480, 120, 24);
				jButton3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						int i=jTable1.getSelectedRow();
						if(i<0){
							new MessageUI(Color.red,"请选择要查看的车辆");
							//JOptionPane.showMessageDialog(null,"请选择要查看的车辆");
						}
						else {
							new OrderListDialog(mainFrame,Integer.parseInt(s[i][0]));
						}
						
					}
					
				});
			
		
	}
	
	

}
