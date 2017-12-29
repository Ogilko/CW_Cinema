package service;

import entity.Booking;
import parsers.BookingParser;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {
    private List<Booking> bookings = new LinkedList<>();

    public BookingService(String configFile) {
        bookings = ConfigFileManager.loadConfigFile(configFile).stream().filter(str -> !str.isEmpty())
                .map(BookingParser::parseBooking)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }



}
