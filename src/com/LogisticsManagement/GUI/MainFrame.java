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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;




/**
 * @author qinzhenning
 * 2014-3-13����2:40:02
 */
public class MainFrame {
	private JFrame mainFrame;
	private JPanel mainPanel;
	
	private void initialize() {
		//������
		mainFrame = new JFrame();
		mainFrame.setTitle("������Ӫ����ϵͳ");
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 903, 570);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		
		mainPanel=new JPanel();
		
		//�˵���
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("΢���ź�", Font.BOLD, 15));
		mainFrame.setJMenuBar(menuBar);
		
		//�ڲ˵��������	�˵�����˵�
		JMenu orderMenu = new JMenu("�˵�����");
		orderMenu.setFont(new Font("΢���ź�", Font.BOLD, 15));
		menuBar.add(orderMenu);
		//�ڲ˵��������	��������
		JMenu carMenu = new JMenu("��������");
		carMenu.setFont(new Font("΢���ź�", Font.BOLD, 15));
		menuBar.add(carMenu);
		//�ڲ˵��������	������
		JMenu stockMenu = new JMenu("������");
		stockMenu.setFont(new Font("΢���ź�", Font.BOLD, 15));
		menuBar.add(stockMenu);
		//�ڲ˵��������	�˳�
		JMenu quitMenu = new JMenu("�˳�");
		quitMenu.setFont(new Font("΢���ź�", Font.BOLD, 15));
		menuBar.add(quitMenu);
		quitMenu.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
				
			}
			
		});
		
		//�˵�����˵�--�鿴
		JMenuItem seeMenuItem = new JMenuItem("�˵��鿴");
		seeMenuItem.setFont(new Font("΢���ź�", Font.BOLD, 15));
		seeMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
						
			}
		});		
		//�˵�����˵�--¼��
		JMenuItem inputMenuItem = new JMenuItem("�˵�¼��");
		inputMenuItem.setFont(new Font("΢���ź�", Font.BOLD, 15));
		inputMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mainPanel.removeAll();
			new OrderInputFrame(mainFrame, mainPanel);
			mainPanel.repaint();
			}
		});
		//�˵�����˵�--����
		JMenuItem updateMenuItem = new JMenuItem("�˵�����");
		updateMenuItem.setFont(new Font("΢���ź�", Font.BOLD, 15));
		updateMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
						
			}
		});
		orderMenu.add(seeMenuItem);
		orderMenu.add(inputMenuItem);
		orderMenu.add(updateMenuItem);
				
				
		mainFrame.setVisible(true);
	}
	/**
	 * �������
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.initialize();
	}

}
