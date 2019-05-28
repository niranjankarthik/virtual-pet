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
	
	
	
	
	
}
