package com.uptc.view;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.uptc.Controller.LibraryController;
import com.uptc.Controller.UserController;
import com.uptc.model.BookModel;
import com.uptc.model.UserModel;

public class View {
	private Scanner scanner;
	private UserController userController;
	private LibraryController libraryController;
	
	@Autowired 
	public View() {

	}

	public void showMessage(String message){
		System.out.println(message);
	}
	
	public void showList(List<?>list){
		list.forEach(System.out::println);
	}

	public int readInt() {
		int input=0;
		boolean correctFormat=false;
		String inputAsString;

		while(correctFormat){
			this.showMessage("(Recuerda ingresar un numero entero)");
			inputAsString=scanner.nextLine().trim();
			if(!inputAsString.isEmpty()&&inputAsString.matches(("^[0-9]+$"))){
				try {
					input=Integer.parseInt(inputAsString);
					correctFormat=true;
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
			}
			else {
				this.showMessage("La entrada no puede estar vacia");
			}

		}
		return input;
	}

	public String readString() {
		boolean correctFormat=false;
		String input="";
		while(!correctFormat){
			this.showMessage("(Recuerda ingresar una cadena de caracteres)");
			input=scanner.nextLine().trim();
			if(!input.isEmpty()){
				correctFormat=true;
				return input;
			}
			else {
				this.showMessage("La entrada no puede estar vacia");
			}

		}
		return input;
	}

	public void showMenu() {
		this.showMessage("Bienvenido a nuestra Biblioteca\nDigite a continuacion la opcion que desees ");
		this.showMessage("1.Crear Cuenta\n2.Iniciar Sesion\n3.Salir");
		int digitedOption=this.readInt();
		this.run(digitedOption);
	}
	

	public UserModel createUser() {
		String name;
		String lastName;

		this.showMessage("Ingrese su Nombre");
		name=this.readString();
		this.showMessage("Ingrese su apellido");
		lastName=this.readString();
		return this.userController.createUser(name, lastName);
	}
	
	public UserModel loginUser() {
		String name;
		String lastName;
		
		this.showMessage("Ingrese su nombre");
		name=this.readString();
		this.showMessage("Ingrese su apellido");
		lastName=this.readString();
		
		return this.userController.findUser(name, lastName);
	}


	public void run(int digitedOption) {
		boolean exit=false;

		while(!exit){
			switch(digitedOption){
			case 1:
                UserModel registeredUser= this.loginUser();
                int selectedService=this.showServices(registeredUser);
                this.runServices(selectedService,registeredUser);
                
				break;
			case 2:
                UserModel createdUser=this.loginUser();
                String message=this.userController.addUserToList(createdUser);
                this.showMessage(message);
				break;
			case 3:

				break;
			}
		}

	}
	
	public int showServices(UserModel user) {
		int selectedService;
		this.showMessage("Bienvenido "+user.getName()+"\n"+"¿Que deseas Hacer hoy?"+"\n"+"1.Ver libros disponibles"+"\n"+"2.Devolver libro\n3.Ver mis libros prestados\n4.Volver al menu principal");
		selectedService=this.readInt();
		return selectedService;
	}
	
	public void OrderBook() {
		String digitedAnswer;
		int digitedId;
		this.showMessage("¿Deseas pedir algun libro prestado?");
		digitedAnswer=this.readString();
		if(digitedAnswer.toLowerCase().equals("si")){
			this.showMessage("Ingresa el id del libro que quieres pedir prestado");
			digitedId=this.readInt();
			this.libraryController.findBookById(digitedId);
		}
		else {
			this.showMessage("Volviendo al menu principal..");
			this.showMenu();
		}
		
	}
	
	public void showUserBooksList(UserModel user){
		List<BookModel>userBooksList=this.userController.getUserBooksList(user);
		this.showList(userBooksList);
	}
	
	
	
	
	public void runServices(int digitedOption,UserModel user) {
		boolean exit=false;
		
		while(!exit){
			switch(digitedOption){
			case 1:
				List<BookModel>bookList=this.libraryController.getBookList();
				this.showList(bookList);			
				break;
			case 2:
				this.OrderBook();
			    break;
			case 3:
				this.showUserBooksList(user);
				break;
				
			default:
				this.showMessage("La opcion digitada no exitse,Vuelva a intentarlo");
				break;
				
			}
		}
		
	}


}
