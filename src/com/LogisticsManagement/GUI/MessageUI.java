package com.LogisticsManagement.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * @Title: ����Ļ���Ͻ���ʾ.java
 * @Package 
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author ������
 * @date 2013-6-20 ����2:11:42
 * @version V1.0
 */

/**
 * @ClassName: ����Ļ���Ͻ���ʾ
 * @Description: TODO(������һ�仰��������������)
 * @author ����
 * @date 2013-6-20 ����2:11:42
 */
public class MessageUI extends JWindow implements Runnable {

	/**
	 * @Fields serialVersionUID
	 * @Description: TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("", Font.ITALIC, 13);
	private JPanel mainPanel; // �����
	private JLabel titleLabel; // ��������ǩ
	private JPanel titlePanel; // ���������
	private JLabel messageLabel; // ���ݱ�ǩ
	private JPanel messagePanel; // �������

	private int startX, startY; // ���λ��
	private Integer windowWidth = 300; // ������ʾ���ڿ��
	private Integer windowHeight = 70; // ������ʾ���ڸ߶�
	private String title = "���ѣ�";
	private String message = "������";
	private Color titleColor = Color.blue;
	private Color messageColor = Color.WHITE;
	private static int timesPressed = 0;

	public MessageUI(String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.message = message;
		init();
	}

	public MessageUI(Color titleColor, String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.message = message;
		this.titleColor = titleColor;
		init();
	}

	public MessageUI(Color titleColor, String title, String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.titleColor = titleColor;
		this.title = title;
		this.message = message;
		init();
	}

	public MessageUI(Color titleColor, Color messageColor, String title,
			String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.titleColor = titleColor;
		this.messageColor = messageColor;
		this.title = title;
		this.message = message;
		init();
	}

	public MessageUI(String message, int width, int hight) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.message = message;
		this.windowWidth = width;
		this.windowHeight = hight;
		init();
	}

	public MessageUI(String message, Color titleColor, Color messageColor) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.message = message;
		this.titleColor = titleColor;
		this.messageColor = messageColor;
		init();
	}

	public MessageUI(String message, int width, int hight, Color titleColor,
			Color messageColor) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "�벻Ҫ�������죡");
			this.dispose();
			return;
		}
		this.message = message;
		this.windowWidth = width;
		this.windowHeight = hight;
		this.titleColor = titleColor;
		this.messageColor = messageColor;
		init();
	}

	public void init() {
		
		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		startX = screenSize.width;
		startY = 3;

		mainPanel = new JPanel(new BorderLayout());
		titleLabel = new JLabel(title, JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(font);
		titlePanel = new JPanel(new BorderLayout());
		titlePanel.setFont(font);
		titlePanel.setBackground(titleColor);
		titlePanel.add(titleLabel, BorderLayout.CENTER);

		messageLabel = new JLabel(message, JLabel.CENTER);
		messageLabel.setBorder(null);
		messageLabel.setFont(font);
		messagePanel = new JPanel(new BorderLayout());
		messagePanel.add(messageLabel, BorderLayout.CENTER);
		messagePanel.setBackground(messageColor);

		mainPanel.add(titlePanel, BorderLayout.WEST);
		mainPanel.add(messagePanel, BorderLayout.CENTER);

		this.setSize(windowWidth, windowHeight);
		this.setAlwaysOnTop(false);
		this.getContentPane().add(mainPanel);
		// Toolkit.getDefaultToolkit().beep(); // ����ϵͳ��������ʾһ��
		this.setVisible(true);
		this.setAlwaysOnTop(true);// ǰ����ʾ

		new Thread(this).start();
	}

	public void run() {
		timesPressed++;
		boolean expand = true;
		int scap = 1; // ע�ⲻ����Ϊ1���µ���
		try {
			Thread.sleep(5); //��ͣ�Ա�֤��ʼ�����
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				this.setLocation(startX - scap, startY);
				if (scap < 0) {
					this.dispose();
					break;
				}
				if (expand) {
					scap += 20;
				} else {
					scap -= 20;
				}
				if (scap >= 300) {
					Thread.sleep(1800);
					expand = false;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// try {
			// this.setLocation(startX - scap, startY);
			// if (scap == 0) {
			// this.dispose();
			// break;
			// }
			// if (expand) {
			// scap += 1;
			// } else {
			// scap -= 1;
			// }
			// if (scap >= 600) {
			// Thread.sleep(1800);
			// expand = false;
			// }
			// if (scap > 20) {
			// Thread.sleep(scap / 256); // ����ͣ��ʱ����Ե��ڵ����ƶ��ٶ�
			// } else {
			// Thread.sleep((long) 0.1);
			// }
			//
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}// end while
		timesPressed--;
	}// end else

}
