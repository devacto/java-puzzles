package ac.victor.java.conferenceplanner;

import java.util.Date;

import ac.victor.java.conferenceplanner.Talk;

/**
 * The session class gives a start time to a talk. 
 * 
 * @author victor
 */

public class Session {

	private Talk talk;
	private Date startTime;
	
	public Session(Talk talk, Date startTime) {
		this.talk = talk;
		this.startTime = startTime;
	}
	
	public Session() {
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public Talk getTalk() {
		return this.talk;
	}
}
