package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {

	public Ship myShip;
	public Ship myShip2;
	public Ship myShip3;
	public Ocean myOcean;

	@Before
	public void setUp() throws Exception {
		myOcean = new Ocean();
		myShip = new Battleship();
		myShip.bowRow = 1;
		myShip.bowColumn = 1;
		myShip.horizontal = true;
		myShip.hit[0]=false;
		myShip.hit[1]=false;
		myShip.hit[2]=false;
		myShip.hit[3]=false;


		myShip2 = new Cruiser();
		myShip2.bowRow = 4;
		myShip2.bowColumn = 0;
		myShip2.horizontal = true;
		myShip2.hit[0]=false;
		myShip2.hit[1]=false;


		myShip3 = new Destroyer();
		myShip3.bowRow = 0;
		myShip3.bowColumn = 9;
		myShip3.horizontal = false;
		myShip3.hit[0]=false;
		myShip3.hit[1]=false;
	}

	@Test
	public void testGetLength() {
		assertEquals(4,myShip.getLength());
		assertEquals(3,myShip2.getLength());
		assertEquals(2,myShip3.getLength());
	}

	@Test
	public void testGetBowRow() {
		// myShip
		assertEquals(1,myShip.getBowRow());
		// myShip2
		assertEquals(4,myShip2.getBowRow());
		// myShip3
		assertEquals(0,myShip3.getBowRow());
	}

	@Test
	public void testGetHit() {
		// myShip 
		// element
		assertEquals(false,myShip.getHit()[0]);
		// size
		assertEquals(4,myShip.getHit().length);
	}

	@Test
	public void testGetBowColumn() {
		// myShip (1,1)
		assertEquals(1,myShip.getBowColumn());
		// myShip2 (4,0)
		assertEquals(0,myShip2.getBowColumn());
		// myShip3 (0,9)
		assertEquals(9,myShip3.getBowColumn());
	}

	@Test
	public void testIsHorizontal() {
		assertTrue(myShip.isHorizontal());
		assertTrue(myShip2.isHorizontal());
		assertFalse(myShip3.isHorizontal());
	}

	@Test
	public void testSetBowRow() {
		// myShip originally (1,1)
		myShip.setBowRow(7);
		assertEquals(7,myShip.getBowRow());

		// myShip2 (4,0)
		myShip2.setBowRow(5);
		assertEquals(5,myShip2.getBowRow());

	}

	@Test
	public void testSetBowColumn() {
		// myShip originally (1,1)
		myShip.setBowColumn(3);
		assertEquals(3,myShip.getBowColumn());

		// myShip2 (4,0)
		myShip2.setBowColumn(6);
		assertEquals(6,myShip2.getBowColumn());
	}

	@Test
	public void testSetHorizontal() {
		// myShip Horizontal
		myShip.setHorizontal(false);
		assertEquals(false,myShip.isHorizontal());

		// myShip3 vertical
		myShip3.setHorizontal(true);
		assertEquals(true,myShip3.isHorizontal());

	}

	@Test
	public void testGetShipType() {
		// myShip Battleship
		String Type1 = myShip.getShipType();
		assertEquals("Battleship",Type1);

		// myShip2 Cruiser
		String Type2 = myShip2.getShipType();
		assertEquals("Cruiser",Type2);

		// create empty sea
		Ship myEmpty = new EmptySea();
		String Type3 = myEmpty.getShipType();
		assertEquals("empty",Type3);

	}

	@Test
	public void testOkToPlaceShipAt() {
		// myShip put at (1,1)->(1,4)
		myOcean.ships[1][1]=myShip;
		myOcean.ships[1][2]=myShip;
		myOcean.ships[1][3]=myShip;
		myOcean.ships[1][4]=myShip;

		// no diagonal contact
		assertEquals(false,myShip2.okToPlaceShipAt(2, 5, true, myOcean));

		// no exceed boundary
		assertEquals(false,myShip3.okToPlaceShipAt(9, 3, false, myOcean));

		// no next it 
		assertEquals(false,myShip2.okToPlaceShipAt(2, 4, false, myOcean));

	}

	@Test
	public void testPlaceShipAt() {
		// place myShip at (1,1) on myOcean
		myShip.placeShipAt(1, 1, true, myOcean);

		// use getType to check whether myShip is placed at right position
		assertEquals("Battleship",myOcean.ships[1][1].getShipType());
		assertEquals("Battleship",myOcean.ships[1][2].getShipType());
		assertEquals("Battleship",myOcean.ships[1][3].getShipType());
		assertEquals("Battleship",myOcean.ships[1][4].getShipType());



	}

	@Test
	public void testShootAt() {
		// place myShip at (1,1) to (1,4) firstly
		myShip.placeShipAt(1, 1, true, myOcean);

		// shoot at (1,3)
		myOcean.shootAt(1, 3);

		// After shoot --> the hit array [2] would change into true 
		assertEquals(true,myShip.getHit()[2]);
		// So this ship will return true at shootAt method
		assertEquals(true,myShip.shootAt(1, 3));


		// while others remain false
		assertEquals(false,myShip.getHit()[0]);
		assertEquals(false,myShip.getHit()[1]);
		assertEquals(false,myShip.getHit()[3]);

		// But there's a part of the ship shoot -> true
		assertEquals(true,myShip.shootAt(1, 1));
		assertEquals(true,myShip.shootAt(1, 2));
		assertEquals(true,myShip.shootAt(1, 4));

	}

	@Test
	public void testIsSunk() {
		// put myShip at (1,1)->(1,4)
		myShip.placeShipAt(1, 1, true, myOcean);

		// originally not sunk
		assertFalse(myShip.isSunk());

		// make it sunk --> shoot 4 times
		myOcean.shootAt(1, 1);
		myOcean.shootAt(1, 2);
		myOcean.shootAt(1, 3);
		myOcean.shootAt(1, 4);

		// test whether this ship is sunk
		assertTrue(myShip.isSunk());

	}

	@Test
	public void testSet() {
		// myShip
		//currentr
		myShip.set(5, 6);
		// currentc
		assertEquals(5,myShip.currentr);
		assertEquals(6,myShip.currentc);
	}

	@Test
	public void testToString() {
		// myShip
		// return "S"
		// place myShip at (1,1) to (1,4) firstly
		myShip.placeShipAt(1, 1, true, myOcean);

		// shoot at (1,3)
		myOcean.shootAt(1, 3);
		
		assertEquals("S",myShip.toString());


	}

}
