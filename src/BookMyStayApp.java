import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


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

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        List<Room> roomTypes = new ArrayList<>();
        roomTypes.add(new Room("Single Room", 1, 250, 1500.0));
        roomTypes.add(new Room("Double Room", 2, 400, 2500.0));
        roomTypes.add(new Room("Suite Room", 3, 750, 5000.0));

        System.out.println("Hotel Room Inventory Status");

        for (Room room : roomTypes) {
            int availableCount = inventory.getRoomAvailability().getOrDefault(room.getType(), 0);

            System.out.println("\n" + room.getType() + ":");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available Rooms: " + availableCount);
        }
    }
}