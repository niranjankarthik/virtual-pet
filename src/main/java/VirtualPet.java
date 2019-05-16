
public class VirtualPet {

	private String name;
	private int hunger = 10;
	private boolean boredom = true;
	private int thirst = 10;
	private int boredomCounter = 6;

	public VirtualPet() {

	}

	public VirtualPet(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	public int getHunger() {
		return this.hunger;
	}
	public boolean getBoredom() {	
		return boredom;
	}
	public int getThirst() {
		return thirst;
	}
	public int getBoredomCounter() {
		return boredomCounter;	
	}
	public void feedMeal() {
		this.hunger = 0;	
	}

	public void feedSnack() {
		this.hunger = this.hunger - 2;
		if (this.hunger < 0) {
			this.hunger = 0;
		}

	}
	public void play() {
		this.boredom = false;

	}

	public void tick() {	
		this.hunger += 10;
		this.thirst += 20;
		this.boredomCounter += 1;

	}

	public void giveDrink() {
		this.thirst = 0;
	}



}
