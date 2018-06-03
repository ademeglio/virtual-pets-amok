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
	
	@Before
	public void setUp() {
		testLitterBox = new LitterBox();
		testCat = new Cat("Fluffy");
	}
		
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
		int wasteLevel = testCat.getWaste();
		// Assert
		assertEquals(wasteLevel, 0);
	}
	
	
}
