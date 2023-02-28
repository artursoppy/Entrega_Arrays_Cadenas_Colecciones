package ejer1;
import java.util.Scanner;

public class Principal {

    static void ordenarMarcaMetodoBurbuja(Concesionario[] coches){
        boolean ordenado = false;
        int cuentaIntercambios = 0;

        while(!ordenado){

            for (int i = 0; i < coches.length-1; i++) {

                if (coches[i].marca.compareToIgnoreCase(coches[i+1].marca)>0){

                    Concesionario aux = coches[i];
                    coches[i] = coches[i+1];
                    coches[i+1] = aux;
                    cuentaIntercambios++;

                }
            }

            if (cuentaIntercambios == 0){
                ordenado=true;
            }
            cuentaIntercambios = 0;

        }
    }

    public static void MayorPrecio(Concesionario[] coches){

        boolean compruebaOrdenacion = false;
        int cuentaIntercambios = 0;

        while (!compruebaOrdenacion){

            for (int i = 0; i < coches.length-1; i++) {

                if (coches[i].precioBase<coches[i+1].precioBase){

                    Concesionario aux = coches[i];
                    coches[i] = coches[i+1];
                    coches[i+1] = aux;
                    cuentaIntercambios++;

                }
            }

            if (cuentaIntercambios == 0){
                compruebaOrdenacion = true;
            }
            cuentaIntercambios = 0;

        }

    }

    public static int busquedaDicotomica(Concesionario[] coches, String key){

        int index = Integer.MAX_VALUE;
        int low = 0;
        int high = coches.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (coches[mid].marca.compareToIgnoreCase(key) < 0) {
                low = mid + 1;
            } else if (coches[mid].marca.compareToIgnoreCase(key) > 0) {
                high = mid - 1;
            } else if (coches[mid].marca.compareToIgnoreCase(key) == 0) {
                index = mid;
                break;
            }
        }

        return index;

    }

    public static void main(String[] args) {

        Concesionario[] coches = new Concesionario[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona opción");
        byte opcion = sc.nextByte();

        while (opcion != 0){

            switch (opcion) {
                case 1:
                    coches[0] = new Concesionario("Citroen", "C3", 13000, true, false, false, "Eléctrico");
                    coches[1] = new Concesionario("Audi", "E5", 23000, true, true, true, "Híbrido");
                    coches[2] = new Concesionario("Opel", "D3", 10000, true, false, false, "Diesel");
                    break;
            case 2:
                    ordenarMarcaMetodoBurbuja(coches);
                    for (Concesionario coch : coches) {
                        System.out.println(coch.marca);
                    }
                    break;
            case 3:
                    MayorPrecio(coches);
                    for (Concesionario coch : coches) {
                        System.out.println(coch.precioBase);
                    }
                    break;
            case 4:
                    System.out.println("Introuce la marca a buscar");
                    sc = new Scanner(System.in);
                    String key = sc.nextLine();
                    System.out.println(busquedaDicotomica(coches, key));
                break;
                case 5:
                    for (Concesionario coch : coches) {
                        System.out.println(coch.marca + " " + coch.modelo + " " + coch.precioBase + " " +
                                "" + coch.aireAcondicionado + " " + coch.cierreCentral + " " +
                                "" + coch.pinturaMetalizada + " " + coch.tipoMotor);
                    }
                    break;
                default:
                    System.err.println("No válida");
                    break;
            }

            System.out.println("Selecciona opción");
            opcion = sc.nextByte();

        }
    }
}

