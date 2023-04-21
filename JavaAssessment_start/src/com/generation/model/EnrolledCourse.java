package com.generation.model;

public class EnrolledCourse extends Course
{
    private double grade;

    public EnrolledCourse( Course course )
    {
        super(course.getCode(), course.getName(), course.getCredits(),course.getModule());
        this.grade = 0;
    }

    public double getGrade()
    {
        return grade;
    }

    public void setGrade( double grade )
    {
        this.grade = grade;
    }

    public String toString()
    {
        return super.toString() + " Grade: " + this.grade;
    }
}
