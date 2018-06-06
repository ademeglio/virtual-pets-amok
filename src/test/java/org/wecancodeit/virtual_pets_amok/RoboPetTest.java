package org.wecancodeit.virtual_pets_amok;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class RoboPetTest {

	PetBox testPetBox;
	VirtualPet testPet1;
	
	@Before
	public void setUp() {
		testPetBox = new PetBox();
		testPet1 = new VirtualPet("Bob");
	}
	
	@Test
	public void shouldAddRoboCat() {
		// Setup
		RoboCat roboCat1 = new RoboCat("Bytes");
		// Act
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(roboCat1);
		int petCountEnd = testPetBox.getSize();
		String petName = roboCat1.getPetName();
		//Assert
		assertEquals(petCountEnd -1, petCountStart);
		assertEquals(petName, "Bytes");
	}
	
	@Test
	public void shouldAddRoboDog() {
		// Setup
		RoboDog roboDog1 = new RoboDog("Copper");
		// Act
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(roboDog1);
		int petCountEnd = testPetBox.getSize();
		String petName = roboDog1.getPetName();
		//Assert
		assertEquals(petCountEnd -1, petCountStart);
		assertEquals(petName, "Copper");
	}
	
	@Test
	public void ShouldAddRoboDogAndRoboCat() {
		// Setup
		RoboCat roboCat1 = new RoboCat("Bytes");
		RoboDog roboDog1 = new RoboDog("Copper");
		// Act
		testPetBox.addPet(roboCat1);
		testPetBox.addPet(roboDog1);
		// Assert
		assertThat(roboCat1, instanceOf(VirtualPet.class));
		assertThat(roboDog1, instanceOf(VirtualPet.class));
	}
	
	@Test
	public void shouldRemoveRoboPet() {
		// setup
		RoboCat roboCat1 = new RoboCat("Bytes");
		RoboDog roboDog1 = new RoboDog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		
		//Act
		testPetBox.addPet(roboDog2);
		testPetBox.addPet(roboCat2);
		testPetBox.addPet(roboDog1);
		testPetBox.addPet(roboCat1);
		testPetBox.removePet(roboDog1);
		Collection<VirtualPet> allPets = testPetBox.getAllPets();
		// Assert
		assertThat(allPets, not(contains(roboDog1)));
		
	}
	
	@Test
	public void shouldDecreaseRustLevel() {
		RoboCat roboCat1 = new RoboCat("Bytes");
		roboCat1.oilPet();
		int rustLevelEnd = roboCat1.getPetRustLevel();
		// Assert
		assertEquals(rustLevelEnd, 0);
	}
	
	@Test
	public void shouldGeAllRobotPets() {
		// Setup
		Cat Cat1 = new Cat("Bytes");
		Dog Dog1 = new Dog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		// Action
		testPetBox.addPet(roboDog2);
		testPetBox.addPet(roboCat2);
		testPetBox.addPet(Dog1);
		testPetBox.addPet(Cat1);
		
		Collection<RoboPet> robotPets = testPetBox.getAllRobotPets();
		
		// Assert
		assertThat(robotPets, not(containsInAnyOrder(Dog1, Cat1)));
	}
	
	@Test
	public void shouldEffectRobotHealthHappinessRustWhenTickIsRun() {
		// Setup
		RoboCat roboCat = new RoboCat("Javi");
		testPetBox.addPet(roboCat);
		int catHappinessStart = roboCat.getHappiness();
		int catRustStart = roboCat.getPetRustLevel();
		int catHealthStart = roboCat.getHealth();
		// Act
		roboCat.tick();
		// Assert
		assertEquals(catHappinessStart -1, 4);
		assertEquals(catRustStart + 1, 2);
		assertEquals(catHealthStart -1, 9);
	}

}
