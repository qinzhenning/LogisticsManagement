package dateTimeSelector;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * ����ʱ��:2013-5-23����9:35:01
 * ����:Selector
 * ������:������
 */
public class SelectorTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("�ҵĲ���");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		DateTimeSelector mp = new DateTimeSelector();
		frame.add(mp, BorderLayout.CENTER);

		JTextField seField = new JTextField();
		seField.setPreferredSize(new Dimension(100, 25));

		frame.add(seField, BorderLayout.SOUTH);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
