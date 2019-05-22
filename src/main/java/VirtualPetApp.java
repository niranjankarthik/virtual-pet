import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a Pet Name");
		String name = input.nextLine();
		VirtualPet virtualPet1 = new VirtualPet(name, "");
		System.out.println("Your Pet is " + name);

//		Scanner input = new Scanner(System.in);
//		System.out.println("Please enter a Pet Name");
//		String name = input.nextLine();
//		VirtualPet virtualPet1 = new VirtualPet(name);
//		System.out.println("Your Pet is " + name);

	}
		

}
