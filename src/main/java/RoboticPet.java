
public class RoboticPet extends VirtualPet{

	private int oilValue;
	private int maintenanceValue;

	public RoboticPet(String name, String species) {
		super(name, species);
		this.oilValue = 50;
		this.maintenanceValue = 50;
	}
	
	public RoboticPet(String name, String species, int age) {
		super(name, species, age);
		this.oilValue = 50;
		this.maintenanceValue = 50;
	}

	public int getOilValue() {
		if(oilValue > 100) {
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
		maintenanceValue -= 3;
	}

	public int getMaintenanceValue() {
		if(maintenanceValue < 0) {
			maintenanceValue = 0;
		}
		return maintenanceValue;
	}

	public void doMaintenance() {
		maintenanceValue = 100;
	}
}
