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
  //Definimos las variables
  private static SessionFactory sessionFactory;
  private static Session session;
	
  //Creamos la factoría de sesiones
  public static void buildSessionFactory() {

    Properties properties = new Properties();
    properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");     
    properties.put(Environment.URL, "jdbc:mysql://database-1.cvliipm1ojas.eu-west-2.rds.amazonaws.com/sys");
    properties.put(Environment.USER, "admin");
    properties.put(Environment.PASS, "administrador");
    properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
    properties.put(Environment.SHOW_SQL, "false");


    Configuration configuration = new Configuration();
    configuration.setProperties(properties);
    configuration.configure();

    //Se registran las clases que hay que mapear con cada tabla de la base de datos
    configuration.addAnnotatedClass(dept.class);
    configuration.addAnnotatedClass(emp.class);
    
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
    configuration.getProperties()).build();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

  }
	
  //Abrimos nueva sesión
  public static void openSession() {
    session = sessionFactory.openSession();
  }
	
  //Devolvemos la sesión actual
  public static Session getCurrentSession() {
	
    if ((session == null) || (!session.isOpen()))
      openSession();
			
    return session;
  }
	
  //Cerramos hibernate
  public static void closeSessionFactory() {
	
    if (session != null)
      session.close();
		
    if (sessionFactory != null)
      sessionFactory.close();
  }
}
