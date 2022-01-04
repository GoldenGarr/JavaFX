package com.example.firstjavafx.util;

public class FlashCard {
    private String term;
    private String definition;
    private boolean is_starred;

    public FlashCard() {
    }

    public FlashCard(String text, String definition, boolean is_starred) {
        this.term = text;
        this.definition = definition;
        this.is_starred = is_starred;
    }

    public String getText() {
        return term;
    }

    public void setText(String text) {
        this.term = text;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean isIs_starred() {
        return is_starred;
    }

    public void setIs_starred(boolean is_starred) {
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
