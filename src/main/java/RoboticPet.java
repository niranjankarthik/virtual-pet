
public class RoboticPet extends VirtualPet{

	public int oil;
	
	
	public RoboticPet(String name, String species) {
		this.name = name;
		this.species = species;
		this.boredom = true;
		this.boredomCounter = 6;
		this.ownership = true;
		this.oil = 100;
	}
	
	public int getOil() {
		
		return 0;
	}

}
