package com.kazup0n.property_counter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class PropertyFileLineCounterTest {

	@Test
	public void testCountEntries() throws IOException {
		final File propertyFile = new File(getClass().getResource("test.properties").getFile());
		final long actual = PropertyFileLineCounter.countEntries(propertyFile);
		final long expected = 10L;
		assertThat(actual, is(expected));
	}

}
