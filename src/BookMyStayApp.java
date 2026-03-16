import java.util.HashMap;
import java.util.Map;

class GuestManager {
    private Map<String, Integer> guestFeedback;

    public GuestManager() {
        this.guestFeedback = new HashMap<>();
    }

    public void addFeedback(String guestName, int score) {
        guestFeedback.put(guestName, score);
    }

    public void displayFeedback() {
        System.out.println("Guest Feedback Records:");
        for (Map.Entry<String, Integer> entry : guestFeedback.entrySet()) {
            System.out.println("Guest: " + entry.getKey() + " | Score: " + entry.getValue());
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        GuestManager manager = new GuestManager();

        manager.addFeedback("Abhi", 5);
        manager.addFeedback("Subha", 4);
        manager.addFeedback("Vanmathi", 5);

        manager.displayFeedback();
    }
}