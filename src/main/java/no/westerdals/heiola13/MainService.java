package no.westerdals.heiola13;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by Ola on 09.10.2015.
 */
public class MainService {


    private final Users interfaceService;


    @Inject
    public MainService(Users interfaceService) {
        this.interfaceService = interfaceService;
    }

}