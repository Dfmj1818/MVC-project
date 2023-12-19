package com.uptc.exceptions;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException() {
		super("Libro no encontado ");
	}
	
}
