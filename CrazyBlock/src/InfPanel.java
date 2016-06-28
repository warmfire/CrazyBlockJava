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


//��ʾ��Ϣ��
public class InfPanel extends JPanel{
	
	public JLabel 
			lTime = new JLabel("�Ѽ��ʱ��:"),
			lShowTime = new JLabel();//������ʾʱ��
	
	private JPanel	timePanel = new JPanel(new GridLayout(10,1));
	
	private ImageIcon ic;
	private String address;
	public static final long timemillis1 = System.currentTimeMillis();//�������ʱ��
	public static long timemillis2 = 0;//���ÿ���getTime()��ʹ�õ�ʱ��	
	private CenterIcon ci;
	private int flag = 0;//����flag�ж��Ƿ������߳�
	
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
	
	//ʵ�ֻ�ȡIcon�ľ���·��
	private String getAddress(String address)
	{
		return address;
	}
	
	//ʵ�ּ�ʱ���ܣ�ÿ��1ms����һ�μ���
	private void setTime(JLabel time)
	{
		final JLabel varTime = time;
		Timer timeAction = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timemillis2 = System.currentTimeMillis();

				// ת��������ʾ��ʽ
				SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");
				varTime.setText(df.format(timemillis2 - timemillis1));
			}
		});
		timeAction.start();
	}
	
	//����ʱ��
	public int getTime()
	{		
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("ss");//��ȡ�м����
		str = df.format(timemillis2 - timemillis1);
		int timeInt = Integer.parseInt(str);
		return timeInt;
	}
	
}






