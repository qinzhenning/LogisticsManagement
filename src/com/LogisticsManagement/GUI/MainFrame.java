/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.LogisticsManagement.logic.Order;
import com.LogisticsManagement.logic.Product;




/**
 * @author qinzhenning
 * 2014-3-13下午2:40:02
 */
public class MainFrame {
	private JFrame mainFrame;
	private JPanel mainPanel;
	public static ArrayList<Order> orderlist = new ArrayList();
	
	private void initialize() {
		Product p1 = new Product("1233121","牙膏",15,66,true);
		Product p2 = new Product("1233122","玩具枪",18,66,false);
		Product p3 = new Product("1233123","雨伞",88,180,true);
		ArrayList<Product> p = new ArrayList<Product>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		orderlist.add(new Order("1121341124", p, 1000.0, "小明", "15195991111", "广西南宁市上林县", "小红", 
				"18697243456", "北京西城区", "已经发货", new ArrayList<String>() , "2014-3-14", "", 0));
		
		//主界面
		mainFrame = new JFrame();
		mainFrame.setTitle("物流运营管理系统");
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 903, 570);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		
		mainPanel=new JPanel();
		
		//菜单栏
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mainFrame.setJMenuBar(menuBar);
		
		//在菜单栏中添加	运单管理菜单
		JMenu orderMenu = new JMenu("运单管理");
		orderMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(orderMenu);
		//在菜单栏中添加	车辆管理
		JMenu carMenu = new JMenu("车辆管理");
		carMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(carMenu);
		//在菜单栏中添加	库存管理
		JMenu stockMenu = new JMenu("库存管理");
		stockMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(stockMenu);
		//在菜单栏中添加	退出
		JMenu quitMenu = new JMenu("退出");
		quitMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(quitMenu);
		quitMenu.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			
		});
		
		//运单管理菜单--查看
		JMenuItem seeMenuItem = new JMenuItem("运单查看");
		seeMenuItem.setFont(new Font("微软雅黑", Font.BOLD, 15));
		seeMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mainPanel.removeAll();
			new OrderExaminationFrame(mainFrame, mainPanel,orderlist);
			mainPanel.repaint();
			}
		});		
		//运单管理菜单--录入
		JMenuItem inputMenuItem = new JMenuItem("运单录入");
		inputMenuItem.setFont(new Font("微软雅黑", Font.BOLD, 15));
		inputMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mainPanel.removeAll();
			new OrderInputFrame(mainFrame, mainPanel);
			mainPanel.repaint();
			}
		});
		orderMenu.add(seeMenuItem);
		orderMenu.add(inputMenuItem);				
				
		mainFrame.setVisible(true);
	}
	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.initialize();
	}

	public static ArrayList<Order> getOrderList(){
		return orderlist;
	}
}
