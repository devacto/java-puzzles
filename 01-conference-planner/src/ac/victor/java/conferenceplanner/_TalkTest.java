/**
 * 
 */
package ac.victor.java.conferenceplanner;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author victor
 *
 */
public class _TalkTest {

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Talk#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		Talk t = new Talk("Test", 10);
		t.setTitle("Test Title");
		assertEquals(new Talk("Test Title", 10), new Talk("Test Title", 10));
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Talk#setMinuteDuration(int)}.
	 */
	@Test
	public void testSetMinuteDuration() {
		Talk t = new Talk("Test Title", 10);
		t.setMinuteDuration(20);
		assertEquals(new Talk("Test Title", 20), t);
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Talk#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		Talk t = new Talk("Test Title", 10);
		assertEquals("Test Title", t.getTitle());
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Talk#getMinuteDuration()}.
	 */
	@Test
	public void testGetMinuteDuration() {
		Talk t = new Talk("Test Title", 10);
		assertEquals(10, t.getMinuteDuration());
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Talk#compareTo(ac.victor.java.conferenceplanner.Talk)}.
	 */
	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

}
