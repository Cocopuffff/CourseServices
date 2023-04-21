package com.generation.utils;

import com.generation.model.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu()
    {
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Grade Student             |" );
        System.out.println( "| . 4 Enroll Student to Course  |" );
        System.out.println( "| . 5 Show Students Summary     |" );
        System.out.println( "| . 6 Show Courses Summary      |" );
        System.out.println( "| . 7 Show Passed Courses       |" );
        System.out.println( "| . 8 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner ) throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student name:                 |" );
        String name = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();

        DateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );

        //TODO validate date format and catch exception to avoid crash
        boolean isDate = false;
        String date = "";
        while (!isDate) {
            try {
                System.out.println( "| Enter student birth date(MM/dd/yyyy)|" );
                date = scanner.next();
                if ((date.length() == 10) && (date.charAt(2) == '/') && (date.charAt(5) == '/')) {
                    isDate = true;
                }
                else {
                    throw new Exception("Invalid date format. Make sure you type date using the " +
                            "following format: MM/dd/yyyy");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Make sure you type date using the following format: " +
                        "MM/dd/yyyy");
            }
        }

        Date birthDate = formatter.parse( date );
        System.out.println( "|-------------------------------------|" );
        Student student = new Student( id, name, email, birthDate );
        System.out.println( "Student Successfully Registered! " );
        System.out.println( student );
        return student;


    }

}
