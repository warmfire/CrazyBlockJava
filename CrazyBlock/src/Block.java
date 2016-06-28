import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//中间5个方块类
public  class Block {

	private int x, y, width, height;//块的位置、大小
	private int b = 1;//用来判断块所处的位置
	private int v;//块运动的速度，可改变
	private InfPanel infPanel;
	private int time;//计时器的时间
	private IndexSence is;//传递CenterIcon参数用
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
	
	//画出矩形
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fill3DRect(x, y, width, height, true);
	}
	
	//运动方法
	public void MovingTrack()
	{
		//设置在块运动时就进行检测是否加速
		AdjustSpeed();
		
		//设置块的运动方向
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
		
		
		//判断块来自哪里
		if(x >= 425 - width)//块的x,y在左上角，减去块的宽度使其正好在边界反弹
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
	
	//根据时间控制速度
	public void AdjustSpeed()
	{
		//获取时间
		infPanel = new InfPanel(is.ci);
		time =  infPanel.getTime();
		//每10秒 v += 3；
		if(time % 10 == 0 && time != 0)		//2015-10-26更新：time != 0
		{
			v += 1;
		}
	}
	
	//块的碰撞检测
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