import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class VenueBookingTest {

    @Test
    public void testAvailabilityForNonSetVenue() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date = LocalDate.of(2023, 12, 25);
        assertFalse(bookingSystem.checkAvailability("Venue123", date));
    }

    @Test
    public void testSetAndCheckAvailableVenue() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date = LocalDate.of(2023, 12, 25);
        String venueId = "Venue123";

        bookingSystem.setAvailability(venueId, date, true);
        boolean isAvailable = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable);
        assertTrue(bookingSystem.checkAvailability(venueId, date));
    }

    @Test
    public void testSetAndCheckUnavailableVenue() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date = LocalDate.of(2023, 12, 26);
        String venueId = "Venue123";

        bookingSystem.setAvailability(venueId, date, false);

        boolean isAvailable = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable);

//        boolean bookingResult = bookingSystem.bookVenue(venueId, date);
//        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult ? "Success" : "Failed"));
        //assertFalse(bookingSystem.checkAvailability(venueId, date));
        assertEquals(false, bookingSystem.bookVenue(venueId, date));
    }

    @Test
    public void testBookAvailableVenue() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date = LocalDate.of(2023, 12, 27);
        String venueId = "Venue123";
        bookingSystem.setAvailability(venueId, date, true);


        boolean isAvailable = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable);


        boolean bookingResult = bookingSystem.bookVenue(venueId, date);
        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult ? "Success" : "Failed"));

        assertEquals(false,bookingSystem.bookVenue(venueId, date));



    }

    @Test
    public void testSameVenueDifferentDates() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date1 = LocalDate.of(2023, 12, 28);
        LocalDate date2 = LocalDate.of(2023, 12, 29);
        String venueId = "Venue123";

        bookingSystem.setAvailability(venueId, date1, true);
        boolean isAvailable = bookingSystem.checkAvailability(venueId, date1);
        System.out.println("Is venue " + venueId + " available on " + date1 + "? " + isAvailable);

        boolean bookingResult = bookingSystem.bookVenue(venueId, date1);
        System.out.println("Booking venue " + venueId + " on " + date1 + ": " + (bookingResult ? "Success" : "Failed"));

        bookingSystem.setAvailability(venueId, date2, true);
        boolean isAvailable2 = bookingSystem.checkAvailability(venueId, date2);
        System.out.println("Is venue " + venueId + " available on " + date2 + "? " + isAvailable2);

        boolean bookingResult2 = bookingSystem.bookVenue(venueId, date2);
        System.out.println("Booking venue " + venueId + " on " + date2 + ": " + (bookingResult2 ? "Success" : "Failed"));

        assertFalse(bookingSystem.checkAvailability(venueId, date1));
        assertFalse(bookingSystem.checkAvailability(venueId, date2));
    }

    @Test
    public void testAvailabilityAfterBooking() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date = LocalDate.of(2023, 12, 30);
        String venueId = "Venue123";
        bookingSystem.setAvailability(venueId, date, true);
        boolean isAvailable = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable);
        boolean bookingResult = bookingSystem.bookVenue(venueId, date);
        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult ? "Success" : "Failed"));
        //assertFalse(bookingSystem.bookVenue(venueId, date));

        bookingSystem.setAvailability(venueId, date, false);
        boolean isAvailable2 = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable2);
//        boolean bookingResult2 = bookingSystem.bookVenue(venueId, date);
//        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult2 ? "Success" : "Failed"));
        assertFalse(bookingSystem.bookVenue(venueId, date));

    }

    @Test
    public void testDoubleBookingSameVenue() {
        VenueBooking bookingSystem = new VenueBooking();
        LocalDate date = LocalDate.of(2023, 12, 31);
        String venueId = "Venue123";

        bookingSystem.setAvailability(venueId, date, true);
        boolean isAvailable = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable);
        boolean bookingResult = bookingSystem.bookVenue(venueId, date);
        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult ? "Success" : "Failed"));

        assertFalse(bookingSystem.bookVenue(venueId, date));


        boolean isAvailable1 = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable1);
        boolean bookingResult1 = bookingSystem.bookVenue(venueId, date);
        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult1 ? "Success" : "Failed"));

        assertFalse(bookingSystem.bookVenue(venueId, date));
    }



}

