package com.freudromero.hibernate.demo;

import com.freudromero.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateStudentDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session

        Session session = factory.getCurrentSession();

        try {
            // Use the session object to save Java object
            // Create a student object
            System.out.println("Creating a new Student object...");
            Student tempStudent = new Student("Paul", "Wall", "paul@mail.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
