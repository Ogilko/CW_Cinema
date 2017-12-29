package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CinemaRoom {
    private CinemaRoomType type;
    ArrayList places;

    public CinemaRoom(CinemaRoomType type) {
        this.type = type;
        places = new ArrayList(type.getCapacity());
    }

}
