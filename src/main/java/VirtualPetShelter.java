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
		if (singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getHunger();
		} else {
			return -1;
		}
	}

	public int getPetOilValue(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof RoboticPet) {
			return ((RoboticPet) singlePet).getOilValue();
		} else {
			return -1;
		}
	}

	public int getPetMaintenanceHealth(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof RoboticPet) {
			return ((RoboticPet) singlePet).getMaintenanceHealth();
		} else {
			return -1;
		}
	}

	public int getPetThirst(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getThirst();
		} else {
			return -1;
		}
	}

	public boolean getPetBoredom(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getBoredom();
		} else {
			return false;
		}
	}

	public int getPetBoredomCounter(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getBoredomCounter();
		} else {
			return -1;
		}
	}

	public boolean getPetRabiesStatus(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getRabiesStatus();
		} else {
			return false;
		}
	}

	public int getPetSoilRate(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			return ((OrganicPet) singlePet).getSoilRate();
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

	public VirtualPet getSinglePet(String name) {
		return virtualPetsMap.get(name);
	}

	public void sendPetToShelter(String name) {
		virtualPetsMap.get(name).sendPetToShelter();
	}

	public void feedPetMeal(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			((OrganicPet) singlePet).feedMeal();
		}
	}
	
	public void feedAllMeal() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			if (virtualPet.getOwnership() == true) {
				feedPetMeal(virtualPet.getName());
			}
		}
	}

	public void feedPetSnack(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof OrganicPet) {
			((OrganicPet) singlePet).feedSnack();
		}
	}

	public void feedAllSnack() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			if (virtualPet.getOwnership() == true) {
				feedPetSnack(virtualPet.getName());
			}
		}
	}
	
	public void playWithSinglePet(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);

		if (singlePet instanceof OrganicPet) {
			((OrganicPet) singlePet).play();
		}
	}

	public void playWithAll() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			if (virtualPet.getOwnership() == true) {
				playWithSinglePet(virtualPet.getName());
			}
		}
	}

	public void oilSinglePet(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof RoboticPet) {
			((RoboticPet) singlePet).addOil();
		}
	}

	public void oilAll() {
		for (VirtualPet virtualPet : virtualPetsMap.values()){
			if(virtualPet.getOwnership() == true) {
				oilSinglePet(virtualPet.getName());				
			}
		}
	}
	
	public void MaintainSinglePet(String name) {
		VirtualPet singlePet = virtualPetsMap.get(name);
		if (singlePet instanceof RoboticPet) {
			((RoboticPet) singlePet).doMaintenance();
		}
	}

	public void maintainAll() {
		for (VirtualPet virtualPet : virtualPetsMap.values()) {
			if (virtualPet.getOwnership() == true) {
				MaintainSinglePet(virtualPet.getName());
			}
		}
	}
}