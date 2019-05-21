import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	public Map<String, VirtualPet> petsMap = new HashMap<>();

	public void addPetToShelter(VirtualPet virtualPet) {
		petsMap.put(virtualPet.getName(), virtualPet);
		
	}

	
	
}
