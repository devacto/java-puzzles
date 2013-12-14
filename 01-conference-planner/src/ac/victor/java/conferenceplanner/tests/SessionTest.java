/**
 * 
 */
package ac.victor.java.conferenceplanner.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.victor.java.conferenceplanner.Session;
import ac.victor.java.conferenceplanner.Talk;
import ac.victor.java.conferenceplanner.utils.DateTimeUtil;

/**
 * @author victor
 *
 */
public class SessionTest {

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Session#setTalk(ac.victor.java.conferenceplanner.Talk)}.
	 */
	@Test
	public void testSetTalk() {
		Talk t = new Talk("Test", 10);
		Session s = new Session();
		s.setTalk(t);
		s.setStartTime(DateTimeUtil.generateTime(10, 0));
		assertEquals(t, s.getTalk());
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Session#setStartTime(java.util.Date)}.
	 */
	@Test
	public void testSetStartTime() {
		Talk t = new Talk("Test", 10);
		Session s = new Session(t, DateTimeUtil.generateTime(9, 0));
		s.setStartTime(DateTimeUtil.generateTime(10, 0));
		assertEquals(DateTimeUtil.generateTime(10, 0), DateTimeUtil.generateTime(10, 0));
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Session#getStartTime()}.
	 */
	@Test
	public void testGetStartTime() {
		Talk t = new Talk("Test Talk", 10);
		Session s = new Session(t, DateTimeUtil.generateTime(9, 0));
		assertEquals(DateTimeUtil.generateTime(9, 0), s.getStartTime());
	}

	/**
	 * Test method for {@link ac.victor.java.conferenceplanner.Session#getTalk()}.
	 */
	@Test
	public void testGetTalk() {
		Talk t = new Talk("Test", 10);
		Session s = new Session(t, DateTimeUtil.generateTime(9, 0));
		assertEquals(t, s.getTalk());
	}

}
