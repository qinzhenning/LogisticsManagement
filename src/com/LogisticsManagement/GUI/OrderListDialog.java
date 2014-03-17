package com.LogisticsManagement.GUI;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class OrderListDialog extends JDialog{ 
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private int cid;
	private ArrayList<Order> orlist;
	
	public OrderListDialog(JFrame mainFrame,int cid){
		super(mainFrame,true);
		this.cid=cid;
		initGUI();
		this.setLocationRelativeTo(mainFrame);
		this.setVisible(true);
	}

	private void initGUI() {
		try {
			{
				jScrollPane1 = new JScrollPane();
				//jScrollPane1.setLayout(null);
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				{
					
					orlist=new ArrayList<Order>();
					
					for(Car c:MainFrame.getCarList()){
						if(c.getCid()==cid){
							orlist=c.getOrlist();
							break;
						}
					}
					int i=orlist.size();
					String [][] s=new String[i][3];
					int k=0;
					for(Order o:orlist){
						s[k][0]=o.getOid();
						s[k][1]=o.getSdate();
						s[k][2]=Double.toString(o.getCOD());
						k++;
					}
					TableModel jTable1Model = 
							new DefaultTableModel(
									//new String[][] { { "One", "Two" }, { "Three", "Four" } },
									s,
									new String[] { "运单编号", "创建时间" ,"代收货款"});
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
			{
				this.setSize(416, 328);
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
