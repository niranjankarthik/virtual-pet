
public abstract class VirtualPet {

	private String name;
	private boolean ownership;
	private String species;
	private int age;

	public VirtualPet(String name, String species, int age) {
		this.name = name;
		this.ownership = true;
		this.species = species;
		this.age = age;
	}
	public VirtualPet(String name, String species) {
		this.name = name;
		this.ownership = true;
		this.species = species;
		this.age = 0;
	}

	public String getName() {
		return this.name;
	}

	public boolean getOwnership() {
		return ownership;
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public void tick() {	
		
	}

	public void play() {

	}
	
	public void walk() {
		
	}

	public void sendPetToShelter() {
		this.ownership = false;
	}

	public void incrementAge() {
		age ++;	
	}
	
	
	
	
}