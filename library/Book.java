package library;

public class Book {
	/*
	 * instance variables
	 */
	public String title;
	public String author; // only one author per book
	public int dueDate; // -1 if the book is not checked out
	
	// constructor
	public Book(String title, String author){
		// When created, this book is not checked out --> means dueDate = -1
		this.title = title;
		this.author = author;
		this.dueDate = -1;
		
	}
	
	// method starts
	
	public String getTitle(){
		return this.title;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public int getDueDate(){
		return this.dueDate;
	}
	
	public void checkOut(int date){
		/**
		 * Sets the due date of this Book 
		 * to the specified date 
		 */
		
		dueDate = date;
	}
	
	public void checkIn(){
		/**
		 * Sets the due date of this Book to -1
		 */
		
		dueDate = -1;
		
	}
	
	public String toString(){
		String form = title+", "+author;
		
		return form;
	}
	
	
	public static void main(String[] args){
		
	}
	
	
	
}
