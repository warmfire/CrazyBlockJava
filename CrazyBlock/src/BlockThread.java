import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.plaf.SliderUI;


//�����߳���
public class BlockThread extends JPanel implements Runnable{

	private int flag = 0;//�ж��Ƿ������߳�
	private IndexSence is;//��ȡIndexSence�����е�4����
	
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
