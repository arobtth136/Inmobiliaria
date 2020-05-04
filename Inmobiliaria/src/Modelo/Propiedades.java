package Modelo;

public class Propiedades {
    private int ID;
    private String Direccion;
    private String Tipo;
    private String Tamaño;
    private double Precio;
    private double PrecioAlquiler;

    public Propiedades() {
    }

    public Propiedades(int ID, String Direccion, String Tipo, String Tamaño, double Precio, double PrecioAlquiler) {
        this.ID = ID;
        this.Direccion = Direccion;
        this.Tipo = Tipo;
        this.Tamaño = Tamaño;
        this.Precio = Precio;
        this.PrecioAlquiler = PrecioAlquiler;
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



    
    
}