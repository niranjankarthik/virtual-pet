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
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Dog"));
	}
	@Test
	public void shouldBeAbleToGetFredNameFromTheShelter() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Dog"));		
		String expectedName = underTest.getPetName("Fred");
		assertEquals("Fred", expectedName);
	}
	@Test
	public void shoudlBeAbleToGetPetLawrenceNameFromTheShelter() {
		underTest.addOrganicPetToShelter(new OrganicPet("Lawrence", "Dog"));
		String expectedName = underTest.getPetName("Lawrence");
		assertEquals("Lawrence", expectedName);
	}
	@Test
	public void shouldBeAbleToGetFredTheDogSpeciesFromTheShelter() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Dog"));		
		String expectedSpecies = underTest.getPetSpecies("Fred");
		assertEquals("Dog", expectedSpecies);
	}
	@Test
	public void shouldBeAbleToAddThreePetsToTheShelterAndCheckPetsMapSize() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.addOrganicPetToShelter(new OrganicPet("Lawrence", "Dog"));
		underTest.addOrganicPetToShelter(new OrganicPet("Matt", "Dog"));
		int expectedNumberOfPets = underTest.getHowManyPets();
		assertEquals(3, expectedNumberOfPets);
	}
	@Test
	public void shouldBeAbleToCheckFredHunger() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		int expectedHunger = underTest.getPetHunger("Fred");
		assertEquals(10, expectedHunger);
	}
	@Test
	public void shouldBeAbleToReturnAArrayWithAllPetName() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.addOrganicPetToShelter(new OrganicPet("Lawrence", "Dog"));
		underTest.addOrganicPetToShelter(new OrganicPet("Matt", "Dog"));
		ArrayList<String> actualAllNames = underTest.getAllNames();
		assertThat(actualAllNames, containsInAnyOrder("Matt","Fred","Lawrence"));
	}
	
	@Test
	public void shouldPutFredIntoShelterAndShouldBeAbleToGetFredAndFredsStats() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		VirtualPet resultPet = underTest.getSinglePet("Fred");
		assertThat("Fred", is(resultPet.getName()));
		assertThat("Cat", is(resultPet.getSpecies()));
		assertThat( true , is(resultPet.getOwnership()));
		
	}
	
	@Test
	public void petSentToShelterShouldNotBeWFedWhenFeedAllSnackMethodIsCalled() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.sendPetToShelter("Fred");
		underTest.feedAllSnackMethod();
		VirtualPet resultPet = underTest.getSinglePet("Fred");
		assertThat(((OrganicPet)resultPet).getHunger(), is(10));
	}
	@Test
	public void petNotSentToShelterShouldNotBeWFedWhenFeedAllSnackMethodIsCalled() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.feedAllSnackMethod();
		VirtualPet resultPet = underTest.getSinglePet("Fred");
		assertThat(((OrganicPet)resultPet).getHunger(), is(8));
	}
	@Test
	public void imJustMessingAroundHere() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.feedPetMeal("Fred");
		int resultHunger = underTest.getPetHunger("Fred");
		assertThat(resultHunger, is(0));
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