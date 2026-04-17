package com.hotel;

public class Room {
    private int roomId;
    private boolean isAvailable;

    // Default constructor (Needed for some frameworks)
    public Room() {}

    public Room(int roomId) {
        this.roomId = roomId;
        this.isAvailable = true;
    }

    // Standard Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Useful for debugging logs
    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", isAvailable=" + isAvailable + '}';
    }
}
