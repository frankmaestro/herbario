package edu.course.sisumss.sisumss.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.course.sisumss.sisumss.models.Course;
import edu.course.sisumss.sisumss.models.Student;
import edu.course.sisumss.sisumss.repositories.CourseRepository;
import edu.course.sisumss.sisumss.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentCouseController {

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public CourseRepository courseRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void getCourse() {

        Course couser = new Course("Couser 1");
        Course couser1 = new Course("Couser 11");
        Course couser2 = new Course("Couser 12");

        courseRepository.save(couser);
        courseRepository.save(couser1);
        courseRepository.save(couser2);

        Student student = new Student("Studente 1");
        List<Course> courses1 = new ArrayList<>();
        courses1.add(couser);
        courses1.add(couser1);
        courses1.add(couser2);
        student.setCourseList(courses1);
        studentRepository.save(student);

        Student studen1 = new Student("Studente 11");
        List<Course> courses2 = new ArrayList<>();
        courses2.add(couser);
        studen1.setCourseList(courses2);
        studentRepository.save(studen1);

        Student student2 = new Student("Studente 12");
        List<Course> courses3 = new ArrayList<>();
        courses3.add(couser2);
        student2.setCourseList(courses3);
        studentRepository.save(student2);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudent() {

        return studentRepository.findAll();
    }

}
