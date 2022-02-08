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
                    insertarTablaDeptno(ent);
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
    }

    private static void mostrarTablaEMP() {
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

     private static void insertarTablaEmp(Scanner sc){
        
        String name, job,fecha;
        int mrg, id;
        float sal,deptno, comm;
        Date hiredate=new Date();
        
        System.out.println("Tabla EMP");
        
        System.out.print("\nID?");
        id=sc.nextInt();
        System.out.print("\nIntroduce el nombre ");
        name=sc.nextLine();
        System.out.print("\nIntroduce el trabajo ");
        job=sc.nextLine();
        System.out.print("\nJefe de?");
        mrg=sc.nextInt();
        System.out.print("\nIntroduce la fecha"); //Validar
        fecha=sc.nextLine();
        System.out.print("\nIntroduce el salario");
        sal=sc.nextFloat();
        System.out.print("\nIntroduce el comm");
        comm=sc.nextFloat();
        System.out.print("\nDepartamento?");
        deptno=sc.nextInt();
            
        emp empto = new emp(id,name, job, mrg, fecha, sal, comm, deptno);
        //bd.postEMP(empto);
        

    }



    public static int menu(Scanner ent,int opcion){
        System.out.println("Menu");
        System.out.println("1. Insertar tabla DEPT");
        System.out.println("2. Borrar tabla DEPT");
        System.out.println("3. Mostrar tabla EMP");
        System.out.println("4. Mostrar tabla DEPT");
        System.out.println("5. Salir");
        do {  //TODO asegurar que la entrada sea un numero
            System.out.println("Introduce una opcion(1-5)");
            opcion=ent.nextInt();
        }while(opcion<1||opcion>5);
        return opcion;
    }
}
