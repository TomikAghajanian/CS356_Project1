package model;

import java.util.ArrayList;

/**
 * Created by Tomik on 10/12/2017.
 */
public abstract class Question {
    private String question;
    private ArrayList<String> options;
    private ArrayList<String> correctAnswer;

    public Question(String question, ArrayList<String> options, ArrayList<String> correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;

    }

    public String getQuestion() {
        return this.question;
    }

    public ArrayList<String> getOptions() {
        return this.options;
    }
}
