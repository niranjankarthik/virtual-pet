import java.util.Scanner;

public class VirtualPetApp {
	public static final String ANSI_GREEN = "\u001B[32m";
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
			if (userChoice.equals("1")) {

				createPet(myShelter, input);
				continue;
			}
			if (userChoice.equals("2")) {
				System.out.println("What would you like to do?");
				System.out.println("(1) Feed your Pets");
				System.out.println("(2) Water your Pets");
				System.out.println("(3) Play with your Pets");
				System.out.println("(4) Oil your Pets");
				System.out.println("(5) Maintain your Pets");
				System.out.println("(6) Walk with Pet");

				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					System.out.println("(1) Feed all pets a snack \n(2) Feed a single pet a snack \n(3) Feed all pets a meal \n(4) Feed a single pet a meal");
					System.out.println("Any other input returns you to main menu");
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.feedAllSnack();
						System.out.println("All pets were given a snack");
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to feed a snack");
						name = input.nextLine();
						myShelter.feedPetSnack(name);
						System.out.println(name + " was given a snack");
						ConsoleOutput.printPetAttributes(myShelter, name);
					}
					if (userChoice.equals("3")) {
						myShelter.feedAllMeal();
						System.out.println("All pets were given a meal");
					}
					if (userChoice.equals("4")) {
						System.out.println("Enter Name of Pet you want to feed a meal");
						name = input.nextLine();
						myShelter.feedPetMeal(name);
						System.out.println(name + " was given a meal");
					}
				}
					if (userChoice.equals("2")) {
						System.out.println("(1) Water all pets \n(2) Water a single pet");
						System.out.println("Any other input returns you to main menu");
						userChoice = input.nextLine();
						if (userChoice.equals("1")) {
							myShelter.waterAllPets();
							System.out.println("All pets were watered");
						}
						if (userChoice.equals("2")) {
							System.out.println("Enter Name of Pet you want to give water");
							name = input.nextLine();
							myShelter.waterPet(name);
							System.out.println(name + " was given water");
						}
						
					}
					if (userChoice.equals("3")) {
						System.out.println("(1) Play with all pets \n(2) Play with a single pet");
						System.out.println("Any other input returns you to main menu");
						userChoice = input.nextLine();
						if (userChoice.equals("1")) {
							myShelter.playWithAll();
							System.out.println("All pets were played with");
						}
						if (userChoice.equals("2")) {
							System.out.println("Enter Name of Pet you want to play with");
							name = input.nextLine();
							myShelter.playWithPet(name);
							System.out.println(name + " was played with");
						}
						
					}
					if (userChoice.equals("4")) {
						System.out.println("(1) Oil all pets \n(2) Oil a single pet");
						System.out.println("Any other input returns you to main menu");
						userChoice = input.nextLine();
						if (userChoice.equals("1")) {
							myShelter.playWithAll();
							System.out.println("All pets were oiled");
						}
						if (userChoice.equals("2")) {
							System.out.println("Enter Name of Pet you want to walk");
							name = input.nextLine();
							myShelter.playWithPet(name);
							System.out.println(name + " was given oil");
						}
						
					}
					if (userChoice.equals("5")) {
						System.out.println("(1) Maintain all pets \n(2) Maintain a single pet");
						System.out.println("Any other input returns you to main menu");
						userChoice = input.nextLine();
						if (userChoice.equals("1")) {
							myShelter.playWithAll();
							System.out.println("All pets were maintained");
						}
						if (userChoice.equals("2")) {
							System.out.println("Enter Name of Pet you want to maintain");
							name = input.nextLine();
							myShelter.playWithPet(name);
							System.out.println(name + " was given maintence");
						}
						
					}
					if (userChoice.equals("6")) {
						System.out.println("(1) Walk all pets \n(2) Walk a single pet");
						System.out.println("Any other input returns you to main menu");
						userChoice = input.nextLine();
						if (userChoice.equals("1")) {
							myShelter.playWithAll();
							System.out.println("All pets were walked");
						}
						if (userChoice.equals("2")) {
							System.out.println("Enter Name of Pet you want to walk");
							name = input.nextLine();
							myShelter.playWithPet(name);
							System.out.println(name + " was given a walk");
						}
						
					}continue;
				}

			
			if (userChoice.equals("3")) {
				System.out.println("Press 1 to show single pet stats");
				System.out.println("Press 2 to show all pet stats");
				System.out.println("Press 3 to show Owned pet stats");

				System.out.println("Any other input returns you to main menu");
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					System.out.println("Which pet's stats do you want to see?");
					userChoice = input.nextLine();
					ConsoleOutput.printPetAttributes(myShelter, userChoice);
				} else if (userChoice.equals("2")) {
					ConsoleOutput.printAllPetAttributes(myShelter);
				} else if (userChoice.equals("3")) {
					ConsoleOutput.printAllOwnedPetAttributes(myShelter);
				}

				else {
					continue;
				}
				continue;
			}
			if (userChoice.equals("4")) {
				System.out.println("Which Pet do you want to relinquish ownership of?");
				name = input.nextLine();
				myShelter.sendPetToShelter(name);
			}
			if (userChoice.equals("5")) {
				System.out.println("How much time should pass");
				System.out.println("(1) a day");
				System.out.println("(2) a week");
				System.out.println("(3) go on vacation");
				System.out.println("Any other input returns you to main menu");
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					myShelter.tickShelter();

				} else if (userChoice.equals("2")) {
					for (int i = 0; i < 7; i++) {
						myShelter.tickShelter();
					}

				} else if (userChoice.equals("3")) {
					for (int i = 0; i < 30; i++) {
						myShelter.tickShelter();
					}
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
		System.out.println("Press 2 Interact with your Pets");
		System.out.println("Press 3 Show Pet Stats");
		System.out.println("Press 4 Relinquish Ownership");
		System.out.println("Press 5 Let time pass");
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
