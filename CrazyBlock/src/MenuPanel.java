import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//�˵�����
public class MenuPanel extends JMenuBar{
	
	private JMenu 
			about = new JMenu("����"),
			ljjh = new JMenu("�۽�����");
	
	private JMenuItem 
			aboutUs = new JMenuItem("��������"),
			aboutGame = new JMenuItem("�������"),
			submitBug = new JMenuItem("�ύBUG"),
			rank = new JMenuItem("���а�");

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
				JOptionPane.showMessageDialog(null, "���ҽ����Ĵ��������");
			}
		});
		aboutGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Produce by ��������ң�Version��1.0");
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
