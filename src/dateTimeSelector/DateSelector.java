package dateTimeSelector;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 创建时间:2013-5-23下午9:34:55 类名:DateSelector 创建者:刘伯乐
 */
public class DateSelector extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateTimeSelector dts;
	private Calendar calendar;
	private Calendar now = Calendar.getInstance();

	private Font font = new Font("宋体", Font.PLAIN, 12);
	private final LabelManager lm = new LabelManager();
	

	private JP1 jp1;
	private JP2 jp2;
	private JP3 jp3;
	private JP4 jp4;

	public DateSelector(Calendar cal, DateTimeSelector sel) {
		calendar = cal;
		dts = sel;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.gray));

		jp1 = new JP1();
		jp2 = new JP2();
		jp3 = new JP3();
		jp4 = new JP4();

		JPanel up = new JPanel(new BorderLayout());
		up.add(jp1, BorderLayout.NORTH);
		up.add(jp2, BorderLayout.CENTER);

		this.add(up, BorderLayout.NORTH);
		this.add(jp3, BorderLayout.CENTER);
		this.add(jp4, BorderLayout.SOUTH);
	}

	// 第一部分：年、月
	private class JP1 extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel left_Year, right_Year, center_Year, left_Mon, right_Mon,
				center_Mon;
		JPanel left, right;

		public JP1() {
			super(new GridLayout());
			this.setBackground(new Color(160, 185, 215));
			initJP1();
		}

		private void initJP1() {
			left_Year = new JLabel("   << ", JLabel.CENTER);
			left_Year.setToolTipText("上一年");
			left_Year.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

			center_Year = new JLabel("", JLabel.CENTER);

			right_Year = new JLabel(" >>  ", JLabel.CENTER);
			right_Year.setToolTipText("下一年");
			right_Year.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

			left_Mon = new JLabel("    << ", JLabel.CENTER);
			left_Mon.setToolTipText("上一月");
			left_Mon.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

			center_Mon = new JLabel("", JLabel.CENTER);

			right_Mon = new JLabel(" >>   ", JLabel.CENTER);
			right_Mon.setToolTipText("下一月");
			right_Mon.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

			updateDate();

			left = new JPanel(new BorderLayout());
			left.add(left_Year, BorderLayout.WEST);
			left.add(center_Year, BorderLayout.CENTER);
			left.add(right_Year, BorderLayout.EAST);

			right = new JPanel(new BorderLayout());
			right.add(left_Mon, BorderLayout.WEST);
			right.add(center_Mon, BorderLayout.CENTER);
			right.add(right_Mon, BorderLayout.EAST);

			this.add(left);
			this.add(right);
			this.setPreferredSize(new Dimension(240, 25));

			left_Year.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					left_Year.setCursor(new Cursor(Cursor.HAND_CURSOR));
					left_Year.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					left_Year.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					left_Year.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					calendar.add(Calendar.YEAR, -1);
					left_Year.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					left_Year.setForeground(Color.BLACK);
				}
			});
			right_Year.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					right_Year.setCursor(new Cursor(Cursor.HAND_CURSOR));
					right_Year.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					right_Year.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					right_Year.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					calendar.add(Calendar.YEAR, 1);
					right_Year.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					right_Year.setForeground(Color.BLACK);
				}
			});

			left_Mon.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					left_Mon.setCursor(new Cursor(Cursor.HAND_CURSOR));
					left_Mon.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					left_Mon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					left_Mon.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					calendar.add(Calendar.MONTH, -1);
					left_Mon.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					left_Mon.setForeground(Color.BLACK);
				}
			});
			right_Mon.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					right_Mon.setCursor(new Cursor(Cursor.HAND_CURSOR));
					right_Mon.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					right_Mon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					right_Mon.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					calendar.add(Calendar.MONTH, 1);
					right_Mon.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					right_Mon.setForeground(Color.BLACK);
				}
			});
		}

		private void updateDate() {
			center_Year.setText(calendar.get(Calendar.YEAR) + " 年");
			center_Mon.setText((calendar.get(Calendar.MONTH) + 1) + " 月");
		}
	}

	// 第二部分：星期
	private class JP2 extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JP2() {
			this.setPreferredSize(new Dimension(240, 20));
		}

		protected void paintComponent(Graphics g) {
			g.setFont(font);
			g.drawString(" 一    二   三    四    五   六    日", 5, 10);
			g.drawLine(0, 15, getWidth(), 15);
		}
	}

	// 第三部分：日期（号数）
	private class JP3 extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JP3() {
			super(new GridLayout(5, 7));
			this.setPreferredSize(new Dimension(240, 150));
			updateDate();
		}

		public void updateDate() {
			this.removeAll();
			this.updateUI();
			lm.clear();

			Date temp = calendar.getTime();
			Calendar select = Calendar.getInstance();
			select.setTime(temp);
			// dts.setCalendar(temp);
			select.set(Calendar.DAY_OF_MONTH, 1);

			int index = select.get(Calendar.DAY_OF_WEEK);
			int sum = (index == 1 ? 8 : index);
			select.add(Calendar.DAY_OF_MONTH, 0 - sum + 1);

			for (int i = 0; i < 35; i++) {
				select.add(Calendar.DAY_OF_MONTH, 1);
				lm.addLabel(new MyLabel(select.get(Calendar.YEAR), select
						.get(Calendar.MONTH), select.get(Calendar.DAY_OF_MONTH)));
			}
			for (MyLabel my : lm.getLabels()) {
				this.add(my);
			}
			// select.setTime(temp);
			// dts.setCalendar(temp);
		}
	}

	// 第四部分：“回到今天”
	private class JP4 extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JButton today, done;
		JLabel chinaDate;

		public JP4() {
			super(new BorderLayout());
			this.setPreferredSize(new Dimension(240, 20));
			// this.setBackground(new Color(160, 185, 215));
			this.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

			today = new JButton("今天");
			chinaDate = new JLabel(dts.getChinaDate(), JLabel.CENTER);
			done = new JButton("完成");

			this.add(today, BorderLayout.WEST);
			this.add(chinaDate, BorderLayout.CENTER);
			this.add(done, BorderLayout.EAST);

			today.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					today.setCursor(new Cursor(Cursor.HAND_CURSOR));
					today.setForeground(Color.blue);
				}

				public void mouseExited(MouseEvent me) {
					today.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					today.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
				}

				public void mouseReleased(MouseEvent me) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					calendar.set(cal.get(Calendar.YEAR),
							cal.get(Calendar.MONTH),
							cal.get(Calendar.DAY_OF_MONTH));
					dts.commit(true);
					jp4.updateChinaDate();
					refresh();
				}
			});

			done.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					done.setCursor(new Cursor(Cursor.HAND_CURSOR));
					done.setForeground(Color.blue);
				}

				public void mouseExited(MouseEvent me) {
					done.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					done.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
				}

				public void mouseReleased(MouseEvent me) {
					done.setForeground(Color.BLACK);
					dts.hidePanel();
				}
			});
		}

		public void updateChinaDate() {
			dts.setChinaDate(calendar); // 保持农历数据，当面板重新show时提供数据
			chinaDate.setText(dts.getChinaDate());
		}
	}

	private class MyLabel extends JLabel implements Comparator<MyLabel>,
			MouseListener, MouseMotionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int year, month, day;
		private boolean isSelected;

		public MyLabel(int year, int month, int day) {
			super("" + day, JLabel.CENTER);
			this.year = year;
			this.day = day;
			this.month = month;
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			this.setFont(font);
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));

			if (month == calendar.get(Calendar.MONTH)) {
				this.setForeground(Color.BLACK);
			} else {
				// this.setForeground(Color.LIGHT_GRAY);
				this.setVisible(false);
			}
			if (day == calendar.get(Calendar.DAY_OF_MONTH)) {
				this.setBackground(new Color(160, 185, 215));
			} else {
				this.setBackground(Color.WHITE);
			}
		}

		public boolean getIsSelected() {
			return isSelected;
		}

		public void setSelected(boolean b, boolean isDrag) {
			isSelected = b;
			if (b && !isDrag) {
				int temp = calendar.get(Calendar.MONTH);
				calendar.set(year, month, day);
				if (temp == month) {
					SwingUtilities.updateComponentTreeUI(jp3);
				} else {
					refresh();
				}
			}
			this.repaint();
		}

		protected void paintComponent(Graphics g) {
			if (day == calendar.get(Calendar.DAY_OF_MONTH)
					&& month == calendar.get(Calendar.MONTH)) {
				// 如果当前日期是选择日期,则高亮显示
				g.setColor(new Color(160, 185, 215));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			if (year == now.get(Calendar.YEAR)
					&& month == now.get(Calendar.MONTH)
					&& day == now.get(Calendar.DAY_OF_MONTH)) {
				// 如果日期和当前日期一样,则用红框
				Graphics2D gd = (Graphics2D) g;
				gd.setColor(Color.RED);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			if (isSelected) {// 如果被选中了就画出一个虚线框出来
				Stroke s = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_BEVEL, 1.0f,
						new float[] { 2.0f, 2.0f }, 1.0f);
				Graphics2D gd = (Graphics2D) g;
				gd.setStroke(s);
				gd.setColor(Color.BLACK);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			super.paintComponent(g);
		}

		public boolean contains(Point p) {
			return this.getBounds().contains(p);
		}

		private void update() {
			repaint();
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			isSelected = true;
			update();
		}

		public void mouseReleased(MouseEvent e) {
			Point p = SwingUtilities.convertPoint(this, e.getPoint(), jp3);
			lm.setSelect(p, false);
			dts.commit(true);
			jp4.updateChinaDate();
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			Point p = SwingUtilities.convertPoint(this, e.getPoint(), jp3);
			lm.setSelect(p, true);
		}

		public void mouseMoved(MouseEvent e) {
		}

		public int compare(MyLabel o1, MyLabel o2) {
			Calendar c1 = Calendar.getInstance();
			c1.set(o1.year, o2.month, o1.day);
			Calendar c2 = Calendar.getInstance();
			c2.set(o2.year, o2.month, o2.day);
			return c1.compareTo(c2);
		}
	}

	private class LabelManager {
		private List<MyLabel> list;

		public LabelManager() {
			list = new ArrayList<MyLabel>();
		}

		public List<MyLabel> getLabels() {
			return list;
		}

		public void addLabel(MyLabel my) {
			list.add(my);
		}

		public void clear() {
			list.clear();
		}

		public void setSelect(Point p, boolean b) {
			// 如果是拖动,则要优化一下,以提高效率
			if (b) {
				// 表示是否能返回,不用比较完所有的标签,能返回的标志就是把上一个标签和
				// 将要显示的标签找到了就可以了
				boolean findPrevious = false, findNext = false;
				for (MyLabel m : list) {
					if (m.contains(p)) {
						findNext = true;
						if (m.getIsSelected()) {
							findPrevious = true;
						} else {
							m.setSelected(true, b);
						}
					} else if (m.getIsSelected()) {
						findPrevious = true;
						m.setSelected(false, b);
					}
					if (findPrevious && findNext) {
						return;
					}
				}
			} else {
				MyLabel temp = null;
				for (MyLabel m : list) {
					if (m.contains(p)) {
						temp = m;
					} else if (m.getIsSelected()) {
						m.setSelected(false, b);
					}
				}
				if (temp != null) {
					temp.setSelected(true, b);
				}
			}
		}

	}

	// 根据新的日期刷新
	private void refresh() {
		jp1.updateDate();
		jp3.updateDate();
		jp4.updateChinaDate();
		dts.commit(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

}// end class
