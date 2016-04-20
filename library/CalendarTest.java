package library;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalendarTest {
	public Calendar testCal;
	int date;

	@Before
	public void setUp() throws Exception {
		this.testCal = new Calendar();
		this.date = 0;
	}

	@Test
	public void testCalendar() {
		assertEquals(0,date);
	}

	@Test
	public void testGetDate() {
		testCal.advance();
		testCal.advance();
		assertEquals(2,testCal.getDate());
		
	}

	@Test
	public void testAdvance() {
		testCal.advance();
		assertEquals(1,testCal.getDate());
	}

}
