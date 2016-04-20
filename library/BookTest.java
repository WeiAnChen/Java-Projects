package library;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookTest {

    static Book testBook;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        testBook = new Book("Alpha", "Boy");

    }

    @Test
    public void testBook() {
        assertEquals("Alpha",testBook.title);
        assertEquals("Boy",testBook.author);
        assertEquals(6,testBook.dueDate);
        assertEquals("Alpha",testBook.getTitle());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Alpha",testBook.getTitle());
        assertEquals("Boy",testBook.getAuthor());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Boy",testBook.getAuthor());
    }

    @Test
    public void testGetDueDate() {
        assertEquals(6,testBook.dueDate);
    }

    @Test
    public void testCheckOut() {
        testBook.checkOut(6);
        assertEquals(6,testBook.dueDate);
    }

    @Test
    public void testCheckIn() {
        testBook.checkIn();
        assertEquals(-1,testBook.dueDate);
    }

    @Test
    public void testToString() {
        assertEquals("Alpha, Boy", testBook.toString());
    }

}
