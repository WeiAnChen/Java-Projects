package battleship;

public class Submarine extends Ship {
	// Describe a ship of length 1

	public Submarine() {
		this.length = 1;
		this.hit[0] = false;
	}

	@Override
	public String getShipType() {
		String shipType = "Submarine";
		return shipType;
	}

}
