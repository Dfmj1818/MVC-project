package com.uptc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.uptc.exceptions.BookNotFoundException;
import com.uptc.model.BookModel;

public class LibraryService {
	private List<BookModel>booksList;
	private int id;

	public LibraryService() {
		booksList=new ArrayList<BookModel>();
		id=0;
	}
	
	
	public List<BookModel>getBookList()throws NullPointerException{
		return booksList;
	}

	public String addBookToList(BookModel book)throws UnsupportedOperationException,ClassCastException {
		boolean addedBook=booksList.add(book);
		String message="";
		if(addedBook){
			message="Libro añadido correctamente";
		}
		else {
			message="Proceso de añadido,incorrecto";
		}
		return message;
	}

	public String eraseBookOfList(int digitedId)throws NullPointerException{
		boolean bookRemoved=booksList.removeIf(bookModel->bookModel.getId()==digitedId);
		String message="";
		if(bookRemoved){
			message="Libro eliminado Correctamente :-)";
			return message;
		}
		else {
			throw new BookNotFoundException();
		}
	}

	public void createBooks() {
		BookModel book=new BookModel();
		addBookToList(book);
		BookModel book2=new BookModel();
		addBookToList(book2);
		BookModel book3=new BookModel();
		addBookToList(book3);
	}


	public void assignIdToBooks() {
		booksList.stream().forEach(bookModel->{
			id++;
			bookModel.setId(id);
		});
	}

	public BookModel findBookById(int digitedId) {
		return booksList.stream()
				.filter(book->book.getId()==digitedId)
				.findFirst()
				.orElseThrow(BookNotFoundException::new);
	}
}
