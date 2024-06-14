package modelo;

public class Sala{
    private int id_sala;
    private String descripcion_sala;

    public Sala() {
    }

    public Sala(int id_sala, String descripcion_sala) {
        this.id_sala = id_sala;
        this.descripcion_sala = descripcion_sala;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getDescripcion_sala() {
        return descripcion_sala;
    }

    public void setDescripcion_sala(String descripcion_sala) {
        this.descripcion_sala = descripcion_sala;
    }

    @Override
    public String toString() {
        return "Sala{" + "id_sala=" + id_sala + ", descripcion_sala=" + descripcion_sala + '}';
    }

}
