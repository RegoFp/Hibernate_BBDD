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
    public Session session;
    

    public void createSession(){
        HibernateUtil.buildSessionFactory();
        session = HibernateUtil.getCurrentSession();
    }


    public void closeSession(){
        session.close();
    }

    //Introducimos departamento
    public void postDept( dept depto){
        
        session.beginTransaction();

        session.save(depto);
        session.getTransaction().commit();

 
    }
    
    //Introducimos empleado
    public void postEmp(emp empl){
    
        
        session.beginTransaction();

        session.save(empl);
        session.getTransaction().commit();


    }

    
    //Mostramos valores
    
    //https://www.baeldung.com/hibernate-select-all
    //Mostramos departamentos
    public List<dept> showDept(){
        
       
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<dept> cq = cb.createQuery(dept.class);
        Root<dept> rootEntry = cq.from(dept.class);
        CriteriaQuery<dept> all = cq.select(rootEntry);
        
        TypedQuery<dept> allQuery = session.createQuery(all);
        return allQuery.getResultList();
        //metodo simple
        //return session.createQuery("select a FROM dept a",dept.class).getResultList();
    }

  
    //Mostramos empleados
    public List<emp> showEmp(){
    

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<emp> cq = cb.createQuery(emp.class);
        Root<emp> rootEntry = cq.from(emp.class);
        CriteriaQuery<emp> all = cq.select(rootEntry);
        
        TypedQuery<emp> allQuery = session.createQuery(all);
        return allQuery.getResultList();
        
    }
    
    
    //Actualizamos la tabla emp
    public void updateEmp(emp empleado){
  

        session.beginTransaction();
        session.update(empleado);
        session.getTransaction().commit();

    }

    
    //Mostramos 1 solo valor

    //Mostramos 1 solo empleado
    public emp getEmp(int empno){
  

        emp emp = session.get(emp.class, empno);

        return emp;

    }

    //Mostramos 1 solo departamento
    public dept getDept(int deptno){
        

        dept dept = session.get(dept.class, deptno);
      
        return dept;

    }


    //Eliminar elementos

    //Eliminamos departamento
    public void delDept(dept deptno){
    
        session.beginTransaction();
        
        session.delete(deptno);
        session.getTransaction().commit();
        

    }

    //Eliminados empleado
    public void delEmp(emp empl){
      
        session.beginTransaction();
        
        session.delete(empl);
        session.getTransaction().commit();
        

    }
}
