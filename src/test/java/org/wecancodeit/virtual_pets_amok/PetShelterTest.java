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
		Cat Cat1 = new Cat("Bytes");
		Dog Dog1 = new Dog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		LitterBox litterBox = new LitterBox();
		
		//Act
		cage1.addPet(Dog1);
		cage2.addPet(roboDog2);
		litterBox.addPet(Cat1);
		litterBox.addPet(roboCat2);
		testShelter.addToShelter(1, cage1);
		testShelter.addToShelter(2, cage2);
		testShelter.addToShelter(3, litterBox);
		Collection<RoboPet> roboPets = testShelter.getAllRoboPets();
		
		// Assert
		assertThat(roboPets, containsInAnyOrder(roboDog2, roboCat2));
		assertThat(roboPets, not(containsInAnyOrder(Dog1, Cat1)));
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
	
	
	
}
