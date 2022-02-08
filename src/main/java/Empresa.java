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
                    insertarTablaDeptno(ent);
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

        System.out.println("Comm    Deptno  Emp    Name");
        for(emp empl: list){   
            System.out.println(empl.getComm()+" "+empl.getDeptno()+" "+empl.getEmpno()+" "+empl.getEname());
       
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
        }while(opcion<1||opcion>5);
        return opcion;
    }
}
