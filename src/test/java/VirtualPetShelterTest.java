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
		underTest.addPetToShelter(new OrganicPet("Fred", "Dog"));
	}
	@Test
	public void shouldBeAbleToGetFredNameFromTheShelter() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Dog"));		
		String expectedName = underTest.getPetName("Fred");
		assertEquals("Fred", expectedName);
	}
	@Test
	public void shoudlBeAbleToGetPetLawrenceNameFromTheShelter() {
		underTest.addPetToShelter(new OrganicPet("Lawrence", "Dog"));
		String expectedName = underTest.getPetName("Lawrence");
		assertEquals("Lawrence", expectedName);
	}
	@Test
	public void shouldBeAbleToGetFredTheDogSpeciesFromTheShelter() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Dog"));		
		String expectedSpecies = underTest.getPetSpecies("Fred");
		assertEquals("Dog", expectedSpecies);
	}
	@Test
	public void shouldBeAbleToAddThreePetsToTheShelterAndCheckPetsMapSize() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.addPetToShelter(new OrganicPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new OrganicPet("Matt", "Dog"));
		int expectedNumberOfPets = underTest.getHowManyPets();
		assertEquals(3, expectedNumberOfPets);
	}
	@Test
	public void shouldBeAbleToCheckFredHunger() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		int expectedHunger = underTest.getPetHunger("Fred");
		assertEquals(10, expectedHunger);
	}
	@Test
	public void shouldBeAbleToReturnAArrayWithAllPetName() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.addPetToShelter(new OrganicPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new OrganicPet("Matt", "Dog"));
		ArrayList<String> actualAllNames = underTest.getAllNames();
		assertThat(actualAllNames, containsInAnyOrder("Matt","Fred","Lawrence"));
	}
	@Test
	public void shouldBeAbleToPullAllAttributesForSpecifedPetFredToListArray(){
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.addPetToShelter(new OrganicPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new OrganicPet("Matt", "Dog"));
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
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.addPetToShelter(new OrganicPet("Lawrence", "Dog"));
		underTest.addPetToShelter(new OrganicPet("Matt", "Dog"));
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
		ArrayList<ArrayList<String>> allAttributes = underTest.getAllAttributes();
		assertThat(allAttributes, containsInAnyOrder(expectedFredAttributes, expectedLawrenceAttributes, expectedMattAttributes));
	}
	
	@Test
	public void shouldPutFredIntoShelterAndShouldBeAbleToGetFredAndFredsStats() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		VirtualPet resultPet = underTest.getSinglePet("Fred");
		assertThat("Fred", is(resultPet.getName()));
		assertThat("Cat", is(resultPet.getSpecies()));
		assertThat( true , is(resultPet.getOwnership()));
		
	}
	
	@Test
	public void petSentToShelterShouldNotBeWFedWhenFeedAllSnackMethodIsCalled() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.sendPetToShelter("Fred");
		underTest.feedAllSnackMethod();
		OrganicPet resultPet = underTest.getSinglePet("Fred");
		assertThat(resultPet.getHunger(), is(10));
	}
	@Test
	public void petNotSentToShelterShouldNotBeWFedWhenFeedAllSnackMethodIsCalled() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.feedAllSnackMethod();
		OrganicPet resultPet = underTest.getSinglePet("Fred");
		assertThat(resultPet.getHunger(), is(8));
	}
	@Test
	public void imJustMessingAroundHere() {
		underTest.addPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.feedPetMeal("Fred");
		OrganicPet resultPet = underTest.getSinglePet("Fred");
		assertThat(resultPet.getHunger(), is(0));
	}
	
	@Test
	public void organicPetShouldBeAbleToGetDefaultHunger() {
		underTest.addOrganicPetToShelter(new OrganicPet("Hungry", "Dog"));
		int resultHunger = underTest.getPetHunger("Hungry");
		assertThat(resultHunger, is(10));
	}
	
	@Test
	public void roboticPetShouldBeAbleToGetHungerNegOne() {
		underTest.addRoboticPetToShelter(new RoboticPet("Robo", "Dog"));
		int resultHunger = underTest.getPetHunger("Robo");
		assertThat(resultHunger, is(-1));
	}
}