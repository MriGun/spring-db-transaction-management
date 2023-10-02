package com.mri.transactional.dao;

import com.mri.transactional.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public class StudentDAOImpl {

    //@PersistenceContext(unitName = "mysqldb")
    @Autowired
    EntityManager entityManager;

    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
        System.out.println("record inserted!");
    }

    public List<Student> findAllStudent() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
       return query.getResultList();
    }
}
