package modelo;

import enumeradores.EnumColor;
import enumeradores.EnumTipo;
import java.util.Date;

public class Objeto {
    private int id_objeto;
    private String descripcion_objeto;
    private EnumTipo tipo;
    private EnumColor color;
    private Date fecha_encontrado;
    private Sala sala;
    private Encontrado encontrado;
    private Recibido recibido;

    public Objeto() {
    }

    public Objeto(int id_objeto, String descripcion_objeto, EnumTipo tipo, EnumColor color, Date fecha_encontrado, Sala sala, Encontrado encontrado, Recibido recibido) {
        this.id_objeto = id_objeto;
        this.descripcion_objeto = descripcion_objeto;
        this.tipo = tipo;
        this.color = color;
        this.fecha_encontrado = fecha_encontrado;
        this.sala = sala;
        this.encontrado = encontrado;
        this.recibido = recibido;
    }

    public int getId_objeto() {
        return id_objeto;
    }

    public void setId_objeto(int id_objeto) {
        this.id_objeto = id_objeto;
    }

    public String getDescripcion_objeto() {
        return descripcion_objeto;
    }

    public void setDescripcion_objeto(String descripcion_objeto) {
        this.descripcion_objeto = descripcion_objeto;
    }

    public EnumTipo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipo tipo) {
        this.tipo = tipo;
    }

    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public Date getFecha_encontrado() {
        return fecha_encontrado;
    }

    public void setFecha_encontrado(Date fecha_encontrado) {
        this.fecha_encontrado = fecha_encontrado;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Encontrado getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Encontrado encontrado) {
        this.encontrado = encontrado;
    }

    public Recibido getRecibido() {
        return recibido;
    }

    public void setRecibido(Recibido recibido) {
        this.recibido = recibido;
    }

    @Override
    public String toString() {
        return "Objeto{" + "id_objeto=" + id_objeto + ", descripcion_objeto=" + descripcion_objeto + ", tipo=" + tipo + ", color=" + color + ", fecha_encontrado=" + fecha_encontrado + ", sala=" + sala + ", encontrado=" + encontrado + ", recibido=" + recibido + '}';
    }
    
    


    
}
