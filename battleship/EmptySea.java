package battleship;

public class EmptySea extends Ship {
	// Describe a part of the ocean that doesn't have a ship in it.

	public EmptySea() {
		this.length = 1;
		
		
	}

	@Override
	public String getShipType() {
		String type = "empty";
		return type;
	}
	
	
	/**
	 * This method overrides shootAt method inherited in Ship class
	 * and always return false to indicate that nothing was hit.
	 * Should also update hit[] array
	 * 
	 */
	@Override
	public boolean shootAt(int row, int column){
		hit[0]=true;
		return false;
	}
	
	/**
	 * This method overrides isSunk method inherited in Ship class
	 * and always return false to indicate you didn't sink anything
	 */
	@Override
	public boolean isSunk(){
		return false;
	}
	
	/**
	 * This method should also be used at the locations which was shot at. 
	 */
	@Override
	public String toString(){
		if (hit[0]==true || hit[1]==true || hit[2]==true || hit[3]==true ){
			return "-";
		}
		else{
			return ".";
		}
	}

}
