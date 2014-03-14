/**
 * 
 */
package com.LogisticsManagement.GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author qinzhenning
 * 2014-3-15ионГ1:32:57
 */
public class OrderExaminationFrame {
	
	public OrderExaminationFrame(JFrame mainFrame,JPanel mainPanel){
		mainPanel.setBackground(Color.white);
		mainFrame.setBackground(Color.white);
		mainPanel.setBounds(0, 0, 905, 527);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		
	}
}
