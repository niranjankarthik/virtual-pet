import java.util.ArrayList;

public class ConsoleOutput {

	private static String makeNCharacterStringWithDashes(String inputString, int length) {
		inputString.trim();
		if(inputString.length() > length) {
			inputString = inputString.substring(0, length);
		}
		while(inputString.length() < length) {
			if(inputString.length() % 2 == 0) {
				inputString = inputString + "-";
			} else {
				inputString = "-" + inputString;
			}
		}
		return inputString;
	}
	private static String make10CharacterStringWithDashes(String input) {
		return makeNCharacterStringWithDashes(input, 10);
	}
	private static String make14CharacterStringWithDashes(String input) {
		return makeNCharacterStringWithDashes(input, 14);
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