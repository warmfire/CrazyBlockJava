import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class INSERT2 extends JFrame {
	// �������
	private JButton btnShow;
	private InfPanel ifp;
	private JLabel lname = new JLabel("�����������:"),
			lgrades = new JLabel("��ĳɼ���:");
	private JPanel lnamePanel = new JPanel(new GridLayout(2, 1)),
			lgradesPanel = new JPanel(new GridLayout(2, 1));
	protected JTextField Jname;
	protected JTextField Jgrades;

	// ���췽��
	public INSERT2() {
		// �����������ԵĶ���
		this.setSize(300, 230);
		this.setLayout(null);
		this.setLocation(780, 185);
		// �������
		lnamePanel.add(lname);
		lnamePanel.setBounds(5, 5, 100, 50);
		this.add(lnamePanel, BorderLayout.NORTH);
		lgradesPanel.add(lgrades);
		lgradesPanel.setBounds(5, 60, 100, 50);
		this.add(lgradesPanel, BorderLayout.NORTH);
		//
		this.Jname = new JTextField();
		this.Jname.setBounds(130, 5, 145, 50);
		this.Jgrades = new JTextField();
		this.Jgrades.setBounds(130, 60, 145, 50);
		/*String str = new String();
		str = str + ifp.getTime();
		System.out.println("123");*/
		Jgrades.setText("06.422");
		this.btnShow = new JButton("�ѳɼ��ϴ������ݰ�");
		this.btnShow.setBounds(10, 130, 265, 50);
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnShow_ActionPerformed(ae);
			}
		});
		// ��������뵽������
		// add(this.scpDemo);
		add(this.btnShow);
		add(this.Jname);
		add(this.Jgrades);
		
		// ��ʾ����
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// �����ťʱ���¼�����
	public void btnShow_ActionPerformed(ActionEvent ae) {
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
		try {
			// �������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.144.244.16:1433;DatabaseName=crazyblock","sa", "123456");
			Statement stmt = conn.createStatement();
			String sql = "";
			sql = sql + "insert into tt2(name,grades) values('"+ Jname.getText() + "'," + Jgrades.getText()
							+ ")";
			stmt.execute(sql);
			JOptionPane.showMessageDialog(null, "��ϲ��", "�Ѿ��ϴ������ݰ�!",JOptionPane.PLAIN_MESSAGE);
			new Main();	
		} catch (Exception e) {

		}
	}
}