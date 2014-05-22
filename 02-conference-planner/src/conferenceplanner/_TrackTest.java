package conferenceplanner;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Victor on 18/05/14.
 */
public class _TrackTest {

    // Track contains a linked list of Sessions.
    // Lunch session is always 12 noon to 1pm.
    // Last session cannot end after 5pm.

    // ts1 stands for Test Session 1
    // tt1 stands for Test Track 1

    @Test (expected = IllegalArgumentException.class)
    public void addSessionToTrackAfterLimitTest(){
        Session ts1 = new Session();
        ts1.setTitle("Test Session 1");
        ts1.setStartTimeFromString("1700");
        ts1.setEndTimeFromString("2000");

        Track tt1 = new Track(new LinkedList<Session>());
        tt1.addSession(ts1);
    }

    // Test if I add overlapping sessions to a talk,
    // then it should not allow me to do it.
    @Test
    public void sessionsCannotOverlapTest(){
        Session ts1 = new Session("Test Session 1", "0800", "0900");
        Session ts2 = new Session("Test Session 2", "0900", "1000");
        Session ts3 = new Session("Test Session 3", "0830", "1030");

        Track tt1 = new Track(new LinkedList<Session>());
        assertTrue(tt1.addSession(ts1));
        assertTrue(tt1.addSession(ts2));
        assertFalse(tt1.addSession(ts3));
    }

}
