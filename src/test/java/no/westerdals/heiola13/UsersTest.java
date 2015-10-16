package no.westerdals.heiola13;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.SQLException;

/**
 * Unit test for simple Users.
 */
public class UsersTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UsersTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( UsersTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testUsersList()
    {
        UsersList us = new UsersList();
        us.addUser(new Bruker("test@test.no", "passord", Type.STUDENT));
        assertNotNull(us.getUser(1));
        Bruker b = us.getUser(1);
        us.updateUser(b.getId(), "test@nytest.no", "passord123", Type.TEACHER);
        assertEquals("test@nytest.no", us.getUser(1).email);
        us.addUser(new Bruker("endaentest@test.no", "pass", Type.TEACHER));
        assertEquals(us.getAllUsers().size(), 2);
        us.deleteUser(1);
        assertEquals(us.getAllUsers().size(), 1);

    }

    public void testUsersDatabase() throws SQLException, ClassNotFoundException
    {
        UsersDatabase us = new UsersDatabase();
        for(int i = 1; i <= 15; i++){
            us.deleteUser(i);
        }
        us.addUser(new Bruker("test@test.no", "passord", Type.STUDENT));
        assertNotNull(us.getAllUsers());
    }
}
