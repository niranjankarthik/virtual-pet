import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrganicCatTest {

	@Test
	public void shouldHaveOrganicCat() {
		OrganicCat underTest = new OrganicCat(null);
	}
	
	@Test
	public void shouldHaveSpeciesOrganicCat() {
		OrganicCat underTest = new OrganicCat(null);
		String nameSpecies = underTest.getSpecies();
		assertEquals("Organic Cat", nameSpecies);
	}
	
	@Test
	public void shouldHaveAttributeHowMuchPoopInLitterBoxDefaultValue5() {
		OrganicCat underTest = new OrganicCat(null);
		int poopInLitterBox = underTest.getHowMuchPoopInLitterBox();
		assertEquals(5, poopInLitterBox);
	}
	
	@Test
	public void shouldHaveAttributeHowMuchPoopInLitterBoxOf6AfterTick() {
		OrganicCat underTest = new OrganicCat(null);
		underTest.tick();
		int poopInLitterBox = underTest.getHowMuchPoopInLitterBox();
		assertEquals(6, poopInLitterBox);
	}
	@Test
	public void shouldBeAbleToCleanCatLitterWhichMakePoopInLitterBoxToZero() {
		OrganicCat underTest = new OrganicCat(null);
		int poopInLitterBox = underTest.getHowMuchPoopInLitterBox();
		underTest.cleanLitterBox();
		int poopInLitterBoxAfterClean = underTest.getHowMuchPoopInLitterBox();
		assertEquals(0, poopInLitterBoxAfterClean);
	}
	
}
