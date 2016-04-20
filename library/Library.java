
package library;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Library {

	// Declare instance variables
	private boolean okToPrint;
	public HashMap<String,Patron> LibMap;
	public ArrayList<Book> readBook;
	public boolean isOpen;
	public static boolean jump;
	public static String PName;
	public static ArrayList<Book> Returnn;
	public static String searchPeople;
	public Calendar myCalendar;


	// constructors
	/**
	 * First constructor
	 * used by main method
	 */
	public Library(){
		this.okToPrint = true;
		// create empty HashMap<String, Patron> <key,value>
		// key: name of patrons
		// value: corresponding Patron objects
		this.LibMap = new HashMap<String, Patron>();
		this.readBook = readBookCollection();
		this.isOpen = false;
		Library.jump = true;
		Library.PName = null;
		Library.Returnn = new ArrayList<Book>();
		Library.searchPeople = null;
		this.myCalendar = new Calendar();

	}

	/**
	 * Second constructor
	 * @param collection
	 */
	public Library(ArrayList<Book> collection){
		this.okToPrint = false;
		this.LibMap = new HashMap<String, Patron>();
		this.readBook = collection;
		this.isOpen = false;
		Library.jump = true;
		Library.PName = null;
		Library.Returnn = new ArrayList<Book>();
		Library.searchPeople = null;
		this.myCalendar = new Calendar();

	}

	/**
	 * This method returns the data in books.txt
	 * @return collection
	 */
	private ArrayList<Book> readBookCollection() {
		File file = new File("books.txt");
		ArrayList<Book> collection = new ArrayList<Book>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			while (true) {
				String line = reader.readLine();
				if (line == null) break;
				line = line.trim();
				if (line.equals("")) continue; // ignore possible blank lines
				String[] bookInfo = line.split(" :: ");
				collection.add(new Book(bookInfo[0], bookInfo[1]));
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return collection;
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		Library library1 = new Library();
		
		
		while(jump){
			library1.start();
		}
		
		
		/*Patron wei = new Patron("wei",library1);
		System.out.println("first book is: "+library1.readBook.get(0));
		// remove book1
		System.out.println(library1.readBook.remove("1984, George Orwell"));
		System.out.println(library1.readBook.contains("1984, George Orwell"));
		//System.out.println(library1.readBook.remove(0));*/
	}



	/**
	 * This method will read commands from the user
	 * such as open or search "saga"
	 * call the corresponding method and print the noDuplicates
	 * 
	 * [Notice]
	 * It should be denoted that every command should include
	 * programming about whether individual command was executed
	 * successfully, unsuccessfully or illegal.
	 */
	public void start(){

		String SucMsg = "Executed successfully";
		String UnsucMsg = "Executed unsuccessfully";
		String IllegalOp = "Illegal Operation";


		// call the command (from 1 to 8)
		System.out.println("Enter the command.");
		System.out.println("1. open");
		System.out.println("2. issueCard Patron's name");
		System.out.println("3. serve Patron's name");
		System.out.println("4. checkIn Book numbers");
		System.out.println("5. search search string");
		System.out.println("6. checkOut Book numbers");
		System.out.println("7. close");
		System.out.println("8. quit");


		Scanner scanner = new Scanner(System.in);
		int command = scanner.nextInt();
		//scanner.close();


		//open the library in the morning
		if (command==1){
			// advance the date (execute open method)
			open();
			println(SucMsg);
		}

		//Issue a library card
		else if (command==2){
			// isOpen should be true --> successful condition
			if (isOpen==true){
				// issueCard
				// record Patron's name in HashMap (confirm that the patron doesn't have a lib card.
				// ask this Patron's name
				println("Patron's name?");
				Scanner sc1 = new Scanner(System.in);
				String issuePatron = sc1.nextLine();
				//sc1.close();

				boolean haveCard = LibMap.containsKey(issuePatron);
				if (haveCard== false){

					// execute issueCard return patron
					Patron IssuedPatron = issueCard(issuePatron);

					println(SucMsg);
				}
				else{
					println("Sorry, this patron already have a library card.");
					println(IllegalOp);
				}
			}

			else{
				println("The library is closed.");
				println(UnsucMsg);
			}
		}

		// serve Patron's name
		else if (command==3){
			/**
			 *  isOpen should be true 
			 *  and should issueCard already
			 *  --> successful condition
			 */
			//String servingNow = PName;
			if (isOpen==true){

				//ask this patron's name
				println("Patron's name?");
				Scanner sc2 = new Scanner(System.in);
				String servingNow = sc2.nextLine();
				//sc2.close();

				// check whether this Patron is in the HashMap
				boolean isIssued = LibMap.containsKey(servingNow);
				if (isIssued==true){
					// execute serve --> return Patron object
					PName = servingNow;
					Patron myPatron = serve(PName);

					// Print number of list of books currently check out(PatronList)


					println(SucMsg);

				}
				else{
					println("Sorry, this patron doesn't have a library card.");
					println(IllegalOp);
				}
			}
			else{
				println("The library is closed");
				println(UnsucMsg);
			}
		}

		else if (command==4){

			if (isOpen==true){
				if(LibMap.containsKey(PName)==true && PName!=null){

					// List PatronList
					//Patron myPatron = serve(PName);


					// ask myPatron which books should return
					ArrayList<Integer> turnLst = new ArrayList<Integer>();

					ArrayList<Integer> checkInLst = new ArrayList<Integer>();
					HashMap<Integer,Book> PatrMap = new HashMap<Integer,Book>();
					for (int j=0;j<serve(PName).PatronList.size();j++){
						PatrMap.put(j, serve(PName).PatronList.get(j));
					}

					int TurnNo = 1;
					while(TurnNo!=0){

						println("Which book you want to checkin? (Type the number before the Book's title.)");

						for (int key: PatrMap.keySet()){
							String StrKey = Integer.toString(key+1);
							println(StrKey+". "+PatrMap.get(key).title+", "+PatrMap.get(key).author);
						}
						println("Please enter the number one by one.");
						println("Enter 0 means no more book to be checkin.");

						Scanner sc4 = new Scanner(System.in);
						TurnNo = sc4.nextInt();
						//sc4.close();

						if (TurnNo>0 && TurnNo<=serve(PName).PatronList.size() && checkInLst.contains(TurnNo)==false){
							turnLst.add(TurnNo);
							checkInLst.add(TurnNo);
							PatrMap.remove(TurnNo-1);

						}
						else if (TurnNo>0 && TurnNo<=serve(PName).PatronList.size() && checkInLst.contains(TurnNo)==true){
							println("You have already choose this book to return.");
							println(IllegalOp);
						}
						else if (TurnNo>serve(PName).PatronList.size() || TurnNo<0){
							println("The number you enter is wrong.");
							println("Please enter the right book number.");
						}

						else{

						}
					}
					checkIn(turnLst);
					serve(PName).PatronList.clear();
					for (int key: PatrMap.keySet()){
						serve(PName).PatronList.add(PatrMap.get(key));
					}

					println(SucMsg);
				}
				else{
					print("You haven't be served yet. Please asked to be served.");
					println(UnsucMsg);
				}
			}
			else{
				println("The library is closed.");
				println(UnsucMsg);
			}
		}

		// Search key words
		else if (command==5){
			if (isOpen == true){
				if (LibMap.containsKey(PName)==true && PName!=null){

					println("Search if the library has what you want.");
					Scanner sc4 = new Scanner(System.in);
					String words = sc4.nextLine();
					//sc4.close();
					Returnn = search(words);
					searchPeople = PName;
					println(SucMsg);
				}
				else{
					print("You haven't be served yet. Please asked to be served.");
					println(UnsucMsg);
				}
			}
			else{
				println("The library is closed.");
				println(UnsucMsg);
			}
		}
		else if (command==6){

			if (isOpen == true &&  LibMap.containsKey(PName)==true && PName!=null){
				if (searchPeople==PName){

					ArrayList<Integer> bookNums = new ArrayList<Integer>();
					int num = 1;

					ArrayList<Integer> checkLst = new ArrayList<Integer>();
					while(num != 0 ){

						println("Which book to be checked out?(Type the number before the Book's title.)");
						for (int j=0;j<Returnn.size();j++){
							String printTitle = (Returnn.get(j).title);
							String printAuthor = (Returnn.get(j).author);
							int index = j+1;
							String StrIndex = Integer.toString(index);
							println(StrIndex+". "+printTitle+", "+printAuthor);
						}


						println("Please enter the number one by one.");
						println("Enter 0 means no more book to be checked.");

						Scanner sc6 = new Scanner(System.in);
						num = sc6.nextInt();
						//sc6.close();


						if (num>0 && num<=Returnn.size() && checkLst.contains(num)==false){
							bookNums.add(num);
							for(int k:bookNums){
								System.out.println("bookNum "+k);
							}
							checkLst.add(num);
						}
						else if (num>0 && num<=Returnn.size() && checkLst.contains(num)==true){
							println("You have already choose this book to checkout.");
							println(IllegalOp);
						}
						else if (num>Returnn.size() || num<0){
							println("The number you enter is wrong.");
							println("Please enter the right book number.");
						}

						else{

						}
					}
					checkOut(bookNums);
					println(SucMsg);
				}
				else{
					println("You haven't search any book for checking out yet.");
					println(UnsucMsg);
				}
			}
			else{	
				if (isOpen == true){
					if(LibMap.containsKey(PName)!=true && PName!=null){
						println("You haven't been served yet. Please asked to be served and wait in line.");
						println(UnsucMsg);
					}
					else{
						println("You haven't been served yet. Please asked to be served and wait in line.");
						println(UnsucMsg);
					}
				}
				else if (isOpen == false){
					println("The library is closed.");
					println(UnsucMsg);
				}

				println(UnsucMsg);
			}
		}	

		else if (command==7){
			close();
			if (isOpen==false){
				println("Library close.");
				println(SucMsg);
			}
			else{

				println(UnsucMsg);
			}
		}

		else if (command==8){
			// jump out of the loop
			quit();
			println("Out of Money. Library won't open anymore.");
			println(SucMsg);

		}
		else{
			throw new IllegalArgumentException("bad input provided");
		}

		println("\n");
	}

	/**
	 * This method print out the message 
	 * if okToPrint is true.
	 * @param message
	 */
	public void print(String message){
		if (okToPrint==true){
			System.out.print(message);
		}
	}

	/**
	 * This method print out the message 
	 * in System.out.print form
	 * if okToPrint is true.
	 * @param message
	 */
	public void println(String message){
		if (okToPrint==true){
			System.out.println(message);
		}
	}

	/**
	 * Start the day (or start the library)
	 * Send overdue notices to all patrons
	 * Set isOpen true
	 * @return openUpdateList
	 * which calling from createOverdueNotices
	 */
	public ArrayList<OverdueNotice> open(){

		// Start the day by advancing calendar
		myCalendar.advance();
		println("Today is "+myCalendar.getDate());

		// send overdue notices to all patrons (call createOverDueNotice and "print" the results)
		ArrayList<OverdueNotice> openUpdateList = new ArrayList<OverdueNotice>();

		// call createOverdueNotices
		openUpdateList = createOverdueNotices();

		// print the results
		println("This is today's overdue notices");
		for (int y=0; y<openUpdateList.size();y++){

			String EachDueYes = openUpdateList.get(y).toString();
			println("Patron name: "+openUpdateList.get(y).patron.name+", "+"Overdue Notice: \n"+EachDueYes);

		}

		// set an instance variable to indicate the library is now open
		isOpen=true;

		// returns the ArrayList openUpdateList got from call createOverdueNotice
		return openUpdateList;
	}


	/**
	 * This method checks each Patron to see whether
	 * he/she has books which were due yesterday
	 * For each such patron, creates and returns a list of 
	 * overdue notices
	 * 
	 * @return OverDueList
	 */
	public ArrayList<OverdueNotice> createOverdueNotices(){

		// Check "each Patron" whether has books due yesterday

		// create an empty OverdueNotice List
		ArrayList<OverdueNotice> OverDueList = new ArrayList<OverdueNotice>();

		// loop through "OverdueNotice object newOverDue" into ArrayList
		int index = 0;
		//String NoticeUsedInOpen = "";

		for (String key: LibMap.keySet()){
			OverdueNotice EachPatrNotice = new OverdueNotice(LibMap.get(key),myCalendar.getDate());
			//NoticeUsedInOpen += EachPatrNotice.toString()+"\n";
			OverDueList.add(index, EachPatrNotice);

			index+=1;
		}



		return OverDueList;

	}

	/**
	 * This method creates a Patron object
	 * save p1 as the value in a HashMap(LibMap)
	 * them returns object Patron p1
	 * @param nameOfPatron
	 * @return p1
	 */
	public Patron issueCard(String nameOfPatron){
		// create a Patron object
		//Library L1 = new Library(); // like Library card for Patron p1?
		Patron p1 = new Patron(nameOfPatron,this);
		System.out.println(this.myCalendar.getDate());

		// save it as the value in a HashMap
		LibMap.put(p1.name,p1);

		return p1;
	}

	/**
	 * This method prepare to serve Patron
	 * @param nameOfPatron
	 * @return ObjectPatron
	 */
	public Patron serve(String nameOfPatron){
		// look up the HashMap(LibMap) for the Patron's name
		Patron ObjectPatron = LibMap.get(nameOfPatron); // get(key) in a HashMap --> return value
		//PName = nameOfPatron;

		return ObjectPatron;
	}

	/**
	 * This method 
	 * @param bookNumbers
	 * @return
	 */
	public ArrayList<Book> checkIn(ArrayList<Integer> bookNumbers){
		println("The person serve now: "+PName);
		ArrayList<Book> checkIn = new ArrayList<Book>();

		HashMap<Integer,Book> PatrMap = new HashMap<Integer,Book>();
		for (int j=0;j<serve(PName).PatronList.size();j++){
			PatrMap.put(j, serve(PName).PatronList.get(j));
		}


		for (int i=0; i < bookNumbers.size(); i++){
			//remove the book from the patron,and add it back to the library.
			//this.readBook.add(serve(PName).getBooks().get(bookNumbers.get(i)-1));

			//Set the book's duedate to be -1.
			this.readBook.get(this.readBook.indexOf(this.serve(PName).getBooks().get(bookNumbers.get(i)-1))).checkIn();
			System.out.println("duedate is " + this.readBook.get(this.readBook.indexOf(serve(PName).getBooks().get(bookNumbers.get(i)-1))).dueDate);
			checkIn.add(serve(PName).getBooks().get(bookNumbers.get(i)-1));
			serve(PName).getBooks().get(bookNumbers.get(i)-1).checkIn();
			PatrMap.remove(bookNumbers.get(i)-1);

		}

		//clear the books that are checked in from patron's hand.
		serve(PName).PatronList.clear();
		for (int key: PatrMap.keySet()){
			serve(PName).PatronList.add(PatrMap.get(key));
		}

		/*for(int i = 0; i<serve(PName).PatronList.size();i++){
        	System.out.println(serve(PName).PatronList.get(i));
        }*/

		for (int w=0;w<checkIn.size();w++){
			System.out.println(checkIn.get(w));
		}

		return checkIn;
	}



	public ArrayList<Book> search(String part){
		HashMap<Book,Integer> result = new HashMap<Book,Integer>();
		//ArrayList<Book> result = new ArrayList<Book>();
		//ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i = 0; i < this.readBook.size(); i++){
			boolean tContained = this.readBook.get(i).getTitle().toLowerCase().contains(part);
			boolean aContained = this.readBook.get(i).getAuthor().toLowerCase().contains(part);
			if((tContained || aContained) && readBook.get(i).dueDate == -1){
				result.put(this.readBook.get(i), this.readBook.indexOf(this.readBook.get(i)));
				// result.add(new Book(this.readBook.get(i).getTitle(), this.readBook.get(i).getAuthor()));
				//index.add(this.readBook.indexOf(this.readBook.get(i)));
			}
		}

		//ArrayList<Book> noDuplicate = new ArrayList<Book>();
		HashMap<Book,Integer> noDuplicate = new HashMap<Book,Integer>();

		for(Book book: result.keySet()){
			boolean duplicate = false;
			for (Book book2: noDuplicate.keySet()){
				if(book.getTitle().equals(book2.getTitle()) && book.getAuthor().equals(book2.getAuthor())){
					duplicate = true;
				}
			}
			if (duplicate == false){
				noDuplicate.put(book, result.get(book));
			}
		}
		ArrayList<Book> Returnn = new ArrayList<Book>();
		Returnn.addAll(noDuplicate.keySet());
		for(int i=0; i<Returnn.size(); i++){ 
			System.out.println(i+1 + ". " + Returnn.get(i));
		}

		return Returnn;
	}


	public ArrayList<Book> checkOut(ArrayList<Integer> bookNumbers){
		println("The person serve now: "+PName);
		ArrayList<Book> checkOut = new ArrayList<Book>();

		//Patron patronNow = serve(PName);
		//Check first if the patron borrowed more than 3 books.
		for (int i=0; i < bookNumbers.size(); i++){
			if (serve(PName).PatronList.size()<3){
				Book book = Returnn.get(bookNumbers.get(i)-1);
				System.out.println(book.getTitle());
				checkOut.add(book);
				this.serve(PName).take(book);
				this.serve(PName).PatronList.get(serve(PName).PatronList.size()-1).checkOut(myCalendar.getDate()+7);
				this.readBook.get(this.readBook.indexOf(book)).checkOut(myCalendar.getDate()+7);
			}


			else{
				System.out.println("You can't borrow more than 3 books.");
			}

		}


		for (Book item:checkOut){
			Returnn.remove(item);
		}

		//noDuplicate.clear();


		for(int k=0;k<checkOut.size();k++){
			String checkOutTitle = checkOut.get(k).title;
			String checkOutAuth = checkOut.get(k).author;
			int indexCheckOut = k+1;
			String StrIndexCO = Integer.toString(indexCheckOut);
			println(StrIndexCO+". "+checkOutTitle+", "+checkOutAuth);

		}

		return checkOut;

	}



		/**
		 * Shut down operations and go home for the night
		 * None of the other operations(except quite) 
		 * can be used when the library is closed.
		 */
		public void close(){
			isOpen = false; // command 2~6 cannot be executed successfully
			this.searchPeople = null;
			this.Returnn = null;
			this.PName = null;
		}

		/**
		 * End the program 
		 * return nothing
		 */
		public void quit(){
			jump=false;
		}

	}
