package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        this.students.put(student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        return this.students.get(studentId);
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have add enroll student to the course
        //Get student object (getStudent) & course object (course)
        Student getStudent = findStudent(studentId);
        if (getStudent != null) {
            getStudent.enrollToCourse(course);
        }
    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        //Loop through each student object to print Student toString()
        System.out.println("Student Details: ");
        for (Student student: this.students.values()) {
            System.out.println(student);
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        Student getStudent = this.students.get(student.getId());
        return getStudent.getEnrolledCourses();
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        Student getStudent = findStudent(student.getId());
        HashMap<String, EnrolledCourse> getEnrolledCourses = getStudent.getEnrolledCourses();
        return getEnrolledCourses.get(courseId);
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
