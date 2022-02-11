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
    

    /**
     * Crea la conexion de Hibernate con la BBDD
     */
    public void createSession(){
        HibernateUtil.buildSessionFactory();
        session = HibernateUtil.getCurrentSession();
    }

    /**
     * Cierra la session de Hibernate con BBDD
     */
    public void closeSession(){
        session.close();
    }

    /**
     * Recibe un departamento  ylo añade a la tabla departamento
     * @param depto El departamento que añadir
     */
    public void postDept( dept depto){
        
        session.beginTransaction();

        session.save(depto);
        session.getTransaction().commit();

 
    }
    
    /**
     * Recibe  un empleado y lo añade a la tabla departamentos
     * @param empl el empleado a añadir
     */
    public void postEmp(emp empl){
    
        
        session.beginTransaction();

        session.save(empl);
        session.getTransaction().commit();


    }

    
    //Mostramos valores
    
    //https://www.baeldung.com/hibernate-select-all
    
    /**
     * Crea una lista con los departamentos de la tabla de departamentos
     * @return Una lista con un objeto por cada elemento de la tabla de departamentos
     */
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

  
    /**
     * Crea una lista con los empleados de la tabla de empleados
     * @return Una lista con un objeto por cada elemento de la tabla de empleados
     */
    public List<emp> showEmp(){
    

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<emp> cq = cb.createQuery(emp.class);
        Root<emp> rootEntry = cq.from(emp.class);
        CriteriaQuery<emp> all = cq.select(rootEntry);
        
        TypedQuery<emp> allQuery = session.createQuery(all);
        return allQuery.getResultList();
        
    }
    
    /**
     * Actualiza un elemento de la tabla empleado
     * @param empleado El empleado ya modifica a actualizar
     */
    public void updateEmp(emp empleado){
  

        session.beginTransaction();
        session.update(empleado);
        session.getTransaction().commit();

    }



    /**
     * Recibe un numero y devuelve el empleado corespondiente a ese numero
     * @param empno El numero del usuario a mostrar
     * @return un objeto emp que posee el numero introducido
     */
    public emp getEmp(int empno){
  

        emp emp = session.get(emp.class, empno);

        return emp;

    }

    /**
     * DRecibe un numero y devuelve el departamento corespondiente a ese numero 
     * @param deptno El numero del departamento a recibir
     * @return un objeto dept que posee el numero introducido
     */
    public dept getDept(int deptno){
        

        dept dept = session.get(dept.class, deptno);
      
        return dept;

    }


    /**
     * Elimina un departamento de la tabla de departamentos
     * @param deptno El departamento a eliminat
     */
    public void delDept(dept deptno){
    
        session.beginTransaction();
        
        session.delete(deptno);
        session.getTransaction().commit();
        

    }

    /**
     * Elimina un empleado de la tabla de empleados
     * @param empl El empleado a eliminar
     */
    public void delEmp(emp empl){
      
        session.beginTransaction();
        
        session.delete(empl);
        session.getTransaction().commit();
        

    }
}
