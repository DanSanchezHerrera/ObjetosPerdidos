package modelo;
import enumeradores.EnumEscuela;
import enumeradores.EnumSemestre;


public class Encontrado {
    private String rut_encontrado, nombre_encontrado, apellido_encontrado;
    private EnumEscuela escuela;
    private EnumSemestre semestre;

    public Encontrado() {
    }

    public Encontrado(String rut_encontrado, String nombre_encontrado, String apellido_encontrado, EnumEscuela escuela, EnumSemestre semestre) {
        this.rut_encontrado = rut_encontrado;
        this.nombre_encontrado = nombre_encontrado;
        this.apellido_encontrado = apellido_encontrado;
        this.escuela = escuela;
        this.semestre = semestre;
    }

    public String getRut_encontrado() {
        return rut_encontrado;
    }

    public void setRut_encontrado(String rut_encontrado) {
        this.rut_encontrado = rut_encontrado;
    }

    public String getNombre_encontrado() {
        return nombre_encontrado;
    }

    public void setNombre_encontrado(String nombre_encontrado) {
        this.nombre_encontrado = nombre_encontrado;
    }

    public String getApellido_encontrado() {
        return apellido_encontrado;
    }

    public void setApellido_encontrado(String apellido_encontrado) {
        this.apellido_encontrado = apellido_encontrado;
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
        return "Encontrado{" + "rut_encontrado=" + rut_encontrado + ", nombre_encontrado=" + nombre_encontrado + ", apellido_encontrado=" + apellido_encontrado + ", escuela=" + escuela + ", semestre=" + semestre + '}';
    }
 
    


}
