package com.uptc.Controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import com.uptc.exceptions.BookNotFoundException;
import com.uptc.exceptions.UserNotFoundException;
import com.uptc.model.BookModel;
import com.uptc.model.UserModel;
import com.uptc.services.UserService;

public class UserController {
	private BookModel bookModel;
	private UserService userService;

	public UserController() {
		bookModel=new BookModel();
		userService=new UserService();
	}

	public String addBookToUserList(UserModel user,BookModel book) {
		String message = "";
		try {
			message=this.userService.addBookToUserList(user,book);
		}catch(UnsupportedOperationException e){
			e.printStackTrace();
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		return message;
	}

	public void eraseBook(UserModel user,int id) {
		try {
			this.userService.eraseBookOfList(user, id);
		}catch(BookNotFoundException e){
			e.getMessage();
		}
	}


	public UserModel createUser(String name,String lastName) {
		return this.userService.createUser(name, lastName);	
	}

	public UserModel findUser(String name,String lastName) {
		UserModel userFound=null;
		try {
			userFound=this.findUser(name,lastName);
		}catch(UserNotFoundException e){
			e.getMessage();
		}
		return userFound;
	}

	
	public String addUserToList(UserModel user) {
		return this.addUserToList(user);
	}
 
	public List<BookModel>getUserBooksList(UserModel user){
		List<BookModel>userBookList=null;
	     try {
	    	 userBookList=user.getUserBooksList();
	     }catch(NullPointerException e) {
	    	 e.printStackTrace();
	     }
	     return userBookList;
	}

}
