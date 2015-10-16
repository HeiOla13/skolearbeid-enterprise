package no.westerdals.heiola13;

import javax.enterprise.inject.Model;
import javax.persistence.*;

/**
 * Created by Ola on 05.10.2015.
 */
enum Type {
    STUDENT,
    TEACHER
}
@Entity
public class Bruker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String email;
    String passord;
    Type type;


    public Bruker(String email, String passord, Type type) {
        this.email = email;
        this.passord = passord;
        this.type = type;
    }

    public Bruker(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}