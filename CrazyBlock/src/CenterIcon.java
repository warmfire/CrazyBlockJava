import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


//�м��ƶ�����
public class CenterIcon extends JLabel {
	
	private static int flag = -1;//����flag�ж��߳��Ƿ�ʼ
	private BlockThread t;		//�߳�
	
	private Insets insets = null;
	private Point position = null;
	private static int x,y;		//ȷ��λ�ñ���
	
	protected int width, height;//��Ĵ�С
	private IndexSence is;
	private InfPanel ip;

	public CenterIcon(int width, int height, IndexSence ise)
	{
		is = ise;
		Icon icon = new ImageIcon("RedBlock.png");
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.setLocation(170, 150);
		this.setIcon(icon);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
			{
				//���õ����ʼ�߳�
				setFlag();
				t = new BlockThread(flag, is);
				Thread thread = new Thread(t);
				thread.start();
				x = e.getX();
				y = e.getY();
				System.out.println("test,�ѵ��");
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
			
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				JLabel l = (JLabel) e.getSource();
				l.setLocation(l.getX() + e.getX() - x, l.getY() + e.getY() - y);
				if(l.getX() < 0)	setLocation(0, l.getY());
				if(l.getX() > 375)	setLocation(375, l.getY());
				if(l.getY() < 0)	setLocation(l.getX(), 0);
				if(l.getY() > 335)	setLocation(l.getX(), 335);
			}
		});
	}


	public void setFlag()
	{
		flag = 1;
	}
	public int getFlag()
	{
		if(flag == 1)
			return 1;
		else
			return -1;
	}
	
}
