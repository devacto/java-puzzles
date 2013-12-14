/**
 * 
 */
package ac.victor.java.conferenceplanner.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.Test;

import ac.victor.java.conferenceplanner.Talk;
import ac.victor.java.conferenceplanner.exceptions.FileFormatException;
import ac.victor.java.conferenceplanner.utils.InputParserUtil;

/**
 * @author victor
 */

public class InputParserUtilTest {

	@Test
	public void testParseInputIntoTalks() {
		Talk t1 = new Talk("T1", 10);
		Talk t2 = new Talk("T2", 10);
		
		ArrayList<Talk> talkList = new ArrayList<Talk>(2);
		talkList.add(t1);
		talkList.add(t2);
		
		final Pattern pattern = Pattern.compile("something");
		
		try {
			assertEquals(talkList, InputParserUtil.parseFile("test_small.input"));
		} catch (FileFormatException e) {
			e.printStackTrace();
		}
	}

}
