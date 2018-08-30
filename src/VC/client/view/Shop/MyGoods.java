package VC.client.view.Shop;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import VC.client.bz.Impl.ShopSrvImpl;
import VC.common.Goods;

public class MyGoods extends JFrame{
	
	public ShopSrvImpl shopsrv = new ShopSrvImpl();
	
	public MyGoods() throws ClassNotFoundException, IOException {
		//数据库的表格数据的显示
		
		/*
		String[] GoodsName = {"商品名称","apple","orange","banana"};
		String[] GoodsID = {"商品编号","001","002","003",};
		String[] GoodsPrice = {"商品价格","2.5","3.0","2.0"};
		String[] NUM= {"商品数量","10","3","6"};
		*/
		List<String> GoodsName = new ArrayList<String>();
		List<String> GoodsID = new ArrayList<String>();
		List<String> GoodsPrice = new ArrayList<String>();
		List<String> NUM = new ArrayList<String>();
		List<Goods> goodslist = shopsrv.getAllGoods();
		for(int i=0;i<goodslist.size();i++) {
			GoodsName.add(i, goodslist.get(i).getProductName());
			GoodsID.add(i, goodslist.get(i).getGoodsID());
			GoodsPrice.add(i, goodslist.get(i).getValue());
			NUM.add(i, goodslist.get(i).getGoodsNum());
		}
		
				
		JButton jb = new JButton("返回");
		JButton jb1 = new JButton("购买");
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(1,4,20,100));
		
		JPanel p1 = new JPanel(new GridLayout(GoodsName.size()+1,1));
		JPanel p2 = new JPanel(new GridLayout(GoodsName.size()+1,1));
		JPanel p3 = new JPanel(new GridLayout(GoodsName.size()+1,1));
		JPanel p4 = new JPanel(new GridLayout(GoodsName.size()+1,1));
		
		for(int i=0;i<GoodsID.size()+1;i++) {
			if(i!=GoodsID.size()) {
				p1.add(new JLabel(GoodsID.get(i)));
			}
			else {
				p1.add(jb1);
			}
		}
		for(int i=0;i<GoodsName.size();i++) {
			p2.add(new JLabel(GoodsName.get(i)));
		}
		for(int i=0;i<GoodsPrice.size();i++) {
			p3.add(new JLabel(GoodsPrice.get(i)));
		
		}
		for(int i=0;i<NUM.size()+1;i++) {
			if(i!=NUM.size()) {
				p4.add(new JLabel(NUM.get(i)));
			}
			else {
				p4.add(jb);
			}
		}
		
		jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new ShopPage();
            	setVisible(false);
            }
        });
		
		jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "购买成功");
            	
            }
        });
		
		container.add(p1);
		container.add(p2);
		container.add(p3);
		container.add(p4);
		
		this.setVisible(true);
		this.setSize(500, 350);
		this.setTitle("虚拟校园商店购物车");
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args) {
		try {
			new MyGoods();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
