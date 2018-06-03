package org.wecancodeit.virtual_pets_amok;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class OrganicCatTest {

	LitterBox testLitterBox;
	Cat testCat;
	OrganicPet organicPet;
	PetBox petBox;
	
	@Before
	public void setUp() {
		
		testLitterBox = new LitterBox();
		testCat = new Cat("Fluffy");
		organicPet = new OrganicPet("Rock");
		petBox = new PetBox();
	}
	
	// Test OrganicPet Object
	@Test
	public void shouldAddOrganicPetToPetBox() {
		// Setup
		// Act
		petBox.addPet(organicPet);
		Collection<VirtualPet> checkPets = petBox.getAllPets();
		// Assert
		assertThat(checkPets, contains(organicPet));
	}
	
	@Test
	public void shouldGetOrganicPetWaste() {
		// Act
		petBox.addPet(organicPet);
		int petWasteLevel = organicPet.getWasteLevel();
		// Assert
		assertEquals(petWasteLevel, 1);
	}
	
	@Test
	public void shouldGetOrganicPetHunger() {
		// Act
		petBox.addPet(organicPet);
		int petHunger = organicPet.getHungerLevel();
		// Assert
		assertEquals(petHunger, 1);
	}
	
	@Test
	public void shouldGetOrganicPetThirst() {
		// Act
		petBox.addPet(organicPet);
		int petThirst = organicPet.getThirstLevel();
		// Assert
		assertEquals(petThirst, 1);
	}
	
	// Test Cat Object
	@Test
	public void shouldAddCatToLitterBox() {
		// Setup
		// Act
		testLitterBox.addPet(testCat);
		Collection<VirtualPet> checkPets = testLitterBox.getAllPets();
		// Assert
		assertThat(checkPets, contains(testCat));
	}
	
	@Test
	public void shouldGetCatWasteLevel() {
		//setup
		// Act
		testLitterBox.addPet(testCat);
		int wasteLevel = testCat.getWasteLevel();
		// Assert
		assertEquals(wasteLevel, 1);
	}
	
	
	
	
}
