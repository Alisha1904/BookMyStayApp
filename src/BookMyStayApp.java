import java.util.LinkedList;
import java.util.Queue;

/**
 * CLASS - Reservation
 * Represents a booking request made by a guest.
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

/**
 * CLASS - BookingRequestQueue
 * Manages booking requests using a FIFO queue to ensure fair allocation.
 */
class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        this.requestQueue = new LinkedList<>();
    }

    /** Adds a booking request to the queue. */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /** Retrieves and removes the next booking request. */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /** Checks if there are pending requests. */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

/**
 * MAIN CLASS - UseCase5BookingRequestQueue
 */
public class BookMyStayApp {
    public static void main(String[] args) {
        // Display application header
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue (FIFO order)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process queued booking requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " + next.getGuestName() +
                    ", Room Type: " + next.getRoomType());
        }
    }
}