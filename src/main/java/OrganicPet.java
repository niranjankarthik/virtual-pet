
public class OrganicPet extends VirtualPet {


	
	private int hunger;
	private int thirst;
	private boolean rabiesStatus;
	private int soilRate;
	


	public OrganicPet(String name, String species) {
		this.name = name;
		this.species = species;
		this.hunger = 10;
		this.thirst = 10;
		this.boredomCounter = 6;
		this.ownership = true;
		this.soilRate =5;

	}
	public OrganicPet(String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.hunger = 10;
		this.thirst = 10;
		this.boredomCounter = 6;
		this.ownership = true;
		
	}
	public int getHunger() {
		return this.hunger;
	}

	public boolean getBoredom() {
		if(boredomCounter > 5) {
			return true;
		}else {
			return false;
		}
	}
	public int getThirst() {
		return thirst;
	}
	public String getName() {
		return this.name;
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

	public void feedMeal() {
		this.hunger = 0;
	}
	public void feedSnack() {
		this.hunger -= 2;
		if (this.hunger < 0) {
			this.hunger = 0;
		}
	}
	public void giveDrink() {
		this.thirst = 0;
	}

	public void play() {
//		this.boredom = false;
		this.boredomCounter -= 3;
		if (this.boredomCounter < 0) {
			this.boredomCounter = 0;		
		}
	}
	public void tick() {	
		this.hunger += 10;
		this.thirst += 20;
		this.soilRate ++;
		this.boredomCounter += 1;
		if(this.boredomCounter > 10) {
			this.boredomCounter = 10;
		}
		if(this.thirst > 100) {
			this.thirst = 100;
		}
		if(this.hunger > 100) {
			this.hunger = 100;
		}
	}
	public void sendPetToShelter() {
		this.ownership = false;
	}

	public void contractRabies() {
		this.rabiesStatus = true;
	}
	public boolean getRabiesStatus() {
		return rabiesStatus;
	}

	public void incrementAge() {
		age ++;
		
	}
	public int getSoilRate() {
		return soilRate;
	}
	public void walk() {
		this.soilRate = 0;
		
	}

	
	
}
