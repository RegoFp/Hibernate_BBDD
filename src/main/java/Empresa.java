import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class Empresa {
    static BBDD bd = new BBDD();

    public static void main(String []args){
        Scanner ent=new Scanner(System.in);
        int opcion=0;
        do{
            opcion=menu(ent,opcion);
            switch(opcion){
                case 1:
                    //insertarTablaDeptno(ent);
                    insertarTablaEmp(ent);
                    break;
                case 2:
                    borrarTabla();
                    break;
                case 3:
                    mostrarTablaEMP();
                    break;
                case 4:
                    mostrarTablaDEPT();
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                default:
                    break;


            }
        }while(opcion!=5);
        ent.close();
    }

    private static void mostrarTablaDEPT() {

        List<dept> list = bd.showDept();

        int index  = 1;//Esta forma de hacer el for no devuelve la posicion
        for(dept depto: list){   
            System.out.println(index +" "+ depto.getDname()+" "+ depto.getLoc());
            index += 1;
        }


    }

    private static void mostrarTablaEMP() {
        List<emp> list = bd.showEmp();

        for(emp empl: list){   
            System.out.println(empl.getComm()+""+empl.getDeptno()+""+empl.getEmpno()+""+empl.getEname());
       
        }
    }

    private static void borrarTabla() {
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

     private static void insertarTablaEmp(Scanner ent){
        Scanner sc=ent;
        String name, job,fecha;
        int mrg, id,deptno;
        float sal, comm;
 
        
        System.out.println("Tabla EMP\n");
        
        System.out.print("ID?\n");
        id=sc.nextInt();
        sc.nextLine();
        
        System.out.print("Introduce el nombre \n");
        name=sc.nextLine();
        
        System.out.print("Introduce el trabajo \n");
        job=sc.nextLine();
        
        System.out.print("Jefe de ?\n");
        mrg=sc.nextInt();
        sc.nextLine();

        //Validar fecha
        fecha = validacionFecha(sc);
        
        System.out.print("Introduce el salario\n");
        sal=sc.nextFloat();
        
        System.out.print("Introduce el comm\n");
        comm=sc.nextFloat();
        
        System.out.print("Departamento?\n");
        deptno=sc.nextInt();
        sc.nextLine();

        
            
        emp empto = new emp(id,name, job, mrg, fecha, sal, comm, deptno);
        bd.postEmp(empto);
        

    }



    public static int menu(Scanner ent,int opcion){
        System.out.println("Menu");
        System.out.println("1. Insertar en tabla DEPT");
        System.out.println("2. Borrar de tabla DEPT");
        System.out.println("3. Mostrar tabla EMP");
        System.out.println("4. Mostrar tabla DEPT");
        System.out.println("5. Salir");
        do {  //TODO asegurar que la entrada sea un numero
            System.out.println("Introduce una opcion(1-5)");
            opcion=ent.nextInt();
            ent.nextLine();

        }while(opcion<1||opcion>5);
        return opcion;
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
}
