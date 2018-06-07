package org.wecancodeit.virtual_pets_amok;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CageTest {

	Cage cageTest;
	
	@Before
	public void setUp() {
		cageTest = new Cage(1);
		
	}
	
	
	@Test
	public void shouldHaveDirtyValueAfterMakeDirty() {
		// Setup
		
		// Act
		int cageDirtyStart = cageTest.getCleanliness();
		cageTest.makePetBoxDirty(1);
		int cageDirtyEnd = cageTest.getCleanliness();
		// Assert
		assertEquals(cageDirtyStart + 1, cageDirtyEnd);
	}
	
	@Test
	public void shouldCleanPetBox() {
		// setup
		cageTest.makePetBoxDirty(1);
		int cageDirtyStart = cageTest.getCleanliness();
		cageTest.scrubPetBox();
		int cageDirtyEnd = cageTest.getCleanliness();
		// Assert
		assertEquals(cageDirtyStart - 1, cageDirtyEnd);
	}
	
}
