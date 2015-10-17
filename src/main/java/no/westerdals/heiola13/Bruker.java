package no.westerdals.heiola13;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Ola on 05.10.2015.
 */
enum Type {
    STUDENT,
    TEACHER
}
@Entity
@NamedQueries({
        @NamedQuery(name="Bruker.findAll", query="SELECT b FROM Bruker b"),
        @NamedQuery(name="Bruker.findByID", query="SELECT b FROM Bruker b WHERE b.id = :id")
})
public class Bruker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="This is not a valid email-address")
    String email;
    @NotNull
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})", message = "Invalid password")
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