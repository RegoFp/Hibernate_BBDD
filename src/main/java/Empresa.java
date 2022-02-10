import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



public class Empresa {
    //Definimos la conexión con la base de datos
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
                    cambiarDeptdeEmp(ent);
                    break;
                case 8:
                    mostrarDept(ent);
                    break;
                case 9:
                    mostrarEmp(ent);
                    break;
                case 10:
                    System.out.println("Fin del programa");
                default:
                    break;


            }
        }while(opcion!=10);
        ent.close();
    }

    //Mostramos la tabla Dept
    private static void mostrarTablaDept() {
        List<dept> list = bd.showDept();
        
        for(dept depto: list){   
            System.out.println(depto.getDeptno() +" "+ depto.getDname()+" "+ depto.getLoc());
        }


    }

    //Mostramos la tabla Emp
    private static void mostrarTablaEmp() {
        List<emp> list = bd.showEmp();

        System.out.println("Empno Comm    Deptno  Emp    Name");
        for(emp empl: list){   
            System.out.println(empl.getEmpno() +" "+ empl.getComm()+" "+empl.getDeptno()+" "+empl.getEmpno()+" "+empl.getEname());
       
        }
    }

    //Eliminamos un usuario de la tabla emp
    private static void borrarTablaEmp(Scanner ent) {
        int id=0;
        boolean continua;
        do {
            try {
                continua=false;
                System.out.println("Introduce el empleado que quieres borrar");
                id = ent.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
                ent.next();
                continua=true;
            }
        }while(continua);

        emp emplead = bd.getEmp(id);

        //Comprueba que existe
        if(Objects.isNull(emplead)){
            System.out.println("Ese empleado no existe, no se pudo borrar");
        }else{
            bd.delEmp(emplead);
            System.out.println("Empleado borrado");
        }
    }

    //Eliminamos un departamento de la tabla dept
    private static void borrarTablaDept(Scanner ent) {
        int id=0;
        boolean continua;
        do {
            try {
                continua=false;
                System.out.println("Introduce el departamento que quieres borrar");
                id = ent.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
                ent.next();
                continua=true;
            }
        }while(continua);

        dept deptno = bd.getDept(id);

        if(Objects.isNull(deptno)){
            System.out.println("Ese departamento no existe, no se pudo borrar");
        }else{
            bd.delDept(deptno);
            System.out.println("Departamento borrado");
        }
    }

    //Insertamos departamento en la tabla dept
    private static void insertarTablaDeptno(Scanner sc) {
        String name, loc;
        //El deptno se autoasigna
        System.out.println("Tabla DEPTNO");
        
        System.out.print("\nIntroduce el nombre ");
        name=sc.nextLine();
        System.out.print("\nIntroduce la localización ");
        loc=sc.nextLine();
        
        dept depto = new dept(name, loc);
        bd.postDept(depto);
        
    }

     //Insertamos empleado en la tabla emp
     private static void insertarTablaEmp(Scanner ent){
        Scanner sc=ent;
        String name, job,fecha;
        int id,deptno;
        float sal, comm, mrg;

        emp checkEmp = null;
        dept checkDept = null;
        //Comprueba si el empleado ya existía
        boolean unique = false; 

        System.out.println("Tabla EMP\n");
        
        System.out.print("ID?\n");

         //Solo deja usar un ID que no este en uso
        do{ 
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
        
        System.out.print("Introduce el código de su jefe\n");
         
       // Solo deja introducir un empleado que exista
        do{
            unique = true;
            mrg=sc.nextFloat();
            sc.nextLine();
            checkEmp = bd.getEmp((int) mrg);

            if(checkEmp==null){
                System.out.println("Ese usuario no existe, introduce un empleado que exista");
                unique = false;
            }
        }while(!unique);


        //Validamos la fecha
        fecha = validacionFecha(sc);
        
        System.out.print("Introduce el salario\n");
        sal=sc.nextFloat();
        
        System.out.print("Introduce el comm\n");
        comm=sc.nextFloat();
        
        System.out.print("Departamento?\n");
        
        // Solo deja introducir un departamento que exista
        do{
            unique = true;
            deptno=sc.nextInt();
            sc.nextLine();

            checkDept = bd.getDept(deptno);
            if(Objects.isNull(checkDept)){
                System.out.println("Ese departamento no existe, introduce un departamento que exista:");
                unique = false;
            }
        }while(!unique);


        emp empto = new emp(id,name, job, mrg, fecha, sal, comm, deptno);
        bd.postEmp(empto);
    }
    
    //Validamos la fecha introducida
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

    //Cambiamos el departamento de un empleado
    public static void cambiarDeptdeEmp(Scanner ent){
        int id=0;
        boolean continua;
        do {
            try {
                continua=false;
                System.out.println("Introduce el departamento que quieres borrar");
                id = ent.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
                ent.next();
                continua=true;
            }
        }while(continua);
        dept deptno;
        int dept;

        emp empl = bd.getEmp(id);

        if(Objects.isNull(empl)){
            System.out.println("Ese empleado no existe");
        }else{
            System.out.println(empl.getEname() + " " + empl.getDeptno());
            System.out.println("Nuevo departamento:");

            dept = ent.nextInt();
            ent.nextLine();

            deptno = bd.getDept(dept);
            
             //Comprobar que exista
            if (Objects.isNull(deptno)){
                System.out.print("Ese departamento no existe.");
            }else{
                //Hacer update
                empl.setDeptno(dept); 
                bd.updateEmp(empl);
              
            }
        }
    }


    public static void mostrarEmp(Scanner ent){
        int id=0;
        emp empl;
        boolean continua;
        do {
            try {
                continua=false;
                System.out.println("Introduce el empleado que quieres mostrar: ");
                id = ent.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
                ent.next();
                continua=true;
            }
        }while(continua);
        ent.nextLine();

        empl = bd.getEmp(id);

        if(Objects.isNull(empl)){
            System.out.println("Ese empleado no existe ");
        }else{
            System.out.println("nº   Nombre   Fecha de contrato   Trabajo");
            System.out.println(empl.getEmpno() + " " + empl.getEname() + " " + empl.getHiredate() + " " + empl.getJob());

        }

    }

    public static void mostrarDept(Scanner ent){
        int id=0;
        dept deptno;
        boolean continua;
        do {
            try {
                continua=false;
                System.out.println("Introduce el departamento que quieres mostrar: ");
                id = ent.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
                ent.next();
                continua=true;
            }
        }while(continua);
        deptno = bd.getDept(id);

        if(Objects.isNull(deptno)){
            System.out.println("Ese departamento no existe ");
        }else{
            System.out.println("nº   Nombre   Ubicacion");
            System.out.println(deptno.getDeptno() + " " + deptno.getDname() + " " + deptno.getLoc());

        }

    }

    //Creación del menú
    public static int menu(Scanner ent){
        int opcion;
        System.out.println("Menu");
        System.out.println("1. Insertar en tabla DEPT");
        System.out.println("2. Insertar en tabla EMP");
        System.out.println("3. Borrar de tabla DEPT");
        System.out.println("4. Borrar de tabla EMP");
        System.out.println("5. Mostrar tabla DEPT");
        System.out.println("6. Mostrar tabla EMP");
        System.out.println("7. Cambiar empleado de departamento");
        System.out.println("8. Mostrar departamento");
        System.out.println("9. Mostrar empleado");
        System.out.println("10. Salir");

        do {
            try{
                System.out.println("Introduce una opcion(1-10)");
                opcion= ent.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Introduce un número");
                opcion=0;}
            ent.nextLine();
        }while(opcion<1||opcion>10);
    
        return opcion;
    }
}
