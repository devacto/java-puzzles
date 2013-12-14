package ac.victor.java.conferenceplanner.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import ac.victor.java.conferenceplanner.Session;
import ac.victor.java.conferenceplanner.Talk;
import ac.victor.java.conferenceplanner.Track;
import ac.victor.java.conferenceplanner.utils.DateTimeUtil;

public class TrackTest {

	@Test
	public void testAddSessions() {
		Track track = new Track();
		Session session1 = new Session(new Talk("Test 1", 10), DateTimeUtil.generateTime(9, 0));
		Session session2 = new Session(new Talk("Test 2", 10), DateTimeUtil.generateTime(9, 10));
		Session session3 = new Session(new Talk("Test 3", 10), DateTimeUtil.generateTime(9, 20));
		
		track.addSession(session1);
		track.addSession(session2);
		track.addSession(session3);
		assertEquals(session1, track.getSession(0));
	}
	
	@Test
	public void testAddOverlappingSessions(){
		// TODO When have time, test for overlapping sessions.
	}

	@Test
	public void testGetSessions() {
		Track track = new Track();
		Session session1 = new Session(new Talk("Test 1", 10), DateTimeUtil.generateTime(9, 0));
		Session session2 = new Session(new Talk("Test 2", 10), DateTimeUtil.generateTime(9, 10));
		Session session3 = new Session(new Talk("Test 3", 10), DateTimeUtil.generateTime(9, 20));
		
		track.addSession(session1);
		track.addSession(session2);
		track.addSession(session3);
		
		ArrayList<Session> sessionsList = new ArrayList<Session>(3);
		sessionsList.add(session1);
		sessionsList.add(session2);
		sessionsList.add(session3);
		
		assertEquals(sessionsList, track.getSessions());
	}

}
