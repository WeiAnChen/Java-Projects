package battleship;

public class Cruiser extends Ship {
	// Describe a ship of length 3

	public Cruiser() {
		this.length = 3;
		this.hit[0] = false;
		this.hit[1] = false;
		this.hit[2] = false;
		
	}

	@Override
	public String getShipType() {
		String shipType = "Cruiser";
		return shipType;
	}

}
