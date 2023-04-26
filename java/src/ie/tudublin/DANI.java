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



	public void setup() {
		colorMode(HSB);
		loadFile();

	}

	public void keyPressed() {
        if (key == ' ') {
            sonnet = writeSonnet();
            for (String line : sonnet) {
                System.out.println(line);
            }

        }
    }

	

	float off = 0;

	public void loadFile() {
		String[] lines = loadStrings("small.txt");
		for (String line : lines) {
			String[] words = split(line, ',');
			for (String w : words) {
				w = w.replaceAll("[^w\\s]","");
				w = w.toLowerCase();
			}
		}
	}
	
	public void printModel() {
        for (Word word : model) {
            System.out.print(word.getWord() + ": ");
            for (Follow follow : word.getFollows()) {
                System.out.print(follow.getWord() + "(" + follow.getCount() + ") ");
            }
            System.out.println();
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

	public String[] writeSonnet() {
		String[] sonnet = new String[14];
		for (int i = 0; i < 14; i++) {
			String line = "";
			Word word = model.get((int)random(model.size()));
			line += word.getWord();
			int count = 1;
			while (count <= 8) {
				ArrayList<Follow> follows = word.getFollows();
				if (follows.size() == 0) {
					break;
				}
				Follow follow = follows.get((int)random(follows.size()));
				line += " " + follow.getWord();
				count++;
				word = findWord(follow.getWord());
			}
			sonnet[i] = line;
		}
		return sonnet;
	}


	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);
		

	}

	//added follow class

	public class Follow {

		private String word;
		private int count;
	
		public Follow(String word, int count) {// Constructor that takes a word and a count
			this.word = word;
			this.count = count;
		}
	
		public String getWord() {// Getter for the word
			return word;
		}
	
		public int getCount() {
			return count;// Getter for the count

		}

		public void setWord(String word) {//setters word
			this.word = word;
		}

		public void setCount(int count) {//setter count
			this.count = count;
		}
	
		public String toString() {
			return word + ": " + count;
		}
	}

	//added word class

	public class Word {
		private String word;
		private ArrayList<Follow> follows;
	
		public Word(String word, ArrayList<Follow> arrayList) {
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






