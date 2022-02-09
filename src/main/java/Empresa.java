import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;



public class Empresa {
    static BBDD bd = new BBDD();

    public static void main(String []args){
        Scanner ent=new Scanner(System.in);
        int opcion=0;

        do{
            opcion=menu(ent);
            switch(opcion){
                case 1:
                    insertarTablaDeptno(ent);
                    break;
                case 2:
                    insertarTablaEmp(ent);
                    break;
                case 3:
                    borrarTablaDept(ent);
                    break;
                case 4:
                    borrarTablaEmp(ent);
                    break;
                case 5:
                    mostrarTablaDept();
                    break;
                case 6:
                    mostrarTablaEmp();
                    break;
                case 7:
                    System.out.println("Fin del programa");
                default:
                    break;


            }
        }while(opcion!=7);
        ent.close();
    }

    private static void mostrarTablaDept() {

        List<dept> list = bd.showDept();

        int index  = 1;//Esta forma de hacer el for no devuelve la posicion
        for(dept depto: list){   
            System.out.println(index +" "+ depto.getDname()+" "+ depto.getLoc());
            index += 1;
        }


    }

    private static void mostrarTablaEmp() {
        List<emp> list = bd.showEmp();

        System.out.println("Empno Comm    Deptno  Emp    Name");
        for(emp empl: list){   
            System.out.println(empl.getEmpno() +" "+ empl.getComm()+" "+empl.getDeptno()+" "+empl.getEmpno()+" "+empl.getEname());
       
        }
    }

    //TODO comprobar si existe antes de borrar
    private static void borrarTablaEmp(Scanner ent) {
        int id;
        System.out.println("Introduce el usuario que quieres borrar");
        id= ent.nextInt();  //TODO asegurar entrada
        emp emplead = bd.getEmp(id);
        bd.delEmp(emplead);


    }

    private static void borrarTablaDept(Scanner ent) {
        int id;
        System.out.println("Introduce el departamento que quieres borrar");
        id= ent.nextInt();  //TODO asegurar entrada
        dept deptno = bd.getDept(id);
        bd.delDept(deptno);
    }

    
    private static void insertarTablaDeptno(Scanner sc) {
        String name, loc;
        
        System.out.println("Tabla DEPTNO");
        
        System.out.print("\nIntroduce el nombre ");
        name=sc.nextLine();
        System.out.print("\nIntroduce la locación ");
        loc=sc.nextLine();
        
        dept depto = new dept(name, loc);
        bd.postDept(depto);
        
    }


     //TODO asegurase que la clave foranea se cumple 
     //TODO Comprobar que es no existe ya
     //Asegurar todas las entradas
     private static void insertarTablaEmp(Scanner ent){
        Scanner sc=ent;
        String name, job,fecha;
        int id,deptno;
        float sal, comm, mrg;

        emp checkEmp = null;
        dept checkDept = null;
        
        boolean unique = false; //Comprueba si el empleado ya existia.

        System.out.println("Tabla EMP\n");
        
        System.out.print("ID?\n");

        do{ //Solo deja usar un ID que no este en uso
            unique = true;
            id=sc.nextInt();
            sc.nextLine();

            checkEmp = bd.getEmp(id);
            if(checkEmp!=null){
                System.out.println("Ese usuario ya existe, introduce un id sin usar");
                unique = false;
            }
        }while(!unique);
        
        System.out.print("Introduce el nombre \n");
        name=sc.nextLine();
        
        System.out.print("Introduce el trabajo \n");
        job=sc.nextLine();
        
        System.out.print("Introduce su jefe\n");
       
        do{// Solo deja introducir un empleado que exista
            unique = true;
            mrg=sc.nextFloat();
            sc.nextLine();
            checkEmp = bd.getEmp((int) mrg);

            if(checkEmp==null){
                System.out.println("Ese usuario no existe, introduce un empleado que exista");
                unique = false;
            }
        }while(!unique);


        //Validar fecha
        fecha = validacionFecha(sc);
        
        System.out.print("Introduce el salario\n");
        sal=sc.nextFloat();
        
        System.out.print("Introduce el comm\n");
        comm=sc.nextFloat();
        
        System.out.print("Departamento?\n");
        

        do{// Solo deja introducir un empleado que exista
            unique = true;
            deptno=sc.nextInt();
            sc.nextLine();
            checkDept = bd.getDept(deptno);

            if(checkEmp==null){
                System.out.println("Ese departamento no existe, introduce un departamento que exista:");
                unique = false;
            }
        }while(!unique);


        emp empto = new emp(id,name, job, mrg, fecha, sal, comm, deptno);
        bd.postEmp(empto);
        

    }
  
    public static String validacionFecha(Scanner sc){
        String fecha = null;
        int seleccion;
        
             System.out.println("¿La fecha corresponde con la actual?(S:1 N:2)");
             seleccion = sc.nextInt();
             
             switch(seleccion){
                 case 1:{
                     LocalDateTime now = LocalDateTime.now();                 
                     fecha = now.getYear()+"/"+now.getMonthValue()+"/"+now.getDayOfMonth();
                      }break;
                 case 2:{
                     
                    int anho=0, mes = 0, dia = 0;
                    boolean correcto = false;

                    while(!correcto){
                       System.out.println("Introduce el año");
                         anho = sc.nextInt();
                       System.out.println("mes (1-12)");
                         mes = sc.nextInt();
                       System.out.println("dia");
                         dia = sc.nextInt();

                       try {
                           //Formato de fecha (día/mes/año)
                           SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                           formatoFecha.setLenient(false);
                           //Comprobación de la fecha
                           formatoFecha.parse(anho + "/" + mes + "/" + dia);
                           correcto = true;
                           fecha = anho + "/" + mes + "/" + dia;
                       } catch (ParseException e) {
                           //Si la fecha no es correcta, pasará por aquí
                           System.out.println("Fecha en foramto incorrecto.");
                           correcto = false;
                       }                 
                    }  
                 }break;
                 default:
                     System.out.println("Introduce 1 o 2 para seleccionar el menú");
             }      
        return fecha;
    }



    public static int menu(Scanner ent){
        int opcion;
        System.out.println("Menu");

        System.out.println("1. Insertar tabla DEPT");
        System.out.println("2. Insertar tabla EMP");
        System.out.println("3. Borrar tabla DEPT");
        System.out.println("4. Borrar tabla EMP");
        System.out.println("5. Mostrar tabla DEPT");
        System.out.println("6. Mostrar tabla EMP");
        System.out.println("7. Salir");

        do {  //TODO asegurar que la entrada sea un numero
            System.out.println("Introduce una opcion(1-7)");
            opcion=ent.nextInt();
            ent.nextLine();
        }while(opcion<1||opcion>7);

        return opcion;
    }
}
