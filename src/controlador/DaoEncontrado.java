package controlador;
import enumeradores.EnumEscuela;
import enumeradores.EnumSemestre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Encontrado;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DaoEncontrado {
    private Connection cone;

    public DaoEncontrado() {
        cone = new Conexion().getCone();
    }
    
        
        public boolean Grabar (Encontrado enc){ 
        try {
            String sql= "insert into ENCONTRADO values (?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, enc.getRut_encontrado());
            pstm.setString(2, enc.getNombre_encontrado());
            pstm.setString(3, enc.getApellido_encontrado());
            pstm.setString(4, enc.getEscuela().toString());
            pstm.setString(5, enc.getSemestre().toString());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error grabar receptor: "+ e.getMessage());
            return false;
        }
    }
    
        public ArrayList <Encontrado> Listar(){
        try {
            String sql="select * from ENCONTRADO";
            PreparedStatement pstm=cone.prepareCall(sql);
            ResultSet rs=pstm.executeQuery();
            ArrayList<Encontrado> listado=new ArrayList<>();         
            while (rs.next()) {         
                Encontrado enc = new Encontrado();
                enc.setRut_encontrado(rs.getString("rut_encontrado"));
                enc.setNombre_encontrado(rs.getString("nombre_encontrado"));
                enc.setApellido_encontrado(rs.getString("apellido_encontrado"));
                String escuela = rs.getString("escuela");
                switch (escuela) {
                    case "Administracion_negocios":
                        enc.setEscuela(EnumEscuela.Administracion_negocios);
                        break;
                    case "Disenio":
                        enc.setEscuela(EnumEscuela.Disenio);
                        break;
                    case "Ingenieria":
                        enc.setEscuela(EnumEscuela.Ingenieria);
                        break;
                    case "Comunicacion":
                        enc.setEscuela(EnumEscuela.Comunicacion);
                        break;
                    case "Gastronomia":
                        enc.setEscuela(EnumEscuela.Gastronomia);
                        break;
                    case "Salud":
                        enc.setEscuela(EnumEscuela.Salud);
                        break;
                    case "Construccion":
                        enc.setEscuela(EnumEscuela.Construccion);
                        break;
                    case "Informatica_telecomunicaciones":
                        enc.setEscuela(EnumEscuela.Informatica_telecomunicaciones);
                        break;
                    case "Turismo_hoteleria":
                        enc.setEscuela(EnumEscuela.Turismo_hoteleria);
                        break;
                }
                String semestre = rs.getString("semestre");
                switch (semestre) {
                    case "S1":
                        enc.setSemestre(EnumSemestre.S1);
                        break;
                    case "S2":
                        enc.setSemestre(EnumSemestre.S2);
                        break;
                    case "S3":
                        enc.setSemestre(EnumSemestre.S3);
                        break;
                    case "S4":
                        enc.setSemestre(EnumSemestre.S4);
                        break;
                    case "S5":
                        enc.setSemestre(EnumSemestre.S5);
                        break;
                    case "S6":
                        enc.setSemestre(EnumSemestre.S6);
                        break;
                    case "S7":
                        enc.setSemestre(EnumSemestre.S7);
                        break;
                    default:
                        enc.setSemestre(EnumSemestre.S8);
                }
                listado.add(enc);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar receptor:"+e.getMessage());
            return null;
        }
    }
        
        public boolean Eliminar (String rut_encontrado) {
        try {
            String sql = "delete from ENCONTRADO where rut_encontrado=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, rut_encontrado);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error eliminar receptor"+ e.getMessage());
            return false;
        }
    }
        
        public boolean Modificar (Encontrado pt){ 
        try {
            String sql= "update ENCONTRADO set nombre_encontrado=?,"
                    +"apellido_encontrado=?,"
                    +"escuela=?,"
                    +"semestre=? where rut_encontrado=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(5, pt.getRut_encontrado());
            pstm.setString(1, pt.getNombre_encontrado());
            pstm.setString(2, pt.getApellido_encontrado());
            pstm.setString(3, pt.getEscuela().toString());
            pstm.setString(4, pt.getSemestre().toString());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error modificar encontrado: "+ e.getMessage());
            return false;
        }
        }
        
        public Encontrado Buscar(String rut_encontrado){
        try {
            String sql="select * from ENCONTRADO  where rut_encontrado=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, rut_encontrado);
            ResultSet rs = pstm.executeQuery();
            Encontrado enc = null;
            
            
        while (rs.next()) {         
                enc = new Encontrado();
                enc.setRut_encontrado(rs.getString("rut_encontrado"));
                enc.setNombre_encontrado(rs.getString("nombre_encontrado"));
                enc.setApellido_encontrado(rs.getString("apellido_encontrado"));
                String escuela = rs.getString("escuela");
                switch (escuela) {
                    case "Administracion_negocios":
                        enc.setEscuela(EnumEscuela.Administracion_negocios);
                        break;
                    case "Disenio":
                        enc.setEscuela(EnumEscuela.Disenio);
                        break;
                    case "Ingenieria":
                        enc.setEscuela(EnumEscuela.Ingenieria);
                        break;
                    case "Comunicacion":
                        enc.setEscuela(EnumEscuela.Comunicacion);
                        break;
                    case "Gastronomia":
                        enc.setEscuela(EnumEscuela.Gastronomia);
                        break;
                    case "Salud":
                        enc.setEscuela(EnumEscuela.Salud);
                        break;
                    case "Construccion":
                        enc.setEscuela(EnumEscuela.Construccion);
                        break;
                    case "Informatica_telecomunicaciones":
                        enc.setEscuela(EnumEscuela.Informatica_telecomunicaciones);
                        break;
                    case "Turismo_hoteleria":
                        enc.setEscuela(EnumEscuela.Turismo_hoteleria);
                        break;
                }
                String semestre = rs.getString("semestre");
                switch (semestre) {
                    case "S1":
                        enc.setSemestre(EnumSemestre.S1);
                        break;
                    case "S2":
                        enc.setSemestre(EnumSemestre.S2);
                        break;
                    case "S3":
                        enc.setSemestre(EnumSemestre.S3);
                        break;
                    case "S4":
                        enc.setSemestre(EnumSemestre.S4);
                        break;
                    case "S5":
                        enc.setSemestre(EnumSemestre.S5);
                        break;
                    case "S6":
                        enc.setSemestre(EnumSemestre.S6);
                        break;
                    case "S7":
                        enc.setSemestre(EnumSemestre.S7);
                        break;
                    default:
                        enc.setSemestre(EnumSemestre.S8);
                }
            }
            return enc;
        } catch (Exception e) {
            System.out.println("error listar encontrado:"+e.getMessage());
            return null;
        }
    }
    
    
}
