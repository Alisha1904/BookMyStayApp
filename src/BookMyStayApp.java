import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Class - Room (Abstract to prevent instantiation and fix build errors)
 */
abstract class Room {
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
 * Subclasses representing specific room types with predefined attributes.
 */
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 750, 5000.0);
    }
}

/**
 * Class - RoomInventory: The Single Source of Truth
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

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

/**
 * Main Class - BookMyStayApp
 */
public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        // Use Case 3: Registration using Subclasses
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        System.out.println("Hotel Room Inventory Status");

        for (Room room : rooms) {
            String type = room.getType();
            // Fetching availability from centralized HashMap
            int availableCount = inventory.getRoomAvailability().getOrDefault(type, 0);

            System.out.println("\n" + type + ":");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available Rooms: " + availableCount);
        }
    }
}