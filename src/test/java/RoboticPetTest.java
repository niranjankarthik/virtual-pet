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
		int testOilValue = underTest.getOilValue();
		assertEquals(50, testOilValue);
	}
	
	@Test
	public void addingOilShouldIncreaseOilValueBy25() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int initialOilValue = underTest.getOilValue();
		underTest.addOil();
		int finalOilValue = underTest.getOilValue();
		assertEquals(initialOilValue + 25, finalOilValue);
	}
	
	@Test
	public void addingOil3xShouldOnlyIncreaseOilValueToMaximumValueOf100() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		underTest.addOil();
		underTest.addOil();
		underTest.addOil();
		int finalOilValue = underTest.getOilValue();
		assertEquals(100, finalOilValue);
	}
	
	@Test
	public void tickShouldDecreaseOilValueBy2() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int initialOilValue = underTest.getOilValue();
		underTest.tick();
		int finalOilValue = underTest.getOilValue();
		assertEquals(initialOilValue - 2, finalOilValue);
	}
	
	@Test
	public void tickShouldNotDecreaseOilBelowZero() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		for(int i = 0; i < 26; i++) {
			underTest.tick();
		}
		int finalOilValue = underTest.getOilValue();
		assertEquals(0, finalOilValue);
	}
	
	@Test
	public void shouldHaveInitialMaintenanceValueOf50() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int testMaintenanceValue = underTest.getMaintenanceHealth();
		assertEquals(50, testMaintenanceValue);
	}
	
	@Test
	public void doMaintenanceShouldIncreaseMaintenanceValueTo100() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		underTest.doMaintenance();
		int testMaintenanceValue = underTest.getMaintenanceHealth();
		assertEquals(100, testMaintenanceValue);
	}
	
	@Test
	public void tickShouldDecreaseMaintenanceByThree() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int initialMaintenanceValue = underTest.getMaintenanceHealth();
		underTest.tick();
		int finalMaintenanceValue = underTest.getMaintenanceHealth();
		assertEquals(initialMaintenanceValue - 3, finalMaintenanceValue);
	}
	
	@Test
	public void tickShouldNotDecreaseMaintenanceBelowZero() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		for(int i = 0; i < 17; i++) {
			underTest.tick();
		}
		int finalMaintenanceHealth = underTest.getMaintenanceHealth();
		assertEquals(0, finalMaintenanceHealth);
	}
	
	@Test
	public void walkingPetShouldDecreaseMaintenanceHealthBy10() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		int initialMaintenanceHealth = underTest.getMaintenanceHealth();
		underTest.walk();
		int finalMaintenanceHealth = underTest.getMaintenanceHealth();
		assertEquals(initialMaintenanceHealth - 10, finalMaintenanceHealth);
	}
	
	@Test
	public void walkingPet6xShouldNotDecreaseMaintenanceHealthAndOilValueBelowZero() {
		RoboticPet underTest = new RoboticPet(null, null, 0);
		underTest.walk();
		underTest.walk();
		underTest.walk();
		underTest.walk();
		underTest.walk();
		underTest.walk();
		int finalOilValue = underTest.getOilValue();
		int finalMaintenanceHealth = underTest.getMaintenanceHealth();
		assertEquals(0, finalMaintenanceHealth);
		assertEquals(0, finalOilValue);
	}
}
