package com.hotel;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {
    // Concurrent map to prevent race conditions during booking
    private final ConcurrentHashMap<Integer, Boolean> rooms = new ConcurrentHashMap<>();

    public boolean bookRoom(int roomId) {
        // putIfAbsent returns null if the key was empty (successful booking)
        return rooms.putIfAbsent(roomId, true) == null;
    }

    public boolean cancelBooking(int roomId) {
        return rooms.remove(roomId) != null;
    }
}
