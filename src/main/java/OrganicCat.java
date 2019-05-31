
public class OrganicCat extends OrganicPet {

	public OrganicCat(String name) {
		super(name, "Organic Cat");
	}

	public int getHowMuchPoopInLitterBox() {
		return getSoilRate();
	}

	public void cleanLitterBox() {
		putSoilRateToZero();
	}

}
