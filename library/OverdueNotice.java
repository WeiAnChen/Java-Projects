package library;

import java.util.ArrayList;

public class OverdueNotice {
	public Patron patron;
	public int todaysDate;
	public ArrayList<Book> AllList;  // 
	
	public OverdueNotice(Patron patron, int todaysDate){
		this.patron = patron;
		this.todaysDate = todaysDate;
		this.AllList = patron.PatronList;
		
	}
	
	
	/**
	 * Returns as a String, in a nice, humanly readable format, an overdue notice.
	 * The notice should list all the books currently checked out by the patron,
	 * along with their due dates, and call attention to which ones are overdue
	 */
	public String toString(){
		String s = "";
		
		for (int i=0;i<AllList.size();i++){
			String si = Integer.toString(i+1);
			int DueDate = AllList.get(i).getDueDate();
			String StrDD = Integer.toString(DueDate);
			String BookName = AllList.get(i).title;
			String AuthorName = AllList.get(i).author;
			
			if (DueDate+1==todaysDate){
				s += si+". title: "+BookName+", "+"Author: "+ AuthorName +", "+"Due date: "+StrDD+". \n";
				s += "This book is overdue. Please remember to turn back.";
				s+="\n";
			}
			else if (DueDate+1<todaysDate){
				s += si+". title: "+BookName+", "+"Author: "+ AuthorName +", "+"Due date: "+StrDD+". \n";
				s += "This book due larger than one day.";
				s+="\n";
			}
			else{
				s += si+". title: "+BookName+", "+"Author: "+ AuthorName +", "+"Due date: "+StrDD+". \n";
				
			}
		}
		
		return s;
		
	}
	
	public static void main(String[] args){
		Library L2 = new Library();
		Patron p2 = new Patron("Wei-An",L2);
		
		Calendar myCalInOD = new Calendar();
		myCalInOD.advance();
		myCalInOD.advance();
		myCalInOD.advance();
		myCalInOD.advance(); // today is 4
		System.out.println("Today is:"+myCalInOD.getDate());
		
		
		Book book1 = new Book("A Bend in the River","V.S. Naipaul");
		book1.checkOut(2); // set book1's due day to 2. (which means due larger than one day)
		
		Book book2 = new Book("A Clockwork Orange","Anthony Burgess");
		book2.checkOut(10);  // set book2's due day to 10
		
		Book book3 = new Book("Harry Potter","J.K. Rowling");
		book3.checkOut(3); // set book3's due day to 3 (which means due yesterday)
		
		p2.take(book1);
		p2.take(book2);
		p2.take(book3);
		
		
		OverdueNotice O1 = new OverdueNotice(p2,myCalInOD.getDate());
		
		System.out.println(O1.toString());
		
	}
	
	
}
