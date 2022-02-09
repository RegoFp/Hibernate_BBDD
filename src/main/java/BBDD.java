import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BBDD{
    //Introducimos valores

    //Introducimos departamento
    public void postDept( dept depto){
        HibernateUtil.buildSessionFactory();

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        session.save(depto);
        session.getTransaction().commit();

        session.close();
    }
    
    //Introducimos empleado
    public void postEmp(emp empl){
        HibernateUtil.buildSessionFactory();
        
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        session.save(empl);
        session.getTransaction().commit();

        session.close();

    }

    
    //Mostramos valores
    
    //https://www.baeldung.com/hibernate-select-all
    //Mostramos departamentos
    public List<dept> showDept(){
        
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
       
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<dept> cq = cb.createQuery(dept.class);
        Root<dept> rootEntry = cq.from(dept.class);
        CriteriaQuery<dept> all = cq.select(rootEntry);
        
        TypedQuery<dept> allQuery = session.createQuery(all);
        return allQuery.getResultList();
        //metodo simple
        //return session.createQuery("select a FROM dept a",dept.class).getResultList();
    }

    //TODO no funciona
    //Mostramos empleados
    public List<emp> showEmp(){
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<emp> cq = cb.createQuery(emp.class);
        Root<emp> rootEntry = cq.from(emp.class);
        CriteriaQuery<emp> all = cq.select(rootEntry);
        
        TypedQuery<emp> allQuery = session.createQuery(all);
        return allQuery.getResultList();
        
    }
    
    
    //Actualizamos la tabla emp
    public void updateEmp(emp empleado){
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.update(empleado);
    }

    
    //Mostramos 1 solo valor

    //Mostramos 1 solo empleado
    public emp getEmp(int empno){
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();

        emp emp = HibernateUtil.getCurrentSession().get(emp.class, empno);
        return emp;

    }

    //Mostramos 1 solo departamento
    public dept getDept(int deptno){
        
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();

        dept dept = HibernateUtil.getCurrentSession().get(dept.class, deptno);
        return dept;

    }


    //Eliminar elementos

    //Eliminamos departamento
    public void delDept(dept deptno){
        HibernateUtil.buildSessionFactory();
        
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        
        session.delete(deptno);
        session.getTransaction().commit();
        
        session.close();
    }

    //Eliminados empleado
    public void delEmp(emp empl){
        HibernateUtil.buildSessionFactory();
        
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        
        session.delete(empl);
        session.getTransaction().commit();
        
        session.close();
    }
}
