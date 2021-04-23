package com.mymaven.hibernateannotationexamplethree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateAnnotationExampleThree {
    public static void main(String [] args){
    String file = "hibernate.cfg.xml";
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure(file).build();
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    
    SessionFactory session = meta.getSessionFactoryBuilder().build();
    Session s = session.openSession();
    Transaction t = s.beginTransaction();
    
    Employee emp1 = new Employee();
    emp1.setEmpid(107);
    emp1.setName("Neelam");
    emp1.setPassword("n1234");
    emp1.setDept("HR");
    emp1.setDeptno(3);
    emp1.setSalary(5678);
    
    s.save(emp1);
    t.commit();
    System.out.println("Record saved successfully");
    s.close();
    session.close();
    }
}
