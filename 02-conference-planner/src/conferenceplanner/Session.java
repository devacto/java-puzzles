package conferenceplanner;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Victor on 18/05/14.
 */
public class Session {
    private String title;
    private Date startTime;
    private Date endTime;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTimeFromString(String startTime) {
        try {
            this.startTime = Constants.DEFAULT_DATE_FORMAT.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setEndTimeFromString(String endTime) {
        try {
            Date endTimeDate = Constants.DEFAULT_DATE_FORMAT.parse(endTime);

            if (this.startTime != null) {
                if (endTimeDate.before(this.startTime)) {
                    throw new IllegalArgumentException("Proposed end time is before start time");
                }
            }

            this.endTime = endTimeDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getDuration() {
        return (int) ((endTime.getTime() - startTime.getTime()) / 1000 / 60);
    }

    public String getStartTimeInString() {
        return Constants.DEFAULT_DATE_FORMAT.format(startTime);
    }

    public String getEndTimeInString() {
        return Constants.DEFAULT_DATE_FORMAT.format(endTime);
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
        return startTime;
    }
}
