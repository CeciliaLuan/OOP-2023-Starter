package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void loadfile() {
		String[] sonnet = loadStrings("sonnet.txt");
		for (String s : sonnet) {
			System.out.println(s);
		}
	}


	public void findWord(String str) {
		for (String s : sonnet) {
			if (s.contains(str)) {
				System.out.println(s);
			}
		}
	}


	//loads the small.txt file

	public void loadfile() {
		String[] small = loadStrings("small.txt");
		for (String s : small) {
			System.out.println(s);
		}
	}

//prints the small.txt file
	public void printModel() {
		String[] small = loadStrings("small.txt");
		for (String s : small) {
			System.out.println(s);
		}
	}
	
	public void writeSonnet()
	{
		
	}

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
