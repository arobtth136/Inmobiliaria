package Modelo;

import java.util.ArrayList;


public class Propiedades{
    private int ID;
    private String Direccion;
    private String Tipo;
    private String Tamaño;
    private double Precio;
    private double PrecioAlquiler;
    private String Empleado;
    private ArrayList<String> Dueños;
    private String Estado;
    public Propiedades() {
    }

    public Propiedades(int ID, String Direccion, String Tipo, String Tamaño, double Precio, double PrecioAlquiler, String Empleado) {
        this.ID = ID;
        this.Direccion = Direccion;
        this.Tipo = Tipo;
        this.Tamaño = Tamaño;
        this.Precio = Precio;
        this.PrecioAlquiler = PrecioAlquiler;
        this.Empleado = Empleado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String Tamaño) {
        this.Tamaño = Tamaño;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getPrecioAlquiler() {
        return PrecioAlquiler;
    }

    public void setPrecioAlquiler(double PrecioAlquiler) {
        this.PrecioAlquiler = PrecioAlquiler;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String Empleado) {
        this.Empleado = Empleado;
    }

    public ArrayList<String> getDueños() {
        return Dueños;
    }

    public void setDueños(ArrayList<String> Dueños) {
        this.Dueños = Dueños;
    }
    
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }    
}