package no.westerdals.heiola13;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ola on 08.10.2015.
 */

public class UsersList implements Users {
    int idCounter = 0;
    List<Bruker> users = new ArrayList<>();

    public List<Bruker> getAllUsers(){
        return users;
    }

    public void updateUser(int id, String email, String password, Type type){
        Bruker a = users.get(id-1);
        a.email = email;
        a.passord = password;
        a.type = type;
    }
    public void addUser(Bruker user){
        idCounter++;
        //Bruker bruker = new Bruker(email, password, type);
        user.setId(idCounter);
        users.add(user);
    }
    public Bruker getUser(int id){
        return users.get(id-1);
    }
    public void deleteUser(int id){
        users.remove(id-1);
    }


    public void exec(){
        System.out.println("Using ArrayList as persistance-technology");
    }
}
