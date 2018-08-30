package VC.client.bz.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VC.common.Goods;
import VC.common.GoodsMessage;
import VC.common.MessageType;

public class ShopSrvImpl extends ClientSrvImpl{

	public ShopSrvImpl() {
		super();
	}
	
	public List<Goods> getAllGoods() throws ClassNotFoundException, IOException{
		
		List<Goods> retGoodslist = new ArrayList<Goods>();
		String type = MessageType.CMD_GET_ALL_GOODS;
		GoodsMessage sendmsg = new GoodsMessage();
		sendmsg.setSender("wls");
		sendmsg.setType(type);
		
		this.SendMessage(sendmsg);
		
		GoodsMessage rcvmsg = new GoodsMessage();
		rcvmsg = (GoodsMessage) this.ReceiveMessage();
		retGoodslist = rcvmsg.getGoodslist();
		
		return retGoodslist;
	}
}
