import java.util.Scanner;

public class VirtualPetApp {
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) {
		VirtualPetShelter myShelter = new VirtualPetShelter();
		String name;
		String userChoice;
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Virtual Pet Shelter");
		System.out.println();

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
				printPetInteractionMenu();
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					printFeedPetMenu();
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.feedAllSnack();
						System.out.println("All organic spets were given a snack");
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to feed a snack");
						name = input.nextLine();
						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							if(myShelter.getPetSpecies(name).contains("Robotic")) {
								System.out.println("Robots don't eat.");
							} else {	
								myShelter.feedPetSnack(name);
								System.out.println(name + " was given a snack");
								ConsoleOutput.printPetAttributes(myShelter, name);
							}
						} else {
							System.out.println("No pet in shelter with name " + name);
						}
						continue;
					}
					if (userChoice.equals("3")) {
						myShelter.feedAllMeal();
						System.out.println("All organic pets were given a meal");
						continue;
					}
					if (userChoice.equals("4")) {
						System.out.println("Enter Name of Pet you want to feed a meal");
						name = input.nextLine();
						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							if(myShelter.getPetSpecies(name).contains("Robotic")) {
								System.out.println("Robots don't eat.");
							} else {								
								myShelter.feedPetMeal(name);
								System.out.println(name + " was given a meal");
								ConsoleOutput.printPetAttributes(myShelter, name);
							}
						} else {
							System.out.println("No pet in shelter with name " + name);
						}
						continue;
					}
				}
				if (userChoice.equals("2")) {
					printAllOrOne("water");
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.waterAllPets();
						System.out.println("All organic pets were watered");
						continue;
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to give water");
						name = input.nextLine();

						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							if(myShelter.getPetSpecies(name).contains("Robotic")) {
								System.out.println("Robots don't drink.");
								System.out.println(name + " gets wet and sparks");
							} else {
								myShelter.waterPet(name);
								System.out.println(name + " was given water");
								ConsoleOutput.printPetAttributes(myShelter, name);
							}
						} else {
							System.out.println("No pet in shelter with name " + name);
							continue;
						}
					}
				}
				if (userChoice.equals("3")) {
					printAllOrOne("play");
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.playWithAll();
						System.out.println("All pets were played with");
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to play with");
						name = input.nextLine();
						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							myShelter.playWithPet(name);
							System.out.println(name + " was played with");
						} else {
							System.out.println("No pet in shelter with name " + name);
							continue;
						}
					}
					continue;
				}
				if (userChoice.equals("4")) {
					printAllOrOne("oil");
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.oilAll();
						System.out.println("All robotic pets were oiled");
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to oil");
						name = input.nextLine();
						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							myShelter.oilPet(name);
							if (myShelter.getPetSpecies(name).contains("Organic")) {
								System.out.println(
										"You pour oil on " + name + 
										" they are covered in oil, they look at you puzzled");
							} else
								System.out.println(name + " was given oil");
						} else {
							System.out.println("No pet in shelter with name " + name);
						}
						continue;
					}
				}
				if (userChoice.equals("5")) {
					printAllOrOne("maintain");
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.maintainAll();
						System.out.println("All robotic pets were maintained");
						continue;
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to maintain");
						name = input.nextLine();
						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							myShelter.maintainPet(name);
							if(myShelter.getPetSpecies(name).contains("Organic")) {
								System.out.println("You can't maintain an organic pet.");
							} else {
								System.out.println(name + " was given maintenance");
							}
						} else {
							System.out.println("No pet in shelter with name " + name);
							continue;
						}
						continue;
					}
				}
				if (userChoice.equals("6")) {
					printAllOrOne("walk");
					userChoice = input.nextLine();
					if (userChoice.equals("1")) {
						myShelter.walkAll();
						System.out.println("All pets were walked...except for organic cats");
					}
					if (userChoice.equals("2")) {
						System.out.println("Enter Name of Pet you want to walk");
						name = input.nextLine();
						if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
							myShelter.walkPet(name);
							if (myShelter.getPetSpecies(name).equals("Organic Cat")) {
								System.out.println(name + " scratches you, "
										+ "Organic Cats don't like walks");
							} else
								System.out.println(name + " was given a walk");
						} else {
							System.out.println("No pet in shelter with name " + name);
						}
					}
				}
				continue;
			}

			if (userChoice.equals("3")) {
				System.out.println("Press 1 to show single pet stats");
				System.out.println("Press 2 to show all pet stats");
				System.out.println("Press 3 to show Owned pet stats");

				System.out.println("Any other input returns you to main menu");
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					System.out.println("Which pet's stats do you want to see?");
					name = input.nextLine();
					if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
						ConsoleOutput.printPetAttributes(myShelter, name);
					} else {
						System.out.println("No pet in shelter with name " + name);
					}
				} else if (userChoice.equals("2")) {
					ConsoleOutput.printAllPetAttributes(myShelter);
				} else if (userChoice.equals("3")) {
					ConsoleOutput.printAllOwnedPetAttributes(myShelter);
				}
				continue;
			}
			if (userChoice.equals("4")) {
				System.out.println("Which Pet do you want to relinquish ownership of?");
				System.out.println("You will never see them again");
				name = input.nextLine();
				if(myShelter.getAllNames().contains(name) && myShelter.getPetOwnership(name)) {
					myShelter.sendPetToShelter(name);
					System.out.println("You see " + name + " walk off into the distance");
					
				} else {
					System.out.println("No pet in shelter with name " + name);
					System.out.println("You are a horrible owner.");
					System.out.println("You don't even know the name of the pet you want to get rid of.");
				}
			}
			if (userChoice.equals("5")) {
				System.out.println("How much time should pass");
				System.out.println("- Enter 1 for a day");
				System.out.println("- Enter 2 for a week");
				System.out.println("- Enter 3 to go on vacation for a month");
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
				continue;
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
		System.out.println("- Enter 1 for Organic Dog   - Enter 2 for Organic Cat");
		System.out.println("- Enter 3 for Robotic Dog   - Enter 4 for Robotic Cat");

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
		System.out.println("- Enter 1 to make another pet");
		System.out.println("- Enter 2 to interact with your pets");
		System.out.println("- Enter 3 to show pet stats");
		System.out.println("- Enter 4 to relinquish ownership of a pet");
		System.out.println("- Enter 5 to let time pass");
		System.out.println("- Enter 9 to exit");
		System.out.println();
	}

	private static void printPetInteractionMenu() {
		System.out.println("What would you like to do?");
		System.out.println("- Enter 1 to feed your pet(s)");
		System.out.println("- Enter 2 to water your pet(s)");
		System.out.println("- Enter 3 to play with your pet(s)");
		System.out.println("- Enter 4 to oil your pet(s)");
		System.out.println("- Enter 5 to maintain your pet(s)");
		System.out.println("- Enter 6 to walk your pet(s)");
		System.out.println("- Any other input returns you to main menu");
		System.out.println();
	}

	private static void printFeedPetMenu() {
		System.out.println(
				"- Enter 1 to feed all pets a snack \n"
						+ "- Enter 2 to feed a single pet a snack \n"
						+ "- Enter 3 to feed all pets a meal \n"
						+ "- Enter 4 to feed a single pet a meal");
		System.out.println("Any other input returns you to main menu");
		System.out.println();
	}
	
	private static void printAllOrOne(String interaction) {
		System.out.println("- Enter 1 to " + interaction + " all pets");
		System.out.println("- Enter 2 to " + interaction + " single pet");
		System.out.println("Any other input returns you to main menu");
		System.out.println();
	}
}
