import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import org.wecancodeit.VirtualPet;

public class VirtualPetTest {

	@Test
	public void shouldBeAbleToCreatePet() {
		VirtualPet pet = new VirtualPet("");
	}

	@Test
	public void petShouldHaveName() {
		VirtualPet underTest = new VirtualPet("Jeff");
		String name = underTest.getName();
		assertEquals("Jeff", name);
	}

	@Test
	public void shouldHaveDefaultHunger() {
		VirtualPet underTest = new VirtualPet("Steve");
		int hunger = underTest.getHunger();
		assertEquals(10, hunger);
	}

	@Test
	public void shouldBeAbleToFeedMealWhichMeansHungerDecreasesToZero() {
		VirtualPet underTest = new VirtualPet("");
		underTest.feedMeal();
		int hunger = underTest.getHunger();
		assertEquals(0, hunger);
	}

	@Test
	public void shouldBeAbleToFeedSnackAndDecreaseHungerByTwo() {
		VirtualPet underTest = new VirtualPet("");
		underTest.feedSnack();
		int hunger = underTest.getHunger();
		assertEquals(8, hunger);
	}

	@Test
	public void shouldBeAbleToFeedSnackTwiceAndDecreaseHungerByFour() {
		VirtualPet underTest = new VirtualPet("");
		underTest.feedSnack();
		underTest.feedSnack();
		int hunger = underTest.getHunger();
		assertEquals(6, hunger);
	}

	@Test
	public void shouldBeAbleToFeedSnack6xAndDecreaseHungerToZero() {
		VirtualPet underTest = new VirtualPet("");
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
		VirtualPet underTest = new VirtualPet("");
		boolean isBored = underTest.getBoredom();
		assertEquals(true, isBored);
	}

	@Test
	public void shouldBeAbleToPlayToMakeBoredomFalse() {
		VirtualPet underTest = new VirtualPet("");
		underTest.play();
		boolean isBored = underTest.getBoredom();
		assertEquals(false, isBored);
	}

	@Test
	public void hungerShouldGoUpBy10WhenTick() {
		VirtualPet underTest = new VirtualPet("");
		int initialHunger = underTest.getHunger();
		underTest.tick();
		int hungerAfterTick = underTest.getHunger();
		assertEquals(initialHunger + 10, hungerAfterTick);
	}

	@Test
	public void shouldHaveDefaultThirst() {
		VirtualPet underTest = new VirtualPet("");
		int Thirst = underTest.getThirst();
		assertEquals(10, Thirst);
	}

	@Test
	public void shouldBeAlbeToGiveDrinkAndDecreaseThirstToZero() {
		VirtualPet underTest = new VirtualPet("");
		underTest.giveDrink();
		int Thirst = underTest.getThirst();
		assertEquals(0, Thirst);
	}

	@Test
	public void thirstShouldGoUpBy20WhenTick() {
		VirtualPet underTest = new VirtualPet("");
		int initialThirst = underTest.getThirst();
		underTest.tick();
		int thirstAfterTick = underTest.getThirst();
		assertEquals(initialThirst + 20, thirstAfterTick);
	}

	@Test
	public void shouldHaveBoredomCounterDefaultValueSix() {
		VirtualPet underTest = new VirtualPet("");
		int boredomCounter = underTest.getBoredomCounter();
		assertEquals(6, boredomCounter);
	}

	@Test
	public void boredomCounterShouldIncreaseByOneWhenTick() {
		VirtualPet underTest = new VirtualPet("");
		int initialBoredomCounter = underTest.getBoredomCounter();
		underTest.tick();
		int boredomCounterAfterTick = underTest.getBoredomCounter();
		assertEquals(initialBoredomCounter + 1, boredomCounterAfterTick);
<<<<<<< HEAD
	}	
	
	@Test
	public void getPetBoredomShouldBeTrueIfBoredomCounterIsGreaterThan5() {
		VirtualPet underTest = new VirtualPet("");
		
	}
	}
	

=======
	}

	@Test
	public void getBoredomShouldReturnTrueIfBoredomCounterIsGreaterThanFive() {
		VirtualPet underTest = new VirtualPet("");
		boolean boredom = underTest.getBoredom();
		assertEquals(true, boredom);
	}

	@Test
	public void boredomCounterShouldDecreaseByThreeWhenPlay() {
		VirtualPet underTest = new VirtualPet("");
		int boredomCounterBeforePlay = underTest.getBoredomCounter();
		underTest.play();
		int boredomCounterAfterPlay = underTest.getBoredomCounter();
		assertEquals(boredomCounterBeforePlay - 3, boredomCounterAfterPlay);
	}

	@Test
	public void boredomCounterShouldBeTenAfterFiveTicks() {
		VirtualPet underTest = new VirtualPet("");
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
		VirtualPet underTest = new VirtualPet("");
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
		VirtualPet underTest = new VirtualPet("");
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
		VirtualPet underTest = new VirtualPet("");
		underTest.play();
		underTest.play();
		underTest.play();
		int boredomCounterAfterThreePlays = underTest.getBoredomCounter();
		assertEquals(0, boredomCounterAfterThreePlays);
	}
}
//© We Can Code
>>>>>>> master
