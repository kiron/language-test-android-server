package gov.kiron.server.la;

/**
 * Created on 30.04.2016. Documentation TODO!
 *
 * @author <a href="mailto:christian.plewnia@rwth-aachen.de">Christian Plewnia</a>
 */
public class Status {

    private final boolean success;
    private final String message;

    public Status(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
