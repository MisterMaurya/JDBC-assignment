package com.assignment2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Beans successfully loaded ...");
        JDBCConnection jdbcConnection = context.getBean("connectionObject",JDBCConnection.class);
        jdbcConnection.getJDBCConnection();
    }
}
