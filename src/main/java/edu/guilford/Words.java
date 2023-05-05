package edu.guilford;

public class Words implements Comparable<Words> {
    // this class stores the word and count together
    private String word;
    private int count;
    // constructor for the class 
    public Words(String word, int count) {
        this.word = word;
        this.count = count;
    }
    // getters for the class
    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }
    // compareTo method for the class
    @Override
    public int compareTo(Words other) {
        int cmp = Integer.compare(other.count, this.count);
        if (cmp == 0) {
            cmp = this.word.compareTo(other.word);
        }
        return cmp;
    }
}
