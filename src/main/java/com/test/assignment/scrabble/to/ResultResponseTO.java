package com.test.assignment.scrabble.to;

public class ResultResponseTO {

    private String word;

    private Integer points;

    private String message;

    private boolean accepted;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "ResultResponseTO{" +
                "word='" + word + '\'' +
                ", points=" + points +
                ", message='" + message + '\'' +
                ", accepted=" + accepted +
                '}';
    }
}
