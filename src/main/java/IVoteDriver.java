import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.VotingService;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tomik on 10/12/2017.
 */
public class IVoteDriver {
    private static final Logger logger = LogManager.getLogger(IVoteDriver.class);

    public static void main(String[] args) {
        Student[] students = new Student[45];

        ArrayList<String> multiOptions = new ArrayList<>();
        ArrayList<String> correctAnswer = new ArrayList<>();

        Question multipleChoice = new MultipleChoiceQuestion("A good specification should be?", multiOptions, correctAnswer);
        multiOptions.add("a) unambiguous");
        multiOptions.add("b) distinctly specific");
        multiOptions.add("c) functional");
        multiOptions.add("d) all of these");

        correctAnswer.add(multiOptions.get(3));

        VotingService service1 = new VotingService(multipleChoice);

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setAnswers(generateAnswers(multiOptions.size(), multiOptions));
            students[i].submit(service1);
        }
        service1.showResults();

        System.out.println("Total participants: " + Student.getCount() + "\n");

        ArrayList<String> option2 = new ArrayList<>();
        option2.add("yes");
        option2.add("no");

        ArrayList<String> option2Answers = new ArrayList<>();
        option2Answers.add(option2.get(0));

        Question singleChoice = new SingleChoiceQuestion("For the following statements will arr[3] and ptr[3] fetch the same character?\n" +
                "char arr[] = \"IndiaBIX\";\n" +
                "char *ptr = \"IndiaBIX\";", option2, option2Answers);
        VotingService service2 = new VotingService(singleChoice);

        for (int i = 0; i < students.length; i++) {
            students[i].setAnswers(generateAnswers(option2.size(), option2));
            students[i].submit(service2);
        }
        service2.showResults();
        System.out.println("Total participants: " + Student.getCount());
    }

    public static ArrayList<String> generateAnswers(int numOfChoices, ArrayList<String> choices) {
        Random rand = new Random();
        int numOfAns = 1;
        ArrayList<String> answer = new ArrayList<>();

        if (numOfChoices > 2) {
            numOfAns = rand.nextInt(numOfChoices);
        }

        for (int i = 0; i < numOfAns; i++) {
            answer.add(choices.get(rand.nextInt(numOfChoices)));
        }
        return answer;
    }

}
