package programming.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import programming.HashTableImpl;

public class HashTableImplTest {

	private HashTableImpl classToTest = new HashTableImpl();
	@Rule public ExpectedException expectedException;
	
	@Test
	public void shouldAddElements() {
		classToTest.put("one", "one val");
		classToTest.put("two", "two val");
		classToTest.put("three", "three val");
		assertThat("Size should be 3 after adding 3 elements", classToTest.size(), is(equalTo(3)));
		classToTest.remove("three");
		assertThat("Size should be 2 after removing 1 elements", classToTest.size(), is(equalTo(2)));
		System.out.println("Keys :: " + classToTest.keys());
		System.out.println("Values :: " + classToTest.values());
		assertThat("Values not mapped correctly", classToTest.get("one"), is(equalTo("one val")));
	}

}
