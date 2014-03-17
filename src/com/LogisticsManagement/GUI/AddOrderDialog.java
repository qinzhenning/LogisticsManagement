package com.LogisticsManagement.GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.LogisticsManagement.logic.Car;
import com.LogisticsManagement.logic.Order;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AddOrderDialog extends JDialog{
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton2;
	private JTable jTable1;
	private int cid;
	private String [][] s;
	private TableModel jTable1Model;
	private ArrayList<Order> list1,list2;
	
	public AddOrderDialog(JFrame mainFrame,int cid){
		super(mainFrame,true);
		this.cid=cid;
		initGUI();
		this.setLocationRelativeTo(mainFrame);
		this.setVisible(true);
	}

	private void initGUI() {
		try {
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(0,0,286,188);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(286, 188));
					{
						list1=new ArrayList<Order>();
						for(Order o:MainFrame.getOrderList()){
							if(o.getStatus()=="未发货")
								list1.add(o);
						}
						int i=list1.size();
						s=new String[i][1];
						int k=0;
						for(Order o:list1){
							s[k][0]=o.getOid();
							k++;
						}
						jTable1Model = 
								new DefaultTableModel(
										//new String[][] { { "One" }, { "Three" } },
										s,
										new String[] { "运单号", "是否添加" });
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
						
						TableColumn tc = jTable1.getColumnModel().getColumn(1);
						tc.setCellEditor(jTable1.getDefaultEditor(Boolean.class));
						tc.setCellRenderer(jTable1.getDefaultRenderer(Boolean.class));
					}
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("\u53d6\u6d88");
					jButton2.setBounds(173, 215, 75, 25);
					jButton2.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							close();
						}
						
					});
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("\u786e\u5b9a");
					jButton1.setBounds(27, 215, 75, 25);
					jButton1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							list2=new ArrayList<Order>();
							int count=jTable1.getRowCount();
							for(int i=0;i<count;i++){
								if(jTable1Model.getValueAt(i, 1)!=null){
									if(jTable1Model.getValueAt(i, 1).equals(true)){
										String id=s[i][0];
										for(Order or:list1){
											if(or.getOid()==id){
												list2.add(or);
											}
										}
									}
								}
							}
						
							add();
							
							close();
						}
					
						
						
					});
				}
			}
			{
				this.setSize(295, 312);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close(){
		this.dispose();
	}
	
	private void add(){
		for(Car c:MainFrame.getCarList()){
			if(c.getCid()==cid){
				c.setOrlist(list2);
				break;
			}
		}
		
	}

}
