package com.devacto.conferenceplanner;

public class FileFormatException extends Exception {
	
	/**
	 * Exception class to handle wrong string format
	 * in the text file.
	 * 
	 */
	
	private static final long serialVersionUID = 1495775446306927166L;
	
	private String errorDescription;
	private int lineNumber;

	public FileFormatException(String errorDescription, int lineNumber) {
		this.errorDescription = errorDescription;
		this.lineNumber = lineNumber;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	
}
