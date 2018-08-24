package VC.common;

import java.util.List;

public class BookMessage implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7021817663078650928L;
	private String bookname;
	private String bookauthor;
	private Book book;
	private String type;
	
	private List<Book> bookdata;
	
	public BookMessage(){
		
	}
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Book> getBookdata() {
		return bookdata;
	}

	public void setBookdata(List<Book> bookdata) {
		this.bookdata = bookdata;
	}
	
	
}
