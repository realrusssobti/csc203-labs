import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String id;
    private List<Session> sessions = new ArrayList<Session>();
    public Customer(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public List<Session> getSessions() {
        return sessions;
    }
    public void addSession(Session session) {
        sessions.add(session);
    }

}
