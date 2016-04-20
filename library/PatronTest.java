package library;



import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PatronTest {

	public Patron testPatron;
	public Book book1;
	public Book book2;
	public Library lib;
	public ArrayList<Book> testLib = new ArrayList<Book>();

	@Before
	public void setUpBeforeClass() throws Exception {
		book1 = new Book("Beta","BBB");
		book2 = new Book("Gamma","GGG");
		testLib.add(book1);
		testLib.add(book2);
		lib = new Library(testLib);
		testPatron = new Patron("Boy" , lib);
	}

	@Test
	public void testPatron() {
		assertEquals("Boy", testPatron.name);
		assertEquals(lib, testPatron.libInfo);
		assertEquals(0, testPatron.PatronList.size());
	}

	@Test
	public void testGetName() {
		assertEquals("Boy", testPatron.getName());
	}

	@Test
	public void testTake() {
		testPatron.take(book1);
		assertEquals("Beta", testPatron.PatronList.get(testPatron.PatronList.indexOf(book1)).title);
		assertEquals("BBB", testPatron.PatronList.get(testPatron.PatronList.indexOf(book1)).author);
		testPatron.take(book2);
		assertEquals("Gamma", testPatron.PatronList.get(testPatron.PatronList.indexOf(book2)).title);
		assertEquals("GGG", testPatron.PatronList.get(testPatron.PatronList.indexOf(book2)).author);
		assertEquals(2,testPatron.PatronList.size());
	}

	@Test
	public void testGiveBook() {
		testPatron.take(book1);
		testPatron.take(book2);
		testPatron.giveBack(book2);
		assertEquals(1,testPatron.PatronList.size());
		assertEquals(false, testPatron.PatronList.contains(book2));
	}

	@Test
	public void testGetBooks() {
		testPatron.take(book1);
		testPatron.take(book2);
		assertEquals(2,testPatron.getBooks().size());
	}




}
