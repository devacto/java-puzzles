package ac.victor.java.conferenceplanner;

import java.util.ArrayList;

/**
 * A Track basically contains a list of Sessions.
 * @author victor
 * 
 */

public class Track {

	private ArrayList<Session> sessions;
	
	// Constructing a track from a series of talks
	public Track() {
		sessions = new ArrayList<Session>();
	}
	
	public void addSession (Session session) {
		this.sessions.add(session);
	}
	
	public ArrayList<Session> getSessions() {
		return this.sessions;
	}

	public Session getSession(int index) {
		return this.sessions.get(index);
	}
}
