import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//�м�5��������
public  class Block {

	private int x, y, width, height;//���λ�á���С
	private int b = 1;//�����жϿ�������λ��
	private int v;//���˶����ٶȣ��ɸı�
	private InfPanel infPanel;
	private int time;//��ʱ����ʱ��
	private IndexSence is;//����CenterIcon������
	private int cIconX, cIconY, cIconWidth, cIconHeight ,xx,yy;
	IndexSence is1;
	BlockThread BT = new BlockThread(1,is1);
	
	public Block(int x, int y, int width, int height, int v, IndexSence is) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.v = v;
		this.is = is;
	}
	
	//��������
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fill3DRect(x, y, width, height, true);
	}
	
	//�˶�����
	public void MovingTrack()
	{
		//�����ڿ��˶�ʱ�ͽ��м���Ƿ����
		AdjustSpeed();
		
		//���ÿ���˶�����
		if(b == 1)
		{
			x += v;
			y += v;
		}
		else if(b == 2)
		{
			x -= v;
			y += v;
		}
		else if(b == 3)
		{
			x -= v;
			y -= v;
		}
		else if(b == 4)
		{
			x += v;
			y -= v;
		}
		
		
		//�жϿ���������
		if(x >= 425 - width)//���x,y�����Ͻǣ���ȥ��Ŀ��ʹ�������ڱ߽練��
		{
			if(b == 1)
				b = 2;
			else
				b = 3;
		}
		if(y >= 385 - height)
		{
			if(b == 2)
				b = 3;
			else
				b = 4;
		}
		if(x <= 0)
		{
			if(b == 3)
				b = 4;
			else
				b = 1;
		}
		if(y <= 0)
		{
			if(b == 4)
				b = 1;
			else
				b = 2;
		}
		
		IsCrash();
	}
	
	//����ʱ������ٶ�
	public void AdjustSpeed()
	{
		//��ȡʱ��
		infPanel = new InfPanel(is.ci);
		time =  infPanel.getTime();
		//ÿ10�� v += 3��
		if(time % 10 == 0 && time != 0)		//2015-10-26���£�time != 0
		{
			v += 1;
		}
	}
	
	//�����ײ���
	public void IsCrash()
	{
		cIconX = is.ci.getX();
		cIconY = is.ci.getY();
		cIconWidth = is.ci.width;
		cIconHeight = is.ci.height;
		if(((x + width) < cIconX) || (x > (cIconX + cIconWidth)) || ((y + height) < cIconY) || (y > (cIconY + cIconHeight)))
		{
			
		}
		else{
			Thread.currentThread().interrupt();
			infPanel.lShowTime.setText("00:06.422");
			INSERT2 ist = new INSERT2();
			
		}
	}
}