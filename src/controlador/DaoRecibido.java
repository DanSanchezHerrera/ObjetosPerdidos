package controlador;
import enumeradores.EnumEscuela;
import enumeradores.EnumSemestre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Recibido;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DaoRecibido {
    private Connection cone;

    public DaoRecibido() {
        cone = new Conexion().getCone();
    }
    
        public boolean Grabar (Recibido recibido){ 
        try {
            String sql= "insert into RECIBIDO values (?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, recibido.getRut_recibido());
            pstm.setString(2, recibido.getNombre_recibido());
            pstm.setString(3, recibido.getApellido_recibido());
            pstm.setString(4, recibido.getEscuela().toString());
            pstm.setString(5, recibido.getSemestre().toString());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error grabar receptor: "+ e.getMessage());
            return false;
        }
    }
    
        public ArrayList <Recibido> Listar(){
        try {
            String sql="select * from RECIBIDO";
            PreparedStatement pstm=cone.prepareCall(sql);
            ResultSet rs=pstm.executeQuery();
            ArrayList<Recibido> listado=new ArrayList<>();         
            while (rs.next()) {                
                Recibido rec=new Recibido();
                rec.setRut_recibido(rs.getString("rut_recibido"));
                rec.setNombre_recibido(rs.getString("nombre_recibido"));
                rec.setApellido_recibido(rs.getString("apellido_recibido"));
                String escuela = rs.getString("escuela");
                switch (escuela) {
                    case "Administracion_negocios":
                        rec.setEscuela(EnumEscuela.Administracion_negocios);
                        break;
                    case "Disenio":
                        rec.setEscuela(EnumEscuela.Disenio);
                        break;
                    case "Ingenieria":
                        rec.setEscuela(EnumEscuela.Ingenieria);
                        break;
                    case "Comunicacion":
                        rec.setEscuela(EnumEscuela.Comunicacion);
                        break;
                    case "Gastronomia":
                        rec.setEscuela(EnumEscuela.Gastronomia);
                        break;
                    case "Salud":
                        rec.setEscuela(EnumEscuela.Salud);
                        break;
                    case "Construccion":
                        rec.setEscuela(EnumEscuela.Construccion);
                        break;
                    case "Informatica_telecomunicaciones":
                        rec.setEscuela(EnumEscuela.Informatica_telecomunicaciones);
                        break;
                    case "Turismo_hoteleria":
                        rec.setEscuela(EnumEscuela.Turismo_hoteleria);
                        break;
                }
                String semestre = rs.getString("semestre");
                switch (semestre) {
                    case "S1":
                        rec.setSemestre(EnumSemestre.S1);
                        break;
                    case "S2":
                        rec.setSemestre(EnumSemestre.S2);
                        break;
                    case "S3":
                        rec.setSemestre(EnumSemestre.S3);
                        break;
                    case "S4":
                        rec.setSemestre(EnumSemestre.S4);
                        break;
                    case "S5":
                        rec.setSemestre(EnumSemestre.S5);
                        break;
                    case "S6":
                        rec.setSemestre(EnumSemestre.S6);
                        break;
                    case "S7":
                        rec.setSemestre(EnumSemestre.S7);
                        break;
                    default:
                        rec.setSemestre(EnumSemestre.S8);
                }
                listado.add(rec);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar receptor:"+e.getMessage());
            return null;
        }
    }
        
        public boolean Eliminar (String rut_recibido) {
        try {
            String sql = "delete from RECIBIDO where rut_recibido=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, rut_recibido);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error eliminar receptor"+ e.getMessage());
            return false;
        }
    }
        
        public boolean Modificar (Recibido pt){ 
        try {
            String sql= "update RECIBIDO set nombre_recibido=?,"
                    +"apellido_recibido=?,"
                    +"escuela=?,"
                    +"semestre=? where rut_recibido=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(5, pt.getRut_recibido());
            pstm.setString(1, pt.getNombre_recibido());
            pstm.setString(2, pt.getApellido_recibido());
            pstm.setString(3, pt.getEscuela().toString());
            pstm.setString(4, pt.getSemestre().toString());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error modificar receptor: "+ e.getMessage());
            return false;
        }
        }
        
        public Recibido Buscar(String rut_recibido){
        try {
            String sql="select * from RECIBIDO  where rut_recibido=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, rut_recibido);
            ResultSet rs = pstm.executeQuery();
            Recibido rec = null;
            
            
            while (rs.next()) {                
                rec=new Recibido();
                rec.setRut_recibido(rs.getString("rut_recibido"));
                rec.setNombre_recibido(rs.getString("nombre_recibido"));
                rec.setApellido_recibido(rs.getString("apellido_recibido"));
                String escuela = rs.getString("escuela");
                switch (escuela) {
                    case "Administracion_negocios":
                        rec.setEscuela(EnumEscuela.Administracion_negocios);
                        break;
                    case "Disenio":
                        rec.setEscuela(EnumEscuela.Disenio);
                        break;
                    case "Ingenieria":
                        rec.setEscuela(EnumEscuela.Ingenieria);
                        break;
                    case "Comunicacion":
                        rec.setEscuela(EnumEscuela.Comunicacion);
                        break;
                    case "Gastronomia":
                        rec.setEscuela(EnumEscuela.Gastronomia);
                        break;
                    case "Salud":
                        rec.setEscuela(EnumEscuela.Salud);
                        break;
                    case "Construccion":
                        rec.setEscuela(EnumEscuela.Construccion);
                        break;
                    case "Informatica_telecomunicaciones":
                        rec.setEscuela(EnumEscuela.Informatica_telecomunicaciones);
                        break;
                    case "Turismo_hoteleria":
                        rec.setEscuela(EnumEscuela.Turismo_hoteleria);
                        break;
                }
                String semestre = rs.getString("semestre");
                switch (semestre) {
                    case "S1":
                        rec.setSemestre(EnumSemestre.S1);
                        break;
                    case "S2":
                        rec.setSemestre(EnumSemestre.S2);
                        break;
                    case "S3":
                        rec.setSemestre(EnumSemestre.S3);
                        break;
                    case "S4":
                        rec.setSemestre(EnumSemestre.S4);
                        break;
                    case "S5":
                        rec.setSemestre(EnumSemestre.S5);
                        break;
                    case "S6":
                        rec.setSemestre(EnumSemestre.S6);
                        break;
                    case "S7":
                        rec.setSemestre(EnumSemestre.S7);
                        break;
                    default:
                        rec.setSemestre(EnumSemestre.S8);
                }
            }
            return rec;
        } catch (Exception e) {
            System.out.println("error listar receptor:"+e.getMessage());
            return null;
        }
    }
    
}
