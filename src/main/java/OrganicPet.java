
public class OrganicPet extends VirtualPet {

	private int hunger;
	private int thirst;
	private boolean rabiesStatus;
	private int soilRate;
	private int boredomCounter;

	public OrganicPet(String name, String species) {
		super(name, species);
		this.boredomCounter = 6;
		this.hunger = 10;
		this.thirst = 10;
		this.soilRate =5;

	}
	public OrganicPet(String name, String species, int age) {
		super(name, species, age);
		this.boredomCounter = 6;
		this.hunger = 10;
		this.thirst = 10;
	}
	
	public boolean getBoredom() {
		if(boredomCounter > 5) {
			return true;
		}else {
			return false;
		}
	}

	public int getBoredomCounter() {
		return boredomCounter;	
	}
	
	public int getHunger() {
		return this.hunger;
	}

	public int getThirst() {
		return thirst;
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

	@Override
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
	
	@Override
	public void play() {
		this.boredomCounter -= 3;
		if (this.boredomCounter < 0) {
			this.boredomCounter = 0;		
		}
	}
	public void contractRabies() {
		this.rabiesStatus = true;
	}
	public boolean getRabiesStatus() {
		return rabiesStatus;
	}
	public int getSoilRate() {
		return soilRate;
	}
	
	@Override
	public void walk() {
		this.soilRate = 0;	
	}
}
