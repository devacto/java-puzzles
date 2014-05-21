package conferenceplanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _SessionTest {

    // Session should have a start time.
    // Session should have an end time.

    @Test
    public void startAndEndTimeTest(){
        Session s = new Session();
        s.setTitle("Test Title");
        s.setStartTimeFromString("1000");
        s.setEndTimeFromString("1200");

        assertEquals("Get start time.", "1000", s.getStartTimeInString());
        assertEquals("Get end time.", "1200", s.getEndTimeInString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addSessionWithEndTimeLessThanStartTime(){
        Session s = new Session();
        s.setStartTimeFromString("1000");
        s.setEndTimeFromString("0900");
    }

    @Test
    public void durationTest(){
        Session s = new Session();
        s.setTitle("Test Title");
        s.setStartTimeFromString("1000");
        s.setEndTimeFromString("1200");

        System.out.println(s.getDuration());
        assertEquals("Get duration in minutes.", 120, s.getDuration());
    }

}