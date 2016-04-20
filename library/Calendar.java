package library;

public class Calendar {
	private int date;
	
	
	public Calendar(){
		this.date = 0;
		
	}
	public int getDate(){
		return date;
	}
	public void advance(){
		date++;
	}
	
	public static void main(String[] args){
		Calendar one = new Calendar();
		Calendar two = new Calendar();
		two.advance();
		two.advance();
		System.out.println(one.getDate());
		System.out.println(two.getDate());
		
	}
	

}
