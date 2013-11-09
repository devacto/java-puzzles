package com.devacto.conferenceplanner;

import java.util.ArrayList;

import com.devacto.conferenceplanner.Session;

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
}
