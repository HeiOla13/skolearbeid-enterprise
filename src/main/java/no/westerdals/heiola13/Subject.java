package no.westerdals.heiola13;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Ola on 18.10.2015.
 */
@Entity
@SecondaryTable(name = "Location")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String name;
    @OneToMany
    @JoinColumn(name = "FK_LOCATION")
    private Location location;
    @Size(min=0, max=100)
    private List<Bruker> users;


    public Subject(String name, List<Bruker> users, Location location){
        this.name = name;
        this.users = users;
        this.location = location;
    }

    public Subject(){

    }

}
