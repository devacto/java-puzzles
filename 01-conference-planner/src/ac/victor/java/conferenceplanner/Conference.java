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
	
	private void addTrack(Track track) {
		this.tracks.add(track);
	}

	private Track getTrack(int index) {
		return this.tracks.get(index);
	}
	
}
