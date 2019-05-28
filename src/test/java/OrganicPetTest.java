import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

//import org.wecancodeit.VirtualPet;

public class OrganicPetTest {

	OrganicPet underTest = new OrganicPet("", "");

	@Before
	public void setup() {
		VirtualPet underTest = new OrganicPet("", "");
	}

	@Test
	public void shouldBeAbleToCreatePet() {
	VirtualPet underTest = new OrganicPet("", "");
	}

	@Test
	public void petShouldHaveName() {
		VirtualPet underTest = new OrganicPet("Jeff", "");
		String name = underTest.getName();
		assertEquals("Jeff", name);
	}

	@Test
	public void shouldHaveDefaultHunger() {
		OrganicPet underTest = new OrganicPet("Steve", "");
		int hunger = underTest.getHunger();
		assertEquals(10, hunger);
	}

	@Test
	public void shouldBeAbleToFeedMealWhichMeansHungerDecreasesToZero() {
		underTest.feedMeal();
		int hunger = underTest.getHunger();
		assertEquals(0, hunger);
	}

	@Test
	public void shouldBeAbleToFeedSnackAndDecreaseHungerByTwo() {
		underTest.feedSnack();
		int hunger = underTest.getHunger();
		assertEquals(8, hunger);
	}

	@Test
	public void shouldBeAbleToFeedSnackTwiceAndDecreaseHungerByFour() {
		underTest.feedSnack();
		underTest.feedSnack();
		int hunger = underTest.getHunger();
		assertEquals(6, hunger);
	}

	@Test
	public void shouldBeAbleToFeedSnack6xAndDecreaseHungerToZero() {
		underTest.feedSnack();
		underTest.feedSnack();
		underTest.feedSnack();
		underTest.feedSnack();
		underTest.feedSnack();
		underTest.feedSnack();
		int hunger = underTest.getHunger();
		assertEquals(0, hunger);
	}

	@Test
	public void shouldBeAbleToCheckBoredomLevel() {
		boolean isBored = underTest.getBoredom();
		assertEquals(true, isBored);
	}

//	@Test
//	public void shouldBeAbleToPlayToMakeBoredomFalse() {
//		underTest.play();
//		boolean isBored = underTest.getBoredom();
//		assertEquals(false, isBored);
//	}

	@Test
	public void hungerShouldGoUpBy10WhenTick() {
		int initialHunger = underTest.getHunger();
		underTest.tick();
		int hungerAfterTick = underTest.getHunger();
		assertEquals(initialHunger + 10, hungerAfterTick);
	}

	@Test
	public void shouldHaveDefaultThirst() {
		int Thirst = underTest.getThirst();
		assertEquals(10, Thirst);
	}

	@Test
	public void shouldBeAlbeToGiveDrinkAndDecreaseThirstToZero() {
		underTest.giveDrink();
		int Thirst = underTest.getThirst();
		assertEquals(0, Thirst);
	}

	@Test
	public void thirstShouldGoUpBy20WhenTick() {

		int initialThirst = underTest.getThirst();
		underTest.tick();
		int thirstAfterTick = underTest.getThirst();
		assertEquals(initialThirst + 20, thirstAfterTick);
	}

	@Test
	public void shouldHaveBoredomCounterDefaultValueSix() {

		int boredomCounter = underTest.getBoredomCounter();
		assertEquals(6, boredomCounter);
	}

	@Test
	public void boredomCounterShouldIncreaseByOneWhenTick() {

		int initialBoredomCounter = underTest.getBoredomCounter();
		underTest.tick();
		int boredomCounterAfterTick = underTest.getBoredomCounter();
		assertEquals(initialBoredomCounter + 1, boredomCounterAfterTick);
	}

	@Test
	public void getBoredomShouldReturnTrueIfBoredomCounterIsGreaterThanFive() {

		boolean boredom = underTest.getBoredom();
		assertEquals(true, boredom);
	}
	@Test
	public void getBoredomShouldReturnFalseIfBoredomCounterIsThree() {
		underTest.play();
		boolean boredom = underTest.getBoredom();
		assertEquals(false, boredom);
	}

	@Test
	public void boredomCounterShouldDecreaseByThreeWhenPlay() {

		int boredomCounterBeforePlay = underTest.getBoredomCounter();
		underTest.play();
		int boredomCounterAfterPlay = underTest.getBoredomCounter();
		assertEquals(boredomCounterBeforePlay - 3, boredomCounterAfterPlay);
	}

	@Test
	public void boredomCounterShouldBeTenAfterFiveTicks() {

		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int boredomCounterAfterFiveTicks = underTest.getBoredomCounter();
		assertEquals(10, boredomCounterAfterFiveTicks);
	}

	@Test
	public void thirstCounterShouldBe100AfterFiveTicks() {

		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int thirstAfterFiveTicks = underTest.getThirst();
		assertEquals(100, thirstAfterFiveTicks);
	}

	@Test
	public void hungerShouldBe100AfterTenTicks() {

		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int hungerAfterTenTicks = underTest.getHunger();
		assertEquals(100, hungerAfterTenTicks);
	}

	@Test
	public void boredomCounterShouldBeZeroAfterPlaying3x() {

		underTest.play();
		underTest.play();
		underTest.play();
		int boredomCounterAfterThreePlays = underTest.getBoredomCounter();
		assertEquals(0, boredomCounterAfterThreePlays);
	}

	@Test
	public void checkDefaultPetOwnershipStatusShouldBeOwned() {

		boolean owned = underTest.getOwnership();
		assertEquals(true, owned);
	}

	@Test
	public void shouldBeAbleToSendPetToShelter() {

		underTest.sendPetToShelter();
	}

	@Test
	public void ifPetIsSentToShelterThenOwnershipIsFalse() {

		underTest.sendPetToShelter();
		boolean owned = underTest.getOwnership();
		assertEquals(false, owned);
	}

	@Test
	public void shouldBeAbleToGetRabies() {

		underTest.contractRabies();
	}

	@Test
	public void defaultRabiesShouldBeFalse() {

		boolean hasRabies = underTest.getRabiesStatus();
		assertEquals(false, hasRabies);
	}

	@Test
	public void contractRabiesShouldChangeRabiesStatusToTrue() {

		underTest.contractRabies();
		boolean hasRabies = underTest.getRabiesStatus();
		assertEquals(true, hasRabies);
	}

	@Test
	public void shouldDifferentSpecies() {

		String species = underTest.getSpecies();
		assertEquals("", species);
	}

	@Test
	public void speciesDogShouldExists() {
		VirtualPet underTest = new OrganicPet("", "dog");
		String species = underTest.getSpecies();
		assertEquals("dog", species);
	}

	@Test
	public void speciesCatShouldExists() {
		VirtualPet underTest = new OrganicPet("", "cat");
		String species = underTest.getSpecies();
		assertEquals("cat", species);
	}

	@Test
	public void setDefaultAgeToZero() {
		int age = underTest.getAge();
		assertEquals(0, age);
	}

	@Test
	public void ageShouldIncreaseByOne() {
		int ageBeforeIncrement = underTest.getAge();
		underTest.incrementAge();
		int ageAfterIncrement = underTest.getAge();
		assertEquals(ageBeforeIncrement + 1, ageAfterIncrement);
	}

	@Test
	public void shouldBeAbleToSetInitialAgeToThree() {
		VirtualPet underTestInitialAge = new OrganicPet("", "", 3);
		int initialAge = underTestInitialAge.getAge();
		assertEquals(3, initialAge);
	}
	@Test
	public void shouldHaveDefaultSoilRateOf5() {
		int soilRate = underTest.getSoilRate();
		assertEquals(5, soilRate);
	
	}
	@Test
	public void soilRateShouldGoFrom5to0AfterWalk() {
		int soilRateBeforeWalk = underTest.getSoilRate();
		underTest.walk();
		int soilRateAfterWalk = underTest.getSoilRate();
		assertEquals(0, soilRateAfterWalk);
	}
	@Test
	public void soilRateShouldTick() {
		underTest.walk();
		underTest.tick();
		int soilRateAfterTick = underTest.getSoilRate();
		assertEquals(1, soilRateAfterTick);
	}
	
	

}