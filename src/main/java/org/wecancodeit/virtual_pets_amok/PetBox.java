package org.wecancodeit.virtual_pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetBox {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	
	
	// getters
	public int getSize() {
		return pets.size();
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void addPet(VirtualPet pet) {
		pets.put(pet.getPetName(), pet);
	}

}
