package entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FilmSchedule {
    //    id | filmID | Зал (small|big) | Стоимость (uah) | Дата | Время (начало) | Формат (3D)
    private long id;
    private long filmID;
    private String hall;
    private double price;
    private LocalDate date;
    private List<LocalTime> starts;
    private String format;

    public FilmSchedule(long id, long id_film, String hall, double price, LocalDate date, List<LocalTime> starts, String format) {
        this.id = id;
        this.filmID = id_film;
        this.hall = hall;
        this.price = price;
        this.date = date;
        this.starts = starts;
        this.format = format;
    }

    public long getId() {
        return id;
    }

    public long getFilmID() {
        return filmID;
    }

    public String getHall() {
        return hall;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<LocalTime> getStarts() {
        return starts;
    }

    public String getFormat() {
        return format;
    }
}
