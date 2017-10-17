package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tomik on 10/12/2017.
 */
public class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String question, ArrayList<String> options, ArrayList<String> correctAnswer) {
        super(question, options, correctAnswer);
    }
}
