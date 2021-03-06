package ac.victor.java.conferenceplanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import ac.victor.java.conferenceplanner.ConferencePlanner;
import ac.victor.java.conferenceplanner.exceptions.FileFormatException;

/**
 * Executable class which provides sanitised input to a conference class for timetable computation.
 * The class relies on clean data. It possesses no capacity for fuzzy interpretation of badly formatted 
 * data, thus it does sanitise the data but merely ensures that what is passed to the Conference object 
 * has been verified. On encountering a parsing error, it will simply exit with an error code.
 * 
 * @author Victor Wibisono (devacto@gmail.com)
 *
 */

public class Client {
	
	// The default filename, used if no filename is provided by the user.
	private static final String DEFAULT_FILE = "test.input";
	
	// The name file from which data is to be read.
	private static String inputFileName;

	private static Scanner s;
	
	/**
	 * Takes a String argument identifying the file to be opened. If the String is null, a filename
	 * is requested from Standard.in. If the user enters an empty String, the default filename is used.
	 * @param args
	 * @throws IOException 
	 * @throws FileFormatException 
	 */
	
	public static void main(String[] args) throws FileFormatException, IOException {
		
		// Initial parameter will contain filename, if one exist, so check this first.
		if(args.length==0) {
			// Filename not supplied by command line, get from user.
			inputFileName = getInputFileName();
		} else {
			inputFileName = args[0];
		} 
		
		// Instantiate the Conference object with the filename specified. 
		try {
			@SuppressWarnings("unused")
			ConferencePlanner conference = new ConferencePlanner(inputFileName);
		} catch (FileNotFoundException e) {
			System.err.println("Fatal error: " + e.getMessage() + "\nProgram terminated unsuccessfully.");
		}

	}

	private static String getInputFileName() {
		
		s = new Scanner(System.in);
		while (true) {
			System.out.println("Enter input file name: ");
			String input = s.nextLine();
			if(input.isEmpty()) {
				input = DEFAULT_FILE; 
			}
			return input;
		}
	}
	
}
