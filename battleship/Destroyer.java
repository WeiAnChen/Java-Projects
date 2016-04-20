package battleship;

public class Destroyer extends Ship {
	// Describe a ship of length 2

	public Destroyer() {
		this.length = 2;
		this.hit[0] = false;
		this.hit[1] = false;
		
	}

	@Override
	public String getShipType() {
		String shipType = "Destroyer";
		return shipType;
	}

}
