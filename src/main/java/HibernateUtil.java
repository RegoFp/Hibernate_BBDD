import java.io.File;
import java.util.Properties;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

  private static SessionFactory sessionFactory;
  private static Session session;
	

  
  /**
   *<property name="hibernate.connection.driver_class"></property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost/basededatos</property>
    <property name="hibernate.connection.username">usuario</property>
    <property name="hibernate.connection.password">contraseña</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
    <property name="hibernate.show_sql">true</property>
   * 
   * Crea la factoria de sesiones
   */
  public static void buildSessionFactory() {

    Properties properties = new Properties();
    properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
    //properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");      
    properties.put(Environment.URL, "jdbc:mysql://database-1.cvliipm1ojas.eu-west-2.rds.amazonaws.com/sys");
    properties.put(Environment.USER, "admin");
    properties.put(Environment.PASS, "administrador");
    properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
    properties.put(Environment.SHOW_SQL, "true");


    Configuration configuration = new Configuration();
    configuration.setProperties(properties);
    configuration.configure();

    // Se registran las clases que hay que mapear con cada tabla de la base de datos
    configuration.addAnnotatedClass(dept.class);
    configuration.addAnnotatedClass(emp.class);
    
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
      configuration.getProperties()).build();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

  }
	
  /**
   * Abre una nueva sesión
   */
  public static void openSession() {
    session = sessionFactory.openSession();
  }
	
  /**
   * Devuelve la sesión actual
   * @return
   */
  
  public static Session getCurrentSession() {
	
    if ((session == null) || (!session.isOpen()))
      openSession();
			
    return session;
  }
	
  /**
   * Cierra Hibernate
   */
  public static void closeSessionFactory() {
	
    if (session != null)
      session.close();
		
    if (sessionFactory != null)
      sessionFactory.close();
  }
}