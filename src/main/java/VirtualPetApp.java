import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualPetShelter myShelter = new VirtualPetShelter();
		String name;
		String userChoice;
		Scanner input = new Scanner(System.in);

		createPet(myShelter, input);

		do {
			printMainMenu();
			userChoice = input.nextLine();

			if (userChoice.equals("9")) {
				break;
			}
			if (userChoice.equals("3")) {
				System.out.println("Press 1 to show single pet stats");
				System.out.println("Press 2 to show all pet stats");
				System.out.println("Any other input returns you to main menu");
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					System.out.println("Which pet's stats do you want to see?");
					userChoice = input.nextLine();
					ConsoleOutput.printPetAttributes(myShelter, userChoice);
				} else if (userChoice.equals("2")) {
					ConsoleOutput.printAllPetAttributes(myShelter);
				} else {
					continue;
				}
			}
			if (userChoice.equals("1")) {

				createPet(myShelter, input);
			}
			if (userChoice.equals("2")) {
				System.out.println("Feed all pets (1)\nor single (2)?");
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					myShelter.feedAllSnackMethod();
					System.out.println("All pets were given a meal");
				}
				if (userChoice.equals("2")) {
					System.out.println("Enter Name of Pet you want to feed a snack");
					name = input.nextLine();
					myShelter.feedPetSnack(name);
					System.out.println(name + " was given a snack");
				}
			}

		} while (!userChoice.equals("9"));

		System.out.println("Good Bye");
		input.close();
	}

	private static void createPet(VirtualPetShelter myShelter, Scanner input) {
		String name;
		String userChoice;
		System.out.println("Please enter a Pet Name");
		name = input.nextLine();
		System.out.println("What Kind of pet do you choose?");
		System.out.println("(1)Organic Dog   (2)Organic Cat");
		System.out.println("(3)Robotic Dog   (4)Robotic Cat");

		userChoice = input.nextLine();
		if (userChoice.equals("1")) {
			myShelter.addOrganicPetToShelter(new OrganicDog(name));
			System.out.println("Your pet is " + name + " the Organic Dog");
		}
		if (userChoice.equals("2")) {
			myShelter.addOrganicPetToShelter(new OrganicCat(name));
			System.out.println("Your pet is " + name + " the Organic Cat");
		}
		if (userChoice.equals("3")) {
			myShelter.addRoboticPetToShelter(new RoboticDog(name));
			System.out.println("Your pet is " + name + " the Robotic Dog");
		}
		if (userChoice.equals("4")) {
			myShelter.addRoboticPetToShelter(new RoboticCat(name));
			System.out.println("Your pet is " + name + " the Robotic Cat");
		}
	}

	private static void printMainMenu() {
		System.out.println("Press 1 Make another Pet");
		System.out.println("Press 2 Feed, Give Drink, Play with ,Walk, Clean Litter, Oil, give Maintence");
		System.out.println("Press 3 Show Pet Stats");
		System.out.println("Press 9 to exit");
	}
}

//VirtualPetShelter defaultShelter = new VirtualPetShelter();

//defaultShelter.addPetToShelter(new VirtualPet("Fred", "Cat"));
//defaultShelter.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
//defaultShelter.addPetToShelter(new VirtualPet("Matt", "Dog"));

//System.out.println(defaultShelter.getPetAttributes("Fred"));
//System.out.println();
//System.out.println(defaultShelter.getAllAttributes());
