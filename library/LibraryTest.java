package library;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
	public Library emptyLib;
	public Library myLib;
	public Patron myPatron;
	public ArrayList<Book> Returnn;
	public OverdueNotice O1;
	public Patron myPatron3;
	public OverdueNotice O2;
	public Calendar myCalendar2;
	public String PName;

	public Book b1;
	public Book b2;
	public Book b3;
	public Book b4;

	public Library Lib1;
	public Patron myPatron2;
	public OverdueNotice O3;
	public Patron myPatron4;
	public OverdueNotice O4;
	public Book b5;
	public Book b6;
	public Book b7;
	public Book b8;

	public Library LibServe;
	public Book b9;
	public Book b10;
	public Book b11;
	public Book b12;



	@Before
	public void setUp() throws Exception {


		b1 = new Book("HP","JKR");
		b2 = new Book("Bible","God");
		b3 = new Book("Snow White","Green");
		b4 = new Book("General Physics","Halliday");
		ArrayList<Book> collection = new ArrayList<Book>();
		myCalendar2 = new Calendar();
		PName = null;
		Returnn = new ArrayList<Book>();
		collection.add(b1);
		collection.add(b2);
		collection.add(b3);
		collection.add(b4);
		myLib = new Library(collection);
		emptyLib = new Library(collection);
		myPatron = new Patron("abc",myLib);
		myPatron3 = new Patron("def",myLib);
		O1 = new OverdueNotice(myPatron,8);
		O2 = new OverdueNotice(myPatron3,8);

		b5 = new Book("title1","author1");
		b6 = new Book("title2","author2");
		b7 = new Book("t2itle3","author3");
		b8 = new Book("title4","author4");
		ArrayList<Book> collection2 = new ArrayList<Book>();
		collection2.add(b5);
		collection2.add(b6);
		collection2.add(b7);
		collection2.add(b8);
		Lib1 = new Library(collection2);
		myPatron2 = new Patron("ttt",Lib1);
		O3 = new OverdueNotice(myPatron2,8);
		myPatron4 = new Patron("yyy",Lib1);
		O4 = new OverdueNotice(myPatron4,8);

		b9 = new Book("title5","author5");
		b10 = new Book("title6","author6");
		b11 = new Book("title7","author7");
		b12 = new Book("title9","author8");
		ArrayList<Book> collection3 = new ArrayList<Book>();
		LibServe = new Library(collection3);


	}

	@Test
	public void testLibrary() {
		Library conLib = new Library();
		assertEquals(0,conLib.myCalendar.getDate());
		assertEquals(false,conLib.isOpen);
		assertEquals(true,conLib.jump);
		assertEquals(null,Library.PName);
		assertEquals(null,Library.searchPeople);


	}

	@Test
	public void testLibraryArrayListOfBook() {
		Library conLib = new Library();
		assertEquals(0,conLib.myCalendar.getDate());
		assertEquals(false,conLib.isOpen);
		assertEquals(true,conLib.jump);
		assertEquals(null,Library.PName);
		assertEquals(null,Library.searchPeople);

	}

	@Test
	public void testOpen() {
		// open method will make isOpen to true
		myLib.isOpen = false;
		myLib.open();
		assertEquals(true,myLib.isOpen);

		// open method will return the ArrayList<OverdueList> according to createOverdueNotices

		// myPatron takes 3 books in total
		myPatron.take(b1);
		myPatron.libInfo.readBook.remove(b1);

		myPatron.take(b2);
		myPatron.libInfo.readBook.remove(b2);

		myPatron.take(b3);
		myPatron.libInfo.readBook.remove(b3);
		myLib.LibMap.put(myPatron.name, myPatron);  

		// checkOut set due date of the book to 1
		myPatron.PatronList.get(0).checkOut(1); 
		myPatron.PatronList.get(1).checkOut(1);
		myPatron.PatronList.get(2).checkOut(2); // not overdue

		assertEquals(1,b1.getDueDate());
		assertEquals(1,b2.getDueDate());
		assertEquals(2,b3.getDueDate());

		// Make sure that these 3 books are in PatronList
		assertTrue(myPatron.PatronList.contains(b1));
		assertTrue(myPatron.PatronList.contains(b2));
		assertTrue(myPatron.PatronList.contains(b3));

		// Set todays date to 2
		myLib.myCalendar.advance(); // Today = 1
		myLib.myCalendar.advance(); // Today = 2

		System.out.println("Today: "+myLib.myCalendar.getDate());

		/* 
		 * No matter how many books a patron take, 
		 * one patron can only occupy one index in ArrayList<OverdueNotice>
		 * So the size should be 1
		 */
		assertEquals(1,myLib.createOverdueNotices().size());

		// open method will return the ArrayList<OverdueList> according to createOverdueNotices
		assertEquals(myLib.createOverdueNotices().size(),myLib.open().size());
		assertEquals(1,myLib.open().size());
	}

	@Test
	public void testCreateOverdueNotices() {
		// myPatron takes 3 books in total
		myPatron.take(b1);
		myPatron.libInfo.readBook.remove(b1);

		myPatron.take(b2);
		myPatron.libInfo.readBook.remove(b2);

		myPatron.take(b3);
		myPatron.libInfo.readBook.remove(b3);
		myLib.LibMap.put(myPatron.name, myPatron);  

		// checkOut set due date of the book to 1
		myPatron.PatronList.get(0).checkOut(1); 
		myPatron.PatronList.get(1).checkOut(1);
		myPatron.PatronList.get(2).checkOut(2); // not overdue

		assertEquals(1,b1.getDueDate());
		assertEquals(1,b2.getDueDate());
		assertEquals(2,b3.getDueDate());

		// Make sure that these 3 books are in PatronList
		assertTrue(myPatron.PatronList.contains(b1));
		assertTrue(myPatron.PatronList.contains(b2));
		assertTrue(myPatron.PatronList.contains(b3));

		// Set todays date to 2
		myLib.myCalendar.advance(); // Today = 1
		myLib.myCalendar.advance(); // Today = 2

		System.out.println("Today: "+myLib.myCalendar.getDate());

		/* 
		 * No matter how many books a patron take, 
		 * one patron can only occupy one index in ArrayList<OverdueNotice>
		 * So the size should be 1
		 */
		assertEquals(1,myLib.createOverdueNotices().size());

		// Test the size of PatronList-->should be two since we take two books
		assertEquals(3,myPatron.PatronList.size());

		// Test the number of books due yesterday 
		int count = 0;
		for (int n=0; n<myPatron.PatronList.size(); n++){
			if (myPatron.PatronList.get(n).dueDate+1==myLib.myCalendar.getDate()){
				count+=1;
			}
		}
		System.out.println(count);
		assertEquals(2,count);

		// another patron -- myPatron2
		myPatron3.take(b10);
		myPatron3.libInfo.readBook.remove(b10);
		myPatron3.take(b11);
		myPatron3.libInfo.readBook.remove(b11);
		myPatron3.take(b12);
		myPatron3.libInfo.readBook.remove(b12);
		myLib.LibMap.put(myPatron3.name, myPatron3); 

		// checkOut set due date of the book to 1
		myPatron3.PatronList.get(0).checkOut(1); 
		myPatron3.PatronList.get(1).checkOut(1);
		myPatron3.PatronList.get(2).checkOut(1); 

		// Now testing the ArrayList<OverdueNotice>
		assertEquals(2,myLib.createOverdueNotices().size());


	}

	@Test
	public void testIssueCard() {
		// After issue a patron "wei", we can find her in HashMap
		Patron IssuePatron = new Patron("wei",myLib);
		LibServe.LibMap.put("wei", IssuePatron);
		myLib.issueCard("wei");
		assertTrue(myLib.LibMap.containsKey("wei"));

	}

	@Test
	public void testServe() {
		LibServe.LibMap.put("abc",myPatron);
		LibServe.LibMap.put("ttt",myPatron2);
		assertEquals(LibServe.LibMap.get("abc"),LibServe.serve("abc"));
		assertTrue(LibServe.LibMap.containsKey("ttt"));
	}

	@Test
	public void testCheckIn() {
		Lib1.close();
		LibServe.close();
		myLib.open();


		Library.PName = "abc";
		myLib.issueCard("abc");
		myLib.serve("abc");
		assertEquals(true,myLib.isOpen);
		//simulate checking out first.
		myLib.serve("abc").take(b1);
		assertTrue(myLib.serve("abc").PatronList.contains(b1));
		myLib.serve("abc").take(b2);
		assertTrue(myLib.serve("abc").PatronList.contains(b2));
		myLib.serve("abc").take(b3);
		assertTrue(myLib.serve("abc").PatronList.contains(b3));
		ArrayList<Book> test = new ArrayList<Book>();
		test.add(b1);
		test.add(b2);
		test.add(b3);
		assertEquals(test,myLib.serve("abc").PatronList);
		assertEquals(b1,test.get(0));
		assertEquals(myLib.serve("abc").PatronList.get(0),b1);
		//then check in
		ArrayList<Integer> bookNumbers = new ArrayList<Integer>();
		bookNumbers.add(1);
		assertTrue(bookNumbers.contains(1));
		assertEquals(0,bookNumbers.indexOf(1));
		bookNumbers.add(3);
		assertTrue(bookNumbers.contains(3));
		assertEquals(1,bookNumbers.indexOf(3));



		myLib.readBook.get(myLib.readBook.indexOf(b1)).checkOut(10); 
		myLib.readBook.get(myLib.readBook.indexOf(b2)).checkOut(10);
		myLib.readBook.get(myLib.readBook.indexOf(b3)).checkOut(10);

		myLib.serve("abc").libInfo.checkIn(bookNumbers);
		assertEquals(1,myLib.serve("abc").PatronList.size());
		//check if each book is in patron's hand after check in.
		assertTrue(myLib.serve("abc").PatronList.contains(b2));
		assertTrue(!(myLib.serve("abc").PatronList.contains(b3)));
		assertTrue(!(myLib.serve("abc").PatronList.contains(b1)));
		//check if the duedate of each book checked in is set to -1.
		assertEquals(-1,myLib.readBook.get(myLib.readBook.indexOf(b1)).dueDate);
		assertEquals(10,myLib.readBook.get(myLib.readBook.indexOf(b2)).dueDate);
		assertEquals(-1,myLib.readBook.get(myLib.readBook.indexOf(b3)).dueDate);



	}



	@Test
	public void testSearch() {
		Lib1.open();
		Library.PName = "ttt";
		Lib1.issueCard("ttt");
		Lib1.serve("ttt");
		assertEquals(true,Lib1.isOpen);
		//search the books containing"2"
		ArrayList<Book> result = Lib1.serve("ttt").libInfo.search("2");
		//define a desired answer.
		ArrayList<Book> test = new ArrayList<Book>();
		test.add(b6);
		test.add(b7);
		assertEquals(result.get(1),test.get(0));
		assertEquals(result.get(0),test.get(1));

	}

	@Test
	public void testCheckOut() {

		myLib.open();
		myLib.issueCard("abc");
		Library.PName = "abc";
		myLib.serve("abc").PatronList.clear();
		Patron A = myLib.serve("abc");
		assertEquals(true,myLib.isOpen);
		assertEquals("abc",myLib.PName);
		ArrayList<Integer> bookNumbers = new ArrayList<Integer>();
		bookNumbers.add(1);
		bookNumbers.add(3);
		Library.Returnn.add(b1);
		Library.Returnn.add(b2);
		Library.Returnn.add(b3);

		//assertEquals(0,myPatron.PatronList.size());
		System.out.println("size"+A.PatronList.size());

		myLib.serve("abc").libInfo.checkOut(bookNumbers);
		assertEquals(2,myLib.serve("abc").PatronList.size());
		assertTrue(myLib.serve("abc").PatronList.contains(b1));
		assertTrue(myLib.serve("abc").PatronList.contains(b3));
		assertEquals(8,myLib.readBook.get(myLib.readBook.indexOf(b1)).dueDate);
		assertEquals(8,myLib.readBook.get(myLib.readBook.indexOf(b3)).dueDate);
		assertEquals(-1,myLib.readBook.get(myLib.readBook.indexOf(b2)).dueDate);


	}
	@Test
	public void testClose() {
		myLib.isOpen = true;
		myLib.close();
		assertFalse(myLib.isOpen);
	}



}
