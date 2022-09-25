package com.mri.transactional.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> studentInfo = Class.forName("com.mri.transactional.proxy.Student");

        Constructor<?>[] constructors = studentInfo.getConstructors();

        for (Constructor constr : constructors) {
            System.out.println("constr " + constr);
        }

        Method[] methods = studentInfo.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method " + method);
        }

        Class<Student> student = Student.class;
        Student newStudent = student.newInstance();

        /*Student newStudent = new Student();
        Class<Student>studentInfoNew = newStudent.getClass();*/

        Class[] methodArgs = new Class[] {Integer.class};
        Method method =  student.getDeclaredMethod("attendClass", methodArgs);
        method.invoke(newStudent, 101);

        Method method2 =  student.getDeclaredMethod("attendClass");
        method2.invoke(newStudent);


    }
}
