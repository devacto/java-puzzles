package ac.victor.java.conferenceplanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import ac.victor.java.conferenceplanner.exceptions.FileFormatException;
import ac.victor.java.conferenceplanner.utils.DateTimeUtil;
import ac.victor.java.conferenceplanner.utils.InputParserUtil;

public class ConferencePlanner {

	private ArrayList<Track> tracks;

	/**
	 * Arranges the Talk objects into Session objects by 
	 * giving them a starting time. Sessions are then arranged into Track objects.
	 * Then it generates an output file containing the schedule.
	 * 
	 * @param inputFileName
	 * @throws FileFormatException
	 * @throws IOException
	 */

	public ConferencePlanner(String inputFileName) throws FileFormatException, IOException {
		
		// Create an inputParser object whose sole purpose is to parse input file into an array of talks.
		ArrayList<Talk> talks = InputParserUtil.parseFile(inputFileName);
		
		this.tracks = generateTracksFromTalk(talks);

		// Create a fileOutputProducer object whose sole purpose is to produce output file from tracks.
		FileOutputProducer fileOutputProducer = new FileOutputProducer(this.tracks, inputFileName);
		
		// Print output file containing the conference track schedule.
		fileOutputProducer.printScheduleToFile(inputFileName);
	}

	public ArrayList <Track> getTracks() {
		return this.tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}	

	private ArrayList<Track> generateTracksFromTalk(ArrayList<Talk> talks) {

		// Sort talks based on duration, the talk with the longest duration first.
		Collections.sort(talks);

		// Find out the number of tracks based on the total amount of duration.
		int numberOfTracks = calculateNumberOfTracks(talks);

		ArrayList<Track> trackArray = new ArrayList<Track>();
		for (int z = 0; z < numberOfTracks; z++) {
			Track track = new Track();

			// Arrange morning sessions that run from 9am to 12pm.
			arrangeMorningSessions(talks, track);

			// Insert lunch that runs from 12pm to 1pm.
			insertLunch(track);

			// Arrange afternoon sessions that run from 1pm to between 4pm and 5pm.
			arrangeAfternoonSessions(talks, track);

			// Add track into the list of tracks.
			trackArray.add(track);
		}

		return trackArray;
	}

	private void insertNetworkingEvent(Track track, Date afternoonSessionTime) {
		
		// Create a networking session and insert it at the end of the day.
		Talk networkingTalk = new Talk("Networking Event", 0);
		Session networkingSession = new Session(networkingTalk, afternoonSessionTime);
		track.addSession(networkingSession);
	}

	private void arrangeAfternoonSessions(ArrayList<Talk> talks, Track track) {
		
		// Generates the starting hour and minutes of the afternoon session.
		Date afternoonSessionTime = DateTimeUtil.generateTime(13, 0);
		int afternoonDurationCredit = 240;
		while ((afternoonDurationCredit > 0) && (talks.isEmpty() == false)) {

			// Look for the next talk that fits into the remaining duration and create a session by giving it a start time.
			for (Iterator<Talk> i = talks.iterator(); i.hasNext();) {
				Talk t = i.next();
				if (t.getMinuteDuration() <= afternoonDurationCredit) {
					afternoonDurationCredit -= t.getMinuteDuration();
					Session s = new Session(t, afternoonSessionTime);
					afternoonSessionTime = DateTimeUtil.addMinutesToTime(afternoonSessionTime, t.getMinuteDuration());
					track.addSession(s);
					talks.remove(t);
					break;
				}
			}

		}
		
		// Insert networking session.
		insertNetworkingEvent(track, afternoonSessionTime);
	}

	private void insertLunch(Track track) {
		
		// Create a lunch 'session' and insert it into the track.
		Talk lunchTalk = new Talk("Lunch", 60);
		Session lunchSession = new Session(lunchTalk, DateTimeUtil.generateTime(12, 0));
		track.addSession(lunchSession);
	}

	private void arrangeMorningSessions(ArrayList<Talk> talks, Track track) {
		// Fill up the track with sessions
		Date morningSessionTime = DateTimeUtil.generateTime(9, 0);

		// Arrange morning session with total duration of 180 minutes.
		int morningDurationCredit = 180;
		while ((morningDurationCredit > 0) && (talks.isEmpty() == false)) {

			// Look for the next talk that fits into the remaining duration and create a session by giving it a start time.
			for (Iterator<Talk> i = talks.iterator(); i.hasNext();) {
				Talk t = i.next();
				if (t.getMinuteDuration() <= morningDurationCredit) {
					morningDurationCredit -= t.getMinuteDuration();
					Session s = new Session(t, morningSessionTime);
					morningSessionTime = DateTimeUtil.addMinutesToTime(morningSessionTime, t.getMinuteDuration());
					track.addSession(s);
					talks.remove(t);
					break;
				}
			}
		}
	}

	// Estimate the number of tracks, from the total duration of all the talks.	
	private int calculateNumberOfTracks(ArrayList<Talk> talks) {
		int totalRawDuration = 0;
		for (Iterator<Talk> i = talks.iterator(); i.hasNext();) {
			Talk talk = i.next();
			totalRawDuration = totalRawDuration + talk.getMinuteDuration();
		}

		int numberOfTracks = totalRawDuration / 420 + 1;
		return numberOfTracks;
	}

}

