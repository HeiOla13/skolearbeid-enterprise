package no.westerdals.heiola13;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import no.westerdals.heiola13.ServiceQualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ola on 09.10.2015.
 */
public class MainService {

    @Inject
    private Users interfaceService;

    @Inject @ServiceQualifier
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
    }

}