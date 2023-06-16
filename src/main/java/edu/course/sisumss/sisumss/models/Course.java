package edu.course.sisumss.sisumss.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 500)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;

    public Course() {

    }

    public Course(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
