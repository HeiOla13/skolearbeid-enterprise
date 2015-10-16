package no.westerdals.heiola13;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Instance;
/**
 * Created by Ola on 09.10.2015.
 */
public class UsersConsole {

    public static void main(String [] args){
        System.out.println("1. Opprett bruker\n2. Oppdater eksisterende bruker\n3. Hent bruker(basert på id)\n4. Hent alle brukere\n5. Slett bruker");
        WeldContainer container = new Weld().initialize();
        Instance<Users> inst = container.instance().select(Users.class);
        Users us = inst.get();

    }

}
