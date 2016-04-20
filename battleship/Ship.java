package battleship;

public abstract class Ship {
	// Ship is an abstract class, we always create a specific kind of ship
	/*
	 * instance variable goes here
	 */
	int currentr, currentc;
	int bowRow = 0;  // the row(0 to 9) which contains the front of the ship
	int bowColumn = 0;  // the column (0 to 9) which contains the front of the ship
	int length;  // the number of squares occupied by the ship (empty sea location has length 1)
	boolean horizontal; // true: ship occupies a single row, false otherwise.
	boolean [] hit = new boolean[4]; // an array of booleans telling whether that part of the ship has been hit.


	//abstract class -> no need of constructor 
	/*
	public Ship() {

	}
	 */


	/**
	 * Return the length of "this" particular ship. 
	 * This method exists only to be overridden
	 * 
	 * @return 
	 */
	public int getLength(){
		return length;
	}

	// Getters
	
	/**
	 * This method will return bowRow
	 * @return bowRow
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * This method will return hit
	 * @return hit
	 */
	public boolean[] getHit() {
		return hit;
	}

	/**
	 * This method will return bowColumn
	 * @return bowColumn
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * This method will return horizontal 
	 * @return horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}


	// Setters
	/**
	 * This mehtod will set row
	 * @param row
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}
	/**
	 * This mehtod will set row
	 * @param column
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	/**
	 * This method will set horizontal
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/* abstract method
	 * every ship has its own ship type
	 */
	public abstract String getShipType();

	/**
	 * This method will return true if it is okay to put a ship of this 
	 * length with its bow in this location, with the given orientation
	 * returns false otherwise
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){

		boolean twoIsEmpty = false;
		boolean loopIsComp = false;
		boolean notExceed = false;
		boolean itselfEmpty = false;
		int counter = 0;
		int counterEmpty = 0;

		if ((column<=9 && column>=0)&&(row<=9 && row>=0)){

			if (horizontal==true){

				// make sure that the ship didn't exceed the array
				if (column<=(10-length)){
					notExceed = true;
				}
				else{
					notExceed = false;
				}

				// make sure [row][column] not occupy any thing
				if(notExceed==true){
					for (int x=0; x<length; x++){
						if (ocean.isOccupied(row, column+x)==false){
							counterEmpty+=1;
						}
						else{
							break;
						}
					}

					if (counterEmpty==length){
						itselfEmpty=true;
					}
					else if (counterEmpty<length){
						itselfEmpty = false;
					}

					else{
						System.out.println("Impossible situation.");
					}

				}
				else{
					return false;
				}


				if (notExceed==true && itselfEmpty==true){
					if (row==0 || row==9){//1
						if ((row==0 && column==0)||(row==9 && column==0)){// 1

							// one side
							for (int a=column;a<=column+length;a++){
								if (row==0){
									if (ocean.isOccupied(row+1, a)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
								else{ // row==9
									if (ocean.isOccupied(row-1, a)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
							}

							if (counter==length+1){
								loopIsComp = true;
							}
							else{
								loopIsComp = false;
							}

						}

						else if ((row==0 && column==10-length) || (row==9 && column==10-length)){
							// one side
							for (int a=column-1;a<column+length;a++){
								if (row==0){
									if (ocean.isOccupied(row+1, a)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
								else{ // row==9
									if (ocean.isOccupied(row-1, a)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
							}

							if (counter==length+1){
								loopIsComp = true;
							}
							else{
								loopIsComp = false;
							}

						}

						else{// 2
							// one side
							for (int a=column-1;a<=column+length;a++){
								if (row==0){
									if (ocean.isOccupied(row+1, a)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
								else{ // row==9
									if (ocean.isOccupied(row-1, a)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
							}

							if (counter==length+2){
								loopIsComp = true;
							}
							else{
								loopIsComp = false;
							}
						}

						// one point and two points
						if ((row==0 && column==0) || (row==9 && column==0)){
							if (ocean.isOccupied(row,column+length)==false){
								twoIsEmpty=true;
							}
							else{
								twoIsEmpty=false;
							}
						}
						else if((row==0&&column==10-length) || (row==9&&column==10-length)){
							if (ocean.isOccupied(row,column-1)==false){
								twoIsEmpty=true;
							}
							else{
								twoIsEmpty=false;
							}
						}
						else{// two points
							if (ocean.isOccupied(row, column-1)==false && ocean.isOccupied(row,column+length)==false){
								twoIsEmpty=true;
							}
							else{
								twoIsEmpty=false;
							}
						}
					}

					////////////////////////////////////////// to be fixed condition 3 and 4

					// condition 3 (column==0)
					else if((column==0 && row!=0 && row!=9)){
						// The two rows for loop complete (row-1 and row+1) two sides
						for (int j=column;j<=column+length;j++){
							if (ocean.isOccupied(row-1, j)==false && ocean.isOccupied(row+1, j)==false){
								counter+=1;
							}

							else{
								counter+=0;
							}
						}

						if (counter==length+1){
							loopIsComp = true;
						}
						else{
							loopIsComp = false;
						}

						// The one positions should be empty. 
						if (ocean.isOccupied(row,column+length)==false){
							twoIsEmpty=true;
						}
						else{
							twoIsEmpty=false;
						}
					}

					// condition 3 (column==10-length)
					else if ((column==10-length && row!=0 && row!=9)){

						for (int j=column-1;j<column+length;j++){
							if (ocean.isOccupied(row-1, j)==false && ocean.isOccupied(row+1, j)==false){
								counter+=1;
							}

							else{
								counter+=0;
							}
						}

						if (counter==length+1){
							loopIsComp = true;
						}
						else{
							loopIsComp = false;
						}

						// The one positions should be empty. 
						if (ocean.isOccupied(row, column-1)==false){
							twoIsEmpty=true;
						}
						else{
							twoIsEmpty=false;
						}
					}

					// condition 4 (normal condition)
					else{
						// The two positions should be empty
						if (ocean.isOccupied(row, column-1)==false && ocean.isOccupied(row,column+length)==false){
							twoIsEmpty=true;
						}
						else{
							twoIsEmpty=false;
						}

						// The two rows for loop complete (row-1 and row+1)
						// create array to record the occupation

						for (int j=column-1;j<=column+length;j++){
							if (j>=0 && j<=9){
								if (ocean.isOccupied(row-1, j)==false && ocean.isOccupied(row+1, j)==false){
									counter+=1;
								}
							}
							else{

							}
						}

						if (counter==length+2){
							loopIsComp = true;
						}
						else{
							loopIsComp = false;
						}

					}
				}

				else{
					System.out.println("Invalid (out of bound or itself has ship already)");
					//System.out.println("itselfEmpty: "+itselfEmpty);
					return false;
				}
				// return the total boolean
				if (itselfEmpty==true && notExceed==true && loopIsComp==true && twoIsEmpty == true){
					return true;
				}

				else{
					return false;
				}

			}

			// vertical ship situation --> 
			else{
				// make sure that the ship didn't exceed the array
				if (row<=10-length){
					notExceed = true;
				}
				else{
					notExceed = false;
				}

				// make sure [row][column] not occupy any thing
				if(notExceed == true){
					for (int x=0; x<length; x++){
						if (ocean.isOccupied(row+x, column)==false){
							counterEmpty+=1;
						}
						else{
							break;
						}
					}

					if (counterEmpty==length){
						itselfEmpty=true;
					}
					else if (counterEmpty<length){
						itselfEmpty = false;
					}

					else{
						System.out.println("Impossible situation.");
					}
				}
				else{
					return false;
				}

				if (notExceed==true && itselfEmpty==true){

					if (column==0 || column==9){//1
						if ((column==0 && row==0) || (column==9 && row==0) ){// 1

							// one side
							for (int a=row;a<=row+length;a++){
								if (column==0){
									if (ocean.isOccupied(a, column+1)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
								else{ // column==9
									if (ocean.isOccupied(a, column-1)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
							}

							if (counter==length+1){
								loopIsComp = true;
							}
							else{
								loopIsComp = false;
							}

						}

						else if ((column==0 && row==10-length) || (column==9 && row==10-length)){

							// one side
							for (int a=row-1;a<row+length;a++){
								if (column==0){
									if (ocean.isOccupied(a, column+1)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
								else{ // column==9
									if (ocean.isOccupied(a, column-1)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
							}

							if (counter==length+1){
								loopIsComp = true;
							}
							else{
								loopIsComp = false;
							}

						}


						else{// 2
							// one side
							for (int a=row-1;a<=row+length;a++){
								if (column==0){
									if (ocean.isOccupied(a, column+1)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
								else{ // column==9
									if (ocean.isOccupied(a, column-1)==false){
										counter+=1;
									}
									else{
										counter+=0;
									}
								}
							}

							if (counter==length+2){
								loopIsComp = true;
							}
							else{
								loopIsComp = false;
							}
						}

						// one point and two points
						// 1 condition
						if ((column==0 && row==0) || (column==9 && row==0)){
							if (ocean.isOccupied(row+length,column)==false){
								twoIsEmpty=true;
							}
							else{
								twoIsEmpty=false;
							}
						}
						// 1 condition
						else if((column==0 && row==10-length) || (column==9 && row==10-length)){
							if (ocean.isOccupied(row-1,column)==false){
								twoIsEmpty=true;
							}
							else{
								twoIsEmpty=false;
							}
						}

						else{// two points  ,2 condition
							if (ocean.isOccupied(row-1, column)==false && ocean.isOccupied(row+length,column)==false){
								twoIsEmpty=true;
							}
							else{
								twoIsEmpty=false;
							}
						}
					}

					//-----------------------------------------------------

					// condition 3 (row==0)
					else if((row==0 && column!=0 && column!=9)){
						// The two rows for loop complete (row-1 and row+1) two sides
						for (int j=row;j<=row+length;j++){
							if (ocean.isOccupied(j, column-1)==false && ocean.isOccupied(j, column+1)==false){
								counter+=1;
							}

							else{
								counter+=0;
							}
						}

						if (counter==length+1){
							loopIsComp = true;
						}
						else{
							loopIsComp = false;
						}

						// The one positions should be empty. 
						if (ocean.isOccupied(row+length,column)==false){
							twoIsEmpty=true;
						}
						else{
							twoIsEmpty=false;
						}
					}

					// condition 3 (row==10-length)
					else if ((row==10-length && column!=0 && column!=9)){

						for (int j=row-1;j<row+length;j++){
							if (ocean.isOccupied(j, column-1)==false && ocean.isOccupied(j, column+1)==false){
								counter+=1;
							}

							else{
								counter+=0;
							}
						}

						if (counter==length+1){
							loopIsComp = true;
						}
						else{
							loopIsComp = false;
						}

						// The one positions should be empty. 
						if (ocean.isOccupied(row-1, column)==false){
							twoIsEmpty=true;
						}
						else{
							twoIsEmpty=false;
						}
					}
					///////////////////////should be fixed
					// condition 4 (normal condition)
					else{
						// The two positions should be empty
						if (ocean.isOccupied(row-1, column)==false && ocean.isOccupied(row+length,column)==false){
							twoIsEmpty=true;
						}
						else{
							twoIsEmpty=false;
						}

						// The two rows for loop complete (row-1 and row+1)
						// create array to record the occupation

						for (int j=row-1;j<=row+length;j++){
							if (j>=0 && j<=9){
								if (ocean.isOccupied(j, column-1)==false && ocean.isOccupied(j, column+1)==false){
									counter+=1;
								}
							}
							else{

							}
						}

						if (counter==length+2){
							loopIsComp = true;
						}
						else{
							loopIsComp = false;
						}

					}
				}

				else{
					System.out.println("Invalid (out of bound or itself has ship already)");
					//System.out.println("itselfEmpty: "+itselfEmpty);

					return false;
				}
				// return the total boolean
				if (itselfEmpty == true && notExceed==true && loopIsComp==true && twoIsEmpty == true){
					return true;
				}

				else{
					return false;
				}

			}
		}

		else{
			return false;
		}
	}

	/**
	 * This method can put ship in the ocean. 
	 * And involves the following parameters.
	 * Must refer to the whole ship.
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){

		if (horizontal==true){
			this.setBowRow(row);
			this.setBowColumn(column);
			this.horizontal = horizontal;
			for(int p=0;p<length;p++){
				ocean.ships[row][column+p] = this;
			}
		}
		else{ // vertical situation
			this.setBowRow(row);
			this.setBowColumn(column);
			this.horizontal = horizontal;
			for(int q=0;q<length;q++){
				ocean.ships[row+q][column] = this;
			}
		}

	}

	/**
	 * This method would return true if a part of the ship([row][column]) was hit but not sunk
	 * return false otherwise
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){

		boolean isOccupy = false;
		boolean sunk = true;
		int posInShip = 0;
		int counter2 = 0;

		// categorize horizontal or not
		if (this.horizontal==true){

			// (1) a part of the ship occupy at [row][column]
			for (int x=0;x<length;x++){
				if (this.bowRow==row && this.bowColumn+x==column){
					isOccupy = true;
					break;
				}
				else{
					isOccupy = false;
				}
				posInShip += 1;
			}
			// (2)the ship hasn't been sunk
			for (int y=0; y<length;y++){

				if (hit[y]==true){
					
					counter2 += 1;
				}
				else{
					counter2 += 0;
				}
			}

			if (counter2==length){
				sunk = true;
			}
			else if (counter2<length){
				sunk = false;
			}
			else{
				System.out.println("Impossible situation.");
			}

			// The above two condition fit--> mark that part of the ship "hit" and return true
			if (isOccupy==true && sunk==false){
				// when x = 0 --> means the bow
				
				this.hit[posInShip]=true;

				return true;
			}

			// Any of the two conditions is not true, then return false
			else{

				return false;
			}
		}

		else{ // vertical
			// (1) a part of the ship occupy at [row][column]
			for (int x=0;x<length;x++){
				if (this.bowRow+x==row && this.bowColumn==column){
					isOccupy=true;
					break;
				}
				else{
					isOccupy=false;
				}
				posInShip += 1;
			}

			// (2)the ship hasn't been sunk
			for (int y=0; y<length;y++){
				if (hit[y]==true){
				
					counter2 += 1;
				}
				else{
					counter2 += 0;
				}
			}

			if (counter2==length){
				sunk = true;
			}
			else if (counter2<length){
				sunk = false;
			}
			else{

				System.out.println("Impossible situation.");
			}

			// The above two condition fit--> mark that part of the ship "hit" and return true
			if (isOccupy==true && sunk==false){
				// when x = 0 --> means the bow
				this.hit[posInShip]=true;

				return true;
			}

			// Any of the two conditions is not true, then return false
			else{


				return false;
			}
		}

	}

	/**
	 * This method return true if every part of the ship has been hit
	 * false otherwise
	 * 
	 * @return
	 */
	public boolean isSunk(){
		int counter3 = 0;

		for (int h=0; h<length;h++){
			if (hit[h]==true){
				counter3 += 1;
			}
			else{
				counter3 += 0;
			}
		}

		if (counter3==length){
			return true;
		}

		else {
			return false;
		}


	}
	public void set(int i, int j){
		currentr = i;
		currentc = j;
	}



	/**
	 * This method should only be used at the location that has been shot 
	 * Not at the location that hasn't been shot
	 */
	@Override
	public String toString(){
		// (1) return X if the ship has been sunk
		// (2) return S if the ship has not been sunk
		if(this.isSunk())
			return "x";
		return "S";


		//		int counter4 = 0;
		//		String charPrint = "";
		//
		//		
		//		
		//		for (int z=0; z<length; z++){
		//			if (this.hit[z]==true){
		//				counter4 += 1;
		//			}
		//			else{
		//				counter4 += 0;
		//			}
		//		}
		//		
		//
		//		// X or S
		//		if (counter4 == length){
		//			charPrint = "x";
		//			//System.out.println("x situation");
		//		}
		//		else if(counter4>0 && counter4<length){
		//			
		//			for(int x =0; x < length; x++){
		//				if( currentc  == x + this.bowColumn){
		//					System.out.println("currentc " + currentc  + " currentr " + currentr);
		//					System.out.println("i am here " + currentc  + " " + x + " " + this.bowColumn);
		//					charPrint = "S";
		//					break;
		//				}
		//					
		//			
		//			}
		//			
		//			//System.out.println("S situation");
		//		}
		//		else{ // counter4==0 or counter4>length
		//			//charPrint = ".";
		//			System.out.println("This method should not be used to print locations that have not been shot at.");
		//		}
		//		
		//	
		//		
		//		
		//		return charPrint;


	}





}