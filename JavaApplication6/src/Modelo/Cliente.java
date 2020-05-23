package Modelo;

import java.util.ArrayList;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String dni;
    public  ArrayList<Cliente> clientes;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String direccion, String telefono, String dni) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        clientes = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setArregloClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }

    public ArrayList getArregloClietes() {
        return this.clientes;
    }

}
