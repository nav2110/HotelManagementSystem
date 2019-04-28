import People.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private Person person;

    @Before
    public void setup(){
        person=new Person("Alex", "786165");

    }

    @Test
    public void getNameOfPersonTest(){

        assertEquals("Alex", person.getPersonName());

    }

    @Test
    public void getIdOfPersonTest(){

        assertEquals("786165", person.getId());
    }


}