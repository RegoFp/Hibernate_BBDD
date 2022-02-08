import java.util.List;
import java.util.Scanner;
import java.util.Date;
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
                    borrarTablaDept();
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
        }while(opcion!=5);
        ent.close();
    }

    private static void delDept() {
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

        System.out.println("Comm    Deptno  Emp    Name");
        for(emp empl: list){   
            System.out.println(empl.getComm()+" "+empl.getDeptno()+" "+empl.getEmpno()+" "+empl.getEname());
       
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

    private static void borrarTablaDept() {
        bd.delDept();
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
     private static void insertarTablaEmp(Scanner sc){
        
        String name, job,fecha;
        int  id,deptno;
        float mrg, sal, comm;
 
        
        System.out.println("Tabla EMP");
        
        System.out.print("\nID?");
        id=sc.nextInt();
        sc.nextLine();
        System.out.print("\nIntroduce el nombre ");
        name=sc.nextLine();
        System.out.print("\nIntroduce el trabajo ");
        job=sc.nextLine();
        System.out.print("\nJefe de?");
        mrg=sc.nextFloat();
        sc.nextLine();
        System.out.print("\nIntroduce la fecha"); //Validar
        fecha=sc.nextLine();
        System.out.print("\nIntroduce el salario");
        sal=sc.nextFloat();
        sc.nextLine();
        System.out.print("\nIntroduce el comm");
        comm=sc.nextFloat();
        sc.nextLine();
        System.out.print("\nDepartamento?");
        deptno=sc.nextInt();
        sc.nextLine();
            
        emp empto = new emp(id,name, job, mrg, fecha, sal, comm, deptno);
        bd.postEmp(empto);
        

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
