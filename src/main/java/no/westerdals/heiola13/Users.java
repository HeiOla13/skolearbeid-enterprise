package no.westerdals.heiola13;

import java.util.List;

public interface Users
{
    void updateUser(int id, String email, String password, String type);
    void addUser(String email, String password, String type);
    Bruker getUser(int id);
    List<Bruker> getAllUsers();
    void deleteUser(int id);

}
