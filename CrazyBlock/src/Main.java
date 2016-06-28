import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//主函数
public class Main extends JFrame{
	
	private IndexSence indexSence;//游戏主页面
	private InfPanel infPanel;//信息页面
	private MenuPanel menuPanel;//菜单栏
	public Main()
	{
		JFrame j = new JFrame("CrazyBlock");
		
		Container cont = j.getContentPane();
		cont.setLayout(new BorderLayout());
		
		indexSence = new IndexSence();
		cont.add(indexSence,BorderLayout.CENTER);	
		
		
		infPanel = new InfPanel(indexSence.ci);
		cont.add(infPanel,BorderLayout.EAST);
		menuPanel = new MenuPanel();
		cont.add(menuPanel,BorderLayout.NORTH);
		
		j.setBounds(525,170,550,450);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Main();		
	}
}
