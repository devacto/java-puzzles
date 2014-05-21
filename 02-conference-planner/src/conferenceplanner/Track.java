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

    public boolean addSession(Session session) {
        if (sessions.isEmpty()) {
            this.sessions.add(session);
            return true;
        }

        // Cannot add session after 5pm.
        try {
            Date lastSessionTime = Constants.DEFAULT_DATE_FORMAT.parse(Constants.LAST_SESSION_TIME_STRING);
            if (session.getEndTime().after(lastSessionTime)) {
                return false;
            }

            if (checkNotOverlap(session)) {
                this.sessions.add(session);
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean checkNotOverlap(Session session) {
        for (Session existingSession : this.sessions) {
            if ((session.getStartTime().after(existingSession.getStartTime())) && (session.getStartTime().before(existingSession.getEndTime()))) {
                return false;
            }

            if ((session.getEndTime().after(existingSession.getStartTime())) && (session.getEndTime().before(existingSession.getEndTime()))) {
                return false;
            }
        }
        return true;
    }
}
