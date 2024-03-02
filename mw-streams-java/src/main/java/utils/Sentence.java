package utils;

import com.opencsv.bean.CsvBindByName;

public class Sentence {
    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "sentence")
    private String sentence;

    // Constructors, getters, and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}