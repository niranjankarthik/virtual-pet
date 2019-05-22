import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
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
		String expectedName = underTest.virtualPetsMap.get("Fred").getName();
		assertEquals("Fred", expectedName);
	}
	@Test
	public void shoudlBeAbleToGetPetLawrenceNameFromTheShelter() {
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		String expectedName = underTest.virtualPetsMap.get("Lawrence").getName();
		assertEquals("Lawrence", expectedName);
	}
	@Test
	public void shouldBeAbleToGetFredTheDogSpeciesFromTheShelter() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Dog"));		
		String expectedSpecies = underTest.virtualPetsMap.get("Fred").getSpecies();
		assertEquals("Dog", expectedSpecies);
	}
	@Test
	public void shouldBeAbleToAddThreePetsToTheShelterAndCheckPetsMapSize() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new VirtualPet("Matt", "Dog"));
		int expectedNumberOfPets = underTest.virtualPetsMap.size();
		assertEquals(3, expectedNumberOfPets);
	}
	@Test
	public void shouldBeAbleToCheckFredHunger() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		int expectedHunger = underTest.virtualPetsMap.get("Fred").getHunger();
		assertEquals(10, expectedHunger);
	}
	@Test
	public void shouldBeAbleToReturnAArrayWithAllPetName() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new VirtualPet("Matt", "Dog"));
		ArrayList<String> actualAllNames = underTest.getAllNames();
		assertThat(actualAllNames, containsInAnyOrder("Matt","Fred","Lawrence"));
	}
	@Test
	public void shouldBeAbleToPullAllAttributesForSpecifedPetFredToListArray(){
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new VirtualPet("Matt", "Dog"));
		ArrayList<String> petAttributes = underTest.getPetAttributes("Fred");
		ArrayList<String> expectedPetAttributes = new ArrayList<String>();
		expectedPetAttributes.add("Fred");
		expectedPetAttributes.add("Cat");
		expectedPetAttributes.add("10");
		expectedPetAttributes.add("true");
		expectedPetAttributes.add("10");
		expectedPetAttributes.add("6");
		expectedPetAttributes.add("true");
		assertThat(petAttributes, is(expectedPetAttributes));
	}
	
}