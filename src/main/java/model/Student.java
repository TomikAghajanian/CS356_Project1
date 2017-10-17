package model;

import service.VotingService;

import java.util.ArrayList;

/**
 * Created by Tomik on 10/12/2017.
 */
public class Student {
    private String ID;
    private static int count = 0;

    private ArrayList<String> answers;

    public Student() {
        count++;
        this.ID = "1" + count;
    }

    public String getId() {
        return this.ID;
    }

    public static int getCount() {
        return count;
    }

    public boolean setAnswers(ArrayList<String> entry) {
        this.answers = entry;
        return true;
    }

    public boolean submit(VotingService iVote) {
        if (this.answers == null)
            return false;
        else {
            iVote.submitAnswers(this.ID, this.answers);
            return true;
        }
    }
}
