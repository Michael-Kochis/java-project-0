package com.revature.view.scanner;

import java.util.Scanner;

public class ConsoleScanner {
    static Scanner s;
    
    ConsoleScanner() {
    	super();
    	ConsoleScanner.s = getScanner();
    }
    
    public static Scanner getScanner() {
    	if (s == null) {
    		ConsoleScanner.s = new Scanner(System.in);
    	}
    	
    	return s;
    }
    
    public static void setScanner(Scanner scan) {
    	ConsoleScanner.s = getScanner();
    }

	@Override
	public String toString() {
		return "ConsoleScanner is static, use getScanner() method for an instance.";
	}
}
