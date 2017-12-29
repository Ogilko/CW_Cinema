package parsers;

import entity.Film;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FilmParser {
    private FilmParser() {
    }

    public static Optional<Film> parseFilm(String input) {
        try {
            String[] inputArgs = input.split("\\|");
            long id_film = Long.parseLong(inputArgs[0]);
            String title = inputArgs[1];
            String country = inputArgs[2];
            int year = Integer.parseInt(inputArgs[3]);
            List<String> genres = Arrays.asList(inputArgs[4].split(","));
            List<String> actors = Arrays.asList(inputArgs[5].split(","));
            long budget = Long.parseLong(inputArgs[6]);
            int duration = Integer.parseInt(inputArgs[7]);
            int ratio = Integer.parseInt(inputArgs[8]);
            String description = inputArgs[9];


            return Optional.of(new Film(id_film, title, country, year, genres, actors, budget, duration, ratio, description));
        } catch (Exception e) {
            System.out.println("Can't parse string " + input);
            return Optional.empty();
        }
    }
}
