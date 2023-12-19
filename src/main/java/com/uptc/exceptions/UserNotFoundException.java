package com.uptc.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super("Usuario no encontrado");
	}
}
