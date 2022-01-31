package com.mycompany.hibernate_bbdd;

import org.hibernate.Session;

public class BBDD{


    public void postDept( dept depto){

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(depto);
        session.getTransaction().commit();
        session.close();

    }

}