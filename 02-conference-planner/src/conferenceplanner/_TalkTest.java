package conferenceplanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Victor on 18/05/14.
 */
public class _TalkTest {

    @Test
    public void createOneTalkTest(){
        Talk t = new Talk();
        t.setTitle("Test Title");
        t.setMinuteDuration(90);

        assertEquals("Talk duration should be 90.", 90, t.getMinuteDuration());
        assertEquals("Talk title should be Test Title.", "Test Title", t.getTitle());
    }

    @Test (expected = IllegalArgumentException.class)
    public void negativeDurationNotAllowedTest() throws Exception {
        Talk t = new Talk("Test Title", -90);
    }

    // Test that talk title cannot contain number
    @Test (expected = IllegalArgumentException.class)
    public void talkTitleCannotContainNumberTest() {
        Talk t = new Talk();
        t.setTitle("90 minutes with me!");
    }
}
