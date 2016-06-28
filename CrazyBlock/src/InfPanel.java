import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


//显示信息类
public class InfPanel extends JPanel{
	
	public JLabel 
			lTime = new JLabel("已坚持时间:"),
			lShowTime = new JLabel();//用来显示时间
	
	private JPanel	timePanel = new JPanel(new GridLayout(10,1));
	
	private ImageIcon ic;
	private String address;
	public static final long timemillis1 = System.currentTimeMillis();//设置最初时间
	public static long timemillis2 = 0;//设置可在getTime()中使用的时间	
	private CenterIcon ci;
	private int flag = 0;//设置flag判断是否启动线程
	
	public InfPanel(CenterIcon ci)
	{
		this.ci = ci;
		flag = ci.getFlag();
		
		this.setLayout(new BorderLayout());		
		
		
		timePanel.add(lTime);
		timePanel.add(lShowTime);
		
		//if(flag == 1)
			this.setTime(lShowTime);
		/*else
			lShowTime.setText("00:00.000");*/
		
		//System.out.println("test,flag = " + flag);
		
		this.add(timePanel,BorderLayout.CENTER);
		
	}
	
	//实现获取Icon的绝对路径
	private String getAddress(String address)
	{
		return address;
	}
	
	//实现计时功能，每隔1ms进行一次计算
	private void setTime(JLabel time)
	{
		final JLabel varTime = time;
		Timer timeAction = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timemillis2 = System.currentTimeMillis();

				// 转换日期显示格式
				SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");
				varTime.setText(df.format(timemillis2 - timemillis1));
			}
		});
		timeAction.start();
	}
	
	//传递时间
	public int getTime()
	{		
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("ss");//获取中间的秒
		str = df.format(timemillis2 - timemillis1);
		int timeInt = Integer.parseInt(str);
		return timeInt;
	}
	
}






