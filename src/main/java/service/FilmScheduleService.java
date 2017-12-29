package service;

import entity.Context;
import entity.Film;
import entity.FilmSchedule;
import parsers.FilmScheduleParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmScheduleService {
    private Map<LocalDate, Film> smallCinemaRoom = new HashMap<>();
    private Map<LocalDate, Film> bigCinemaRoom = new HashMap<>();
    private List<FilmSchedule> filmSchedules;

    public FilmScheduleService(String configFile) {
        filmSchedules =
                ConfigFileManager.loadConfigFile(configFile)
                        .stream()
                        .filter(str -> !str.isEmpty())
                        .map(FilmScheduleParser::parseFilmSchedule)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());

        for (FilmSchedule filmSchedule : filmSchedules) {
            Film film = Context.getFilmManager().getFilmByID(filmSchedule.getFilmID()).get();

            if (filmSchedule.getHall().equals("small")) {
                smallCinemaRoom.put(filmSchedule.getDate(), film);
            } else if (filmSchedule.getHall().equals("big")) {
                bigCinemaRoom.put(filmSchedule.getDate(), film);
            }
        }
    }

    public void showSchedule(LocalDate localDate) {
        if (smallCinemaRoom.containsKey(localDate)) {
            System.out.println("Small Cinema Room:");
            System.out.println(smallCinemaRoom.get(localDate));
//            Todo start time
//            System.out.println(smallCinemaRoom.get(localDate));
        } else if (bigCinemaRoom.containsKey(localDate)) {
            System.out.println("Big Cinema Room:");
            System.out.println(bigCinemaRoom.get(localDate));
            //            Todo start time
//            System.out.println(smallCinemaRoom.get(localDate));
        } else {
            System.out.println("Nothing to show");
        }
    }


    public void showSchedule(String filmTitle, LocalDate localDate) {
        Film film = Context.getFilmManager().getFilmByTitle(filmTitle).get();
        if (film != null) {
            filmSchedules.stream()
                    .filter(f -> f.getDate() == localDate)
                    .filter(f -> f.getFilmID() == film.getFilmID());

        } else{
            System.out.println("Nothing to show");
        }


    }


}
