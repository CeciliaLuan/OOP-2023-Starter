package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {



	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}

	String[] sonnet;
	private String w;

	public String[] writeSonnet() {
		return null;
	}

	public void loadfile() {
		String[] sonnet = loadStrings("small.txt");
		for(String s: sonnet)
		{
		String[] words = s.split(" "); // Split a string into an array of words
        w.replaceAll("[^\\w\\s]",""); // Remove punction characters
        s.toLowerCase(); // Convert a string to lower case 
		}}

	// prints the small.txt file
	public void printModel() {
		String[] small = loadStrings("small.txt");
		for (String s : small) {
			System.out.println(s);
		}
	}

	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);

	}

	public class Follow {
		private String word;
		private int count;
	
		public Follow(String word, int count) {
			this.word = word;
			this.count = count;
		}
	
		public String getWord() {
			return word;
		}
	
		public int getCount() {
			return count;
		}
	
		public String toString() {
			return word + ": " + count;
		}
	}
	
	public class Word {
		private String word;
		private ArrayList<Follow> follows;
	
		public Word(String word) {
			this.word = word;
			this.follows = new ArrayList<Follow>();
		}
	
		public String getWord() {
			return word;
		}
	
		public ArrayList<Follow> getFollows() {
			return follows;
		}
	
		public void addFollow(String word, int count) {
			follows.add(new Follow(word, count));
		}
	
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(word).append(": ");
			for (Follow follow : follows) {
				sb.append(follow.toString()).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			return sb.toString();
		}
	}
}





