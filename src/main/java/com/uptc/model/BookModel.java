package com.uptc.model;

public class BookModel {
	private String author;
	private String bookType;
	private String bookName;
	private int id;


	public BookModel() {

	}

	public void setBookName(String bookName) {
		this.bookName=bookName;
	}

	public String getBookName() {
		return bookName;
	}
	public void setAuthor(String author){
		this.author=author;
	}

	public String getAuthor() {
		return author;
	}

	public void setBookType(String bookType) {
		this.bookType=bookType;
	}

	public String getBookType() {
		return bookType;
	}

	public void setId(int bookType) {
		this.id=bookType;
	}

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		StringBuilder bookInformation=new StringBuilder();
		bookInformation.append("ID:").append(getId()).append(" ").append("\n")
		.append("Nombre del Libro").append(getBookName()).append(" ").append("\n")
		.append("TIpo de libro").append(getBookType()).append("\n");
		return bookInformation.toString();
	}


}
