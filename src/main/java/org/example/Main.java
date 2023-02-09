package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCust_name("li");

        Customer customer2 = new Customer();
        customer2.setCust_name("hua");


        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkm_name("ruhua");

        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkm_name("fengjie");


        LinkMan linkMan3 = new LinkMan();
        linkMan3.setLkm_name("wangcai");

        linkMan1.setCustomer(customer1);
        linkMan2.setCustomer(customer1);
        linkMan3.setCustomer(customer2);

        customer1.getLinkMans().add(linkMan1);
        customer1.getLinkMans().add(linkMan2);

        customer2.getLinkMans().add(linkMan3);

        session.save(customer1);
        session.save(customer2);

        session.save(linkMan1);
        session.save(linkMan2);
        session.save(linkMan3);


        tx.commit();
    }
}