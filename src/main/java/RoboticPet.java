
public class RoboticPet extends VirtualPet{

	private int oil;

	public RoboticPet(String name, String species) {
		super(name, species);
		this.oil = 50;
	}
	
	public RoboticPet(String name, String species, int age) {
		super(name, species, age);
		this.oil = 50;
	}

	public int getOil() {
		return oil;
	}

	public void addOil() {
		oil += 25;
		if(oil > 100) {
			oil = 100;
		}
	}
	
	@Override
	public void tick() {
		oil -= 3;
	}
}
