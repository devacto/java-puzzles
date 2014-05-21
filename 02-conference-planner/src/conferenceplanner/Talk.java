package conferenceplanner;

/**
 * Created by Victor on 18/05/14.
 */
public class Talk {

    private String title;
    private int minuteDuration;

    public Talk(String title, int minuteDuration) {
        setTitle(title);
        setMinuteDuration(minuteDuration);
    }

    public Talk() {
        // Empty talk constructor
    }

    public void setTitle(String title) {
        // Title cannot contain numbers
        if (title.matches(".*\\d.*")) throw new IllegalArgumentException("Title cannot contain numbers.");
        this.title = title;
    }

    public void setMinuteDuration(int minuteDuration) {
        if (minuteDuration < 0) throw new IllegalArgumentException("Duration in minutes cannot be negative.");
        this.minuteDuration = minuteDuration;
    }

    public int getMinuteDuration() {
        return minuteDuration;
    }

    public String getTitle() {
        return title;
    }
}
