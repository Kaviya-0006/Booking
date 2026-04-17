package com.hotel;

public class Room {
    private int roomId;
    private boolean isAvailable;

    public Room(int roomId) {
        this.roomId = roomId;
        this.isAvailable = true;
    }

    // Getters and Setters
    public int getRoomId() { return roomId; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
