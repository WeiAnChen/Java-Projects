package library;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OverdueNoticeTest {
	public Patron myPatron;
	public Library myLib;
	public int todaysDate;
	public Calendar myCalInOD;
	
	
	@Before
	public void setUp() throws Exception {
		myPatron = new Patron("Wei-An",myLib);
		todaysDate = 1;
		myCalInOD =  new Calendar();
		
	}

	@Test
	public void testOverdueNotice() {
		assertEquals("Wei-An",this.myPatron.name);
		assertEquals(1,this.todaysDate);
	}

	@Test
	public void testToString() {
		// check todaysdate
		myCalInOD.advance();
		myCalInOD.advance();
		myCalInOD.advance();
		myCalInOD.advance(); // today is 4 now
		
		assertEquals(4,myCalInOD.getDate());
		
		// create book1
		Book book1 = new Book("A Bend in the River","V.S. Naipaul");
		book1.checkOut(2); // set book1's due day to 2. (which means due larger than one day)
		
		// create book2
		Book book2 = new Book("A Clockwork Orange","Anthony Burgess");
		book2.checkOut(10);  // set book2's due day to 10
		
		// create book3
		Book book3 = new Book("Harry Potter","J.K. Rowling");
		book3.checkOut(3); // set book3's due day to 3 (which means due yesterday)
		

		// check overdue notice are correctly printed
		// first situation -- the due date is 2 (which means this book has due larger than one day)
		myPatron.take(book1);
		OverdueNotice myOverdueNotice = new OverdueNotice(myPatron,myCalInOD.getDate());
		assertEquals("1. title: A Bend in the River, Author: V.S. Naipaul, Due date: 2. \nThis book due larger than one day.\n",myOverdueNotice.toString());
		
		// Second situation -- the due date is 10 (which means this book hasn't due yet)
		myPatron.take(book2);
		myPatron.giveBack(book1);
		assertEquals("1. title: A Clockwork Orange, Author: Anthony Burgess, Due date: 10. \n",myOverdueNotice.toString());
		
		// Third situation -- the due date is 3 (which means this book due yesterday.)
		myPatron.take(book3);
		myPatron.giveBack(book2);
		assertEquals("1. title: Harry Potter, Author: J.K. Rowling, Due date: 3. \nThis book is overdue. Please remember to turn back.\n",myOverdueNotice.toString());
		
	}

	
}
