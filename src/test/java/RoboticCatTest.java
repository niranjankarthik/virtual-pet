import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoboticCatTest {

	@Test
	public void roboticCatShouldExist() {
		RoboticCat underTest = new RoboticCat(null);
	}
	
	@Test
	public void roboticCatSpeciesShouldBeRoboticCat() {
		RoboticCat underTest = new RoboticCat(null);
		String nameSpecies = underTest.getSpecies();
		assertEquals("Robotic Cat", nameSpecies);
	}
}
