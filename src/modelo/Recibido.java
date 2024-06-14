package modelo;
import enumeradores.EnumEscuela;
import enumeradores.EnumSemestre;

public class Recibido {
    
    private String rut_recibido, nombre_recibido, apellido_recibido;
    private EnumEscuela escuela;
    private EnumSemestre semestre;

    public Recibido() {
    }

    public Recibido(String rut_recibido, String nombre_recibido, String apellido_recibido, EnumEscuela escuela, EnumSemestre semestre) {
        this.rut_recibido = rut_recibido;
        this.nombre_recibido = nombre_recibido;
        this.apellido_recibido = apellido_recibido;
        this.escuela = escuela;
        this.semestre = semestre;
    }

    public String getRut_recibido() {
        return rut_recibido;
    }

    public void setRut_recibido(String rut_recibido) {
        this.rut_recibido = rut_recibido;
    }

    public String getNombre_recibido() {
        return nombre_recibido;
    }

    public void setNombre_recibido(String nombre_recibido) {
        this.nombre_recibido = nombre_recibido;
    }

    public String getApellido_recibido() {
        return apellido_recibido;
    }

    public void setApellido_recibido(String apellido_recibido) {
        this.apellido_recibido = apellido_recibido;
    }

    public EnumEscuela getEscuela() {
        return escuela;
    }

    public void setEscuela(EnumEscuela escuela) {
        this.escuela = escuela;
    }

    public EnumSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(EnumSemestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Recibido{" + "rut_recibido=" + rut_recibido + ", nombre_recibido=" + nombre_recibido + ", apellido_recibido=" + apellido_recibido + ", escuela=" + escuela + ", semestre=" + semestre + '}';
    }
    
    
    
    
}
