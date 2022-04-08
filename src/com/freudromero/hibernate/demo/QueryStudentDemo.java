package com.freudromero.hibernate.demo;

import com.freudromero.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session

        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // Query the students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(theStudents);

            // Query students: last name='Doe"
            theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            // Query students: lastName='Doe' OR firstName= 'Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").getResultList();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe or first name Daffy");
            displayStudents(theStudents);

            // Query students where email like '%mail.com'
            theStudents = session.createQuery("from Student s where s.email like '%mail.com'").getResultList();

            // display the students
            System.out.println("\n\nStudents who have email like '%mail.com'");
            displayStudents(theStudents);


            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
