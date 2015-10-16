package no.westerdals.heiola13;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by Ola on 09.10.2015.
 */
public class Main {

    public static void main(String[] args) {
        //System.out.println("1. Opprett bruker\n2. Oppdater eksisterende bruker\n3. Hent bruker(basert på id)\n4. Hent alle brukere\n5. Slett bruker");
        WeldContainer container = new Weld().initialize();
        Instance<MainService> inst = container.instance().select(MainService.class);
        MainService mainService = inst.get();
        mainService.execute();

        container.instance().destroy(mainService);
    }
}
