package org.example.hibernate.demo.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "instructor_detail", schema = "hb-01-one-to-one-uni")
public class InstructorDetail
{
    private Integer id;
    private String youtubeChannel;
    private String hobby;
    private Instructor instructor;

    public InstructorDetail()
    {
    }

    public InstructorDetail(String youtubeChannel, String hobby)
    {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "youtube_channel", nullable = true, length = 128)
    public String getYoutubeChannel()
    {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel)
    {
        this.youtubeChannel = youtubeChannel;
    }

    @Basic
    @Column(name = "hobby", nullable = true, length = 45)
    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }


    @OneToOne(mappedBy = "instructorDetail",
            cascade = {CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    @Override
    public String toString()
    {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
