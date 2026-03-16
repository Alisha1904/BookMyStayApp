import java.util.HashMap;
import java.util.Map;

class LoyaltyManager {
    private Map<String, Integer> loyaltyPoints;

    public LoyaltyManager() {
        this.loyaltyPoints = new HashMap<>();
    }

    public void addPoints(String guestName, int points) {
        loyaltyPoints.put(guestName, loyaltyPoints.getOrDefault(guestName, 0) + points);
    }

    public void displayLoyaltyPoints() {
        System.out.println("Guest Loyalty Points:");
        for (Map.Entry<String, Integer> entry : loyaltyPoints.entrySet()) {
            System.out.println("Guest: " + entry.getKey() + " | Points: " + entry.getValue());
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        LoyaltyManager manager = new LoyaltyManager();

        manager.addPoints("Abhi", 100);
        manager.addPoints("Subha", 150);
        manager.addPoints("Vanmathi", 200);

        manager.displayLoyaltyPoints();
    }
}