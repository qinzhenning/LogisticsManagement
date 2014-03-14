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
 * @Title: 在屏幕右上角显示.java
 * @Package 
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 刘伯乐
 * @date 2013-6-20 上午2:11:42
 * @version V1.0
 */

/**
 * @ClassName: 在屏幕右上角显示
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 伯乐
 * @date 2013-6-20 上午2:11:42
 */
public class MessageUI extends JWindow implements Runnable {

	/**
	 * @Fields serialVersionUID
	 * @Description: TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("", Font.ITALIC, 13);
	private JPanel mainPanel; // 主面板
	private JLabel titleLabel; // 标题栏标签
	private JPanel titlePanel; // 标题栏面板
	private JLabel messageLabel; // 内容标签
	private JPanel messagePanel; // 内容面板

	private int startX, startY; // 起点位置
	private Integer windowWidth = 300; // 设置提示窗口宽度
	private Integer windowHeight = 70; // 设置提示窗口高度
	private String title = "提醒！";
	private String message = "！！！";
	private Color titleColor = Color.blue;
	private Color messageColor = Color.WHITE;
	private static int timesPressed = 0;

	public MessageUI(String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
			this.dispose();
			return;
		}
		this.message = message;
		init();
	}

	public MessageUI(Color titleColor, String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
			this.dispose();
			return;
		}
		this.message = message;
		this.titleColor = titleColor;
		init();
	}

	public MessageUI(Color titleColor, String title, String message) {
		if (timesPressed >= 3) {
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
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
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
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
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
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
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
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
			JOptionPane.showMessageDialog(null, "请不要操作过快！");
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
		// Toolkit.getDefaultToolkit().beep(); // 播放系统声音，提示一下
		this.setVisible(true);
		this.setAlwaysOnTop(true);// 前端显示

		new Thread(this).start();
	}

	public void run() {
		timesPressed++;
		boolean expand = true;
		int scap = 1; // 注意不能设为1以下的数
		try {
			Thread.sleep(5); //暂停以保证初始化完成
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
			// Thread.sleep(scap / 256); // 更改停顿时间可以调节弹窗移动速度
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
