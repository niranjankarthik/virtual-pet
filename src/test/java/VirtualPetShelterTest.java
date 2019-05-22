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
	@Test
	public void shouldBeAbleToReturnAllAttributesOfAllPetsToArrayList() {
		underTest.addPetToShelter(new VirtualPet("Fred", "Cat"));
		underTest.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new VirtualPet("Matt", "Dog"));
		ArrayList<String> expectedFredAttributes = new ArrayList<String>();
		expectedFredAttributes.add("Fred");
		expectedFredAttributes.add("Cat");
		expectedFredAttributes.add("10");
		expectedFredAttributes.add("true");
		expectedFredAttributes.add("10");
		expectedFredAttributes.add("6");
		expectedFredAttributes.add("true");
		ArrayList<String> expectedLawrenceAttributes = new ArrayList<String>();
		expectedLawrenceAttributes.add("Lawrence");
		expectedLawrenceAttributes.add("Dog");
		expectedLawrenceAttributes.add("10");
		expectedLawrenceAttributes.add("true");
		expectedLawrenceAttributes.add("10");
		expectedLawrenceAttributes.add("6");
		expectedLawrenceAttributes.add("true");
		ArrayList<String> expectedMattAttributes = new ArrayList<String>();
		expectedMattAttributes.add("Matt");
		expectedMattAttributes.add("Dog");
		expectedMattAttributes.add("10");
		expectedMattAttributes.add("true");
		expectedMattAttributes.add("10");
		expectedMattAttributes.add("6");
		expectedMattAttributes.add("true");
		ArrayList<ArrayList<String>> expectedAllAttributes = new ArrayList<ArrayList<String>>();
		expectedAllAttributes.add(expectedFredAttributes);
		expectedAllAttributes.add(expectedLawrenceAttributes);
		expectedAllAttributes.add(expectedMattAttributes);
		ArrayList<ArrayList<String>> allAttributes = underTest.getAllAttributes();
		assertThat(allAttributes, containsInAnyOrder(expectedFredAttributes, expectedLawrenceAttributes, expectedMattAttributes));
		
	}
}