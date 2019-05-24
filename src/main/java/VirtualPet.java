
public class VirtualPet extends VirtualPetSuperClass {

	int hunger;

	int thirst;
	private boolean rabiesStatus;
	public VirtualPet(String name, String species) {
		this.name = name;
		this.species = species;
		this.hunger = 10;
		this.boredom = true;
		this.thirst = 10;
		this.boredomCounter = 6;
		this.ownership = 	true;
	}
	public VirtualPet(String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.hunger = 10;
		this.boredom = true;
		this.thirst = 10;
		this.boredomCounter = 6;
		this.ownership = true;
		
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
		this.hunger = this.hunger - 2;
		if (this.hunger < 0) {
			this.hunger = 0;
		}
	}
	public void giveDrink() {
		this.thirst = 0;
	}
	public void contractRabies() {
		this.rabiesStatus = true;
	}
	public boolean getRabiesStatus() {
		return rabiesStatus;
	}
	
	
}
