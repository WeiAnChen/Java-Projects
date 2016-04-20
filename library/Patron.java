/**
 * class Patron
 */

package library;

import java.util.ArrayList;


public class Patron {
	/*
	 * instance variables
	 */
	public String name;
	public Library libInfo;
	public ArrayList<Book> PatronList;

	//public HashMap<Integer,Book> PatronHash;

	//constructor
	public Patron(String name, Library library){
		this.name = name;
		this.libInfo = library;
		this.PatronList = new ArrayList<Book>();
	}

	// method 
	public String getName(){
		return name;
	}

	/**
	 * This method Add this book 
	 * to the list of books (PatronList)
	 * checked out by this Patron
	 * @param book
	 */
	public void take(Book book){
		// add to List
		if (PatronList.size()<3){
			PatronList.add(book);
		}
		else{
			System.out.println("You can't borrow more than 3 books.");
		}
	}

	/**
	 * This method remove this Book object
	 * from the list of books checked out 
	 * by this Patron
	 * @param book
	 */
	public void giveBack(Book book){
		// remove this "Book" from list
		PatronList.remove(book);

	}

	/**
	 * This method returns the list of Book object
	 * checked out to this Patron(may be an empty list)
	 * @return PatronList
	 */
	public ArrayList<Book> getBooks(){
		return PatronList;

	}


	/**
	 * This method returns this patron's name
	 * @return name
	 */
	public String toString(){
		return name;
	}

	public String getPatronList(){
		String StrPatronLst = "";
		for (int r=0;r<PatronList.size();r++){
			int indexOfLst = r+1;
			String StrIndexOfLst = Integer.toString(indexOfLst);
			String PatLstAuth = PatronList.get(r).author;
			String PatLstTitle = PatronList.get(r).title;
			StrPatronLst+=StrIndexOfLst+". "+ PatLstTitle+", "+PatLstAuth;
			StrPatronLst+="\n";
		}
		return StrPatronLst;
	}





}
