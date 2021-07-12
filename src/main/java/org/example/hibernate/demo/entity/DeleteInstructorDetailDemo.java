package org.example.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo
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

            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            session.getTransaction().commit();


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
