package gov.kiron.server.la;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import gov.kiron.server.la.data.Answer;
import gov.kiron.server.la.data.Question;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
//
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/questions")
    public List<Question> tests(@RequestParam(value="name", defaultValue="World") String name) {

        List<Question> questions = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://athen052.server4you.de:5432/db-v1","hackathon", "hack4kiron");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM questions ORDER BY id;");
            while (rs.next()) {
                String content = rs.getString("text");
                List<Answer> answers = new ArrayList<>();
                answers.add(new Answer(111, rs.getString("answer1_text")));
                answers.add(new Answer(111, rs.getString("answer2_text")));
                answers.add(new Answer(111, rs.getString("answer3_text")));
                answers.add(new Answer(111, rs.getString("answer4_text")));
                questions.add(new Question(rs.getInt("id"), content, rs.getString("pictureurl"), answers));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return questions;
    }

    @RequestMapping(value="/submit/{answers}", method= RequestMethod.GET)
    @ResponseBody
    public Status answers(@RequestParam(value="username") String username, @PathVariable List<String> answers) {

        Status status;

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://athen052.server4you.de:5432/db-v1","hackathon", "hack4kiron");
            Statement statement = connection.createStatement();

            for(String answer : answers) {
                String[] answerParts = answer.split(":");
                int questionId = Integer.valueOf(answerParts[0]);
                char answerLetter = answerParts[1].charAt(0);

                statement.execute("INSERT INTO testresults(username, questionId, answer) VALUES ('" +
                        username + "', " +
                        questionId + ", '" +
                        answerLetter + "')");
            }

            connection.close();

            status = new Status(true, "Answers: " + answers.size());
        } catch (SQLException e) {
            e.printStackTrace();
            status = new Status(false, "Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            status = new Status(false, "Error: " + e.getMessage());
        }

        return status;
    }

}
