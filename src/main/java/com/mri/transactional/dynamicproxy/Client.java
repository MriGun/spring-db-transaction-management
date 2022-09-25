package com.mri.transactional.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        ITEmployee itEmployee = new ITEmployee();
        itEmployee.setId(101);
        itEmployee.setName("Mrinmoy");
        itEmployee.setSalary(10000);

        /*itEmployee.giveHike(3000);
        System.out.println(itEmployee.getSalary());*/


        EmployeeSalaryInvocationHandler empHandler = new EmployeeSalaryInvocationHandler(itEmployee);

        //TODO
        Object employee = createProxy(ITEmployee.class, empHandler);

        if (employee instanceof IEmployee) {
            IEmployee iEmployee = (IEmployee)employee;
            iEmployee.giveHike(5000);
            System.out.println(iEmployee.getSalary());
            iEmployee.payCut(1000);
        }

        /*IEmployee iemployee = (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(),
                new Class[]{IEmployee.class},
                empHandler);

        iemployee.giveHike(9000);
        System.out.println(iemployee.getSalary());
        iemployee.payCut(3000);*/

    }

    private static Object createProxy(Class clazz, InvocationHandler invocationHandler) {

        Object o =  Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{IEmployee.class},
                invocationHandler);
        return o;
    }


}
