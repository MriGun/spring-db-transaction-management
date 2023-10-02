package com.mri.transactional.app;

import com.mri.transactional.config.AppConfig;
import com.mri.transactional.dao.StudentDAO;
import com.mri.transactional.dao.StudentDAOImpl;
import com.mri.transactional.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDAOImpl studentDAO = container.getBean("studentDAOImpl", StudentDAOImpl.class);

        Student student = new Student();
        student.setName("Mrinmoy");
        student.setMobile("017");
        student.setAddress("dhaka");

        studentDAO.saveStudent(student);

        List<Student> allStudent = studentDAO.findAllStudent();
        allStudent.stream().forEach(s -> System.out.println(s));

    }
}
