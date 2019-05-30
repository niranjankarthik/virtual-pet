import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrganicDogTest {

	@Test
	public void shouldHaveOrganicDog() {
		OrganicDog underTest = new OrganicDog(null);
	}
	
	@Test
	public void shouldHaveSpeciesOrganicDog() {
		OrganicDog underTest = new OrganicDog(null);
		String nameSpecies = underTest.getSpecies();
		assertEquals("Organic Dog", nameSpecies);
	}
	
	@Test
	public void shouldHaveAttributeHowMuchPoopInCageDefaultValue5() {
		OrganicDog underTest = new OrganicDog(null);
		int poopInCage = underTest.getHowMuchPoopInCage();
		assertEquals(5, poopInCage);
	}
	
	@Test
	public void shouldHaveAttributeIsPoopInCageIncreaseWithTick() {
		OrganicDog underTest = new OrganicDog(null);
		underTest.tick();
		int poopInCage = underTest.getHowMuchPoopInCage();
		assertEquals(6, poopInCage);	
	}
	
	
	
	
	
	
}
