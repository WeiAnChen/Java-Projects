package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	public Ocean myOcean;
	public Ship myShip;
	public Ship myShip2;
	public Ship myShip3;

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
	public void testOcean() {
		assertEquals(0,myOcean.shotsFired);
		assertEquals(0,myOcean.hitCount);
		assertEquals(0,myOcean.shipsSunk);

		// the ocean should be all empty
		assertEquals("empty",myOcean.ships[0][0].getShipType());
		assertEquals("empty",myOcean.ships[5][5].getShipType());
	}

	@Test
	public void testPlaceAllShipsRandomly() {
		myOcean.placeAllShipsRandomly();
		int counter = 0;
		for (int i=0; i<10; i++){
			for(int j=0; j<10;j++){
				if (myOcean.isOccupied(i, j)==true){
					counter+=1;
				}
			}
			
		}
		assertEquals(20,counter);
		
		
	}

	@Test
	public void testIsOccupied() {
		// place myShip to (1,1)->(1,4)
		myShip.placeShipAt(1, 1, true, myOcean);
		assertEquals(true,myOcean.isOccupied(1,1));
		assertEquals(true,myOcean.isOccupied(1,2));
		assertEquals(true,myOcean.isOccupied(1,3));
		assertEquals(true,myOcean.isOccupied(1,4));

		// any where in my ocean which hasn't put any ship.
		assertEquals(false,myOcean.isOccupied(0, 0));


	}

	@Test
	public void testShootAt() {
		// place myShip to (1,1)->(1,4)
		myShip.placeShipAt(1, 1, true, myOcean);

		// shoot at (1,1)
		myOcean.shootAt(1, 1);

		// this position was hit 
		// check by toString
		assertEquals("S",myOcean.ships[1][1].toString());
		

		// after shoot, shotFired and hotCount changed
		assertEquals(1,myOcean.shotsFired);
		assertEquals(1,myOcean.hitCount);  // hit myShip

		// shoot at empty sea
		myOcean.shootAt(0, 0);
		assertEquals(2,myOcean.shotsFired); // 2nd shot
		assertEquals(1,myOcean.hitCount);  // doesn't hit anything


	}

	@Test
	public void testGetShotsFired() {

		// default is 0
		assertEquals(0,myOcean.getShotsFired());

		// place myShip to (1,1)->(1,4)
		myShip.placeShipAt(1, 1, true, myOcean);

		// shoot at (1,1)
		myOcean.shootAt(1, 1);
		assertEquals(1,myOcean.getShotsFired());
	}

	@Test
	public void testGetHitCount() {
		// default is 0
		assertEquals(0,myOcean.getHitCount());

		// place myShip to (1,1)->(1,4)
		myShip.placeShipAt(1, 1, true, myOcean);

		// shoot at (1,1)
		myOcean.shootAt(1, 1);
		assertEquals(1,myOcean.getHitCount());

		myOcean.shootAt(9, 9);
		assertEquals(1,myOcean.getHitCount()); // nothing, keep the hit count

	}

	@Test
	public void testGetShipsSunk() {
		// default is 0
		assertEquals(0,myOcean.getShipsSunk());

		// place myShip to (1,1)->(1,4)
		myShip.placeShipAt(1, 1, true, myOcean);
		
		// after place ship, still 0 ship sunk
		assertEquals(0,myOcean.getShipsSunk());

		// shoot at (1,1) (1,2) (1,3) (1,4)
		myOcean.shootAt(1, 1);
		myOcean.shootAt(1, 2);
		myOcean.shootAt(1, 3);
		
		// after 3 part of the battleship hit, still no ship sunk
		assertEquals(0,myOcean.getShipsSunk()); 
		
		myOcean.shootAt(1, 4);
		assertEquals(1,myOcean.getShipsSunk()); 
	

	}

	@Test
	public void testIsGameOver() {
		// when game is over --> all ships sunk
		// originally there should be 10 ships in total
		myShip.placeShipAt(0, 0,true, myOcean);
		
		// Cruisers
		myShip2.placeShipAt(5, 6,true, myOcean);
		Ship myCru2 = new Cruiser();
		myCru2.placeShipAt(1, 5, false, myOcean);
		assertTrue(myOcean.isOccupied(2, 5));
		assertTrue(myOcean.isOccupied(3, 5));
		
		
		// Destroyers
		Ship myDes1 = new Destroyer();
		Ship myDes2 = new Destroyer();
		Ship myDes3 = new Destroyer();
		
		myDes1.placeShipAt(3, 1, false, myOcean);
		myDes2.placeShipAt(6, 1, true, myOcean);
		myDes3.placeShipAt(0, 7, true, myOcean);
		
		Ship mySub1 = new Submarine();
		Ship mySub2 = new Submarine();
		Ship mySub3 = new Submarine();
		Ship mySub4 = new Submarine();
		
		mySub1.placeShipAt(7, 5, true, myOcean);
		mySub2.placeShipAt(2, 7, true, myOcean);
		mySub3.placeShipAt(7, 8, true, myOcean);
		mySub4.placeShipAt(9, 9, true, myOcean);
		
		// After a series of shots...
		myOcean.shootAt(0,0);
		myOcean.shootAt(0,1);
		myOcean.shootAt(0,2);
		myOcean.shootAt(0,3);
		assertEquals(1,myOcean.getShipsSunk());
		
		myOcean.shootAt(5,6);
		myOcean.shootAt(5,7);
		myOcean.shootAt(5,8);
		assertEquals(2,myOcean.getShipsSunk());
		
		
		
		myOcean.shootAt(3,1);
		myOcean.shootAt(4,1);
		assertEquals(3,myOcean.getShipsSunk());
		
		myOcean.shipsSunk = 10;
		
		assertTrue(myOcean.isGameOver());

	}

	@Test
	public void testGetShipArray() {
		// myShip
		myShip.placeShipAt(1, 1, true, myOcean);
		
		assertEquals("Battleship",myOcean.getShipArray()[1][1].getShipType());
		assertEquals(10,myOcean.getShipArray().length);
	}

}
