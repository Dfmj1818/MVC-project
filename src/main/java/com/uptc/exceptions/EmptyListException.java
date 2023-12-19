package com.uptc.exceptions;

public class EmptyListException extends RuntimeException{

	public EmptyListException() {
		super("No tienes libros en la lista");
	}
}
