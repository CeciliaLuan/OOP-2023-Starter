package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> follows;
    
    public Word(String word, ArrayList<Follow> follows) {
        this.word = word;
        this.follows = follows;
    }
    
    public String getWord() {
        return word;
    }
    
    public ArrayList<Follow> getFollows() {
        return follows;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Word: ").append(word).append("\n");
        sb.append("Follows: \n");
        for (Follow follow : follows) {
            sb.append(follow).append("\n");
        }
        return sb.toString();
    }


    
}
