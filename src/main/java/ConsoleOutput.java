import java.util.ArrayList;

public class ConsoleOutput {

//	public static void main(String[] args) {
//		VirtualPetShelter myShelter = new VirtualPetShelter();
//		myShelter.addOrganicPetToShelter(new OrganicPet("Fred", "Cat"));
//		myShelter.addOrganicPetToShelter(new OrganicPet("Lawrence", "Dog"));
//		myShelter.addOrganicPetToShelter(new OrganicPet("Matt", "Dog"));
//		printCommonAttributesOfAllPets(myShelter);
//	}

	private static String makeNCharacterStringWithDashes(String inputString, int length) {
		if (inputString.equals("-1")) {
			inputString = "";
		}
		if (inputString.length() > length) {
			inputString = inputString.substring(0, length);
		}
		while (inputString.length() < length) {
			if (inputString.length() % 2 == 0) {
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
		System.out.printf("|%s", make14CharacterStringWithDashes(virtualPetShelter.getPetName(name)));
		System.out.printf("|%s", make14CharacterStringWithDashes(virtualPetShelter.getPetSpecies(name)));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getPetHunger(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Boolean.toString(virtualPetShelter.getPetBoredom(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getPetThirst(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getPetBoredomCounter(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getLitterBoxCapacity(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getHowMuchPoopInCage(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getPetOilValue(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getPetMaintenanceHealth(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Boolean.toString(virtualPetShelter.getPetOwnership(name))));
		System.out.println("|");
	}

	private static void printPetAttributesHeader() {
		System.out.printf("|%s", make14CharacterStringWithDashes("Name"));
		System.out.printf("|%s", make14CharacterStringWithDashes("Species"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Hunger"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Boredom"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Thirst"));
		System.out.printf("|%s", make10CharacterStringWithDashes("BoredomCounter"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Litter Box Capacity"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Cage Poop"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Oil Value"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Mtnc HP"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Ownership"));
		System.out.println("|");
		for (int i = 0; i < 2; i++) {
			System.out.printf("|%s", make14CharacterStringWithDashes(""));
		}
		for (int i = 2; i < 11; i++) {
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
		int howManyPets = virtualPetShelter.getHowManyPets();
		ArrayList<String> allNames = virtualPetShelter.getAllNames();
		for (int i = 0; i < howManyPets; i++) {
			printSinglePetAttributes(virtualPetShelter, allNames.get(i));
		}
	}

	public static void printAllOwnedPetAttributes(VirtualPetShelter virtualPetShelter) {
		printPetAttributesHeader();
		int howManyPets = virtualPetShelter.getHowManyPets();
		ArrayList<String> allNames = virtualPetShelter.getAllNames();
		for (int i = 0; i < howManyPets; i++) {
			if (virtualPetShelter.getPetOwnership(allNames.get(i))) {
				printSinglePetAttributes(virtualPetShelter, allNames.get(i));
			}
		}
	}

	private static void printCommonPetAttributesHeader() {
		System.out.printf("|%s", make14CharacterStringWithDashes("Name"));
		System.out.printf("|%s", make14CharacterStringWithDashes("Species"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Boredom"));
		System.out.printf("|%s", make10CharacterStringWithDashes("BoredomCounter"));
		System.out.printf("|%s", make10CharacterStringWithDashes("Ownership"));
		System.out.println("|");
		for (int i = 0; i < 2; i++) {
			System.out.printf("|%s", make14CharacterStringWithDashes(""));
		}
		for (int i = 2; i < 5; i++) {
			System.out.printf("|%s", make10CharacterStringWithDashes(""));
		}
		System.out.println("|");
	}

	private static void printCommonSinglePetAttributes(VirtualPetShelter virtualPetShelter, String name) {
		System.out.printf("|%s", make14CharacterStringWithDashes(virtualPetShelter.getPetName(name)));
		System.out.printf("|%s", make14CharacterStringWithDashes(virtualPetShelter.getPetSpecies(name)));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Boolean.toString(virtualPetShelter.getPetBoredom(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Integer.toString(virtualPetShelter.getPetBoredomCounter(name))));
		System.out.printf("|%s",
				make10CharacterStringWithDashes(Boolean.toString(virtualPetShelter.getPetOwnership(name))));
		System.out.println("|");

	}

	public static void printCommonAttributesOfSinglePet(VirtualPetShelter virtualPetShelter, String name) {
		printCommonPetAttributesHeader();
		printCommonSinglePetAttributes(virtualPetShelter, name);
	}

	public static void printCommonAttributesOfAllPets(VirtualPetShelter virtualPetShelter) {
		printCommonPetAttributesHeader();

		for (String name : virtualPetShelter.getAllNames()) {
			printCommonSinglePetAttributes(virtualPetShelter, name);
		}
	}
}