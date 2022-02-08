
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class BBDD{

    //Meter cosas----------------------------------------------------

    //Meter departamento
    public void postDept( dept depto){

        HibernateUtil.buildSessionFactory();

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        session.save(depto);
        session.getTransaction().commit();

        session.close();
    }
    
    //Meter empleado
    public void postEmp(emp empl){
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        session.save(empl);
        session.getTransaction().commit();

        session.close();

    }

    //Mostrar cosas ----------------------------------------------------------

    //https://www.baeldung.com/hibernate-select-all
    public List<dept> showDept(){
        
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
       
        return session.createQuery("select a FROM dept a",dept.class).getResultList();
        

    }

    //TODO no funciona
    public List<emp> showEmp(){
 
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
       
        return session.createQuery("select a FROM emp a",emp.class).getResultList();

     //Metodo chuli que aun no se hacer

     /*    HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<emp> cq = cb.createQuery(emp.class);
        Root<emp> rootEntry = cq.from(emp.class);
        CriteriaQuery<emp> all = cq.select(rootEntry);
        
        TypedQuery<emp> allQuery = session.createQuery(all);
        return allQuery.getResultList();
         */
    }


    //Mostrar solo 1 cosa------------------------------------------------------------------------------------

    //Supuestamente esto devuelve 1 solo empleado, no me lo creo, no lo probe
    public emp getEmp(String name){
        emp emp = HibernateUtil.getCurrentSession().get(emp.class, name);
        return emp;

    }

    //No se como hacer por que la clave primania ni la damos ni la recibimos por que se autogenera
    public dept getDept(){
        return null;
    }


    //Eliminar cosas------------------------------------------------------------------------------------------------------

    //TODO Busqueda de dept, para que devulva solo 1 dept, para que el usuario solo tenga que introducir el id
    public void delDept(dept depto){

        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(depto);
        session.getTransaction().commit();
        session.close();
    }

    public void delEmp(emp empl){

        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(empl);
        session.getTransaction().commit();
        session.close();
    }

}