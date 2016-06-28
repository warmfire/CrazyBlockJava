import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.plaf.SliderUI;


//控制线程类
public class BlockThread extends JPanel implements Runnable{

	private int flag = 0;//判断是否启动线程
	private IndexSence is;//获取IndexSence场景中的4个块
	
	public BlockThread(int flag, IndexSence is)
	{
		this.flag = flag;
		this.is = is;
	}
	
	@Override
	public void run() {
		try
		{
			while (flag == 1) 
			{
				is.block1.MovingTrack();
				is.block2.MovingTrack();
				is.block3.MovingTrack();
				is.block4.MovingTrack();
				Thread.sleep(10);
				is.repaint();
			}
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
}
