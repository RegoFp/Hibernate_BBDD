package com.mycompany.hibernate_bbdd;
import java.util.Scanner;
public class Empresa {
    public static void main(String []args){
        Scanner ent=new Scanner(System.in);
        int opcion=0;
        do{
            opcion=menu(ent,opcion);
            switch(opcion){
                case 1:
                    insertarTabla();
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
    public static int menu(Scanner ent,int opcion){
        System.out.println("Menu");
        System.out.println("1. Insertar tabla DEPT");
        System.out.println("2. Borrar tabla DEPT");
        System.out.println("3. Mostrar tabla EMP");
        System.out.println("4. Mostrar tabla DEPT");
        System.out.println("5. Salir");
        do {
            System.out.println("Introduce una opcion(1-5)");
            opcion=ent.nextInt();
        }while(opcion<1||opcion>5);
        return opcion;
    }
}
