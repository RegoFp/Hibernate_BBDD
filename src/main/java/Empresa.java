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
                    insertarTabla(ent);
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

    private static void insertarTabla(Scanner sc) {
        String name, loc;
        
        System.out.println("Tabla DEPTNO");
        
        do{
            System.out.print("\nIntroduce el nombre ");
            name=sc.nextLine();
            System.out.print("\nIntroduce la locación ");
            loc=sc.nextLine();
        }while(name!="\n");
        if(name.equals("\n"){
            
        }else{
            dept depto = new dept(name, loc);
            bd.postDept(depto);
        }
        
        String name, job;
        int mrg, deptno;
        float sal, comm;
        Date hiredate=new Date();
        
        System.out.println("Tabla EMP");
        
        do{
            System.out.print("\nIntroduce el nombre ");
            name=sc.nextLine();
            System.out.print("\nIntroduce el trabajo ");
            job=sc.nextLine();
            System.out.print("\nJefe de?");
            mrg=sc.nextInt();
            System.out.print("\nIntroduce la fecha");
            System.out.println("Año: "+ (hiredate.getYear()+1900) );
            System.out.println("Mes: "+hiredate.getMonth());
            System.out.println("Dia: "+hiredate.getDate());
            System.out.println("Dia de la semana "+hiredate.getDay());
            System.out.println("Hora: "+hiredate.getHours());
            System.out.println("Minutos: "+hiredate.getMinutes());
            System.out.println("Segundos: "+hiredate.getSeconds());
            System.out.print("\nIntroduce el salario");
            sal=sc.nextFloat();
            System.out.print("\nIntroduce el comm");
            comm=sc.nextFloat();
             do{
                System.out.print("\nDepartamento?");
                deptno=sc.nextInt();
            }while(deptno.isEmpty());
        }while(name!=null);
        if(name==null){
            
        }else{
            empt empto = new empt(name, job, mrg, hiredate, sal, comm, deptno);
            bd.postEmpt(empto);
        }


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
