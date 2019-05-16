import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import org.wecancodeit.VirtualPet;

public class VirtualPetTest {

	@Test
	public void shouldBeAbleToCreatePet() {
		VirtualPet pet = new VirtualPet();
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

}
//© We Can Code