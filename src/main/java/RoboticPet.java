
public class RoboticPet extends VirtualPet implements Walkable {

	private int oilValue;
	private int maintenanceHealth;

	public RoboticPet(String name, String species) {
		super(name, species);
		this.oilValue = 50;
		this.maintenanceHealth = 50;
	}

	public RoboticPet(String name, String species, int age) {
		super(name, species, age);
		this.oilValue = 50;
		this.maintenanceHealth = 50;
	}

	public int getOilValue() {
		if (oilValue > 100) {
			oilValue = 100;
		}
		if (oilValue < 0) {
			oilValue = 0;
		}
		return oilValue;
	}

	public void addOil() {
		oilValue += 25;
	}

	@Override
	public void tick() {
		oilValue -= 2;
		maintenanceHealth -= 3;
	}

	@Override
	public void walk() {
		maintenanceHealth -= 10;
		oilValue -= 10;
	}

	public int getMaintenanceHealth() {
		if (maintenanceHealth < 0) {
			maintenanceHealth = 0;
		}
		return maintenanceHealth;
	}

	public void doMaintenance() {
		maintenanceHealth = 100;
	}
}
