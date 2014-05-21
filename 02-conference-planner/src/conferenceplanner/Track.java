package conferenceplanner;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by victor on 18/05/14.
 */
public class Track {
    private LinkedList<Session> sessions;

    public Track(LinkedList<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        if (sessions.isEmpty()) {
            this.sessions.add(session);
        }

        // Cannot add session after 5pm.
        try {
            Date lastSessionTime = Constants.DEFAULT_DATE_FORMAT.parse(Constants.LAST_SESSION_TIME_STRING);
            if (session.getEndTime().after(lastSessionTime)) throw new IllegalArgumentException("Session cannot " +
                    "start after the specified time limit.");

            this.sessions.add(session);

            // Need to check that sessions do not overlap.

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
