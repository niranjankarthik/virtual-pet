import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualPetShelter myShelter = new VirtualPetShelter();

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a Pet Name");
		String name = input.nextLine();
		System.out.println("Please enter a Pet Species");
		String species = input.nextLine();
		VirtualPet virtualPet1 = new VirtualPet(name, species);
		myShelter.addPetToShelter(virtualPet1);
		System.out.println("Your Pet is " + name + " the " + species);
	
		String userChoice = "";

		do {
			System.out.println("Press 1 Make another Pet");
			System.out.println("Press 2 Feed, Give Drink, Play");
			System.out.println("Press 3 Show Pet Stats");
			System.out.println("Press 9 to exit");
			userChoice = input.nextLine();

			if (userChoice.equals("9")) {
				break;
			}
			if (userChoice.equals("3")) {
				myShelter.showAllPetsAndTheirStats();	
			}
			if (userChoice.equals("1")) {
				System.out.println("Please enter a Pet Name");
				name = input.nextLine();
				System.out.println("Please enter a Pet Species");
				species = input.nextLine();
				virtualPet1 = new VirtualPet(name, species);
				myShelter.addPetToShelter(virtualPet1);
			}
			if (userChoice.equals("2")) {
				System.out.println("Feed all pets or single?");
				myShelter.feedAllSnackMethod();
			}
			
			
			
			}
		while (!userChoice.equals("9"));

		System.out.println("Good Bye");
		input.close();
		}
}		
		

		//VirtualPetShelter defaultShelter = new VirtualPetShelter();
		
		//defaultShelter.addPetToShelter(new VirtualPet("Fred", "Cat"));
		//defaultShelter.addPetToShelter(new VirtualPet("Lawrence", "Dog"));
		//defaultShelter.addPetToShelter(new VirtualPet("Matt", "Dog"));
		
		//System.out.println(defaultShelter.getPetAttributes("Fred"));
		//System.out.println();
		//System.out.println(defaultShelter.getAllAttributes());
		
		
		
		
		
	
		


