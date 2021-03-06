package VC.client.bz.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VC.common.BookMessage;
import VC.common.MessageType;
import VC.common.Book;

public class LibrarySrvImpl extends ClientSrvImpl {

	public LibrarySrvImpl() {
		super();
	}
	public LibrarySrvImpl(String name) {
		super();
		this.setUser(name);
	}

	public List<Book> searchName(String bookname) throws IOException, ClassNotFoundException {

		List<Book> retBooklist = new ArrayList<Book>();
		String type = MessageType.CMD_QUY_BOOK_BOOKNAME;
		BookMessage sendmsg = new BookMessage();
		sendmsg.setBookname(bookname);
		sendmsg.setType(type);

		this.SendMessage(sendmsg);

		BookMessage rcvmsg = new BookMessage();
		rcvmsg = (BookMessage) this.ReceiveMessage();
		retBooklist = rcvmsg.getBooklist();

		return retBooklist;
	}

	public List<Book> getAllBook() throws IOException, ClassNotFoundException {

		List<Book> Booklist = new ArrayList<Book>();
		String type = MessageType.CMD_GET_ALL_BOOK;
		BookMessage sendmsg = new BookMessage();
		sendmsg.setType(type);

		this.SendMessage(sendmsg);

		BookMessage rcvmsg = new BookMessage();
		rcvmsg = (BookMessage) this.ReceiveMessage();
		Booklist = rcvmsg.getBooklist();

		return Booklist;
	}

	public boolean addBook(String bookname, String username) throws ClassNotFoundException, IOException {

		boolean res = false;
		String type = MessageType.CMD_ADD_ALL_BOOK;
		BookMessage sendmsg = new BookMessage();
		sendmsg.setType(type);
		sendmsg.setID(username);
		sendmsg.setBookname(bookname);

		this.SendMessage(sendmsg);

		BookMessage rcvmsg = new BookMessage();
		rcvmsg = (BookMessage) this.ReceiveMessage();
		res = rcvmsg.isRes();
		return res;
	}

	public boolean returnBook(String bookname, String username) throws ClassNotFoundException, IOException {
		boolean res = false;
		String type = MessageType.CMD_DELETE_ALL_BOOK;
		BookMessage sendmsg = new BookMessage();
		sendmsg.setType(type);
		sendmsg.setID(username);
		sendmsg.setBookname(bookname);

		this.SendMessage(sendmsg);

		BookMessage rcvmsg = new BookMessage();
		rcvmsg = (BookMessage) this.ReceiveMessage();
		res = rcvmsg.isRes();
		return res;

	}

	public List<Book> getallMyBook() throws IOException, ClassNotFoundException {
		List<Book> myBooklist = new ArrayList<Book>();
		String type = MessageType.CMD_GET_ALL_MYBOOK;
		BookMessage sendmsg = new BookMessage();
		sendmsg.setType(type);
		sendmsg.setID(this.getUser());

		this.SendMessage(sendmsg);

		BookMessage rcvmsg = new BookMessage();
		rcvmsg = (BookMessage) this.ReceiveMessage();
		myBooklist = rcvmsg.getBooklist();

		return myBooklist;
	}
}
