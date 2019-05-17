
public class VirtualPet {

	private String name;
	private int hunger = 10;

	private boolean boredom = true;

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

}
