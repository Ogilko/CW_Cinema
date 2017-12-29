package parsers;

import entity.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class BookingParser {
    private BookingParser() {
    }

    public static Optional<Booking> parseBooking(String input) {
        try {
            String[] inputArgs = input.split("\\|");
            long id = Long.parseLong(inputArgs[0]);
            LocalDate filmDate = LocalDate.parse(inputArgs[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalTime filmTime = LocalTime.parse(inputArgs[2], DateTimeFormatter.ofPattern("hh:mm"));
            long id_film = Long.parseLong(inputArgs[3]);
            int place = Integer.parseInt(inputArgs[4]);
            LocalDateTime bookingTime = LocalDateTime.parse(inputArgs[5]);
            String firstName = inputArgs[6];
            String secondName = inputArgs[7];
            String email = inputArgs[8];
            String mobile = inputArgs[9];

            return Optional.of(new Booking(id, filmDate, filmTime, id_film,
                    place, bookingTime, firstName, secondName, email, mobile));
        } catch (Exception e) {
            System.out.println("Can't parse string " + input);
            return Optional.empty();
        }
    }
}
