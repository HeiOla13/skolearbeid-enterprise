package no.westerdals.heiola13;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Ola on 09.10.2015.
 */
public class MainService {

    @Inject
    private Users interfaceService;

    @Inject @DatabaseQualifier
    private Users qualifierService;

    @Inject
    public MainService(Users interfaceService) {
        this.interfaceService = interfaceService;
    }

    public void execute(){
        qualifierService.exec();
        Bruker user = new Bruker("mail@mail.no", "passord", Type.STUDENT);
        qualifierService.addUser(user);
        System.out.println("User with mail "+ user.getEmail() + " created.");
        List<Bruker> list = qualifierService.getAllUsers();
        for(Bruker b : list){
            System.out.println(b.getId() + "\t|\t" + b.getEmail());
        }
        System.out.println("---------------------------------");

        qualifierService.updateUser(2, "ny@mail.no", "aaaylmao", Type.TEACHER);
        list = qualifierService.getAllUsers();
        for(Bruker b : list){
            System.out.println(b.getId() + "\t|\t" + b.getEmail());
        }
        System.out.println("---------------------------------");
        qualifierService.deleteUser(2);

        list = qualifierService.getAllUsers();
        for(Bruker b : list){
            System.out.println(b.getId() + "\t|\t" + b.getEmail());
        }

    }

}