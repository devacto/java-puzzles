/**
 * 
 */
package ac.victor.java.conferenceplanner;

import java.util.ArrayList;

/**
 * Conference class which  
 * @author victor
 */
public class Conference {

	private ArrayList<Track> tracks;
	
	public Conference() {
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}

	public Track getTrack(int index) {
		return this.tracks.get(index);
	}
	
}
