package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uptc.Controller.UserController;
import com.uptc.view.View;

@SpringBootApplication
public class MvcProjectApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(MvcProjectApplication.class, args);
	    View view= new View();
	    view.showMenu();
	}

}
