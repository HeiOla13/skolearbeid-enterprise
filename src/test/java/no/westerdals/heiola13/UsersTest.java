package no.westerdals.heiola13;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.validator.HibernateValidator;
import org.junit.Before;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.SQLException;
import java.util.Set;

/**
 * Unit test for simple Users.
 */
public class UsersTest
    extends TestCase
{

    private static Validator validator;

    @Before
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
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

    public void testValidEmail(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Bruker b = new Bruker("", "passoRd1", Type.TEACHER);
        Set<ConstraintViolation<Bruker>> constraintViolations = validator.validate(b);
        assertEquals(1, constraintViolations.size());
        assertEquals("This is not a valid email-address", constraintViolations.iterator().next().getMessage());
    }

    public void testPasswordTooShort(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Bruker b = new Bruker("ola_s_h@hotmail.com", "pA1s", Type.TEACHER);
        Set<ConstraintViolation<Bruker>> constraintViolations = validator.validate(b);
        assertEquals(1, constraintViolations.size());
        assertEquals("Invalid password", constraintViolations.iterator().next().getMessage());
    }

    public void testEntityManager(){
        UsersJPA jpa = new UsersJPA();
        jpa.addUser(new Bruker("test123123@test.no", "passoRd1", Type.TEACHER));
        jpa.closeEntityManager();
    }
}
