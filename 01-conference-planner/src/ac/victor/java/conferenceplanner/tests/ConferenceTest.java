package ac.victor.java.conferenceplanner.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ac.victor.java.conferenceplanner.Conference;
import ac.victor.java.conferenceplanner.Session;
import ac.victor.java.conferenceplanner.Talk;
import ac.victor.java.conferenceplanner.Track;
import ac.victor.java.conferenceplanner.utils.DateTimeUtil;

public class ConferenceTest {

	@Test
	public void testConference() {
		Session s1 = new Session(new Talk("T1", 15), DateTimeUtil.generateTime(9, 0));
		Session s2 = new Session(new Talk("T2", 15), DateTimeUtil.generateTime(9, 15));
		Track tr1 = new Track();
		tr1.addSession(s1);
		tr1.addSession(s2);
		
		Session s3 = new Session(new Talk("T3", 15), DateTimeUtil.generateTime(9, 0));
		Session s4 = new Session(new Talk("T4", 15), DateTimeUtil.generateTime(9, 15));
		Track tr2 = new Track();
		tr2.addSession(s3);
		tr2.addSession(s4);
		
		Conference c = new Conference();
		c.addTrack(tr1);
		c.addTrack(tr2);
		
		assertEquals(tr1, c.getTrack(0));
		assertEquals(tr2, c.getTrack(1));
	}

}
