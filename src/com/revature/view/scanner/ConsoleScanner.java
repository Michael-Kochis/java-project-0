package com.revature.view.scanner;

import java.util.Scanner;

public class ConsoleScanner {
    static Scanner s;
    
    ConsoleScanner() {
    	super();
    	s = getScanner();
    }
    
    public Scanner getScanner() {
    	if (s == null) {
    		s = new Scanner(System.in);
    	}
    	
    	return s;
    }
    
    public void setScanner(Scanner scan) {
    	s = getScanner();
    }

	@Override
	public String toString() {
		return "ConsoleScanner is static, use getScanner() method for an instance.";
	}
}
