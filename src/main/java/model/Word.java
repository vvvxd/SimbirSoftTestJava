package model;

import java.util.Objects;

public class Word {
    private final String text;
    private int count;

    public Word(String text) {
        this.text = text;
        this.count = 1;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return getText().equals(word.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText());
    }

    @Override
    public String toString() {
        return  text + "  " + count;

    }
}
