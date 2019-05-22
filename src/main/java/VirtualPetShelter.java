import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	public Map<String, VirtualPet> virtualPetsMap = new HashMap<>();

	public void addPetToShelter(VirtualPet virtualPet) {
		virtualPetsMap.put(virtualPet.getName(), virtualPet);
		
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

	
	
}
