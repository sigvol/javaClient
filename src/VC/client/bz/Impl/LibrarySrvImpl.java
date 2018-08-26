package VC.client.bz.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VC.common.BookMessage;
import VC.common.MessageType;
import VC.common.Book;

public class LibrarySrvImpl extends ClientSrvImpl{

	public LibrarySrvImpl() {
		super();
	}
	
	public List<Book> searchName(String bookname) throws IOException, ClassNotFoundException {
		
		List<Book> retBooklist = new ArrayList<Book>();
		String type = MessageType.CMD_QUY_BOOK_BOOKNAME;
		BookMessage sendmsg = new BookMessage();
		sendmsg.setSender("wls");
		sendmsg.setBookname(bookname);
		sendmsg.setType(type);
		
		this.SendMessage(sendmsg);
		
		BookMessage rcvmsg = new BookMessage();
		rcvmsg = (BookMessage) this.ReceiveMessage();
		retBooklist = rcvmsg.getBookdata();
		
		return retBooklist;
	}
}
