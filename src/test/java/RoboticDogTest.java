import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoboticDogTest {

	@Test
	public void roboticDogShouldExist() {
		RoboticDog underTest = new RoboticDog(null);
	}
	
	@Test
	public void roboticDogSpeciesShouldBeRoboticDog() {
		RoboticDog underTest = new RoboticDog(null);
		String nameSpecies = underTest.getSpecies();
		assertEquals("Robotic Dog", nameSpecies);
	}
}
