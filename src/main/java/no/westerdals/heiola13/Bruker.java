package no.westerdals.heiola13;

/**
 * Created by Ola on 05.10.2015.
 */
public class Bruker {
    int id;
    String email;
    String passord;
    String type;


    public Bruker(String email, String passord, String type) {
        this.email = email;
        this.passord = passord;
        this.type = type;
    }
}