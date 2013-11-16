package ac.victor.java.conferenceplanner;

public class Talk implements Comparable<Talk> {
	
	private String title;
	private int minuteDuration;
	
	public Talk(String title, int minuteDuration) {
		this.title = title;
		this.minuteDuration = minuteDuration;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMinuteDuration(int minDur) {
		this.minuteDuration = minDur;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getMinuteDuration() {
		return this.minuteDuration;
	}

	@Override
	public int compareTo(Talk talk) {
		// This will do a descending sorting
		if (this.minuteDuration > talk.minuteDuration) {
			return -1;
		} else if (this.minuteDuration < talk.minuteDuration) {
			return 1;
		} else {
			return 0;
		}
	}
}
