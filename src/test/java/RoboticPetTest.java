import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoboticPetTest {

	@Test
	public void roboticPetWithNameAndSpeciesShouldExist() {
		RoboticPet underTest = new RoboticPet(null, null);
	}
	
	@Test
	public void roboticPetWithNameSpeciesAndAgeShouldExist() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
	}
	
	@Test
	public void shouldBeAbleToGetInitialOilValueOf50() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int testOilValue = underTest.getOil();
		assertEquals(50, testOilValue);
	}
	
	@Test
	public void addingOilShouldIncreaseOilValueBy25() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int initialOilValue = underTest.getOil();
		underTest.addOil();
		int finalOilValue = underTest.getOil();
		assertEquals(initialOilValue + 25, finalOilValue);
	}
	
	@Test
	public void addingOil3xShouldOnlyIncreaseOilValueToMaximumValueOf100() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		underTest.addOil();
		underTest.addOil();
		underTest.addOil();
		int finalOilValue = underTest.getOil();
		assertEquals(100, finalOilValue);
	}
}
