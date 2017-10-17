package model;

import java.util.ArrayList;

/**
 * Created by Tomik on 10/12/2017.
 */
public class SingleChoiceQuestion extends Question {
    public SingleChoiceQuestion(String question, ArrayList<String> options, ArrayList<String> correctAnswer) {
        super(question, options, correctAnswer);
    }
}
