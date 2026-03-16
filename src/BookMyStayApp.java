import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Class - Room
 * Represents the base room model.
 */
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

/**
 * Use Case 3: Centralized Room Inventory Management
 */
class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        this.roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

/**
 * Use Case 4: Room Search & Availability Check
 * This class provides read-only search functionality.
 */
class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory, Room single, Room doubleR, Room suite) {
        Map<String, Integer> availability = inventory.getRoomAvailability();
        System.out.println("Room Search Results:");

        displayIfAvailable(single, availability.getOrDefault("Single Room", 0));
        displayIfAvailable(doubleR, availability.getOrDefault("Double Room", 0));
        displayIfAvailable(suite, availability.getOrDefault("Suite Room", 0));
    }

    private void displayIfAvailable(Room room, int count) {
        if (count > 0) {
            System.out.println("\n" + room.getType() + ":");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available: " + count);
        }
    }
}

/**
 * MAIN CLASS - UseCase4RoomSearch
 */
public class BookMyStayApp {
    public static void main(String[] args) {
        // Step 1: Initialize Inventory (UC3)
        RoomInventory inventory = new RoomInventory();

        // Step 2: Initialize Room Definitions
        Room singleRoom = new Room("Single Room", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double Room", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite Room", 3, 750, 5000.0);

        // Step 3: Execute Search (UC4)
        RoomSearchService searchService = new RoomSearchService();
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}