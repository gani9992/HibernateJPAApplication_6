package com.org.ThirdHibernateApplication;
import com.org.dao.*;
import com.org.entity.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Dao d1=new DaoImpl();
        Student s1=new Student();
        s1.setId(1);
        s1.setName("Abdul_gani");
        s1.setEmail("gani@gmail.com");
        System.out.println("completed calling..!!");
        d1.retrieveStudentUsingSqlQuery(1);
    }
}
