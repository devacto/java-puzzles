package ac.victor.java.conferenceplanner.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import ac.victor.java.conferenceplanner.Talk;
import ac.victor.java.conferenceplanner.exceptions.FileFormatException;

public class InputParserUtil {

	private static final String LIGHTNING = "lightning";
	private static final int LIGHTNING_DURATION = 5;
	
	/**
	 * Takes an input file and parses it into Talk objects.
	 * Talk objects are extracted by Conference objects and arranged into tracks.
	 * 
	 * @param inputFile
	 * @throws FileFormatException 
	 */
	
	public static ArrayList<Talk> parseFile(String filename) throws FileFormatException {
		BufferedReader reader = null;
		File inputFile = new File(filename);
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			e.printStackTrace();
		}
		
		return parseToTalks(reader);
	}
	
	private static ArrayList<Talk> parseToTalks(BufferedReader bufferedReader) throws FileFormatException {

		// Read input file line by line and convert the information into Talk objects.
		ArrayList<Talk> result = new ArrayList<Talk>();
		Scanner s = new Scanner(bufferedReader);
 
		try {
			int lineNumber = 0;
			while(s.hasNextLine()) {

				lineNumber ++;
				String title;
				int minuteDuration;

				// Read the next line of the file.
				String rawTalk = s.nextLine();

				// Split title and duration from the index of the first integer in the line.
				
				// Find out the index of the first occurrence of integer.
				String firstDigit  = rawTalk.replaceFirst(".*?(\\d+).*", "$1");
				
				if (firstDigit.matches("\\d+")) {
					int indexOfFirstInteger = rawTalk.indexOf(firstDigit);
					title = rawTalk.substring(0, indexOfFirstInteger);
					minuteDuration = Integer.parseInt(firstDigit);
					
					result.add(new Talk(title,minuteDuration));

				} else {
					// Look for the word "lightning".
					int indexOfLightning = rawTalk.indexOf(LIGHTNING);

					// If there is no word "lightning", throw an error.
					if (indexOfLightning == -1) {
						throw new FileFormatException("Could not find duration or a duration keyword.", lineNumber + 1);
					}

					title = rawTalk.substring(0, indexOfLightning);
					minuteDuration = LIGHTNING_DURATION; 
					result.add(new Talk(title,minuteDuration));
				}

			}

		} finally {
			s.close();
		}

		return result;
	}
	
}
