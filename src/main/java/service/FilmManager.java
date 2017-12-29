package service;

import entity.Context;
import entity.Film;
import parsers.FilmParser;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmManager {
    private Map<Long, Film> films;

    public FilmManager(String configFile) {
        films = ConfigFileManager.loadConfigFile(configFile).stream().filter(str -> !str.isEmpty())
                .map(FilmParser::parseFilm)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(Film::getFilmID, film -> film));
    }

    public Optional<Film> getFilmByTitle(String title) {
        return films.values().stream().filter(film -> film.getTitle().equals(title)).findAny();
    }

    public Optional<Film> getFilmByID(long id) {
        return Optional.ofNullable(films.get(id));
    }

    public void printFilmInformation(String filmName){
        Film film = getFilmByTitle(filmName).get();
        if(film != null){
            System.out.println(film.getTitle());
        }
    }

}
