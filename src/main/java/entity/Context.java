package entity;

import service.BookingService;
import service.FilmManager;
import service.FilmScheduleService;
import service.UserBlackListService;

public class Context {
    private String input;
    private static final String FILM_SCHEDULE_FILE = "film-schedule.txt";
    private static final String FILM_DETAILS_FILE = "film-details.txt";
    private static final String BOOKINGS_FILE = "bookings.txt";
    private static final String USERS_BLACK_LIST_FILE = "users-black-list.txt";
    private static Context instance;

    private static BookingService bookingService;
    private static FilmManager filmManager;
    private static UserBlackListService userBlackListService;
    private static FilmScheduleService filmScheduleService;

    public Context(String input) {
        this.input = input;
        instance = this;

        BookingService bookingService = new BookingService(
                input + System.getProperty("file.separator") + BOOKINGS_FILE);

        FilmManager filmManager = new FilmManager(
                input + System.getProperty("file.separator") + FILM_DETAILS_FILE);

//        UserBlackListService userBlackListService = new UserBlackListService(
//                input + System.getProperty("file.separator") + USERS_BLACK_LIST_FILE);

        FilmScheduleService filmScheduleService = new FilmScheduleService(
                input + System.getProperty("file.separator") + FILM_SCHEDULE_FILE);

    }

    public static BookingService getBookingService() {
        return bookingService;
    }

    public static FilmManager getFilmManager() {
        return filmManager;
    }

    public static UserBlackListService getUserBlackListService() {
        return userBlackListService;
    }

    public static FilmScheduleService getFilmScheduleService() {
        return filmScheduleService;
    }
}
