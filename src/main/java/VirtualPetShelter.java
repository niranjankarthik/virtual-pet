import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> virtualPetsMap = new HashMap<>();

	public void addOrganicPetToShelter(OrganicPet organicPet) {
		virtualPetsMap.put(organicPet.getName(), organicPet);
	}
	public void addRoboticPetToShelter(RoboticPet roboticPet) {
		virtualPetsMap.put(roboticPet.getName(), roboticPet);
	}
	
	public String getPetName(String name) {
		return virtualPetsMap.get(name).getName();
	}
	public boolean getPetOwnership(String name) {
		return virtualPetsMap.get(name).getOwnership();
	}
	public String getPetSpecies(String name) {
		return virtualPetsMap.get(name).getSpecies();
	}
	public int getPetAge(String name) {
		return virtualPetsMap.get(name).getAge();
	}
	public int getPetHunger(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if(singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getHunger();
		} else {
			return -1;
		}
	}
	public int getPetThirst(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if(singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getThirst();
		} else {
			return -1;
		}
	}
	public boolean getPetBoredom(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if(singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getBoredom();
		} else {
			return false;
		}
	}
	public int getPetBoredomCounter(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if(singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getBoredomCounter();
		} else {
			return -1;
		}
	}
	public boolean getPetRabiesStatus(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if(singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getRabiesStatus();
		} else {
			return false;
		}
	}
	public int getPetSoilRate(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if(singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getSoilRate();
		} else {
			return -1;
		}
	}
	public int getHowManyPets() {
		return virtualPetsMap.size();
	}
	
//	public Map<String, VirtualPet> showAll() {
//		Collection<VirtualPet> organicPets = new ArrayList<>();
//		for(VirtualPet virtualPet : virtualPetsMap.values()) {
//			if(virtualPet instanceof OrganicPet) {
//				organicPets.add(virtualPet);
//			}
//		}
//		return organicPets;
//	}
//	
//
//	public ArrayList<String> getAllNames() {
//		ArrayList<String> allNames = new ArrayList<String>();
//		for (VirtualPet virtualPet : virtualPetsMap.values()) {
//			allNames.add(virtualPet.getName());
//		}
//		return allNames;
//	}
//	
//	public ArrayList<String> getPetAttributes(String name) {
//		ArrayList<String> petAttributes = new ArrayList<String>();
//		petAttributes.add(virtualPetsMap.get(name).getName());
//		petAttributes.add(virtualPetsMap.get(name).getSpecies());
//		petAttributes.add(Integer.toString(virtualPetsMap.get(name).getHunger()));
//		petAttributes.add(String.valueOf(virtualPetsMap.get(name).getBoredom()));
//		petAttributes.add(Integer.toString(virtualPetsMap.get(name).getThirst()));
//		petAttributes.add(Integer.toString(virtualPetsMap.get(name).getBoredomCounter()));
//		petAttributes.add(String.valueOf(virtualPetsMap.get(name).getOwnership()));
//		return petAttributes;
//	}
//
//	public ArrayList<ArrayList<String>> getAllAttributes() {
//		ArrayList<ArrayList<String>> allAttributes = new ArrayList<ArrayList<String>>();
//		for (VirtualPet virtualPet : virtualPetsMap.values()) {
//			allAttributes.add(getPetAttributes(virtualPet.getName()));
//		}
//		return allAttributes;
//	}
//	
//	public OrganicPet getSinglePet(String name) {
//		return virtualPetsMap.get(name);
//	}
//	
//	public void sendPetToShelter(String name) {
//		virtualPetsMap.get(name).sendPetToShelter();
//	}
//	
//	public void feedPetMeal(String name) {
//		virtualPetsMap.get(name).feedMeal();
//	}
//	public void showAllPetsAndTheirStats() {
//		for (OrganicPet virtualPet : virtualPetsMap.values()) {
//			System.out.println(virtualPet.getName() + " " + virtualPet.getSpecies() + " " + virtualPet.getBoredom() + " " +virtualPet.getHunger() + " " + virtualPet.getThirst() + " " + virtualPet.getOwnership() + " ");
//		}
//		
//	}
//	public void feedAllSnackMethod() {
//		for (OrganicPet virtualPet : virtualPetsMap.values()) {
//			if(virtualPet.getOwnership() == true) {
//				virtualPet.feedSnack();				
//			}
//			
//		}
//	}
	
}
