import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//菜单栏类
public class MenuPanel extends JMenuBar{
	
	private JMenu 
			about = new JMenu("关于"),
			ljjh = new JMenu("论剑江湖");
	
	private JMenuItem 
			aboutUs = new JMenuItem("关于我们"),
			aboutGame = new JMenuItem("关于软件"),
			submitBug = new JMenuItem("提交BUG"),
			rank = new JMenuItem("排行榜");

	public MenuPanel()
	{
		this.add(about);
		this.add(ljjh);
		
		about.add(aboutUs);
		about.add(aboutGame);
		about.add(submitBug);
		ljjh.add(rank);
		
		aboutUs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "搅乱江湖的错觉工作室");
			}
		});
		aboutGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Produce by 错觉工作室；Version：1.0");
			}
		});
		submitBug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "http://mail.qq.com");
			}
		});
		rank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test test  = new Test();
			}
		});
	}
	
}
