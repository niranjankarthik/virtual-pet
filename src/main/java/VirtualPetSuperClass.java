
public class VirtualPetSuperClass {

	protected String name;
	protected boolean boredom;
	protected int boredomCounter;
	protected boolean ownership;
	protected String species;
	protected int age;

	public VirtualPetSuperClass() {
		super();
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