import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


//作用：把4个块画到场景
//游戏的主场景类
public class IndexSence extends JPanel{
	
	protected Block 
		block1 = new Block(30, 50, 70, 105, 1, this),
		block2 = new Block(250, 50, 100, 65, 2, this),
		block3 = new Block(30, 250, 80, 75, 3, this),
		block4 = new Block(250, 250, 65, 95, 4, this);//设置块的位置、大小、运动速度
	
	protected CenterIcon ci = new CenterIcon(50, 50, this);
	
	public IndexSence()
	{
		
		this.setLayout(null);
		this.add(ci);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		block1.paint(g);
		block2.paint(g);
		block3.paint(g);
		block4.paint(g);
		//System.out.println("test,paintComponent");
	}
}

