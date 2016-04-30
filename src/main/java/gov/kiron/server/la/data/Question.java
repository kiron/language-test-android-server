package gov.kiron.server.la.data;

import java.util.List;

/**
 * Created on 30.04.2016. Documentation TODO!
 *
 * @author <a href="mailto:christian.plewnia@rwth-aachen.de">Christian Plewnia</a>
 */
public class Question {

    private final long id;
    private final String content;
    private final List<Answer> answers;

    public Question(long id, String content, List<Answer> answers) {
        this.id = id;
        this.content = content;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
