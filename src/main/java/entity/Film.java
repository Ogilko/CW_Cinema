package entity;

import java.util.List;

public class Film {
//    FilmID | НазванSие | Страна | Год выхода | Жанр [боевик,комедия,фэнтези] | Актеры [Билл Дьюк, Арнольд Шварценеггер, ...] | Бюджет ($)
// | Продолжительность (мин) | Рейтинг (10 звезд) | Description (255+ characters) |

    private long FilmID;
    private String title;
    private String country;
    private int year;
    private List<String> genres;
    private List<String> actors;
    private long budget;
    private int duration;
    private int ratio;
    private String description;

    public Film(long id_film, String title, String country, int year, List<String> genres, List<String> actors, long budget, int duration, int ratio, String description) {
        this.FilmID = id_film;
        this.title = title;
        this.country = country;
        this.year = year;
        this.genres = genres;
        this.actors = actors;
        this.budget = budget;
        this.duration = duration;
        this.ratio = ratio;
        this.description = description;
    }

    public long getFilmID() {
        return FilmID;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getActors() {
        return actors;
    }

    public long getBudget() {
        return budget;
    }

    public int getDuration() {
        return duration;
    }

    public int getRatio() {
        return ratio;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.println("Film " + getTitle());
    }

}
