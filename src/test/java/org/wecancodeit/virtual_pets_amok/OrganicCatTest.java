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
		
		testLitterBox = new LitterBox(1);
		testCat = new Cat("Fluffy");
		organicPet = new OrganicPet("Rock");
		petBox = new PetBox(1);
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
		// Setup
		petBox.addPet(organicPet);
		// Act
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
	
	@Test
	public void shouldGetCatBoredomLevel() {
		// setup
		petBox.addPet(testCat);
		// Act
		int catBoredomLevel = testCat.getHappiness();
		// Assert
		assertEquals(catBoredomLevel, 5);
	}
	
	@Test
	public void shouldEffectCatHungerHappinessThirstWhenTickIsRun() {
		// setup
		petBox.addPet(testCat);
		int catHungerStart = testCat.getHungerLevel();
		int catHappinessStart = testCat.getHappiness();
		int catThirstStart = testCat.getThirstLevel();
		// Act
		testCat.tick();
		// Assert
		assertEquals(catHungerStart + 1, 2);
		assertEquals(catHappinessStart -1, 4);
		assertEquals(catThirstStart + 1, 2);
	}
	
	
}
