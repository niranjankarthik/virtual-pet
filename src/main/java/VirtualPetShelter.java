import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, OrganicPet> virtualPetsMap = new HashMap<>();

	public void addPetToShelter(OrganicPet virtualPet) {
		virtualPetsMap.put(virtualPet.getName(), virtualPet);
	}
	
	public String getPetName(String name) {
		return virtualPetsMap.get(name).getName();
	}
	public int getPetHunger(String name) {
		return virtualPetsMap.get(name).getHunger();
	}
	public int getPetThirst(String name) {
		return virtualPetsMap.get(name).getThirst();
	}
	public boolean getPetBoredom(String name) {
		return virtualPetsMap.get(name).getBoredom();
	}
	public int getPetBoredomCounter(String name) {
		return virtualPetsMap.get(name).getBoredomCounter();
	}
	public boolean getPetOwnership(String name) {
		return virtualPetsMap.get(name).getOwnership();
	}
	public boolean getRabiesStatus(String name) {
		return virtualPetsMap.get(name).getRabiesStatus();
	}
	public String getPetSpecies(String name) {
		return virtualPetsMap.get(name).getSpecies();
	}
	public int getPetAge(String name) {
		return virtualPetsMap.get(name).getAge();
	}
	public int getSoilRate(String name) {
		return virtualPetsMap.get(name).getSoilRate();
	}
	
	
	public int getHowManyPets() {
		return virtualPetsMap.size();
	}

	public ArrayList<String> getAllNames() {
		ArrayList<String> allNames = new ArrayList<String>();
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			allNames.add(virtualPet.getName());
		}
		return allNames;
	}
	
	public ArrayList<String> getPetAttributes(String name) {
		ArrayList<String> petAttributes = new ArrayList<String>();
		petAttributes.add(virtualPetsMap.get(name).getName());
		petAttributes.add(virtualPetsMap.get(name).getSpecies());
		petAttributes.add(Integer.toString(virtualPetsMap.get(name).getHunger()));
		petAttributes.add(String.valueOf(virtualPetsMap.get(name).getBoredom()));
		petAttributes.add(Integer.toString(virtualPetsMap.get(name).getThirst()));
		petAttributes.add(Integer.toString(virtualPetsMap.get(name).getBoredomCounter()));
		petAttributes.add(String.valueOf(virtualPetsMap.get(name).getOwnership()));
		return petAttributes;
	}

	public ArrayList<ArrayList<String>> getAllAttributes() {
		ArrayList<ArrayList<String>> allAttributes = new ArrayList<ArrayList<String>>();
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			allAttributes.add(getPetAttributes(virtualPet.getName()));
		}
		return allAttributes;
	}
	
	public OrganicPet getSinglePet(String name) {
		return virtualPetsMap.get(name);
	}
	
	public void sendPetToShelter(String name) {
		virtualPetsMap.get(name).sendPetToShelter();
	}
	
	public void feedPetMeal(String name) {
		virtualPetsMap.get(name).feedMeal();
	}
	public void showAllPetsAndTheirStats() {
		for (OrganicPet virtualPet : virtualPetsMap.values()) {
			System.out.println(virtualPet.getName() + " " + virtualPet.getSpecies() + " " + virtualPet.getBoredom() + " " +virtualPet.getHunger() + " " + virtualPet.getThirst() + " " + virtualPet.getOwnership() + " ");
		}
		
	}
	public void feedAllSnackMethod() {
		for (OrganicPet virtualPet : virtualPetsMap.values()) {
			if(virtualPet.getOwnership() == true) {
				virtualPet.feedSnack();				
			}
			
		}
	}
	
}
