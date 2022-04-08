package com.freudromero.hibernate.demo;

import com.freudromero.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
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
            // Create 3 student objects
            System.out.println("Creating a 3 Student objects...");
            Student tempStudent1 = new Student("John", "Doe", "john@mail.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@mail.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@mail.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
