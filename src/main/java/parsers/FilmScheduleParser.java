package parsers;

import entity.FilmSchedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FilmScheduleParser {
    private FilmScheduleParser() {
    }

    public static Optional<FilmSchedule> parseFilmSchedule(String input) {
        try {
            String[] inputArgs = input.split("\\|");
            long id = Long.parseLong(inputArgs[0]);
            long id_film = Long.parseLong(inputArgs[1]);
            String hall = inputArgs[2];
            double price = Double.parseDouble(inputArgs[3]);
            LocalDate date = LocalDate.parse(inputArgs[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            List<LocalTime> starts = new LinkedList<>();
            for (String str : inputArgs[5].split(",")) {
                starts.add(LocalTime.parse(str, DateTimeFormatter.ofPattern("hh:MM")));
            }
            String format = inputArgs[6];

            return Optional.of(new FilmSchedule(id, id_film, hall, price, date, starts, format));
        } catch (Exception e) {
            System.out.println("Can't parse string " + input);
            return Optional.empty();
        }
    }
}
