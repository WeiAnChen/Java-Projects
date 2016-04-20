package battleship;

public class Battleship extends Ship {
	// describe a ship of length 4
	
	public Battleship() {
		
		this.length = 4;
		this.hit[0] = false;
		this.hit[1] = false;
		this.hit[2] = false;
		this.hit[3] = false;
		
	}

	@Override
	public String getShipType() {
		String shipType = "Battleship";
		
		return shipType;
	}
	
	

	

}
