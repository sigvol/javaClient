package VC.client.view.Library;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import VC.client.view.Library.mainFrame;

public class findFrame extends JFrame {
	public static DefaultTableModel model = new DefaultTableModel();
	
	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JFrame jf = new JFrame();

	public findFrame() {
		
		jf.setTitle("����Уͼ��ݲ�ѯ����");
		jf.setSize(new Dimension(700, 505));
		jf.setLocation(200, 200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setLayout(new GridLayout(4, 1));		

		JLabel jb = new JLabel("��ѯҳ��");
		jp.add(jb);
		jf.add(jp);
		JLabel jb1 = new JLabel("����Ҫ��ѯ��������");
		final JTextField jt = new JTextField(15);
		jp1.add(jb1);
		jp1.add(jt);
		jf.add(jp1);
		JScrollPane scrollPane = new JScrollPane();
		jp3.add(scrollPane, BorderLayout.CENTER);
		jf.add(jp3);

		JTable tb = new JTable();
		//tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// �����ѡ��ģʽ����Ϊֻ������ѡ�񡢵����������ѡ������ѡ��
		tb.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		tb.setRowHeight(30);
		JTableHeader header = tb.getTableHeader(); // ��ȡ JTable ��ͷ�Ķ���
		header.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		header.setPreferredSize(new Dimension(header.getWidth(), 35)); // ���ô��������ѡ��С
		scrollPane.setViewportView(tb);
		model = (DefaultTableModel) tb.getModel();
		model.setColumnIdentifiers(new Object[] { "���", "����", "�ݲ�", "����" });

		JButton bt = new JButton("��ѯ");
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				try {
					Connection con = new DB().getConn();
					Statement stmt = con.createStatement();
					String sql = "select * from lesson where id =" + jt.getText().trim();
					ResultSet rs = stmt.executeQuery(sql);
					boolean flag = true;
					if (rs.next()) {
						flag = false;
						int id = rs.getInt(1);
						String name = rs.getString(2);
						String palce = rs.getString(3);
						int num = rs.getInt(4);
						model.setRowCount(0);
						model.addRow(new Object[] { id, name, place, num });
						tb.setModel(model);
					}
					if (flag == true) {
						JOptionPane.showMessageDialog(null, "�ñ��鲻����!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			*/
				new borrowbook();
            	setVisible(false);
			}
		});
		
		JButton bt2 = new JButton("����");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainFrame();
				jf.setVisible(false);
			}
		});
		
		jp2.add(bt);
		jp2.add(bt2);
		jf.add(jp2);

		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new findFrame();
	}

}
