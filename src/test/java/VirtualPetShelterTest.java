import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest = new VirtualPetShelter();
	
	@Test
	public void shouldBeAbleToAddDogFredToShelter() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Dog"));
	}
	@Test
	public void shouldBeAbleToGetFredNameFromTheShelter() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Dog"));		
		String expectedName = underTest.petsMap.get("Fred").getName();
		assertEquals("Fred", expectedName);
	}
	@Test
	public void shoudlBeAbleToGetPetLawrenceNameFromTheShelter() {
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		String expectedName = underTest.petsMap.get("Lawrence").getName();
		assertEquals("Lawrence", expectedName);
	}
	@Test
	public void shouldBeAbleToGetFredTheDogSpeciesFromTheShelter() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Dog"));		
		String expectedSpecies = underTest.petsMap.get("Fred").getSpecies();
		assertEquals("Dog", expectedSpecies);
	}
	@Test
	public void shouldBeAbleToAddThreePetsToTheShelterAndCheckPetsMapSize() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new VirtualPet("Matt", "Dog"));
		int expectedNumberOfPets = underTest.petsMap.size();
		assertEquals(3, expectedNumberOfPets);
	}
	@Test
	public void shouldBeAbleToCheckFredHunger() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		int expectedHunger = underTest.petsMap.get("Fred").getHunger();
		assertEquals(10, expectedHunger);
	}
}