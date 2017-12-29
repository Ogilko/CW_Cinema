package service;

import entity.CinemaRoom;
import entity.CinemaRoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class CinemaRoomManager {
    private static final int SMALL_CINEMA_ROOM_CAPACITY =10;
    private static final int BIG_CINEMA_ROOM_CAPACITY = 20;
    private Map<LocalDate, ArrayList> bigCinemaRoom;
    private Map<LocalDate, ArrayList> smallCinemaRoom;


}
