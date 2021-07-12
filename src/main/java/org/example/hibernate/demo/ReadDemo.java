package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo
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

//            Instructor instructor = new Instructor("Amy", "Adams", "amy.adams@test.com");
//            InstructorDetail instructorDetail = new InstructorDetail("http://www.MLC.com", "gaming");

            // TODO: 24/06/2021 associate the objects
//            instructor.setInstructorDetail(instructorDetail);
            //TODO: 24/06/2021 start a transaction
            session.beginTransaction();
            InstructorDetail instructorDetail =  session.get(InstructorDetail.class, 3);
            // TODO: 24/06/2021 Commit the transaction
            session.getTransaction().commit();

            System.out.println("instructorDetail is: " + instructorDetail);
            System.out.println("instructor is: " + instructorDetail.getInstructor());
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
