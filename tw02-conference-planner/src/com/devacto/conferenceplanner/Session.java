package com.devacto.conferenceplanner;

import java.util.Date;

import com.devacto.conferenceplanner.Talk;

public class Session {

	private Talk talk;
	private Date startTime;
	
	public Session(Talk talk, Date startTime) {
		this.talk = talk;
		this.startTime = startTime;
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
