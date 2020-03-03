package com.revature.view.scanner;

import java.util.Scanner;

public class ConsoleScanner {
    static Scanner s;
    
    ConsoleScanner() {
    	super();
    	ConsoleScanner.s = getScanner();
    }
    
    /** Generates a new scanner for System.in if one does not exist, 
     * then returns the value of the Scanner object. */
    public static Scanner getScanner() {
    	if (s == null) {
    		ConsoleScanner.s = new Scanner(System.in);
    	}
    	
    	return s;
    }
    
    /** Function ignores the attempt to assign a specific Scanner and
     * instead uses the method specified in the getScanner method. */
    public static void setScanner(Scanner scan) {
    	ConsoleScanner.s = getScanner();
    }

    /** Function toString returns a string letting the user know how to
     * use this class. */
	@Override
	public String toString() {
		return "ConsoleScanner is static, use getScanner() method for an instance.";
	}
}
