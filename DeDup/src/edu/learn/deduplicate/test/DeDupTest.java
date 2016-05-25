package edu.learn.deduplicate.test;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.learn.deduplicate.DeDup;

/**
 * 
 * @author Bhupendra
 * Minimal set of test cases for check De Duplication
 */
public class DeDupTest {

	/**
	 * Test case by Linear search.
	 */
	@Test
	public void assertLinearSearchNotNull() {
		DeDup deDup = new DeDup();
		assertNotNull(deDup.getNonDuplicateArrayByLinearSearch());
	}
	
	@Test
	public void assertLinearSearchSize() {
		DeDup deDup = new DeDup();
		assert(deDup.getNonDuplicateArrayByLinearSearch().length==29);
	}
	
	/**
	 * Test case by Java8.
	 */
	@Test
	public void assertJava8StreamNotNull() {
		DeDup deDup = new DeDup();
		assertNotNull(deDup.getNonDuplicateArrayByJavaStream());
	}
	
	@Test
	public void assertJava8StreamSize() {
		DeDup deDup = new DeDup();
		assert(deDup.getNonDuplicateArrayByJavaStream().length==29);
	}
	
	/**
	 * Test case by set.
	 */
	@Test
	public void assertSetNotNull() {
		DeDup deDup = new DeDup();
		assertNotNull(deDup.getNonDuplicateArrayBySet());
	}
	
	@Test
	public void assertSetSize() {
		DeDup deDup = new DeDup();
		assert(deDup.getNonDuplicateArrayBySet().length==29);
	}
	
	/**
	 * Test case by sort.
	 */
	@Test
	public void assertSortNotNull() {
		DeDup deDup = new DeDup();
		assertNotNull(deDup.getNonDuplicateArrayBySort());
	}
	
	@Test
	public void assertSortSize() {
		DeDup deDup = new DeDup();
		assert(deDup.getNonDuplicateArrayBySort().length==29);
	}
}
