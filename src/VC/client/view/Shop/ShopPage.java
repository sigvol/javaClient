package VC.client.view.Shop;


import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Container;
import java.net.URL;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ShopPage extends JFrame{
	String[] GoodsName = {"商品名称","apple","orange","banana"};
	String[] GoodsID = {"商品编号","001","002","003",};
	String[] GoodsPrice = {"商品价格","2.5","3.0","2.0"};
	String[] NUM;
	
	JPanel p1 = new JPanel(new GridLayout(GoodsName.length+1,1));
	JPanel p2 = new JPanel(new GridLayout(GoodsName.length+1,1));
	JPanel p3 = new JPanel(new GridLayout(GoodsName.length+1,1));
	JPanel p4 = new JPanel(new GridLayout(GoodsName.length+1,1));
	
	JButton jb1 = new JButton("加入购物车");
	JButton jb2 = new JButton("我的购物车");
	
	ArrayList<JTextField> jtfs = new ArrayList<>();
	
	public ShopPage() {
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(1,4,20,100));
		
		for(int i=0;i<GoodsID.length+1;i++) {
			if(i!=GoodsID.length) {
				p1.add(new JLabel(GoodsID[i]));
			}
			else {
				p1.add(jb1);
			}
			
		}
		for(int i=0;i<GoodsName.length;i++) {
			p2.add(new JLabel(GoodsName[i]));
		}
		for(int i=0;i<GoodsPrice.length+1;i++) {
			if(i!=GoodsPrice.length) {
				p3.add(new JLabel(GoodsPrice[i]));
			}
			else {
				p3.add(jb2);
			}
		}
		
		//ArrayList<JTextField> jtfs = new ArrayList<>();
		
		for(int i=0;i<GoodsID.length;i++) {
			if(i==0) {
				p4.add(new JLabel("商品数量"));
			}
			else {
				JTextField jtf= new JTextField("");
				jtfs.add(jtf);
				p4.add(jtf);
			}
		}
		
		int a=jtfs.size();
		String[] NUM = new String[a];
		for(int i=0;i<a;i++) {
			NUM[i]=jtfs.get(i).getText();
		}
		
		
		jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "添加成功");
            	
            }
        });
		
		jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//for (int i = 0; i < jtfs.size(); i++) {
                    //String temp = jtfs.get(i).getText();
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
            	//}
            }
         });
		
		
		container.add(p1);
		container.add(p2);
		container.add(p3);
		container.add(p4);
		
		this.setVisible(true);
		this.setSize(500, 350);
		this.setTitle("虚拟校园商店");
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new ShopPage();
	}

}
