
public abstract class VirtualPet {

	private String name;
	private boolean boredom;
	private int boredomCounter;
	private boolean ownership;
	private String species;
	private int age;



	public VirtualPet(String name, String species, int age) {
		this.name = name;
		this.boredom = true;
		this.boredomCounter = 6;
		this.ownership = true;
		this.species = species;
		this.age = age;
	}
	public VirtualPet(String name, String species) {
		this.name = name;
		this.boredom = true;
		this.boredomCounter = 6;
		this.ownership = true;
		this.species = species;
		this.age = 0;
	}

	public String getName() {
		return this.name;
	}

	public boolean getBoredom() {
		return boredom;
	}

	public int getBoredomCounter() {
		return boredomCounter;	
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

	public void play() {
		this.boredom = false;
		this.boredomCounter -= 3;
		if (this.boredomCounter < 0) {
			this.boredomCounter = 0;		
		}
	}

	public void tick() {	
//		this.hunger += 10;
//		this.thirst += 20;
		this.boredomCounter += 1;
		if(this.boredomCounter > 10) {
			this.boredomCounter = 10;
		}
//		if(this.thirst > 100) {
//			this.thirst = 100;
//		}
//		if(this.hunger > 100) {
//			this.hunger = 100;
//		}
	}

	public void sendPetToShelter() {
		this.ownership = false;
	}

	public void incrementAge() {
		age ++;
		
	}

}