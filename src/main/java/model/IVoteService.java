package model;

import java.util.ArrayList;

/**
 * Created by Tomik on 10/12/2017.
 */
public interface IVoteService {
    void submitAnswers(String sID, ArrayList<String> answer);

    void showResults();
}
