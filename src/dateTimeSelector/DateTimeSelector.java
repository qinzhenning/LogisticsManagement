package dateTimeSelector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.IllegalComponentStateException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * 创建时间:2013-5-23下午9:34:39 类名:DateTimeSelector 创建者:刘伯乐
 */
public class DateTimeSelector extends JPanel {
	/**
	 * 本组件由一个Box组成 Box由JTextField和一个JButton组成
	 * 
	 * 当JButton被按下时，弹出一个JPanel 弹出的JPanel由monthJPanel和timeJPanel组成
	 * 
	 * 屏蔽弹出的任何一个JPanel只需注释掉相应JPanel声明和add方法 屏蔽时间可以在setCalendar(Date)方法里面设置
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainJPanel;
	private DateSelector monthJPanel;
	// private TimeSelector timeJPanel;

	private SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat dateTimeSdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private Lunar lunar = new Lunar();
	private Calendar calendar = Calendar.getInstance();
	private Calendar tempCalendar = Calendar.getInstance(); // 临时数据，当提交时赋值给select
	private String chinaDate = ""; // 存放农历数据

	private ImageIcon icon = new ImageIcon(this.getClass().getResource("日历图标.png"));// 图片
	private JTextField showField;
	private JButton showButton;

	private Popup pop;
	private boolean isShow = false;
	private String initString = "选择日期......";

	public DateTimeSelector() {
		initButton();
	}
//
//	public DateTimeSelector(String str) {
//		this.initString = str;
//		initButton();
//	}

	// 日历触发按钮
	private void initButton() {

		new MousetTacker().start(); // 监听鼠标位置，决定隐藏面板
		
		this.setLayout(new BorderLayout());

		showButton = new JButton(icon);
		showButton.setBorder(null);
		showButton.setToolTipText("输入日期");

		showField = new JTextField(initString);
		showField.setEditable(false);
		showField.setPreferredSize(new Dimension(125, 25));

//		Box box = Box.createHorizontalBox();
//		box.add(showField);
//		box.add(showButton);
//
//		this.add(box);
		this.add(showField, BorderLayout.CENTER);
		this.add(showButton, BorderLayout.EAST);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (!me.getSource().equals(this)) // 如果鼠标点击位置在组件外，隐藏窗口
					hidePanel();
			}
		});

		this.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				hidePanel();
			}

			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});

		this.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}

			// 只要祖先组件一移动,马上就让popup消失
			public void ancestorMoved(AncestorEvent event) {
				hidePanel();
			}
		});
		showButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				if (showButton.isEnabled()) {
					showButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					showButton.setForeground(Color.blue);
				}
			}

			public void mouseExited(MouseEvent me) {
				if (showButton.isEnabled()) {
					showButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					showButton.setForeground(Color.BLACK);
				}
			}

			public void mousePressed(MouseEvent me) {
				showButton.requestFocusInWindow();
			}

			public void mouseReleased(MouseEvent me) {
				if (showButton.isEnabled()) {
					showButton.setForeground(Color.BLACK);
					if (isShow)
						hidePanel();
					else {
						setCalendar(calendar.getTime(), false); // 设置屏蔽时、分、秒
						initPanel();
						showPanel(showField);
					}
				}
			}
		});
	}

	// 设置屏蔽时、分、秒
	private void setCalendar(Date date, boolean show) {
		Calendar temp = Calendar.getInstance();
		temp.setTime(date);
		if (show) {
			calendar.set(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH),
					temp.get(Calendar.DAY_OF_MONTH),
					temp.get(Calendar.HOUR_OF_DAY), temp.get(Calendar.MINUTE),
					temp.get(Calendar.SECOND));
		} else { // 这里屏蔽时、分、秒
			calendar.set(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH),
					temp.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		}

	}

	// 根据初始化的日期,初始化面板
	private void initPanel() {
		monthJPanel = new DateSelector(tempCalendar, this);
		// timeJPanel = new TimeSelector(tempCalendar, this);

		mainJPanel = new JPanel(new BorderLayout());
		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		mainJPanel.add(monthJPanel, BorderLayout.WEST);
		// mainJPanel.add(timeJPanel, BorderLayout.EAST);
	}

	protected void hidePanel() {
		if (pop != null) {
			isShow = false;
			pop.hide();
			pop = null;
		}
	}

	// 提交日期
	protected void commit(boolean show) {
		calendar = tempCalendar;
		showField.setText(dateSdf.format(calendar.getTime()));
		if (!show)
			hidePanel();
	}

	protected void setChinaDate(Calendar calendar) {
		lunar.setCalendar(calendar);
		chinaDate = lunar.getChinaDate();
	}

	protected String getChinaDate() {
		return chinaDate;
	}

	private void showPanel(Component owner) {
		if (pop != null) {
			pop.hide();
		}
		Point show = new Point(0, owner.getHeight());
		SwingUtilities.convertPointToScreen(show, owner);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int x = show.x;
		int y = show.y;
		if (x < 0) {
			x = 0;
		}
		if (x > size.width - 390) { // 390是this组件的宽
			x = size.width - 390;
		}
		if (y < size.height - 260) {
		} else {
			y -= 245;
		}
		pop = PopupFactory.getSharedInstance()
				.getPopup(owner, mainJPanel, x, y);
		pop.show();
		isShow = true;
	}

	/**
	 * @ClassName: MousetTacker
	 * @Description: TODO 不断监听鼠标位置并决定隐藏面板
	 * @author 伯乐
	 * @date 2013-6-17 上午12:00:05
	 */
	private class MousetTacker extends Thread {
		private boolean inComponent = false; // 鼠标是否在组件内
		private int times = 0; // 检查次数

		public void run() {
			while (true) {
				Point point = MouseInfo.getPointerInfo().getLocation();
				inComponent = mouseInComponent(point);

				if (inComponent) { // 鼠标在组件内
					times = 0;
				} else if (times >= 5) { // 鼠标tiems次都不在组件内
					hidePanel();
					times = 0;
				} else {
					times++;
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	/**
	 * @param point
	 *            鼠标在屏幕上的位置
	 * @return 鼠标是否在组件内
	 */
	private boolean mouseInComponent(Point point) {
		boolean a = false, b = false;
		if (mainJPanel != null) {
			b = contains(mainJPanel, point);
		}
		SwingUtilities.convertPointFromScreen(point, this); // point被改变，使用point请注意顺序
		// a = contains(this, point); // 采用这种方法有点问题，用this.contains()
		a = this.contains(point);
		return a || b;
	}

	// 重写方法，适应更多判断
	private boolean contains(Component component, Point point) {
		Point p = null;
		double px_min = 0, py_min = 0; // 组件左上角坐标
		double px_max = 0, py_max = 0; // 组件右下角坐标
		double x = 0, y = 0; // 组件的宽(x)、高(y)
		double px = 0, py = 0; // 点的坐标
		boolean valid = true; // 组件是否是showing状态

		try {
			p = component.getLocationOnScreen(); // 转换到屏幕坐标系来比较
		} catch (IllegalComponentStateException icse) { // 组件隐藏时有异常
			valid = false;
		}

		if (valid) {
			px_min = p.getX();
			py_min = p.getY();

			Dimension dimension = component.getPreferredSize(); // 不能直接用this.getX()或this.getY()，有误差
			x = dimension.getWidth();
			y = dimension.getHeight();

			px_max = px_min + x;
			py_max = py_min + y;

			px = point.getX();
			py = point.getY();
			return (px_min <= px && px <= px_max)
					&& (py_min <= py && py <= py_max);
		}
		return false;
	}

	/*----------------------------------------------------------------
	                                                                    对外提供的接口
	 -----------------------------------------------------------------*/
	public String getTime() {
		return timeSdf.format(calendar.getTime());
	}

	public String getDate() {
		return dateSdf.format(calendar.getTime());
	}

	public String getDateTime() {
		return dateTimeSdf.format(calendar.getTime());
	}

	public Date getCalendar() {
		return calendar.getTime();
	}

	public void setEnabled(boolean show) {
		this.showButton.setEnabled(show);
		this.showField.setEnabled(show);
	}
//	public void setBounds(int x, int y, int width, int hight) {
//		showField.set
//	}
	
	public boolean isNull(){
		return showField.getText().equals(initString);
	}
	
	// 清空
	public void setNull(){
		hidePanel();
		calendar = Calendar.getInstance();
		tempCalendar = Calendar.getInstance(); 
		chinaDate = ""; 
		showField.setText(initString); //"请选择日期"
	}
	
	// 设置时间
	public void setTime(Date date) {
		tempCalendar.setTime(date); // 设置时间
		commit(false); // 显示时间并关闭弹窗
		setChinaDate(tempCalendar); // 设置农历
		isShow = false; // 设置弹窗为关闭状态
	}

}
