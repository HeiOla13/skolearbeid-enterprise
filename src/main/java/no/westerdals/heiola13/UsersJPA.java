package no.westerdals.heiola13;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Ola on 17.10.2015.
 */


public class UsersJPA implements Users{

    private EntityManager entityManager;

    public UsersJPA(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("users");
        entityManager = factory.createEntityManager();
    }

    public void closeEntityManager(){
        entityManager.close();
    }

    @Override
    public void updateUser(int id, String email, String password, Type type) {
        Bruker b = entityManager.find(Bruker.class, id);

        entityManager.getTransaction().begin();
        b.setEmail(email);
        b.setPassord(password);
        b.setType(type);
        entityManager.getTransaction().commit();
    }

    @Override
    public void addUser(Bruker user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public Bruker getUser(int id) {
        Query query = entityManager.createNamedQuery("Bruker.findByID", Bruker.class).setParameter("id", id);
        Bruker b = (Bruker) query.getSingleResult();
        return b;
    }

    @Override
    public List<Bruker> getAllUsers() {
        TypedQuery<Bruker> query =
                entityManager.createNamedQuery("Bruker.findAll", Bruker.class);
        List<Bruker> results = query.getResultList();
        return results;
    }

    @Override
    public void deleteUser(int id) {
        Bruker b = entityManager.find(Bruker.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(b);
        entityManager.getTransaction().commit();
    }

    @Override
    public void exec() {
        System.out.println("Using JPA for persistence");
    }

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        System.out.println(UsersJPA.class.getSimpleName() + " - " + ic.getMethod().getName() + " start");
        try {
            entityManager.getTransaction().begin();
            ic.getMethod();
            entityManager.getTransaction().commit();
            return ic.proceed();
        } finally {
            System.out.println(UsersJPA.class.getSimpleName() + " - " + ic.getMethod().getName() + " exit");
        }
    }
}
