
public class OrganicDog extends OrganicPet implements Walkable {

	public OrganicDog(String name) {
		super(name, "Organic Dog");
	}

	public int getHowMuchPoopInCage() {
		return getSoilRate();
	}

	@Override
	public void walk() {
		putSoilRateToZero();
	}

}
