package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Course;
import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.example.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReview
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
            session.beginTransaction();
            //Instructor instructor = session.get(Instructor.class, 5);

            Course course = new Course("Sport", session.get(Instructor.class, 5));
            Review review1 = new Review("Good");
            Review review2 = new Review("Not bad");
            Review review3 = new Review("worth to buy it");

            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);

            session.save(course);
            session.getTransaction().commit();
            session.close();
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
