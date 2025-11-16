package domain;

import java.util.Date;

public class Cliente extends Persona{
    private int idCliente;
    private Date fechaRegistro;
    private static int contadorClientes;
    private boolean vip;

    public Cliente(String nombre, Date fechaRegistro, boolean vip) {
        super(nombre);
        this.idCliente = ++Cliente.contadorClientes;
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return this.vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente { ");
        sb.append("idCliente: ").append(idCliente);
        sb.append(", Nombre: ").append(super.toString());
        sb.append(", fechaRegistro: ").append(fechaRegistro);
        sb.append(", vip: ").append(vip);
        sb.append(" }");
        return sb.toString();
    }
}

