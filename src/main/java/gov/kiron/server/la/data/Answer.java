package gov.kiron.server.la.data;

/**
 * Created on 30.04.2016. Documentation TODO!
 *
 * @author <a href="mailto:christian.plewnia@rwth-aachen.de">Christian Plewnia</a>
 */
public class Answer {

    private final long id;
    private final String content;

    public Answer(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
