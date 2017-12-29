package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Booking {
//    id | Дата | Время | id_film | № места | Дата/время брони | First name | Second Name | email | mobile

    private long id;
    private LocalDate filmDate;
    private LocalTime filmTime;
    private long id_film;
    private int place;
    private LocalDateTime bookingTime;
    private String firstName;
    private String secondName;
    private String email;
    private String mobile;

    public Booking(long id, LocalDate filmDate, LocalTime filmTime, long id_film, int place, LocalDateTime bookingTime, String firstName, String secondName, String email, String mobile) {
        this.id = id;
        this.filmDate = filmDate;
        this.filmTime = filmTime;
        this.id_film = id_film;
        this.place = place;
        this.bookingTime = bookingTime;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.mobile = mobile;
    }

}
