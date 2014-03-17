package dateTimeSelector;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 创建时间:2013-5-23下午9:35:01
 * 类名:Selector
 * 创建者:刘伯乐
 */
public class SelectorTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("我的测试");
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
