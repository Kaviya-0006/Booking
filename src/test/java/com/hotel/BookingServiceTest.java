package com.hotel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    BookingService service;

    @BeforeEach
    void init() { service = new BookingService(); }

    @Test
    void testBookingSuccess() {
        assertTrue(service.bookRoom(101), "Room 101 should be booked successfully.");
    }

    @Test
    void testDoubleBookingFailure() {
        service.bookRoom(102);
        assertFalse(service.bookRoom(102), "Room 102 should not be double-booked.");
    }

    @Test
    void testCancellation() {
        service.bookRoom(103);
        assertTrue(service.cancelBooking(103), "Cancellation should succeed.");
        assertTrue(service.bookRoom(103), "Room 103 should be available again.");
    }
}
