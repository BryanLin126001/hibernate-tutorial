package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class CreateCourseAndStudentDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try
        {

            session.beginTransaction();
            Course course = new Course("Highball", session.get(Instructor.class, 9));
            session.save(course);
            Student student1 = new Student("Tony", "Stark", "tony.stark@avanger.com");
            Student student2 = new Student("Steve", "Rogers", "steve.rogers@avanger.com");

            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }

}
