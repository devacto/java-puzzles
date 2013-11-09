package com.devacto.conferenceplanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class FileOutputProducer {

	/**
	 * Given an array of tracks, this class produces a String which will then be
	 * printed both on the screen and onto the output file.
	 * 
	 * @param tracks
	 */

	private ArrayList<Track> tracks;

	public FileOutputProducer(ArrayList<Track> tracks, String inputFileName) {
		this.tracks = tracks;		
	}

	public File getOutputFile(String inputFileName) {
		return printScheduleToFile(inputFileName);
	}
	
	public File printScheduleToFile(String inputFileName) {
		
		// Print schedule from tracks.
		StringBuilder resultString = new StringBuilder();
		ArrayList<Track> tracks = this.tracks;

		int trackNumber = 0;

		for (Iterator<Track> i = tracks.iterator(); i.hasNext();) {
			Track track = i.next();

			resultString.append("\nTrack ").append(++trackNumber).append(":\n");

			for (Iterator<Session> j = track.getSessions().iterator(); j.hasNext();) {
				Session session = j.next();

				// Produce duration text: Do not display duration text for lunch and networking session menu.
				// Duration of 5 minutes should become lightning.
				String durationText = getDurationText(session);

				resultString.append(generateTimeString(session.getStartTime())).append(": ").append(session.getTalk().getTitle()).append(" ").append(durationText).append("\n");
			}
		}

		// Write the output file.
		return writeOutputFile(getOutputFileName(inputFileName), resultString);
	}

	private String getOutputFileName(String inputFileName) {
		return inputFileName.replace(".", "_") + "_schedule.txt";
	}

	private File writeOutputFile(String fileName, StringBuilder result) {
		File outputFile = new File(fileName);

		// From the collated string, print first to screen and then to output file.
		try {
			PrintWriter writer = new PrintWriter(outputFile);
			writer.print(result);
			System.out.println(result);
			System.out.println("Output written to " + outputFile.getAbsolutePath());
			writer.close();
			return outputFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return outputFile;
	}

	// Helper function to print the duration text.
	private String getDurationText(Session session) {
		String durationText = session.getTalk().getMinuteDuration() + "min";
		if ((session.getTalk().getTitle() == "Lunch") || (session.getTalk().getTitle() == "Networking Event")) {
			durationText = "";
		} else if (session.getTalk().getMinuteDuration() == 5) {
			durationText = "lightning";
		}
		return durationText;
	}

	// Helper function to generate string from a Time object.
	private static String generateTimeString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mma");
		String result = format.format(date);
		return result;
	}
}
