package VC.client.view.Shop;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class shopFrame extends JFrame{
	JButton button1 = new JButton("商店");
	JButton button2 = new JButton("我的购物车");
	
	class LoginOKAction1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "将进入另一个窗体！");
			try {
				new ShopPage();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}
	}
	
	class LoginOKAction2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "将进入另一个窗体！");
			try {
				new MyGoods();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}
	}
	
	public shopFrame(){
		super();
		this.setResizable(false);
		this.setSize(new Dimension(450, 205));
		this.setTitle("虚拟校园商店");
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.getContentPane().add(button1, null);
		this.getContentPane().add(button2, null);
		button1.setBounds(new Rectangle(70, 50, 78, 27));
		button1.addActionListener(new LoginOKAction1());//给按钮加事件监听器
		
		button2.setBounds(new Rectangle(200, 50, 140, 27));
		button2.addActionListener(new LoginOKAction2());//给按钮加事件监听器
	}
	public static void main(String[] args) {
		new shopFrame();
	}


}
