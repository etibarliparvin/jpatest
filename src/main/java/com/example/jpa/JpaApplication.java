package com.example.jpa;

import com.example.jpa.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class JpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student();
        student.setName("Test");
        student.setAddress("test");
        student.setAge(22);
        student.setEmail("test");

        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
