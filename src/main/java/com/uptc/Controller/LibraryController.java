package com.uptc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uptc.exceptions.BookNotFoundException;
import com.uptc.model.BookModel;
import com.uptc.services.LibraryService;

public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;

//	public LibraryController() {
//		libraryService=new LibraryService();
//	}

	public String addBookToList(BookModel book) {
		String message="";
		try {
			 message=this.libraryService.addBookToList(book);
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(IncompatibleClassChangeError e){
			e.printStackTrace();
		}
		return message;
	}

	public String eraseBookToList() {
		String message="";
		try {
			 message=this.libraryService.eraseBookOfList(0);
		}catch(UnsupportedOperationException e){
			e.printStackTrace();
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		return message;
	}

	public BookModel findBookById(int id) {
		BookModel foundBook = null;
		try {
			foundBook=this.libraryService.findBookById(id);
		}catch(BookNotFoundException e){
			e.getMessage();
		}
       return foundBook;
	}
	
	public List<BookModel>getBookList(){
		List<BookModel>booksList=null;
		try {
			booksList=this.libraryService.getBookList();
		}catch(NullPointerException e){
			e.getMessage();
		}
		return booksList;
	}

 
}
