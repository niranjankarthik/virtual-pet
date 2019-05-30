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
	
	@Test
	public void shouldBeAbleToPlayWithSallyAndSeeOrganicCatSallyAndSeeHerBoredomCounterGoDownByThree() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialBoredomCounter = underTest.getPetBoredomCounter("Sally");
		underTest.playWithPet("Sally");
		int sallyFinalBoredomCounter = underTest.getPetBoredomCounter("Sally");
		assertEquals(sallyInitialBoredomCounter - 3, sallyFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithSallyAndSeeNothingHappenToFredBoredomCounter() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int fredInitialBoredomCounter = underTest.getPetBoredomCounter("Fred");
		underTest.playWithPet("Sally");
		int fredFinalBoredomCounter = underTest.getPetBoredomCounter("Fred");
		assertEquals(fredInitialBoredomCounter, fredFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithRSallyAndSeeNothingHappenToRSallyBoredomCounter() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rSallyInitialBoredomCounter = underTest.getPetBoredomCounter("R Sally");
		underTest.playWithPet("R Sally");
		int rSallyFinalBoredomCounter = underTest.getPetBoredomCounter("R Sally");
		assertEquals(rSallyInitialBoredomCounter, rSallyFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithRSallyAndSeeNothingHappenToRFredBoredomCounter() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rFredInitialBoredomCounter = underTest.getPetBoredomCounter("R Fred");
		underTest.playWithPet("R Sally");
		int rFredFinalBoredomCounter = underTest.getPetBoredomCounter("R Fred");
		assertEquals(rFredInitialBoredomCounter, rFredFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithAllPetsAndSeeOrganicCatSallyBoredomCounterGoDownByThree() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialBoredomCounter = underTest.getPetBoredomCounter("Sally");
		underTest.playWithAll();
		int sallyFinalBoredomCounter = underTest.getPetBoredomCounter("Sally");
		assertEquals(sallyInitialBoredomCounter - 3, sallyFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithAllPetsAndSeeOrganicDogFredBoredomCounterGoDownByThree() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int fredInitialBoredomCounter = underTest.getPetBoredomCounter("Fred");
		underTest.playWithAll();
		int fredFinalBoredomCounter = underTest.getPetBoredomCounter("Fred");
		assertEquals(fredInitialBoredomCounter - 3, fredFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithAllPetsAndSeeNothingHappenToRoboticCatRSallyBoredom() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rSallyInitialBoredomCounter = underTest.getPetBoredomCounter("R Sally");
		underTest.playWithAll();
		int rSallyFinalBoredomCounter = underTest.getPetBoredomCounter("R Sally");
		assertEquals(rSallyInitialBoredomCounter, rSallyFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToPlayWithAllPetsAndSeeNothingHappenToRoboticDogRFredBoredom() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rFredInitialBoredomCounter = underTest.getPetBoredomCounter("R Fred");
		underTest.playWithAll();
		int rFredFinalBoredomCounter = underTest.getPetBoredomCounter("R Fred");
		assertEquals(rFredInitialBoredomCounter, rFredFinalBoredomCounter);
	}
	
	@Test
	public void shouldBeAbleToOilSallyAndSeeNothingHappenToSallyOilValue() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialOilValue = underTest.getPetBoredomCounter("Sally");
		underTest.oilPet("Sally");
		int sallyFinalOilValue = underTest.getPetBoredomCounter("Sally");
		assertEquals(sallyInitialOilValue, sallyFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilSallyAndSeeNothingHappenToFredOilValue() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int fredInitialOilValue = underTest.getPetOilValue("Fred");
		underTest.oilPet("Sally");
		int fredFinalOilValue = underTest.getPetOilValue("Fred");
		assertEquals(fredInitialOilValue, fredFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilRSallyAndSeeRSallyOilValueGoUpBy25() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rSallyInitialOilValue = underTest.getPetOilValue("R Sally");
		underTest.oilPet("R Sally");
		int rSallyFinalOilValue = underTest.getPetOilValue("R Sally");
		assertEquals(rSallyInitialOilValue + 25, rSallyFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilRSallyAndSeeNothingHappenToRFredOilValue() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rFredInitialOilValue = underTest.getPetOilValue("R Fred");
		underTest.oilPet("R Sally");
		int rFredFinalOilValue = underTest.getPetOilValue("R Fred");
		assertEquals(rFredInitialOilValue, rFredFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilAllAndSeeNothingHappenToSallyOilValue() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialOilValue = underTest.getPetBoredomCounter("Sally");
		underTest.oilAll();
		int sallyFinalOilValue = underTest.getPetBoredomCounter("Sally");
		assertEquals(sallyInitialOilValue, sallyFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilAllAndSeeNothingHappenToFredOilValue() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int fredInitialOilValue = underTest.getPetOilValue("Fred");
		underTest.oilAll();
		int fredFinalOilValue = underTest.getPetOilValue("Fred");
		assertEquals(fredInitialOilValue, fredFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilAllAndSeeRSallyOilValueGoUpBy25() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rSallyInitialOilValue = underTest.getPetOilValue("R Sally");
		underTest.oilAll();
		int rSallyFinalOilValue = underTest.getPetOilValue("R Sally");
		assertEquals(rSallyInitialOilValue + 25, rSallyFinalOilValue);
	}
	
	@Test
	public void shouldBeAbleToOilAllAndSeeRFredOilValueGoUpBy25() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rFredInitialOilValue = underTest.getPetOilValue("R Fred");
		underTest.oilAll();
		int rFredFinalOilValue = underTest.getPetOilValue("R Fred");
		assertEquals(rFredInitialOilValue + 25, rFredFinalOilValue);
	}
	
	
	
	
	
	
	
	
	@Test
	public void shouldBeAbleToMaintainSallyAndSeeNothingHappenToSallyMaintenanceHealth() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("Sally");
		underTest.maintainPet("Sally");
		int sallyFinalMaintenanceHealth = underTest.getPetMaintenanceHealth("Sally");
		assertEquals(sallyInitialMaintenanceHealth, sallyFinalMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintainSallyAndSeeNothingHappenToFredMaintenanceHealth() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int fredInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("Fred");
		underTest.maintainPet("Sally");
		int fredFinalMaintenanceHealth = underTest.getPetMaintenanceHealth("Fred");
		assertEquals(fredInitialMaintenanceHealth, fredFinalMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintainRSallyAndSeeRSallyMaintenanceHealthGoTo100() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.maintainPet("R Sally");
		int rSallyMaintenanceHealth = underTest.getPetMaintenanceHealth("R Sally");
		assertEquals(100, rSallyMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintainRSallyAndSeeNothingHappenToRFredMaintenanceHealth() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int rFredInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("R Fred");
		underTest.maintainPet("R Sally");
		int rFredFinalMaintenanceHealth = underTest.getPetMaintenanceHealth("R Fred");
		assertEquals(rFredInitialMaintenanceHealth, rFredFinalMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintainAllAndSeeNothingHappenToSallyMaintenanceHealth() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int sallyInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("Sally");
		underTest.maintainAll();
		int sallyFinalMaintenanceHealth = underTest.getPetMaintenanceHealth("Sally");
		assertEquals(sallyInitialMaintenanceHealth, sallyFinalMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintainAllAndSeeNothingHappenToFredMaintenanceHealth() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		int fredInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("Fred");
		underTest.maintainAll();
		int fredFinalMaintenanceHealth = underTest.getPetMaintenanceHealth("Fred");
		assertEquals(fredInitialMaintenanceHealth, fredFinalMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintainAllAndSeeRSallyMaintenanceHealthGoTo100() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.maintainAll();
		int rSallyMaintenanceHealth = underTest.getPetMaintenanceHealth("R Sally");
		assertEquals(100, rSallyMaintenanceHealth);
	}
	
	@Test
	public void shouldBeAbleToMaintaiAllAndSeeRFredMaintenanceHealthGoTo100() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.addRoboticPetToShelter(new RoboticCat("R Sally"));
		underTest.addRoboticPetToShelter(new RoboticDog("R Fred"));
		underTest.maintainAll();
		int rFredFinalMaintenanceHealth = underTest.getPetMaintenanceHealth("R Fred");
		assertEquals(100, rFredFinalMaintenanceHealth);
	}
	
	@Test
	public void shouldAbleToWaterPet() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.waterPet("Sally");
		int sallyThirst = underTest.getPetThirst("Sally");
		assertEquals(0, sallyThirst);
	}
	
	@Test
	public void shouldBeAbleToWaterAllPets() {
		underTest.addOrganicPetToShelter(new OrganicCat("Sally"));
		underTest.addOrganicPetToShelter(new OrganicDog("Fred"));
		underTest.waterAllPets();
		int sallyThirst = underTest.getPetThirst("Sally");
		assertEquals(0, sallyThirst);
		int fredThirst = underTest.getPetThirst("Fred");
		assertEquals(0, fredThirst);
		
	}

	@Test
	public void shouldBeAbleToCleanCatLitterBoxAndNothingHappenToOrganicDogA() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		int aInitialCatLitterBox = underTest.getPetSoilRate("A");
		underTest.cleanCatLitterBox("A");
		int aFinalCatLitterBox = underTest.getPetSoilRate("A");
		assertEquals(aInitialCatLitterBox, aFinalCatLitterBox);
	}
	@Test
	public void shouldBeAbleToCleanCatLitterBoxAndNothingHappenToRoboticDogC() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		int aInitialCatLitterBox = underTest.getPetSoilRate("C");
		underTest.cleanCatLitterBox("C");
		int aFinalCatLitterBox = underTest.getPetSoilRate("C");
		assertEquals(aInitialCatLitterBox, aFinalCatLitterBox);
	}
	@Test
	public void shouldBeAbleToCleanCatLitterBoxAndNothingHappenToRoboticCatD() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		int aInitialCatLitterBox = underTest.getPetSoilRate("D");
		underTest.cleanCatLitterBox("D");
		int aFinalCatLitterBox = underTest.getPetSoilRate("D");
		assertEquals(aInitialCatLitterBox, aFinalCatLitterBox);
	}
  
	@Test
	public void shouldBeAbleToCleanCatLitterBoxAndMakeOrganicCatBDecreaseSoilRateToZero() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));
		underTest.addRoboticPetToShelter(new RoboticCat("C"));
		underTest.addRoboticPetToShelter(new RoboticDog("D"));
		underTest.cleanCatLitterBox("B");
		int bCatLitterBox = underTest.getPetSoilRate("B");
		assertEquals(0, bCatLitterBox);
	}
	@Test
	public void shouldBeAbleToCleanAllLitterBoxAndNothingHappenToOrganicDogA() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		int aInitialCatLitterBox = underTest.getPetSoilRate("A");
		underTest.cleanAllLitterBox();
		int aFinalCatLitterBox = underTest.getPetSoilRate("A");
		assertEquals(aInitialCatLitterBox, aFinalCatLitterBox);
	}
	@Test
	public void shouldBeAbleToCleanAllLitterBoxAndNothingHappenToRoboticDogC() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		int aInitialCatLitterBox = underTest.getPetSoilRate("C");
		underTest.cleanAllLitterBox();
		int aFinalCatLitterBox = underTest.getPetSoilRate("C");
		assertEquals(aInitialCatLitterBox, aFinalCatLitterBox);
	}
  
	@Test
	public void shouldBeAbleToCleanAllLitterBoxAndNothingHappenToRoboticCatD() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		int aInitialCatLitterBox = underTest.getPetSoilRate("D");
		underTest.cleanAllLitterBox();
		int aFinalCatLitterBox = underTest.getPetSoilRate("D");
		assertEquals(aInitialCatLitterBox, aFinalCatLitterBox);
	}
  
	@Test
	public void shouldBeAbleToCleanAllLitterBoxAndMakeOrganicCatBDecreaseSoilRateToZero() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addOrganicPetToShelter(new OrganicCat("B"));
		underTest.addRoboticPetToShelter(new RoboticCat("C"));
		underTest.addRoboticPetToShelter(new RoboticDog("D"));
		underTest.cleanAllLitterBox();
		int bCatLitterBox = underTest.getPetSoilRate("B");
		assertEquals(0, bCatLitterBox);
	}
	
	@Test
	public void shouldBeAbleToWalkPet() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));		
		underTest.addRoboticPetToShelter(new RoboticDog("C"));
		underTest.addRoboticPetToShelter(new RoboticCat("D"));
		underTest.walkPet("A");
		int soilRate = underTest.getPetSoilRate("A");
		assertEquals(0, soilRate);
	}
	
	@Test
	public void ShouldBeAbleToWalkAllPets() {
		underTest.addOrganicPetToShelter(new OrganicDog("A"));
		underTest.addRoboticPetToShelter(new RoboticCat("C"));
		underTest.addRoboticPetToShelter(new RoboticDog("D"));
		int cInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("C");
		int dInitialMaintenanceHealth = underTest.getPetMaintenanceHealth("D");
		underTest.walkAll();
		int AsoilRate = underTest.getPetSoilRate("A");
		assertEquals(0, AsoilRate);
		int cFinalMaitainanceHealth = underTest.getPetMaintenanceHealth("C");
		assertEquals(cInitialMaintenanceHealth -10, cFinalMaitainanceHealth);
		int  dFinalMaitainanceHealth = underTest.getPetMaintenanceHealth("D");
		assertEquals(dInitialMaintenanceHealth -10, dFinalMaitainanceHealth);
	}
	
	
}