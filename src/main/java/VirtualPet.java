
public class VirtualPet {

	private String name;
	private int hunger = 10;

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

	public void feedMeal() {
		this.hunger = 0;

	}

	public void feedSnack() {
		this.hunger = this.hunger - 2;
		if (this.hunger < 0) {
			this.hunger = 0;
		}

	}

}
