import java.util.ArrayList;

public class PrettyVirtualPetShelterConsoleOutput {

	public static void main(String[] args) {
		VirtualPetShelter myShelter = new VirtualPetShelter();
		
		myShelter.addPetToShelter(new VirtualPet("Sam the Firehouse Cat", "Generic Cat"));
		myShelter.addPetToShelter(new VirtualPet("Lawrence", "Sane Dog"));
		myShelter.addPetToShelter(new VirtualPet("Matt", "Crazy Dog"));
		myShelter.addPetToShelter(new VirtualPet("Isaac", "Howler Monkey"));
		myShelter.addPetToShelter(new VirtualPet("Joe", "Systematic Dog"));
		myShelter.addPetToShelter(new VirtualPet("Scott", "Smart Dog"));
		
		printPetAttributes(myShelter, "Sam the Firehouse Cat");
		printPetAttributes(myShelter, "Lawrence");
//		
//		System.out.println();
//		
//		for(int i = 0; i < myShelter.getAllAttributes().size(); i++) {
//			for (int j = 0; j < myShelter.getAllAttributes().get(i).size(); j++) {
//				System.out.printf("|--%s--", myShelter.getAllAttributes().get(i).get(j));
//			}
//			System.out.println("|");
//		}
		
	}
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
	private static void printPetAttributes(VirtualPetShelter virtualPetShelter, String name) {
		for(int i = 0; i < virtualPetShelter.getPetAttributes(name).size(); i++) {
			System.out.printf("|%s", make10CharacterStringWithDashes(virtualPetShelter.getPetAttributes(name).get(i)));
		}
		System.out.println("|");
	}
	
//	private static void printAllAttributes(VirtualPetShelter virtualPetShelter) {
//		String name;
//		for( : ) {
//			name = virtualPetShelter.getPetAttributes(name).get(name);
//			printPetAttributes(virtualPetShelter, name);
//		}
//	}
}