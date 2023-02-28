package ejer1;

public class Concesionario {

    String marca;
    String modelo;
    long precioBase;
    boolean aireAcondicionado;
    boolean cierreCentral;
    boolean pinturaMetalizada;
    String tipoMotor;

    public Concesionario(String marca, String modelo, long precioBase, boolean aireAcondicionado, boolean cierreCentral, boolean pinturaMetalizada, String tipoMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentral = cierreCentral;
        this.pinturaMetalizada = pinturaMetalizada;
        this.tipoMotor = tipoMotor;
    }
}
