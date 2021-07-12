package org.example.hibernate.demo;


import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.text.ParseException;
import java.util.Date;

public class CreateDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try
        {
            System.out.println("Creating new student object...");

            // TODO: 24/06/2021 create objects

            Instructor instructor = new Instructor("Amy", "Adams", "amy.adams@test.com");
            //InstructorDetail instructorDetail = new InstructorDetail("http://www.MLC.com", "gaming");

            // TODO: 24/06/2021 associate the objects
            //instructor.setInstructorDetail(instructorDetail);
            // TODO: 24/06/2021 start a transaction
            session.beginTransaction();
            session.save(instructor);



            // TODO: 24/06/2021 Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            factory.close();
        }




    }
}
