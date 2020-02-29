package com.revature.view.console;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.revature.controller.Driver;

public class ConsoleMenu {
	private static Logger log = Logger.getLogger(ConsoleMenu.class);
	private TreeMap<Character, String> options = new TreeMap<Character, String>();
	private int x, y;
	private String title;

	public ConsoleMenu() {
		super();
		this.x = 0;
		this.y = 39;
		this.title = "";
	}
	
	public ConsoleMenu(TreeMap<Character, String> options) {
		this();
		this.options = options;
	}

	public TreeMap<Character, String> getOptions() {
		return options;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOptions(TreeMap<Character, String> options) {
		this.options = options;
	}
	
	public void setWidth(int nx) {
		if (nx > 78) { 
			log.warn("Attempt to set menu width larger than screen.");
			nx = 78; 
		}
		this.x = nx;
		this.y = (80 - (nx+2))/2;
	}
	
	public void add(char c, String s) {
		int tLen = s.length() +5;
		if (tLen > this.x) {
			this.setWidth(tLen);
		}
		this.options.put(c, s);
	}
	
	private String centerString(String s) {
		StringBuilder os = new StringBuilder(s);
		
		int i = os.length();
		for (;(i+2) < (this.x); i+=2) {
			os = os.append(" ").reverse().append(" ").reverse();
			
		}
		return fillerString(os.toString());
	}
	
	private void displayContents() {
		fillerLine();
		System.out.printf("| " + centerString(this.title) + " |\n");
		fillerLine();
		System.out.printf("| " + fillerString("") + " |\n");
		for (Map.Entry<Character, String> entry : options.entrySet()) {
			fillerLine();
			System.out.printf("| " + fillerString(entry.getKey() + ": " + entry.getValue()) + " |\n");
		}
	}
	
	public void displayMenu() {
		fillerLine();
		System.out.printf("/");
		printHorizontalLine();
		System.out.printf("\\\n");
		displayContents();
		fillerLine();
		System.out.printf("\\");
		printHorizontalLine();
		System.out.printf("/");
	}
	
	private void fillerLine() {
		for (int i = 1; i <= this.y; i++) {
			System.out.printf(" ");
		}
	}
	
	private String fillerString(String s) {
		StringBuilder os = new StringBuilder(s);
		for (int i = s.length(); i < (this.x -2); i++) {
			os.append(" ");
		}
		
		return os.toString();
	}
	
	private void printHorizontalLine() {
		for (int i = 1; i <= this.x; i++) {
			System.out.printf("-");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsoleMenu other = (ConsoleMenu) obj;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsoleMenu [options=" + options + "]";
	}
	
	

}
