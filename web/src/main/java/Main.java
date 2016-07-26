
import configuration.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Event;
import pojo.Person;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pokramovich on 22.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Set<Event> events = createEvents(10);
        Person person = new Person();
        person.setAge(18);
        person.setFirstName("Anton");
        person.setLastName("Pokramovich");
        person.setEvents(events);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();

        person = new Person();
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();
        Person person1 = session1.get(Person.class, 1L);
        person1.getEmails().add("Pokramovich@alutech-mc.com");
        session1.getTransaction().commit();
        ;

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        Query query = session2.createNativeQuery("select * from PERSON_ADDRESS");
        System.out.println(query.list().get(0));
        session2.getTransaction().commit();


        System.out.println(person1);
      /*  for (Event event : person1.getEvents()) {
            // session.save(event);
            System.out.println(event.toString());
        }*/




      /*  Query query = session.createQuery("select en from Event en");
        List<Event> events = query.list();
        session.getTransaction().commit();
        for (Event event1 : events) {
            System.out.println(event1);
        }*/
        HibernateUtil.getSessionFactory().close();


    }

    static Set<Event> createEvents(int count) {
        Set<Event> events = new HashSet<>(count);
        for (int i = 0; i < count; i++) {
            events.add(new Event("Title" + i, new Date()));
        }
        return events;
    }
}
