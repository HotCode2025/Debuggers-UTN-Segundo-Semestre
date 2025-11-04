/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionproveedores;

/**
 *
 * @author Kevito
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String cuit;
    private String telefono;
    private String email;
    private String direccion;
    private String representante;
    private String tipoProductos;
    private boolean activo;

    public Proveedor(int id, String nombre, String cuit, String telefono, String email,
                     String direccion, String representante, String tipoProductos, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.cuit = cuit;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.representante = representante;
        this.tipoProductos = tipoProductos;
        this.activo = activo;
    }
       // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCuit() { return cuit; }
    public void setCuit(String cuit) { this.cuit = cuit; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getRepresentante() { return representante; }
    public void setRepresentante(String representante) { this.representante = representante; }

    public String getTipoProductos() { return tipoProductos; }
    public void setTipoProductos(String tipoProductos) { this.tipoProductos = tipoProductos; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Proveedor {" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", CUIT='" + cuit + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Email='" + email + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Representante='" + representante + '\'' +
                ", Tipo de productos='" + tipoProductos + '\'' +
                ", Activo=" + activo +
                '}';
    }
    
}
