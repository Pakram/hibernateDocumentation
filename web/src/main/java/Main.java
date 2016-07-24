import configuration.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by Pokramovich on 22.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Event event=new Event();
        event.setDate(new Date());
        event.setTitle("New title");
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
        System.out.println(event.toString());
        session.beginTransaction();
       Query query= session.createQuery("select en from Event en");
        List<Event> events=query.list();
        session.getTransaction().commit();
        for(Event event1:events){
            System.out.println(event1);
        }


    }
}
