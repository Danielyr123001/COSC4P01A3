import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class VenueBooking {
    private Map<String, Map<LocalDate, Boolean>> venueAvailability;

    public VenueBooking() {
        this.venueAvailability = new HashMap<>();
    }

    public boolean checkAvailability(String venueId, LocalDate date) {
        return venueAvailability.getOrDefault(venueId, new HashMap<>()).getOrDefault(date, false);
    }

   public boolean bookVenue(String venueId, LocalDate date) {
    // Check if the venue is available for the given date
    if (checkAvailability(venueId, date)) {
        // If available, book the venue by setting the date to true
        Map<LocalDate, Boolean> dates = venueAvailability.get(venueId);
        if (dates == null) {
            dates = new HashMap<>();
            venueAvailability.put(venueId, dates);
        }
        dates.put(date, true);
        return true;
    }
    return false;
}


    public void setAvailability(String venueId, LocalDate date, boolean available) {
        Map<LocalDate, Boolean> dates = venueAvailability.getOrDefault(venueId, new HashMap<>());
        dates.put(date, available);
        venueAvailability.put(venueId, dates);
    }

    public static void main(String[] args) {
        VenueBooking bookingSystem = new VenueBooking();

        // Set availability for a venue
        String venueId = "Venue123";
        LocalDate date = LocalDate.of(2023, 12, 25); // Example date: Dec 25, 2023
        bookingSystem.setAvailability(venueId, date, true);

        // Check and print the availability
        boolean isAvailable = bookingSystem.checkAvailability(venueId, date);
        System.out.println("Is venue " + venueId + " available on " + date + "? " + isAvailable);

        // Attempt to book the venue and print the result
        boolean bookingResult = bookingSystem.bookVenue(venueId, date);
        System.out.println("Booking venue " + venueId + " on " + date + ": " + (bookingResult ? "Success" : "Failed"));
    }
}
