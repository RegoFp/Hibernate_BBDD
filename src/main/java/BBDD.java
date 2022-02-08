
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

    //Meter cosas----------------------------------------------------

    //Meter departamento FUNCIONA NO TOCAR
    public void postDept( dept depto){

        HibernateUtil.buildSessionFactory();

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        session.save(depto);
        session.getTransaction().commit();

        session.close();
    }
    
    //Meter empleado FUNCIONA NO TOCAR
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


    //Mostrar solo 1 cosa------------------------------------------------------------------------------------

    //Devuelve 1 solo empleado
    public emp getEmp(int empno){
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();

        emp emp = HibernateUtil.getCurrentSession().get(emp.class, empno);
        return emp;

    }

    //No se como hacer por que la clave primania ni la damos ni la recibimos por que se autogenera
    public dept getDept(){
        return null;
    }


    //Eliminar cosas------------------------------------------------------------------------------------------------------

    //TODO Busqueda de dept, para que devulva solo 1 dept, para que el usuario solo tenga que introducir el id
    public void delDept(){
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        String sql = "DELETE FROM dept";
        Query query = session.createQuery(sql);
        int row = query.executeUpdate();
        if (row != 0)
            System.out.println("Tabla eliminada");
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