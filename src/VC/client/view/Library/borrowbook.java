package VC.client.view.Library;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.Container;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import VC.client.bz.Impl.CourseSrvImpl;
import VC.client.bz.Impl.LibrarySrvImpl;
import VC.client.view.Library.borrowbook;
import VC.client.view.Library.mainFrame;
import VC.client.view.Library.mybook;
import VC.common.Book;


public class borrowbook extends JFrame implements ActionListener {
	
	//DefaultTableModel defaultModel = null;
	JTable table = null;
	JPanel panel = new JPanel();
	Vector v1 = new Vector();
	JFrame f = new JFrame();
	public LibrarySrvImpl booksrv = new LibrarySrvImpl("mike");

	//String[] bookName = { "History", "Science", "Future", "Policy", "Furture" };
	Vector<String> bookName = new Vector<String>();
	public borrowbook() {
	
		List<Book> booklist = new ArrayList<Book>();
		try {
			booklist = booksrv.getAllBook();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < booklist.size(); i++) {
			bookName.add(booklist.get(i).getBookName());
		}
		//JFrame f = new JFrame();
		MyTable18 mt = new MyTable18();
		final JTable table = new JTable(mt);
		JCheckBox jc1 = new JCheckBox();
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jc1));
		table.setPreferredScrollableViewportSize(new Dimension(400, 150));
		/*
		Object[][] p = {
                { "History", "987", "Mike",false },
                { "Science", "124", "Dan", false }, 
                {"Future","246","Peter",false},
                {"Policy","768","Markus",false},
                {"Furture","111","Song",false},};
		
		String[] n = { "涔﹀悕", "鍑虹増鍟�, "浣滆�", "鏄惁鍔犲叆涔﹀崟" };
		*/

		//defaultModel = new DefaultTableModel(p, n);
        JScrollPane s = new JScrollPane(table);
        f.getContentPane().add(s, BorderLayout.CENTER);
		// 锟斤拷锟斤拷一锟斤拷默锟较的憋拷锟侥ｏ拷锟�

		//defaultModel = new DefaultTableModel(p, n);
		//table = new JTable(defaultModel);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 80));
        
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				int column = table.getSelectedColumn();
				Object obj = table.getValueAt(row, column);
				Object obj1 = true;
				if (table.isCellSelected(row, column)) {
					System.out.println(obj);
					if (obj.equals(obj1)) {
						//System.out.println(row);
						v1.add(row);
					}
				}
			}
		});

		// JPanel panel = new JPanel();
		JButton b = new JButton("加入书单");
		panel.add(b);
		b.addActionListener(this);
		b = new JButton("我的书单");
		panel.add(b);
		b.addActionListener(this);
		b = new JButton("返回");
		panel.add(b);
		b.addActionListener(this);

		Container contentPane = f.getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(s, BorderLayout.CENTER);
		f.getContentPane().add(s, BorderLayout.CENTER);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLocation(200, 200);
		f.setResizable(false);
        f.setTitle("虚拟校园图书馆系统借书界面");
        f.pack();
        f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("加入书单")) {
			for (int i = 0; i < v1.size(); i++) {
				int a = v1.indexOf(i);
				System.out.println(bookName.get(a));
				// 锟皆猴拷锟斤拷锟斤拷锟斤拷菘锟�
			
			}
			for (int i = 0; i < v1.size(); i++) {
				int a = (int) v1.get(i);
				//System.out.println(courseName.get(a));
				// to do: the add course part
				// v1.size()
				try {
					booksrv = new LibrarySrvImpl("mike");
					booksrv.addBook(bookName.get(a), "mike");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}
		if (e.getActionCommand().equals("返回")) {
			new mainFrame();
			f.setVisible(false);
			//setVisible(false);
		}
		if (e.getActionCommand().equals("我的书单")) {
			new mybook();
			f.setVisible(false);
		}
		//table.revalidate();
	}

	public static void main(String[] args) {
		new borrowbook();
	}

}

class MyTable18 extends AbstractTableModel {
	public LibrarySrvImpl booksrv = new LibrarySrvImpl("mike");
	public Object[][] p = null;
	/*
	Object[][] p = {
            { "History", "987", "Mike",false },
            { "Science", "124", "Dan", false }, 
            {"Future","246","Peter",false},
            {"Policy","768","Markus",false},
            {"Furture","111","Song",false},};
*/
	public String[] n = { "书名", "出版商 ","作者", "是否加入" };

	public MyTable18() {
		super();
		List<Book> booklist = new ArrayList<Book>();
		try {
			booklist = booksrv.getAllBook();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		p = new Object[booklist.size()][4];
		for (int i = 0; i < booklist.size(); i++) {
			p[i][0] = booklist.get(i).getBookName();
			p[i][1] = booklist.get(i).getBookPublisher();
			p[i][2] = booklist.get(i).getBookAuthor();
			p[i][3] = false;
		}
	}
	@Override
	public int getRowCount() {
		return p.length;
	}

	@Override
	public int getColumnCount() {
		return n.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return p[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return n[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		//p[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}
