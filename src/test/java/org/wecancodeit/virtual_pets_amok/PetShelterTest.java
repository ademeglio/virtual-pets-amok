package org.wecancodeit.virtual_pets_amok;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PetShelterTest {

	PetShelter testShelter;
	
	@Before
	public void setUp() {
		testShelter = new PetShelter();
	}
	
	@Test
	public void shouldAddCageToShelter() {
		Cage cage1 = new Cage();
		// Action
		testShelter.addToShelter(1, cage1);
		Collection<PetBox> cages = testShelter.getAllCagesAndBoxes();
		// Assert
		assertThat(cages, contains(cage1));
	}
	
	@Test
	public void shouldAddLitterBoxToShelter() {
		LitterBox litter1 = new LitterBox();
		// Action
		testShelter.addToShelter(1, litter1);
		Collection<PetBox> litterB	= testShelter.getAllCagesAndBoxes();
		// Assert
		assertThat(litterB, contains(litter1));
	}
	
	@Test
	public void shouldAddLitterBoxAndTwoCagesToShelter() {
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litter1 = new LitterBox();
		// Action
		testShelter.addToShelter(1, litter1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, cage1);
		assertEquals(testShelter.getAllCagesAndBoxes().size(), 3);
	}
	
	@Test
	public void shouldRemoveABoxFromShelterLeavingUsWith2After3WereAdded() {
		// Setup
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litter1 = new LitterBox();
		// Action
		testShelter.addToShelter(1, litter1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, cage1);
		testShelter.removeFromShelter(2);
		// Assert
		assertEquals(testShelter.getAllCagesAndBoxes().size(), 2);
	}
	
	@Test
	public void shouldGetAllRoboPets() {
		// Setup
		Cat cat1 = new Cat("Bytes");
		Dog dog1 = new Dog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		
		//Act
		cage1.addPet(dog1);
		cage2.addPet(roboDog2);
		litterBox.addPet(cat1);
		litterBox.addPet(roboCat2);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		Collection<RoboPet> roboPets = testShelter.getAllRoboPets();
		
		// Assert
		assertThat(roboPets, containsInAnyOrder(roboDog2, roboCat2));
		assertThat(roboPets, not(containsInAnyOrder(dog1, cat1)));
	}
	
	@Test
	public void shouldOilAllRobotPetsRustLevelTo0() {
		//Setup
		RoboDog roboDog2 = new RoboDog("Trixie");
		Cage cage1 = new Cage();
		cage1.addPet(roboDog2);
		testShelter.addToShelter(1, cage1);
		// Action
		testShelter.oilAllRobots();
		// Assert
		assertEquals(roboDog2.getPetRustLevel(), 0);
	}
		
	@Test
	public void shouldCleanAllDogCages() {
		//Setup
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		cage1.makePetBoxDirty(8);
		cage2.makePetBoxDirty(9);
		litterBox.makePetBoxDirty(13);
		//Action
		testShelter.cleanAllCages();
		int dirtLevel1 = cage1.getCleanliness();
		int dirtLevel2 = cage2.getCleanliness();
		int dirtLevel3 = litterBox.getCleanliness();
		//Assert
		assertEquals(dirtLevel1, 0);
		assertEquals(dirtLevel2, 0);
		assertEquals(dirtLevel3, 13);
	}
	
	@Test
	public void shouldEmptyAllLitterBoxes() {
		//Setup
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		cage1.makePetBoxDirty(8);
		cage2.makePetBoxDirty(9);
		litterBox.makePetBoxDirty(13);
		//Action
		testShelter.cleanAllLitterBoxes();
		int dirtLevel1 = cage1.getCleanliness();
		int dirtLevel2 = cage2.getCleanliness();
		int dirtLevel3 = litterBox.getCleanliness();
		//Assert
		assertEquals(dirtLevel1, 8);
		assertEquals(dirtLevel2, 9);
		assertEquals(dirtLevel3, 0);
	}
	
	@Test
	public void shouldGetAllOrganicPets() {
		// Setup
		Cat cat1 = new Cat("Bytes");
		Dog dog1 = new Dog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		
		//Act
		cage1.addPet(dog1);
		cage2.addPet(roboDog2);
		litterBox.addPet(cat1);
		litterBox.addPet(roboCat2);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		Collection<OrganicPet> organicPets = testShelter.getAllOrganicPets();
		
		// Assert
		assertThat(organicPets, containsInAnyOrder(dog1, cat1));
		assertThat(organicPets, not(containsInAnyOrder(roboDog2, roboCat2)));
	}
	
	@Test
	public void shouldFeedAllOrganicPets() {
		//Setup
		Cat cat1 = new Cat("Bytes");
		Dog dog1 = new Dog("Copper");
		Cage cage1 = new Cage();
		LitterBox litterBox = new LitterBox();
		cage1.addPet(dog1);
		litterBox.addPet(cat1);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(3, litterBox);
		int dogHungerStart = dog1.getHungerLevel();
		int catHungerStart = cat1.getHungerLevel();
		//Action
		testShelter.feedAllPets();
		int dogHungerEnd = dog1.getHungerLevel();
		int catHungerEnd = cat1.getHungerLevel();
		//Assert
		assertEquals(dogHungerStart - 1, dogHungerEnd);
		assertEquals(catHungerStart - 1, catHungerEnd);
	}
	
	@Test
	public void shouldWaterAllOrganicPets() {
		//Setup
		Cat cat1 = new Cat("Bytes");
		Dog dog1 = new Dog("Copper");
		Cage cage1 = new Cage();
		LitterBox litterBox = new LitterBox();
		cage1.addPet(dog1);
		litterBox.addPet(cat1);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(3, litterBox);
		int dogThirstStart = dog1.getThirstLevel();
		int catThirstStart = cat1.getThirstLevel();
		//Action
		testShelter.waterAllPets();
		int dogThirstEnd = dog1.getThirstLevel();
		int catThirstEnd = cat1.getThirstLevel();
		//Assert
		assertEquals(dogThirstStart - 1, dogThirstEnd);
		assertEquals(catThirstStart - 1, catThirstEnd);
	}
	
	@Test
	public void shouldWalkAllDogs() {
		Cat cat1 = new Cat("Bytes");
		Dog dog1 = new Dog("Copper");
		Dog dog2 = new Dog("Benji");
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		cage1.addPet(dog1);
		cage2.addPet(dog2);
		litterBox.addPet(cat1);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		int dogWaste1Start = dog1.getWasteLevel();
		int dogWaste2Start = dog2.getWasteLevel();
		int catWasteStart = cat1.getWasteLevel();
		//Action
		testShelter.walkAllDogs();
		//Assert
		assertEquals(dogWaste1Start - 1, 0);
		assertEquals(dogWaste2Start - 1, 0);
		assertEquals(catWasteStart, 1);
	}
	
	// TODO
	@Test
	public void shouldRunAllPetTicks() {
		// Setup
		Cat cat1 = new Cat("Bytes");
		Dog dog1 = new Dog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		cage1.addPet(roboDog2);
		cage2.addPet(dog1);
		litterBox.addPet(roboCat2);
		litterBox.addPet(cat1);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		// Action
		int catStartThirst = cat1.getThirstLevel();
		int dogStartHunger = dog1.getHungerLevel();
		int roboCatStartHappiness = roboCat2.getHappiness();
		int roboDogStartRustLevel = roboDog2.getPetRustLevel();
		testShelter.runAllTicks();
		int catEndThirst = cat1.getThirstLevel();
		int dogEndHunger = dog1.getHungerLevel();
		int roboCatEndHappiness = roboCat2.getHappiness();
		int roboDogEndRustLevel = roboDog2.getPetRustLevel();
		// Assert
		assertEquals(catStartThirst + 1, catEndThirst);
		assertEquals(dogStartHunger + 1, dogEndHunger);
		assertEquals(roboCatStartHappiness - 1, roboCatEndHappiness);
		assertEquals(roboDogStartRustLevel + 1, roboDogEndRustLevel);
	}
}
