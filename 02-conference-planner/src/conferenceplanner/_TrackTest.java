package conferenceplanner;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by Victor on 18/05/14.
 */
public class _TrackTest {

    // Track contains a linked list of Sessions.
    // Lunch session is always 12 noon to 1pm.
    // Last session cannot end after 5pm.

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

}
