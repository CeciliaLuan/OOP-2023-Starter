package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	String[] sonnet;
	ArrayList<Word> model = new ArrayList<Word>();

	
	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}




	public String[] writeSonnet() {
		return null;
	}


	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {

	}

	float off = 0;

	public void loadFile() {
		String[] lines = loadStrings("small.txt");
		for (String line : lines) {
			String[] words = split(line, ',');
			for (String w : words) {
				w = w.replaceAll("[^\\w\\s]", "");
				w = w.toLowerCase();
			}
		}
	}

	
	public Word findWord(String str) {
		for (Word w : model) {
			if (w.getWord().equals(str)) {
				return w;
			}
		}
		return null;
	}

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


public static void main(String[] args) {
    PApplet.main("ie.tudublin.DANI");
}
}




