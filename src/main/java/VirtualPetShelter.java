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
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet) {
			return ((OrganicPet) virtualPet).getHunger();
		} else {
			return -1;
		}
	}

	public int getPetOilValue(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof RoboticPet) {
			return ((RoboticPet) virtualPet).getOilValue();
		} else {
			return -1;
		}
	}

	public int getPetMaintenanceHealth(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof RoboticPet) {
			return ((RoboticPet) virtualPet).getMaintenanceHealth();
		} else {
			return -1;
		}
	}

	public int getPetThirst(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet) {
			return ((OrganicPet) virtualPet).getThirst();
		} else {
			return -1;
		}
	}

	public boolean getPetBoredom(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet) {
			return ((OrganicPet) virtualPet).getBoredom();
		} else {
			return false;
		}
	}

	public int getPetBoredomCounter(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet) {
			return ((OrganicPet) virtualPet).getBoredomCounter();
		} else {
			return -1;
		}
	}

	public boolean getPetRabiesStatus(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet) {
			return ((OrganicPet) virtualPet).getRabiesStatus();
		} else {
			return false;
		}
	}

	public int getPetSoilRate(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet) {
			return ((OrganicPet) virtualPet).getSoilRate();
		} else {
			return -1;
		}
	}
	public int getLitterBoxCapacity(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicCat) {
			return ((OrganicCat) virtualPet).getHowMuchPoopInLitterBox();
		} else {
			return -1;
		}
	}
	public int getHowMuchPoopInCage(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicDog) {
			return ((OrganicDog) virtualPet).getHowMuchPoopInCage();
		} else {
			return -1;
		}
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

	public VirtualPet getPet(String name) {
		return virtualPetsMap.get(name);
	}

	public void sendPetToShelter(String name) {
		virtualPetsMap.get(name).sendPetToShelter();
	}
	public void tickPet(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet.getOwnership() == true) {
			((VirtualPet) virtualPet).tick();
		}
	}
	
	public void tickShelter() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
				tickPet(virtualPet.getName());
		}
	}

	public void feedPetMeal(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet && virtualPet.getOwnership() == true) {
			((OrganicPet) virtualPet).feedMeal();
		}
	}
	
	public void feedAllMeal() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
				feedPetMeal(virtualPet.getName());
		}
	}

	public void feedPetSnack(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet && virtualPet.getOwnership() == true) {
			((OrganicPet) virtualPet).feedSnack();
		}
	}

	public void feedAllSnack() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
				feedPetSnack(virtualPet.getName());
		}
	}
	
	public void playWithPet(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicPet && virtualPet.getOwnership() == true) {
			((OrganicPet) virtualPet).play();
		}
	}

	public void playWithAll() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
				playWithPet(virtualPet.getName());
		}
	}

	public void oilPet(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof RoboticPet && virtualPet.getOwnership() == true) {
			((RoboticPet) virtualPet).addOil();
		}
	}

	public void oilAll() {
		for (VirtualPet virtualPet : virtualPetsMap.values()){
				oilPet(virtualPet.getName());				
		}
	}
	
	public void maintainPet(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof RoboticPet && virtualPet.getOwnership() == true) {
			((RoboticPet) virtualPet).doMaintenance();
		}
	}

	public void maintainAll() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
				maintainPet(virtualPet.getName());
		}
	}
	public void cleanCatLitterBox(String name) {
		VirtualPet virtualPet = virtualPetsMap.get(name);
		if (virtualPet instanceof OrganicCat && virtualPet.getOwnership() == true){
			((OrganicCat) virtualPet).cleanLitterBox();
		}
	}
	public void cleanAllLitterBox() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			cleanCatLitterBox(virtualPet.getName());		}
	}
}