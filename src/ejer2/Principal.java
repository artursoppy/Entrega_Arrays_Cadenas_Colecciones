package ejer2;
import java.util.ArrayList;
import java.util.Scanner;
public class Principal {

    static byte opcion;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        mensajeMenu();
        opcion = sc.nextByte();
        ArrayList<Notas> curso1 = new ArrayList<>();

        while (opcion != 6){
            switch (opcion){

                case 1:
                    verNota(curso1);
                    break;
                case 2:
                    addNota(curso1);
                    break;
                case 3:
                    borrarNota(curso1);
                    break;
                case 4:
                    stats(curso1);
                    break;
                case 5:
                    suspendidos(curso1);
                    break;
                default:
                    System.err.println("Error");
                    break;
            }
            mensajeMenu();
            opcion = sc.nextByte();
        }

    }

    public static void mensajeMenu(){

        System.out.println("Programa para gestión de notas de alumnos.");
        System.out.println("1.- Ver notas.");
        System.out.println("2.- Añadir nota.");
        System.out.println("3.- Borrar nota.");
        System.out.println("4.- Estadísticas.");
        System.out.println("5.- Ver suspendidos.");
        System.out.println("6.- Salir.");
        System.out.println("Seleccione una opción (1-6)");

    }

    public static void verNota(ArrayList<Notas> curso){
        int cont = 0;
        for (Notas notas : curso) {
            System.out.println("Nota " + (cont++) + ": " + notas.getNombre() + ", que tiene un " + notas.getNota());
        }

    }

    public static void addNota(ArrayList<Notas> curso){

        System.out.println("Introduce el nombre del alumno");
        sc = new Scanner(System.in);
        String nombre = sc.nextLine();

        int nota = compruebaNota();

        if(curso.size() < 100){
            curso.add(new Notas(nombre, nota));
        } else {
            System.out.println("No caben mas alumnos");
        }

    }

    public static void borrarNota(ArrayList<Notas> curso){

        System.out.println("Indica el número de nota que deseas borrar");
        int nota = sc.nextInt();
        curso.remove(nota);

    }

    public static void stats(ArrayList<Notas> curso){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double avg = 0;

        for (Notas nota : curso) {

            if (nota.getNota() > max) max = nota.getNota();
            if (nota.getNota() < min) min = nota.getNota();
            avg = nota.getNota() + avg;

        }

        System.out.println("La nota máxima es un "+max+", la nota mínima es un "+min+" y la media es un "+avg/curso.size());

    }

    public static void suspendidos(ArrayList<Notas> curso){

        for (Notas nota : curso) {

            if (nota.getNota() < 5){
                System.out.println(nota.getNombre()+" con un "+nota.getNota()+" ha suspendido.");
            }
        }

    }

    public static int compruebaNota(){
        int nota = 0;

        while(nota <= 0 || nota >= 10){
            System.out.println("Introduce la nota del alumno, del 0 al 10");
            nota = sc.nextInt();
        }

        return nota;

    }

}
