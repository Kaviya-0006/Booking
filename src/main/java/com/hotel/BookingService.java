package com.hotel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.net.httpserver.HttpServer;

public class BookingService {
    private final ConcurrentHashMap<Integer, Boolean> rooms = new ConcurrentHashMap<>();

    public boolean bookRoom(int roomId) {
        return rooms.putIfAbsent(roomId, true) == null;
    }

    public boolean cancelBooking(int roomId) {
        return rooms.remove(roomId) != null;
    }

    // MAIN METHOD: This is what Kubernetes/Docker needs to start the app
    public static void main(String[] args) throws IOException {
        int port = 8081;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // Simple endpoint to verify the app is alive
        server.createContext("/", exchange -> {
            String response = "Hotel Booking System is Running on Port " + port;
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        System.out.println("Server started on port " + port);
        server.setExecutor(null); 
        server.start();
    }
}
