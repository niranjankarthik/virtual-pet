import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrganicCatTest {

	@Test
	public void shouldHaveOrganicCat() {
		OrganicCat underTest = new OrganicCat(null, null);
		
	}
	
	@Test
	public void shouldHaveSpeciesOrganicCat() {
		OrganicCat underTest = new OrganicCat(null, null);
		String nameSpecies = underTest.getSpecies();
		assertEquals("organicCat", nameSpecies);
	}
	
	
	
	
	
}
