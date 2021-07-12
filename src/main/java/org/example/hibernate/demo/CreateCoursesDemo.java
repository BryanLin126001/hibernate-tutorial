package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Course;
import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.example.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo
{
    public static void main(String[] args)
    {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try
        {
            System.out.println("Creating courses for instructor");
//            Instructor instructor = new Instructor("Lany", "Chen", "lany.chen@test.com");
//            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "gaming");
//            instructor.setInstructorDetail(instructorDetail);
//            instructor.add(new Course("Yoga", instructor));
//            instructor.add(new Course("Math", instructor));


            session.beginTransaction();

            Instructor instructor = new Instructor("Chris", "Mo", "chris.mo@test.123");
            Course classicPiano = new Course("classic piano", instructor);
            Course basketball = new Course("basketball", instructor);

            session.save(instructor);
            session.save(classicPiano);
            session.save(basketball);


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
