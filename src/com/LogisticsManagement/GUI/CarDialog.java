package com.LogisticsManagement.GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.LogisticsManagement.logic.Car;
import com.LogisticsManagement.logic.CarsStatus;

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
public class CarDialog extends JDialog{
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JButton jButton1;
	private JTextField jTextField4;
	private JLabel jLabel4;
	private JButton jButton2;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JFrame mainFrame;
	private JPanel mainPanel;
	
	public CarDialog(JFrame mainFrame,JPanel mainPanel){
		super(mainFrame,true);
		this.mainFrame=mainFrame;
		this.mainPanel=mainPanel;
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	private void initGUI() {
		try {
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u8f66\u724c\u53f7\u7801\uff1a");
					jLabel1.setBounds(19, 45, 82, 18);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u8d2d\u4e70\u65f6\u95f4\uff1a");
					jLabel2.setBounds(19, 100, 82, 17);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("\u9a7e\u9a76\u5458\uff1a");
					jLabel3.setBounds(19, 152, 82, 17);
				}
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1);
					jTextField1.setBounds(131, 43, 136, 24);
				}
				{
					jTextField2 = new JTextField();
					jPanel1.add(jTextField2);
					jTextField2.setBounds(131, 93, 136, 24);
				}
				{
					jTextField3 = new JTextField();
					jPanel1.add(jTextField3);
					jTextField3.setBounds(131, 149, 136, 24);
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("\u786e\u5b9a");
					jButton1.setBounds(31, 250, 70, 24);
					jButton1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							//添加新Car
							String clicense=jTextField1.getText();
							SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd"); 
							Date cbuy = null;
							try {
								cbuy = sdf.parse(jTextField2.getText());
							} catch (ParseException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
							String cuser=jTextField3.getText();
							int cid=Integer.parseInt(jTextField4.getText());
							Car c=new Car();
							c.setCbuy(cbuy);
							c.setCid(cid);
							c.setClicense(clicense);
							c.setCuser(cuser);
							c.setCstatus(CarsStatus.Ready);
							MainFrame.getCarList().add(c);
							//隐去该Dialog
							close();
							//刷新院窗体界面
							mainPanel.removeAll();
							new CarManagementFrame(mainFrame,mainPanel);
							mainPanel.repaint();
						}
						
					});
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("\u53d6\u6d88");
					jButton2.setBounds(167, 250, 72, 24);
					jButton2.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							close();
						}
						
					});
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u8f66\u8f86\u7f16\u53f7\uff1a");
					jLabel4.setBounds(19, 193, 82, 17);
				}
				{
					jTextField4 = new JTextField();
					jPanel1.add(jTextField4);
					jTextField4.setBounds(131, 190, 136, 24);
				}
			}
			{
				this.setSize(295, 331);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void close(){
		this.dispose();
	}

}
