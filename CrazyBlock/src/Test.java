import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame {

	// �������
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;

	// ���췽��
	public Test() {
		// �����������ԵĶ���
		this.setSize(330, 400);
		this.setLayout(null);
		this.setLocation(740, 180);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		this.btnShow = new JButton("���ݰ�");
		this.btnShow.setBounds(10, 10, 300, 30);
		// ����ťע�����
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnShow_ActionPerformed(ae);
			}
		});
		// ��������뵽������
		add(this.scpDemo);
		add(this.btnShow);
		// ��ʾ����
		this.setVisible(true);
	}

	// �����ťʱ���¼�����
	public void btnShow_ActionPerformed(ActionEvent ae) {
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
		try {
			// �������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager
					.getConnection(
							"jdbc:sqlserver://10.144.244.16:1433;DatabaseName=crazyblock",
							"sa", "123456");
			// ������ѯ����
			String sql = "select * from tt2 order by grades desc";
			PreparedStatement pstm = conn.prepareStatement(sql);
			// ִ�в�ѯ
			ResultSet rs = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][4];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("ttId"));
				info[count][1] = rs.getString("name");
				info[count][2] = rs.getString("grades");
				count++;
			}
			// �����ͷ
			String[] title = { "id", "����", "�ɼ�" };
			// ����JTable
			this.tabDemo = new JTable(info, title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "����Դ����", "����",
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}