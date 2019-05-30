import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest = new VirtualPetShelter();
	
	
	@Before
	public void setUp() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
	}
	
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
		VirtualPet resultPet = underTest.getPet("Fred");
		assertThat("Fred", is(resultPet.getName()));
		assertThat("Cat", is(resultPet.getSpecies()));
		assertThat( true , is(resultPet.getOwnership()));
		
	}
	
	@Test
	public void petSentToShelterShouldNotBeWFedWhenFeedAllSnackMethodIsCalled() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.sendPetToShelter("Fred");
		underTest.feedAllSnack();
		VirtualPet resultPet = underTest.getPet("Fred");
		assertThat(((OrganicPet)resultPet).getHunger(), is(10));
	}
	
	@Test
	public void shouldBeAbleToMaintainMultiplePets() {
		underTest.addRoboticPetToShelter(new RoboticDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("Stan"));
		underTest.maintainAll();
		int Main1 = underTest.getPetMaintenanceHealth("Fred");
		int Main2 = underTest.getPetMaintenanceHealth("Fred");
		assertThat(Main1, is(100));
		assertThat(Main2, is(100));
	}
	
	@Test
	public void petNotSentToShelterShouldNotBeWFedWhenFeedAllSnackMethodIsCalled() {
		underTest.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
		underTest.feedAllSnack();
		VirtualPet resultPet = underTest.getPet("Fred");
		assertThat(((OrganicPet)resultPet).getHunger(), is(8));
	}
	
	@Test
	public void shouldBeAbleToFeedOrganicDogFredMealAndHungerGoesToZero() {
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
	
	@Test
	public void shouldBeAbleToFeedAllPetsMealAndSeeOrganicCatSallyHungerGoToZero() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedAllMeal();
		int sallyHunger = underTest.getPetHunger("Sally");
		assertEquals(0, sallyHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsMealAndSeeOrganicDogFredHungerGoToZero() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedAllMeal();
		int fredHunger = underTest.getPetHunger("Fred");
		assertEquals(0, fredHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsMealAndSeeNothingHappenToRoboticCatRSallyHunger() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedAllMeal();
		int rSallyHunger = underTest.getPetHunger("R Sally");
		assertEquals(-1, rSallyHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsMealAndSeeNothingHappenToRoboticDogRFredHunger() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedAllMeal();
		int rFredHunger = underTest.getPetHunger("R Fred");
		assertEquals(-1, rFredHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedSallySnackAndSeeOrganicCatSallyHungerGoToZero() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedPetMeal("Sally");
		int sallyHunger = underTest.getPetHunger("Sally");
		assertEquals(0, sallyHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedSallySnackAndSeeOrganicDogFredHungerStayAtTen() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedPetMeal("Sally");
		int fredHunger = underTest.getPetHunger("Fred");
		assertEquals(10, fredHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedRSallySnackAndSeeNothingHappenToRoboticCatRSallyHunger() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedPetMeal("R Sally");
		int rSallyHunger = underTest.getPetHunger("R Sally");
		assertEquals(-1, rSallyHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedRSallySnackAndSeeNothingHappenToRoboticDogRFredHunger() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedPetMeal("R Sally");
		int sallyHunger = underTest.getPetHunger("Sally");
		assertEquals(10, sallyHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsSnackAndSeeOrganicCatSallyHungerGoDownByTwo() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialHunger = underTest.getPetHunger("Sally");
		underTest.feedAllSnack();
		int sallyFinalHunger = underTest.getPetHunger("Sally");
		assertEquals(sallyInitialHunger - 2, sallyFinalHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsSnackAndSeeOrganicDogFredHungerGoDownByTwo() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedAllSnack();
		int fredInitialHunger = underTest.getPetHunger("Fred");
		underTest.feedAllSnack();
		int sallyFinalHunger = underTest.getPetHunger("Fred");
		assertEquals(fredInitialHunger - 2, sallyFinalHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsSnackAndSeeNothingHappenToRoboticCatRSallyHunger() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rSallyInitialHunger = underTest.getPetHunger("R Sally");
		underTest.feedAllSnack();
		int rSallyFinalHunger = underTest.getPetHunger("R Sally");
		assertEquals(rSallyInitialHunger, rSallyFinalHunger);
	}
	
	@Test
	public void shouldBeAbleToFeedAllPetsSnackAndSeeNothingHappenToRoboticDogRFredHunger() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.feedAllSnack();
		int rFredInitialHunger = underTest.getPetHunger("R Fred");
		underTest.feedAllSnack();
		int rFredFinalHunger = underTest.getPetHunger("R Fred");
		assertEquals(rFredInitialHunger, rFredFinalHunger);
	}
}