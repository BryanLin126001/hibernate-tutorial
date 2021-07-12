package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Course;
import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.example.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadCourseAndReview
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

            Course course = session.get(Course.class, 23);
            System.out.println("the course is: " + course);
            course.getReviews().forEach(x -> System.out.println("reviews: " + x));
            session.delete(course);
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
