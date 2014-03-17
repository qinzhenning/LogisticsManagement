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
 * ����ʱ��:2013-5-23����9:34:39 ����:DateTimeSelector ������:������
 */
public class DateTimeSelector extends JPanel {
	/**
	 * �������һ��Box��� Box��JTextField��һ��JButton���
	 * 
	 * ��JButton������ʱ������һ��JPanel ������JPanel��monthJPanel��timeJPanel���
	 * 
	 * ���ε������κ�һ��JPanelֻ��ע�͵���ӦJPanel������add���� ����ʱ�������setCalendar(Date)������������
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
	private Calendar tempCalendar = Calendar.getInstance(); // ��ʱ���ݣ����ύʱ��ֵ��select
	private String chinaDate = ""; // ���ũ������

	private ImageIcon icon = new ImageIcon(this.getClass().getResource("����ͼ��.png"));// ͼƬ
	private JTextField showField;
	private JButton showButton;

	private Popup pop;
	private boolean isShow = false;
	private String initString = "ѡ������......";

	public DateTimeSelector() {
		initButton();
	}
//
//	public DateTimeSelector(String str) {
//		this.initString = str;
//		initButton();
//	}

	// ����������ť
	private void initButton() {

		new MousetTacker().start(); // �������λ�ã������������
		
		this.setLayout(new BorderLayout());

		showButton = new JButton(icon);
		showButton.setBorder(null);
		showButton.setToolTipText("��������");

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
				if (!me.getSource().equals(this)) // ��������λ��������⣬���ش���
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

			// ֻҪ�������һ�ƶ�,���Ͼ���popup��ʧ
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
						setCalendar(calendar.getTime(), false); // ��������ʱ���֡���
						initPanel();
						showPanel(showField);
					}
				}
			}
		});
	}

	// ��������ʱ���֡���
	private void setCalendar(Date date, boolean show) {
		Calendar temp = Calendar.getInstance();
		temp.setTime(date);
		if (show) {
			calendar.set(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH),
					temp.get(Calendar.DAY_OF_MONTH),
					temp.get(Calendar.HOUR_OF_DAY), temp.get(Calendar.MINUTE),
					temp.get(Calendar.SECOND));
		} else { // ��������ʱ���֡���
			calendar.set(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH),
					temp.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		}

	}

	// ���ݳ�ʼ��������,��ʼ�����
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

	// �ύ����
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
		if (x > size.width - 390) { // 390��this����Ŀ�
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
	 * @Description: TODO ���ϼ������λ�ò������������
	 * @author ����
	 * @date 2013-6-17 ����12:00:05
	 */
	private class MousetTacker extends Thread {
		private boolean inComponent = false; // ����Ƿ��������
		private int times = 0; // ������

		public void run() {
			while (true) {
				Point point = MouseInfo.getPointerInfo().getLocation();
				inComponent = mouseInComponent(point);

				if (inComponent) { // ����������
					times = 0;
				} else if (times >= 5) { // ���tiems�ζ����������
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
	 *            �������Ļ�ϵ�λ��
	 * @return ����Ƿ��������
	 */
	private boolean mouseInComponent(Point point) {
		boolean a = false, b = false;
		if (mainJPanel != null) {
			b = contains(mainJPanel, point);
		}
		SwingUtilities.convertPointFromScreen(point, this); // point���ı䣬ʹ��point��ע��˳��
		// a = contains(this, point); // �������ַ����е����⣬��this.contains()
		a = this.contains(point);
		return a || b;
	}

	// ��д��������Ӧ�����ж�
	private boolean contains(Component component, Point point) {
		Point p = null;
		double px_min = 0, py_min = 0; // ������Ͻ�����
		double px_max = 0, py_max = 0; // ������½�����
		double x = 0, y = 0; // ����Ŀ�(x)����(y)
		double px = 0, py = 0; // �������
		boolean valid = true; // ����Ƿ���showing״̬

		try {
			p = component.getLocationOnScreen(); // ת������Ļ����ϵ���Ƚ�
		} catch (IllegalComponentStateException icse) { // �������ʱ���쳣
			valid = false;
		}

		if (valid) {
			px_min = p.getX();
			py_min = p.getY();

			Dimension dimension = component.getPreferredSize(); // ����ֱ����this.getX()��this.getY()�������
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
	                                                                    �����ṩ�Ľӿ�
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
	
	// ���
	public void setNull(){
		hidePanel();
		calendar = Calendar.getInstance();
		tempCalendar = Calendar.getInstance(); 
		chinaDate = ""; 
		showField.setText(initString); //"��ѡ������"
	}
	
	// ����ʱ��
	public void setTime(Date date) {
		tempCalendar.setTime(date); // ����ʱ��
		commit(false); // ��ʾʱ�䲢�رյ���
		setChinaDate(tempCalendar); // ����ũ��
		isShow = false; // ���õ���Ϊ�ر�״̬
	}

}
