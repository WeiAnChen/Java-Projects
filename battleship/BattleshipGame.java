package battleship;

import java.util.Scanner;

public class BattleshipGame {

	
	public static void main(String[] args) {
		/*
		 *  set up the game:
		 *  shows 10x10 array of locations
		 */
		boolean restart = true;
		

		while(restart){
			//1. initialize new ocean
			Ocean myOcean = new Ocean();


			// create randomly distributed ocean
			myOcean.placeAllShipsRandomly();
			myOcean.print();


			// when all ship sunk, print out msg that the game is over
			while (myOcean.isGameOver()==false){


				//2. accept shot from the user
				//myOcean.printTest();
				// let user hit the ships by calling out row and column
				Scanner scHitRow = new Scanner(System.in);
				System.out.println("Pleas type in the position which you want to hit at.");
				System.out.println("What's the row number? Type in number from 0 to 9.");
				int inputRow = scHitRow.nextInt();

				Scanner scHitColumn = new Scanner(System.in);
				System.out.println("What's the column number? Type in number from 0 to 9.");
				int inputColumn = scHitColumn.nextInt();

				// hit that position
				myOcean.shootAt(inputRow, inputColumn);


				//3. display result
				boolean hitOrNot = myOcean.isOccupied(inputRow, inputColumn);
				// the computer responds "hit" or "miss"
				if (hitOrNot==true){

					if(myOcean.ships[inputRow][inputColumn].toString()=="S"){
						System.out.println("hit");
					}
					else if (myOcean.ships[inputRow][inputColumn].toString()=="x"){
						System.out.println("hit");
						System.out.println("You just sunk a " + myOcean.ships[inputRow][inputColumn].getShipType());
						myOcean.shipsSunk += 1;
					}

					else{
						
						System.out.println("No such situation. Error!");
					}
				}
				else{
					if (myOcean.ships[inputRow][inputColumn].getShipType()=="empty"){
						System.out.println(myOcean.ships[inputRow][inputColumn].toString());
						System.out.println("miss");
					}
					else{
						System.out.println("Should not print out.");
					}
				}

				//4. after each shot, the computer re-displays the ocean with new information
				myOcean.print();
				System.out.println("Sunk "+myOcean.shipsSunk);

			}

			System.out.println("The game is over. You have sunk all the ships.");

			//5. print final scores
			System.out.println("It is required "+myOcean.getShotsFired()+" shots in total.");
			System.out.println("So, you're score is "+myOcean.getShotsFired());

			//6. ask if user want to play again
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Do you want to play again? true if yes, false if not.");

			boolean answer = sc1.nextBoolean();
			restart = answer;

		}
		System.out.println("Have a good time!");


	}

}

