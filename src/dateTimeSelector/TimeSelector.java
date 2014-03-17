package dateTimeSelector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 创建时间:2013-5-23下午9:35:04
 * 类名:TimeSelector
 * 创建者:刘伯乐
 */
public class TimeSelector extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar calendar;
	private DateTimeSelector dts;
	
	private JLabel time, timename;
	private JSlider hSlider, mSlider, sSlider; // 时、分、秒 滑块
	private int hour = 0, min = 0, sec = 0;

	public TimeSelector(Calendar cal, DateTimeSelector sel) {
		calendar = cal;
		dts = sel;
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		min = calendar.get(Calendar.MINUTE);
		sec = calendar.get(Calendar.SECOND);
		time = new JLabel("", JLabel.CENTER);
		updateTime();

		timename = new JLabel("时           分           秒", JLabel.CENTER);

		JPanel up = new JPanel(new BorderLayout());
		up.add(time, BorderLayout.NORTH);
		up.add(timename, BorderLayout.CENTER);

		hSlider = new JSlider(JSlider.VERTICAL, 0, 23,
				calendar.get(Calendar.HOUR_OF_DAY));
		mSlider = new JSlider(JSlider.VERTICAL, 0, 59,
				calendar.get(Calendar.MINUTE));
		sSlider = new JSlider(JSlider.VERTICAL, 0, 59,
				calendar.get(Calendar.SECOND));

		hSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int temp = hSlider.getValue();
				if(hour!=temp){
					hour = temp;
					updateTime();
				}
			}
		});

		mSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int temp = mSlider.getValue();
				if(min!=temp){
					min = temp;
					updateTime();
				}
			}
		});

		sSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int temp = sSlider.getValue();
				if(sec!=temp){
					sec = temp;
					updateTime();
				}
				
			}
		});

		JPanel down = new JPanel(new GridLayout(1, 3));
		down.add(hSlider);
		down.add(mSlider);
		down.add(sSlider);

		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.setPreferredSize(new Dimension(150, 200));
		this.add(up, BorderLayout.NORTH);
		this.add(down, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.setVisible(true);
	}

	private void updateTime() {
		time.setText(hour + ":" + min + ":" + sec);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), hour, min, sec);
		dts.commit(true);
	}
}
