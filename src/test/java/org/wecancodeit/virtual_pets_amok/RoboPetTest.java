package org.wecancodeit.virtual_pets_amok;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
	
	
}
