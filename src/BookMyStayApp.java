import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

class Room {
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() { return type; }
    public int getBeds() { return beds; }
    public int getSize() { return size; }
    public double getPrice() { return price; }
}

class RoomInventory {
    private Map<String, Integer> roomAvailability = new HashMap<>();

    public RoomInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

class GuestManager {
    private Map<String, Integer> guestFeedback = new HashMap<>();

    public void addFeedback(String guestName, int score) {
        guestFeedback.put(guestName, score);
    }

    public void displayFeedback() {
        for (Map.Entry<String, Integer> entry : guestFeedback.entrySet()) {
            System.out.println("Guest: " + entry.getKey() + " | Score: " + entry.getValue());
        }
    }
}

class LoyaltyManager {
    private Map<String, Integer> loyaltyPoints = new HashMap<>();

    public void addPoints(String guestName, int points) {
        loyaltyPoints.put(guestName, loyaltyPoints.getOrDefault(guestName, 0) + points);
    }

    public void displayLoyaltyPoints() {
        for (Map.Entry<String, Integer> entry : loyaltyPoints.entrySet()) {
            System.out.println("Guest: " + entry.getKey() + " | Points: " + entry.getValue());
        }
    }
}

class AdminDashboard {
    public void displaySummary(RoomInventory inventory, GuestManager guestManager, LoyaltyManager loyaltyManager) {
        System.out.println("=== ADMINISTRATIVE DASHBOARD ===");

        System.out.println("\n1. Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " available");
        }

        System.out.println("\n2. Guest Feedback Overview:");
        guestManager.displayFeedback();

        System.out.println("\n3. Loyalty Program Status:");
        loyaltyManager.displayLoyaltyPoints();

        System.out.println("\n================================");
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        GuestManager guestManager = new GuestManager();
        LoyaltyManager loyaltyManager = new LoyaltyManager();

        guestManager.addFeedback("Abhi", 5);
        guestManager.addFeedback("Subha", 4);
        guestManager.addFeedback("Vanmathi", 5);

        loyaltyManager.addPoints("Abhi", 100);
        loyaltyManager.addPoints("Subha", 150);
        loyaltyManager.addPoints("Vanmathi", 200);

        AdminDashboard dashboard = new AdminDashboard();
        dashboard.displaySummary(inventory, guestManager, loyaltyManager);
    }
}