package battleship;

import java.util.*;

public class Ocean {
	Ship[][] ships = new Ship[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk; // (10 ships in all)


	// The constructor create empty ocean.
	public Ocean() { 

		for (int x=0;x<10;x++){
			for(int y=0;y<10;y++){
				this.ships[x][y] = new EmptySea();
				// should set the bowRow and bowColumn
				this.ships[x][y].bowRow = x;
				this.ships[x][y].bowColumn = y;
			}
		}

		this.shotsFired = 0;  // The total number of shots fired by the user
		this.hitCount = 0;  // The number of times a shot hit a ship
		this.shipsSunk = 0;  // The number of ships sunk
	}

	// method start
	/**
	 * This method will make ocean 10*10 matrix
	 * place 10 ships randomly
	 */
	public void placeAllShipsRandomly(){

		// place all ship randomly from 0 to 9
		// Prepare to place one battleship

		Random rand = new Random();
		int nRow = rand.nextInt(9)+0;

		Random rand2 = new Random();
		int nColumn = rand2.nextInt(9)+0;

		Random randBattleH = new Random();
		boolean BattleHoriz = randBattleH.nextBoolean();

		Ship myBattleship = new Battleship();
		boolean canPutBattle = myBattleship.okToPlaceShipAt(nRow, nColumn, BattleHoriz, this);


		// put one battleship firstly
		while(canPutBattle==false){
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Not Okay position: "+"Row: "+nRow+", "+"Column: "+nColumn+", "+"Horizon: "+BattleHoriz);
			nRow = rand.nextInt(9)+0;
			nColumn = rand2.nextInt(9)+0;
			BattleHoriz = randBattleH.nextBoolean();
			canPutBattle = myBattleship.okToPlaceShipAt(nRow, nColumn, BattleHoriz, this);
		}



		myBattleship.placeShipAt(nRow, nColumn, BattleHoriz, this);
		System.out.println("Bat: "+"Row: "+nRow+", "+"Column: "+nColumn+", "+"Horizon: "+BattleHoriz);





		//Prepare to put 1st cruiser
		Random randCru = new Random();
		int nRowCru = randCru.nextInt(9)+0;

		Random rand2Cru = new Random();
		int nColumnCru = rand2Cru.nextInt(9)+0;

		Random randCruH = new Random();
		boolean CruHoriz = randCruH.nextBoolean();

		Ship myCruiser1 = new Cruiser();
		boolean canPutCru1 = myCruiser1.okToPlaceShipAt(nRowCru, nColumnCru, CruHoriz, this);

		while(canPutCru1==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowCru+", "+"Column: "+nColumnCru+", "+"Horizon: "+CruHoriz);
			nRowCru = randCru.nextInt(9)+0;
			nColumnCru = rand2Cru.nextInt(9)+0;
			CruHoriz = randCruH.nextBoolean();
			canPutCru1 = myCruiser1.okToPlaceShipAt(nRowCru, nColumnCru, CruHoriz, this);
		}

		// put 1st Cruiser

		myCruiser1.placeShipAt(nRowCru, nColumnCru, CruHoriz, this);
		System.out.println("Cru1: "+"Row: "+nRowCru+", "+"Column: "+nColumnCru+", "+"Horizon: "+CruHoriz);


		// Prepare to put 2nd Cruiser
		Random randCru2 = new Random();
		int nRowCru2 = randCru2.nextInt(9)+0;

		Random rand2Cru2 = new Random();
		int nColumnCru2 = rand2Cru2.nextInt(9)+0;

		Random randCru2H = new Random();
		boolean Cru2Horiz = randCru2H.nextBoolean();

		Ship myCruiser2 = new Cruiser();
		boolean canPutCru2 = myCruiser2.okToPlaceShipAt(nRowCru2, nColumnCru2, Cru2Horiz, this);

		while(canPutCru2==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowCru2+", "+"Column: "+nColumnCru2+", "+"Horizon: "+Cru2Horiz);
			nRowCru2 = randCru2.nextInt(9)+0;
			nColumnCru2 = rand2Cru2.nextInt(9)+0;
			Cru2Horiz = randCru2H.nextBoolean();
			canPutCru2 = myCruiser2.okToPlaceShipAt(nRowCru2, nColumnCru2, Cru2Horiz, this);
		}

		// put 2nd Cruiser

		myCruiser2.placeShipAt(nRowCru2, nColumnCru2, Cru2Horiz, this);
		System.out.println("Cru2: "+"Row: "+nRowCru2+", "+"Column: "+nColumnCru2+", "+"Horizon: "+Cru2Horiz);


		// Prepare to put the 1st destroyer
		Random randDes = new Random();
		int nRowDes = randDes.nextInt(9)+0;

		Random rand2Des = new Random();
		int nColumnDes = rand2Des.nextInt(9)+0;

		Random randDesH = new Random();
		boolean DesHoriz = randDesH.nextBoolean();

		Ship myDestroyer1 = new Destroyer();
		boolean canPutDes1 = myDestroyer1.okToPlaceShipAt(nRowDes, nColumnDes, DesHoriz, this);

		while(canPutDes1==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowDes+", "+"Column: "+nColumnDes+", "+"Horizon: "+DesHoriz);
			nRowDes = randDes.nextInt(9)+0;
			nColumnDes = rand2Des.nextInt(9)+0;
			DesHoriz = randDesH.nextBoolean();
			canPutDes1 = myDestroyer1.okToPlaceShipAt(nRowDes, nColumnDes, DesHoriz, this);
		}

		// put 1st destroyer

		myDestroyer1.placeShipAt(nRowDes, nColumnDes, DesHoriz, this);
		System.out.println("Des1: "+"Row: "+nRowDes+", "+"Column: "+nColumnDes+", "+"Horizon: "+DesHoriz);


		//Prepare to put 2nd destroyer
		Random randDes2 = new Random();
		int nRowDes2 = randDes2.nextInt(9)+0;

		Random rand2Des2 = new Random();
		int nColumnDes2 = rand2Des2.nextInt(9)+0;

		Random randDes2H = new Random();
		boolean Des2Horiz = randDes2H.nextBoolean();

		Ship myDestroyer2 = new Destroyer();
		boolean canPutDes2 = myDestroyer2.okToPlaceShipAt(nRowDes2, nColumnDes2, Des2Horiz, this);

		while(canPutDes2==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowDes2+", "+"Column: "+nColumnDes2+", "+"Horizon: "+Des2Horiz);
			nRowDes2 = randDes2.nextInt(9)+0;
			nColumnDes2 = rand2Des2.nextInt(9)+0;
			Des2Horiz = randDes2H.nextBoolean();
			canPutDes2 = myDestroyer2.okToPlaceShipAt(nRowDes2, nColumnDes2, Des2Horiz, this);
		}

		// put 2nd destroyer

		myDestroyer2.placeShipAt(nRowDes2, nColumnDes2, Des2Horiz, this);
		System.out.println("Des2: "+"Row: "+nRowDes2+", "+"Column: "+nColumnDes2+", "+"Horizon: "+Des2Horiz);


		// Prepare to put 3rd destroyer

		Random randDes3 = new Random();
		int nRowDes3 = randDes3.nextInt(9)+0;

		Random rand2Des3 = new Random();
		int nColumnDes3 = rand2Des3.nextInt(9)+0;

		Random randDes3H = new Random();
		boolean Des3Horiz = randDes3H.nextBoolean();

		Ship myDestroyer3 = new Destroyer();
		boolean canPutDes3 = myDestroyer3.okToPlaceShipAt(nRowDes3, nColumnDes3, Des3Horiz, this);

		while(canPutDes3==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowDes3+", "+"Column: "+nColumnDes3+", "+"Horizon: "+Des3Horiz);
			nRowDes3 = randDes3.nextInt(9)+0;
			nColumnDes3 = rand2Des3.nextInt(9)+0;
			Des3Horiz = randDes3H.nextBoolean();

			canPutDes3 = myDestroyer3.okToPlaceShipAt(nRowDes3, nColumnDes3, Des3Horiz, this);
		}

		// put 3rd destroyer

		myDestroyer3.placeShipAt(nRowDes3, nColumnDes3, Des3Horiz, this);
		System.out.println("Des3: "+"Row: "+nRowDes3+", "+"Column: "+nColumnDes3+", "+"Horizon: "+Des3Horiz);


		//Prepare to put 1st submarine

		Random randSub = new Random();
		int nRowSub = randSub.nextInt(9)+0;

		Random rand2Sub = new Random();
		int nColumnSub = rand2Sub.nextInt(9)+0;

		Random randSubH = new Random();
		boolean SubHoriz = randSubH.nextBoolean();

		Ship mySubmarine1 = new Submarine();
		boolean canPutSub1 = mySubmarine1.okToPlaceShipAt(nRowSub, nColumnSub, SubHoriz, this);

		while(canPutSub1==false ){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowSub+", "+"Column: "+nColumnSub+", "+"Horizon: "+SubHoriz);
			nRowSub = randSub.nextInt(9)+0;
			nColumnSub = rand2Sub.nextInt(9)+0;
			SubHoriz = randSubH.nextBoolean();
			canPutSub1 = mySubmarine1.okToPlaceShipAt(nRowSub, nColumnSub, SubHoriz, this);
		}

		// put 1st submarine

		mySubmarine1.placeShipAt(nRowSub, nColumnSub, SubHoriz, this);
		System.out.println("Sub1: "+"Row: "+nRowSub+", "+"Column: "+nColumnSub+", "+"Horizon: "+SubHoriz);

		//Prepare to put 2nd submarine

		Random randSub2 = new Random();
		int nRowSub2 = randSub2.nextInt(9)+0;


		Random rand2Sub2 = new Random();
		int nColumnSub2 = rand2Sub2.nextInt(9)+0;

		Random randSub2H = new Random();
		boolean Sub2Horiz = randSub2H.nextBoolean();

		Ship mySubmarine2 = new Submarine();
		boolean canPutSub2 = mySubmarine2.okToPlaceShipAt(nRowSub2, nColumnSub2, Sub2Horiz, this);

		while(canPutSub2==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowSub2+", "+"Column: "+nColumnSub2+", "+"Horizon: "+Sub2Horiz);
			nRowSub2 = randSub2.nextInt(9)+0;
			nColumnSub2 = rand2Sub2.nextInt(9)+0;
			Sub2Horiz = randSub2H.nextBoolean();
			canPutSub2 = mySubmarine2.okToPlaceShipAt(nRowSub2, nColumnSub2, Sub2Horiz, this);
		}

		// put 2nd submarine
		mySubmarine2.placeShipAt(nRowSub2, nColumnSub2, Sub2Horiz, this);
		System.out.println("Sub2: "+"Row: "+nRowSub2+", "+"Column: "+nColumnSub2+", "+"Horizon: "+Sub2Horiz);


		// Prepare to put 3rd submarine

		Random randSub3 = new Random();
		int nRowSub3 = randSub3.nextInt(9)+0;

		Random rand2Sub3 = new Random();
		int nColumnSub3 = rand2Sub3.nextInt(9)+0;

		Random randSub3H = new Random();
		boolean Sub3Horiz = randSub3H.nextBoolean();

		Ship mySubmarine3 = new Submarine();
		boolean canPutSub3 = mySubmarine3.okToPlaceShipAt(nRowSub3, nColumnSub3, Sub3Horiz, this);

		while(canPutSub3==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowSub3+", "+"Column: "+nColumnSub3+", "+"Horizon: "+Sub3Horiz);
			nRowSub3 = randSub.nextInt(9)+0;
			nColumnSub3= rand2Sub.nextInt(9)+0;
			Sub3Horiz = randSubH.nextBoolean();
			canPutSub3 = mySubmarine3.okToPlaceShipAt(nRowSub3, nColumnSub3, Sub3Horiz, this);
		}

		// put 3rd submarine
		mySubmarine3.placeShipAt(nRowSub3, nColumnSub3, Sub3Horiz, this);
		System.out.println("Sub3: "+"Row: "+nRowSub3+", "+"Column: "+nColumnSub3+", "+"Horizon: "+Sub3Horiz);


		// Prepare to put 4th submarine
		Random randSub4 = new Random();
		int nRowSub4 = randSub4.nextInt(9)+0;

		Random rand2Sub4 = new Random();
		int nColumnSub4 = rand2Sub4.nextInt(9)+0;

		Random randSub4H = new Random();
		boolean Sub4Horiz = randSub4H.nextBoolean();

		Ship mySubmarine4 = new Submarine();
		boolean canPutSub4 = mySubmarine4.okToPlaceShipAt(nRowSub4, nColumnSub4, Sub4Horiz, this);

		while(canPutSub4==false){ // not pass ok to put --> false
			System.out.println("Overlapped! Random the position and orientation again.");
			System.out.println("Overlapped position: "+"Row: "+nRowSub4+", "+"Column: "+nColumnSub4+", "+"Horizon: "+Sub4Horiz);
			nRowSub4 = randSub.nextInt(9)+0;
			nColumnSub4 = rand2Sub.nextInt(9)+0;
			Sub4Horiz = randSubH.nextBoolean();

			canPutSub4 = mySubmarine4.okToPlaceShipAt(nRowSub4, nColumnSub4, Sub4Horiz, this);
		}

		// put 4th submarine
		mySubmarine4.placeShipAt(nRowSub4, nColumnSub4, Sub4Horiz, this);
		System.out.println("Sub4: "+"Row: "+nRowSub4+", "+"Column: "+nColumnSub4+", "+"Horizon: "+Sub4Horiz);

	}

	/**
	 * This method will return true if occupied by ships
	 * otherwise false
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isOccupied(int row, int column){

		if (this.ships[row][column].getShipType()=="empty"){
			return false;
		}

		else{
			return true;
		}

	}

	/**
	 * 1. Returns true if the given location contains a real ship(not empty), still afloat
	 * false if not (sunk-->false, not sunk-->true)
	 * 2. This method updates the number of shots that have been fired
	 * and the number of hits
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		//String ShipType = this.ships[row][column].getShipType();
		boolean containShip = this.isOccupied(row, column);
		boolean rightType;
		boolean isAfloat;

		// check whether there's ship there
		if (containShip==true){
			rightType = true;
		}
		else{
			rightType = false;
		}

		// check whether the ship is afloat
		if (this.ships[row][column].isSunk()==false){
			isAfloat = true;
		}
		else{
			isAfloat = false;
		}


		Ship position = ships[row][column];
		// return 
		// update shotsFired and hitCount
		// for hitCount: even thought hit the same part of the ship more than once should be counted
		if (rightType==true && isAfloat==true){

			// update hit array
			if (position.horizontal==true){
				position.getHit()[column-position.bowColumn]=true;
			}
			else{
				position.getHit()[row-position.bowRow]=true;
			}

			shotsFired+=1;
			hitCount+=1;

			return true;
		}

		else if (rightType==true && isAfloat==false){  // already sunk
			shotsFired+=1;
			hitCount+=1;
			// no advance for hitCount
			return false;
		}
		
		
		else{  // nothing happened
			shotsFired+=1;
			position.hit[0]=true;
			return false;
		}

	}
	
	
	 /**
	  * This method will return shotsFired
	  * @return shotsFired
	  */
	public int getShotsFired() {
		return shotsFired;
	}
	
	/**
	  * This method will return hitCount
	  * @return hitCounr
	  */
	public int getHitCount() {
		return hitCount;
	}
	
	/**
	  * This method will return shipSunk
	  * @return shipSunk
	  */
	public int getShipsSunk() {

		int SunkCount = 0;

		for (int b=0; b<10; b++){
			for (int a=0; a<10; a++){
				String type = this.ships[b][a].getShipType();
				if(this.isOccupied(b, a)==true){
					if(this.ships[b][a].isSunk()==true){

						if(type =="Battleship"){
							if(SunkCount<1 && SunkCount>=0){ // 1 battleship
								SunkCount+=1;
							}
							else{
								SunkCount+=0;
							}
						}
						else if(type == "Cruiser"){ // 2 Cruisers
							if(SunkCount<2 && SunkCount>=0){
								SunkCount+=1;
							}
							else{
								SunkCount+=0;
							}
						}
						else if(type == "Destroyer"){ // 3 destroyers
							if(SunkCount<3 && SunkCount>=0){
								SunkCount+=1;
							}
							else{
								SunkCount+=0;
							}
						}
						else{// must be submarine
							if(SunkCount<4 && SunkCount>=0){
								SunkCount+=1;
							}
							else{
								SunkCount+=0;
							}
						}
					}
					else{
						SunkCount+=0;
					}
				}
				else{
					SunkCount+=0;
				}

			}
		}

		shipsSunk = SunkCount;

		return shipsSunk;
	}

	/**
	 * If all ships have been sunk
	 * @return true 
	 * otherwise
	 * @return false
	 */
	public boolean isGameOver(){

		if (this.shipsSunk==10){
			return true;
		}
		else{
			return false;
		}



	}

	/**
	 * The methods in the Ship class that take 
	 * an Ocean parameter really need to be able to look
	 * at the contents of this array.
	 * The "placeShipAt" method even needs to modify it.
	 * 
	 * @return 10*10 array of ships
	 */
	public Ship[][] getShipArray(){
		return this.ships;
	}

	/**
	 * This method will print out the ocean.
	 * "S": locations that you have fired upon and hit a real ship
	 * "-": locations that you have fired upon and found nothing there.
	 * "x": locations containing a sunken ship
	 * ".": locations that you have never fired upon
	 * 
	 */
	public void print(){

		
		String toPrint = "\t";
		// create column numbers
		for (int x=0; x<10; x++){
			String columnNo = Integer.toString(x);
			toPrint+=columnNo;
			toPrint+="\t";
		}
		toPrint+="\n";



		// loop through the whole ocean

		for (int i=0; i<10; i++){
			// add row number every time change row i
			String rowNo = Integer.toString(i);
			toPrint+=rowNo;
			toPrint+="\t";
			
			for (int j=0; j<10; j++){
				Ship position = this.ships[i][j];

				// should divide into horizontal or vertical
				if (position.horizontal==true){
					// this position has been hit or not
					if(position.getHit()[j-position.getBowColumn()]==true){ // has been hit (S,-,x)
						
						position.set(i, j);
						toPrint += position.toString();
						toPrint += "\t";
					}
					
					else if(position.getShipType()=="empty" && position.getHit()[0]==true){
						toPrint += "-";
						toPrint += "\t";
					}
					
					else{ // has never fired upon (".")
						toPrint += ".";
						toPrint += "\t";
					}
				}
				// vertical
				else{
					// this position has been hit or not
					
					if(position.getHit()[i-position.getBowRow()]==true){ // has been hit (S,-,x)
						
						toPrint += position.toString();
						toPrint += "\t";
					}
					else if(position.getShipType()=="empty" && position.getHit()[0]==true){
						toPrint += "-";
						toPrint += "\t";
					}
					else{ // has never fired upon (".")
						toPrint += ".";
						toPrint += "\t";
					}
				}

			}

			toPrint+="\n";
		}

		System.out.println(toPrint);

		System.out.println("The ocean distribution after this shot.");


	}



	/**
	 * This is the help method I created for debugging
	 */
	public void printTest(){
		String toPrint = "\t";
		// create column numbers
		for (int x=0; x<10; x++){
			String columnNo = Integer.toString(x);
			toPrint+=columnNo;
			toPrint+="\t";
		}
		toPrint+="\n";

		// loop through the whole ocean

		for (int i=0; i<10; i++){
			// add row number every time change row i
			String rowNo = Integer.toString(i);
			toPrint+=rowNo;
			toPrint+="\t";

			for (int j=0; j<10; j++){

				//Ship position = this.ships[i][j];
				if (this.isOccupied(i, j)== true){
					toPrint+="o";
					toPrint+="\t";
				}
				else{
					toPrint+="-";
					toPrint+="\t";
				}

			}
			toPrint+="\n";
		}
		System.out.println(toPrint);
	}

}
