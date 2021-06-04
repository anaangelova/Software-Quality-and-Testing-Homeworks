package code;


import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConferenceTest {

    public static double TICKET_PRICE = 8.67;
    public static double AFFILIATE_DISCOUNT = 0.1;
    public static double FACULTY_EMPLOYEE_DISCOUNT = 0.7;

    @Test
    public void EnoughRoomTestTrue(){
        Conference conference=new Conference(10);
        Person person1=new Person("Jane","Doe",Role.STUDENT,22);
        assertTrue(conference.addAttendeeToConference(person1));
    }
    @Test
    public void EnoughRoomTestTrueWithDoubleCapacityTrue(){
        Conference conference=new Conference(10);
        Person person1=new Person("Jane","Doe",Role.STUDENT,22);
        for(int i=0;i<conference.getCapacity();i++){
            conference.addAttendeeToConference(person1);
        }
        assertTrue(conference.addAttendeeToConference(person1));
    }
    @Test
    public void EnoughRoomTestFalse(){
        Conference conference=new Conference(5001);
        Person person1=new Person("Jane","Doe",Role.STUDENT,22);
        for(int i=0;i<conference.getCapacity();i++){
            conference.addAttendeeToConference(person1);
        }
        assertFalse(conference.addAttendeeToConference(person1));
    }
    @Test
    public void doubleCapacityChangeBoundaryConditionalTest(){
        Conference conference=new Conference(5000);
       assertTrue(conference.doubleCapacity());
    }
    @Test
    public void doubleCapacityChangeBoundaryConditionalTest2(){
        Conference conference=new Conference(4500);
        assertTrue(conference.doubleCapacity());
    }
    @Test
    public void calculateTotalPriceTest(){
        Conference conference=new Conference(10);
        Person person1=new Person("Jane","Doe",Role.AFFILIATE,22);
        Person person2=new Person("Jane","Doe",Role.FACULTY_EMPLOYEE,32);
        Person person3=new Person("Jane","Doe",Role.OTHER,45);
        conference.addAttendeeToConference(person1);
        conference.addAttendeeToConference(person2);
        conference.addAttendeeToConference(person3);
        double total = (1 - AFFILIATE_DISCOUNT) * TICKET_PRICE+(1 - FACULTY_EMPLOYEE_DISCOUNT) * TICKET_PRICE+TICKET_PRICE;
        assertEquals(total,conference.calculateTotalPricePaid());
    }
    @Test
    public void getAttendeesTest(){
        Conference conference=new Conference(10);
        Person person1=new Person("Jane","Doe",Role.AFFILIATE,22);
        Person person2=new Person("Jane","Doe",Role.FACULTY_EMPLOYEE,32);
        Person person3=new Person("Jane","Doe",Role.OTHER,45);
        conference.addAttendeeToConference(person1);
        conference.addAttendeeToConference(person2);
        conference.addAttendeeToConference(person3);
       assertEquals(3,conference.getAttendees().size());

    }

    @Test
    public void testMultiplication(){
        Conference conference=new Conference(10);
        conference.doubleCapacity();
        assertEquals(20,conference.getCapacity());
    }



}