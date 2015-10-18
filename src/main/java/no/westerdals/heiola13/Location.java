package no.westerdals.heiola13;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Ola on 18.10.2015.
 */

public class Location {

    @NotNull
    int room;
    @NotNull
    int building;

    public Location(int room, int building) {
        this.room = room;
        this.building = building;
    }

    public Location() {

    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }
}
