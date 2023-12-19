package com.uptc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uptc.exceptions.BookNotFoundException;
import com.uptc.exceptions.EmptyListException;
import com.uptc.exceptions.UserNotFoundException;
import com.uptc.model.BookModel;
import com.uptc.model.UserModel;

public class UserService {
	private UserService userService;
	private UserModel userModel;
	private BookModel Book;
	private List<UserModel>usersList;
    private LibraryService libraryService;
    @Autowired
	public UserService() {
	
	}

	public String addBookToUserList(UserModel user,BookModel book) throws ClassCastException{
		String message="";
		if(book!=null){
			user.getUserBooksList().add(book);
			message="Libro agregado exitosamnete";
			return message;
		}
		else {
			throw new NullPointerException();
		}
	}

	public String addUserToList(UserModel user) {
		String message="";
		if(user!=null){
			usersList.add(user);
			message="Libro añadido Correctamente";
		}
		else {
			message="Error al añadir el libro";
		}
		return message;
	}
	public String eraseBookOfList(UserModel user,int digitedId) throws NullPointerException,UnsupportedOperationException{
		String message="";
		boolean removedBook=user.getUserBooksList().removeIf(bookModel->bookModel.getId()==digitedId);
		if(removedBook){
			message="Libro eliminado correctamente";
			return message;
		}
		else {
			throw new BookNotFoundException();
		}
	}

	public List<BookModel>getUserBooksList(UserModel user){
		List<BookModel>userBooksList=user.getUserBooksList();
		if(!userBooksList.isEmpty()){
			return userBooksList;
		}
		else {
			throw new EmptyListException();
		}
	}


	public UserModel createUser(String name,String lastName) {
		UserModel createdUser=new UserModel();
		createdUser.setName(name);
		createdUser.setLastName(lastName);
		return createdUser;
	}

	public UserModel findUserById(String name,String lastName){
		return usersList.stream()
		         .filter(user->user.getName().equals(name)&&user.getLastName().equals(lastName))
		         .findFirst()
		         .orElseThrow(UserNotFoundException::new);
	}



}
