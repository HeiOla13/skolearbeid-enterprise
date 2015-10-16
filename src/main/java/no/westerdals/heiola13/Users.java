package no.westerdals.heiola13;

import javax.persistence.Entity;
import java.util.List;

public interface Users
{
    void updateUser(int id, String email, String password, Type type);
    void addUser(Bruker user);
    Bruker getUser(int id);
    List<Bruker> getAllUsers();
    void deleteUser(int id);
    void exec();


}
