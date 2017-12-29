package entity;

public enum CinemaRoomType {
    SMALL() {
        public int getCapacity() {
            return 10;
        }
    },
    BIG() {
        public int getCapacity() {
            return 20;
        }
    };
    abstract int getCapacity();
}