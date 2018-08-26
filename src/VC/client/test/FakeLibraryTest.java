package VC.client.test;

import java.io.IOException;
import java.util.*;

import VC.client.bz.Impl.LibrarySrvImpl;
import VC.common.Book;

public class FakeLibraryTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		LibrarySrvImpl librarysrvimpl = new LibrarySrvImpl();
		List<Book> booklist = new ArrayList<Book>();
		booklist = librarysrvimpl.searchName("Future");
		//for(int i = 0; i < booklist.size();i++) {
		//	System.out.println(booklist.get(i).toString());
		//}
		System.out.println(booklist.get(0).toString());
		System.out.println(booklist.get(1).toString());

	}
}
