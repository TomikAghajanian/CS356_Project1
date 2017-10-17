package service;

import model.IVoteService;
import model.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tomik on 10/12/2017.
 */
public class VotingService implements IVoteService {
    private static final Logger logger = LogManager.getLogger(VotingService.class);
    private Question question;
    private HashMap<String, ArrayList<String>> answer;

    public VotingService(Question q) {
        this.question = q;
        this.answer = new HashMap<>();
    }

    public void submitAnswers(String sID, ArrayList<String> answer) {
        Set<String> temp = new HashSet<>(answer);
        ArrayList<String> submission = new ArrayList<>();
        submission.addAll(temp);

        this.answer.put(sID, submission);
    }

    public void showResults() {
        String results = "Question) ";
        results += this.question.getQuestion() + "\n";
        ArrayList<String> options = this.question.getOptions();

        for (String option : options) {
            int choiceCount = 0;
            for (String id : answer.keySet()) {
                if (this.answer.get(id).contains(option)) {
                    choiceCount++;
                }
            }
            results += option + "\t" + choiceCount + "\n";
        }
        System.out.println(results);
    }
}
