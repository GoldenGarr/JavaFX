package com.example.firstjavafx.util;

public class FlashCard {
    private String term;
    private String definition;
    private byte is_starred;

    public FlashCard() {
    }

    public FlashCard(String text, String definition, byte is_starred) {
        this.term = text;
        this.definition = definition;
        this.is_starred = is_starred;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String text) {
        this.term = text;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public byte getIs_starred() {
        return is_starred;
    }

    public void setIs_starred(byte is_starred) {
        this.is_starred = is_starred;
    }

    @Override
    public String toString() {
        return "FlashCard: " +
                "term = '" + term + '\'' +
                ", definition = '" + definition + '\'' +
                ", is_starred = " + is_starred;
    }
}
