package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        //get course code from course object
        String selectedCourseCode =  course.getCode();

        if (this.enrolledCourses.get(selectedCourseCode) == null) {
            //cast course object to EnrolledCourse subclass
            Course c = new EnrolledCourse(course);
            EnrolledCourse newEnrolledCourse = (EnrolledCourse) c;
            //add to student enrolledCourses HashMap
            this.enrolledCourses.put(selectedCourseCode, newEnrolledCourse);
        } else {
            return false;
        }
        return true;
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        return this.enrolledCourses;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        //get the EnrolledCourse object from student's EnrolledCourse Hashmap
        EnrolledCourse getEnrolledCourse = (EnrolledCourse) findCourseById(courseCode);
        getEnrolledCourse.setGrade(grade);
    }

    //NEED TO DOUBLE-CHECK
    public Course findCourseById( String courseId )
    {
        //TODO return EnrolledCourse with the course Id
        return this.getEnrolledCourses().get(courseId);
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade
        //Initialize HashMap to store passed courses
        HashMap<String, EnrolledCourse> PassedCourses = new HashMap<>();

        //Loop through enrolledCourses to put courses that pass to PassedCourses
        for (EnrolledCourse enrCourse: getEnrolledCourses().values()) {
            if (enrCourse.getGrade() >= PASS_MIN_GRADE) {
                PassedCourses.put(enrCourse.getCode(), enrCourse);
            }
        }
        return PassedCourses;
    }

    public String toString()
    {
        String message = "Student {" + super.toString() + "}\n";
        String enrolledCourseMsg = "";

        for (EnrolledCourse course: getEnrolledCourses().values()) {
            enrolledCourseMsg += course+"\n";
        }

        return message + enrolledCourseMsg;
    }
}
