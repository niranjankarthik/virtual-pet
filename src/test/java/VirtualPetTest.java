import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import org.wecancodeit.VirtualPet;

public class VirtualPetTest {

	VirtualPet underTest = new VirtualPet("", "");
	@Test
	public void shouldBeAbleToCreatePet() {
	}

	@Test
	public void petShouldHaveName() {
		VirtualPet underTest = new VirtualPet("Jeff", "");
		String name = underTest.getName();
		assertEquals("Jeff", name);
	}

	@Test
	public void shouldHaveDefaultHunger() {
		VirtualPet underTest = new VirtualPet("Steve", "");
		int hunger = underTest.getHunger();
		assertEquals(10, hunger);
	}

	@Test
	public void shouldBeAbleToFeedMealWhichMeansHungerDecreasesToZero() {
		VirtualPet underTest = new VirtualPet("", "");
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
		VirtualPet underTest = new VirtualPet("", "");
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
		VirtualPet underTest = new VirtualPet("", "");
		boolean isBored = underTest.getBoredom();
		assertEquals(true, isBored);
	}

	@Test
	public void shouldBeAbleToPlayToMakeBoredomFalse() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.play();
		boolean isBored = underTest.getBoredom();
		assertEquals(false, isBored);
	}

	@Test
	public void hungerShouldGoUpBy10WhenTick() {
		VirtualPet underTest = new VirtualPet("", "");
		int initialHunger = underTest.getHunger();
		underTest.tick();
		int hungerAfterTick = underTest.getHunger();
		assertEquals(initialHunger + 10, hungerAfterTick);
	}

	@Test
	public void shouldHaveDefaultThirst() {
		VirtualPet underTest = new VirtualPet("", "");
		int Thirst = underTest.getThirst();
		assertEquals(10, Thirst);
	}

	@Test
	public void shouldBeAlbeToGiveDrinkAndDecreaseThirstToZero() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.giveDrink();
		int Thirst = underTest.getThirst();
		assertEquals(0, Thirst);
	}

	@Test
	public void thirstShouldGoUpBy20WhenTick() {
		VirtualPet underTest = new VirtualPet("", "");
		int initialThirst = underTest.getThirst();
		underTest.tick();
		int thirstAfterTick = underTest.getThirst();
		assertEquals(initialThirst + 20, thirstAfterTick);
	}

	@Test
	public void shouldHaveBoredomCounterDefaultValueSix() {
		VirtualPet underTest = new VirtualPet("", "");
		int boredomCounter = underTest.getBoredomCounter();
		assertEquals(6, boredomCounter);
	}

	@Test
	public void boredomCounterShouldIncreaseByOneWhenTick() {
		VirtualPet underTest = new VirtualPet("", "");
		int initialBoredomCounter = underTest.getBoredomCounter();
		underTest.tick();
		int boredomCounterAfterTick = underTest.getBoredomCounter();
		assertEquals(initialBoredomCounter + 1, boredomCounterAfterTick);
	}

	@Test
	public void getBoredomShouldReturnTrueIfBoredomCounterIsGreaterThanFive() {
		VirtualPet underTest = new VirtualPet("", "");
		boolean boredom = underTest.getBoredom();
		assertEquals(true, boredom);
	}

	@Test
	public void boredomCounterShouldDecreaseByThreeWhenPlay() {
		VirtualPet underTest = new VirtualPet("", "");
		int boredomCounterBeforePlay = underTest.getBoredomCounter();
		underTest.play();
		int boredomCounterAfterPlay = underTest.getBoredomCounter();
		assertEquals(boredomCounterBeforePlay - 3, boredomCounterAfterPlay);
	}

	@Test
	public void boredomCounterShouldBeTenAfterFiveTicks() {
		VirtualPet underTest = new VirtualPet("", "");
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
		VirtualPet underTest = new VirtualPet("", "");
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
		VirtualPet underTest = new VirtualPet("", "");
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
		VirtualPet underTest = new VirtualPet("", "");
		underTest.play();
		underTest.play();
		underTest.play();
		int boredomCounterAfterThreePlays = underTest.getBoredomCounter();
		assertEquals(0, boredomCounterAfterThreePlays);
	}
	
	@Test
	public void checkDefaultPetOwnershipStatusShouldBeOwned() {
		VirtualPet underTest = new VirtualPet("", "");
		boolean owned = underTest.getOwnership();
		assertEquals(true, owned);	
	}
	
	@Test
	public void shouldBeAbleToSendPetToShelter() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.sendPetToShelter();	
	}
	
	@Test
	public void ifPetIsSentToShelterThenOwnershipIsFalse() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.sendPetToShelter();
		boolean owned = underTest.getOwnership();
		assertEquals(false, owned);
	}
	@Test
	public void shouldBeAbleToGetRabies() {
		VirtualPet underTest = new VirtualPet("", "");	
		underTest.contractRabies();
	}
	@Test
	public void defaultRabiesShouldBeFalse () {
		VirtualPet underTest = new VirtualPet("", "");
		boolean hasRabies = underTest.getRabiesStatus();
		assertEquals(false, hasRabies);
	}
	@Test
	public void contractRabiesShouldChangeRabiesStatusToTrue() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.contractRabies();
		boolean hasRabies = underTest.getRabiesStatus();
		assertEquals(true, hasRabies);
	}
	@Test
	public void shouldDifferentSpecies() {
		VirtualPet underTest = new VirtualPet("", "");
		String species = underTest.getSpecies();
		assertEquals("", species);
	}
	@Test
	public void speciesDogShouldExists() {
		VirtualPet underTest = new VirtualPet("", "dog");
		String species = underTest.getSpecies();
		assertEquals("dog", species);
	}
	@Test
	public void speciesCatShouldExists() {
		VirtualPet underTest = new VirtualPet("", "cat");
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
		VirtualPet underTestInitialAge = new VirtualPet("", "", 3);
		int initialAge = underTestInitialAge.getAge();	
		assertEquals(3, initialAge);
		}
	
}