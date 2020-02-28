package com.revature.view.console;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.revature.controller.Driver;

public class ConsoleMenu {
	private static Logger log = Logger.getLogger(ConsoleMenu.class);
	private TreeMap<Character, String> options = new TreeMap<Character, String>();
	private int x, y;

	public ConsoleMenu() {
		super();
		this.x = 0;
		this.y = 39;
	}
	
	public ConsoleMenu(TreeMap<Character, String> options) {
		this();
		this.options = options;
	}

	public TreeMap<Character, String> getOptions() {
		return options;
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
		this.options.put(c, s);
	}
	
	public void displayMenu() {
		fillerLine();
		System.out.printf("/");
		printHorizontalLine();
		System.out.printf("\\\n");
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
