package org.example.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "instructor", schema = "hb-01-one-to-one-uni")
public class Instructor
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetail instructorDetail;
    private List<Course> courses;

    public Instructor()
    {
    }

    public Instructor(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 45)
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    public InstructorDetail getInstructorDetail()
    {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail)
    {
        this.instructorDetail = instructorDetail;
    }


    @OneToMany(mappedBy = "instructor"
            , cascade = {CascadeType.MERGE
            , CascadeType.PERSIST
            , CascadeType.DETACH
            , CascadeType.REFRESH}
            , fetch = FetchType.LAZY)
    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    public void add(Course course)
    {
        if(courses == null)
        {
            courses = new ArrayList<Course>();
        }

        courses.add(course);
        //course.setInstructor(this);

    }
}
