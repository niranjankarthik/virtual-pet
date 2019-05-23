import java.util.ArrayList;

public class ConsoleOutput {

//	public static void main(String[] args) {
//		VirtualPetShelter myShelter = new VirtualPetShelter();
//
//		myShelter.addPetToShelter(new VirtualPet("Sam the Firehouse Cat", "Generic Cat"));
//		myShelter.addPetToShelter(new VirtualPet("Lawrence", "Sane Dog"));
//		myShelter.addPetToShelter(new VirtualPet("Matt", "Crazy Dog"));
//		myShelter.addPetToShelter(new VirtualPet("Isaac", "Howler Monkey"));
//		myShelter.addPetToShelter(new VirtualPet("Joe", "Systematic Dog"));
//		myShelter.addPetToShelter(new VirtualPet("Scott", "Smart Dog"));
////
////		printPetAttributes(myShelter, "Isaac");
////		System.out.println();
////		printAllPetAttributes(myShelter);
//		System.out.println(make10CharacterStringWithDashes("Supercalifragalisticgespiallidocifuckingshit"));
//		System.out.println(make10CharacterStringWithDashes("Bear"));
//		System.out.println(make10CharacterStringWithDashes("Cat"));
//		System.out.println();
//		printSinglePetAttributes(myShelter, "Isaac");
//		System.out.println();
//		printPetAttributesHeader();
//		System.out.println();
//		printPetAttributes(myShelter, "Lawrence");
//		System.out.println();
//		printAllPetAttributes(myShelter);
//	}
	
	private static String make10CharacterStringWithDashes(String input) {
		input.trim();
		if(input.length() > 10) {
			input = input.substring(0, 10);
		}
		while(input.length() < 10) {
			if(input.length() % 2 != 0) {
				input = input + "-";
			} else {
				input = "-" + input;
			}
		}
		return input;
	}
	private static String make14CharacterStringWithDashes(String input) {
		input.trim();
		if(input.length() > 14) {
			input = input.substring(0, 14);
		}
		while(input.length() < 14) {
			if(input.length() % 2 != 0) {
				input = input + "-";
			} else {
				input = "-" + input;
			}
		}
		return input;
	}
	private static void printSinglePetAttributes(VirtualPetShelter virtualPetShelter, String name) {
		for(int i = 0; i < 2; i++) {
			System.out.printf("|%s", make14CharacterStringWithDashes(virtualPetShelter.getPetAttributes(name).get(i)));
		}
		for(int i = 2; i < virtualPetShelter.getPetAttributes(name).size(); i++) {
			System.out.printf("|%s", make10CharacterStringWithDashes(virtualPetShelter.getPetAttributes(name).get(i)));
		}
		System.out.println("|");
	}
	private static void printPetAttributesHeader() {
		System.out.printf("|%s", make14CharacterStringWithDashes("Name"));
		System.out.printf("|%s", make14CharacterStringWithDashes("Species"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Hunger"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Boredom"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Thirst"));
		System.out.printf("|%s", make10CharacterStringWithDashes("BoredomCounter"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Ownership"));
		System.out.println("|");
		for (int i = 0; i < 2; i++) {
			System.out.printf("|%s", make14CharacterStringWithDashes(""));
		}
		for (int i = 2; i < 7; i++) {
			System.out.printf("|%s", make10CharacterStringWithDashes(""));
		}
		System.out.println("|");
	}
	public static void printPetAttributes(VirtualPetShelter virtualPetShelter, String name) {
		printPetAttributesHeader();
		printSinglePetAttributes(virtualPetShelter, name);
	}
	public static void printAllPetAttributes(VirtualPetShelter virtualPetShelter) {
		printPetAttributesHeader();
		ArrayList<ArrayList<String>> allAttributes = virtualPetShelter.getAllAttributes();
		
		for(int i = 0; i < allAttributes.size(); i++) {
			printSinglePetAttributes(virtualPetShelter, allAttributes.get(i).get(0));
		}
	}
}