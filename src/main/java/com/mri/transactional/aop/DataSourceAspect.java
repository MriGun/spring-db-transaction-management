package com.mri.transactional.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.engine.jdbc.connections.internal.ConnectionCreatorFactoryImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Datasource tracker : " + proceedingJoinPoint.getSignature());

        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("return value is : " + proceed);

        if (proceed instanceof Connection) {

            Connection con = (Connection) Proxy.newProxyInstance(
                    ConnectionCreatorFactoryImpl.class.getClassLoader(),
                    new Class[]{Connection.class},
                    new ConnectionInvocationHandler((Connection) proceed)
            );

            return con;
        }
        return proceed;
    }

}
