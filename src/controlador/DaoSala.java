package controlador;

import java.util.ArrayList;
import java.sql.Connection;
import modelo.Sala;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoSala {
    private Connection cone;

    public DaoSala() {
        cone = new Conexion().getCone();
    }
    
    public boolean Grabar (Sala sala){ 
        try {
            String sql= "insert into SALA values (?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, sala.getId_sala());
            pstm.setString(2, sala.getDescripcion_sala());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error grabar sala: "+ e.getMessage());
            return false;
        }
    }
 
    
    public ArrayList<Sala> Listar(){
        try {
            String sql="select * from SALA";
            PreparedStatement pstm=cone.prepareCall(sql);
            ResultSet rs=pstm.executeQuery();
            ArrayList<Sala> listado=new ArrayList<>();         
            while (rs.next()) {                
                Sala sal=new Sala();
                sal.setId_sala(rs.getInt("id_sala"));
                sal.setDescripcion_sala(rs.getString("descripcion_sala"));
                listado.add(sal);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar sala:"+e.getMessage());
            return null;
        }
    }
    
        public boolean Eliminar(int id_sala) {
        try {
            String sql = "delete from SALA where id_sala=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_sala);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error eliminar sala:" + e.getMessage());
            return false;
        }
    }
        
                
        public boolean Modificar(Sala pt) {
        try {
            String sql = "update SALA set descripcion_sala=? where id_sala=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(2, pt.getId_sala());
            pstm.setString(1, pt.getDescripcion_sala());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error modificar sala:" + e.getMessage());
            return false;
        }
    }
        
        public Sala Buscar(int id_sala) {
        try {
            String sql = "select * from SALA where id_sala=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_sala);
            ResultSet rs = pstm.executeQuery();
            Sala sa = null;
            while (rs.next()) {
                sa = new Sala();
                sa.setId_sala(rs.getInt("id_sala"));                                             
                sa.setDescripcion_sala(rs.getString("descripcion_sala"));
            }
            return sa;
        } catch (Exception e) {
            System.out.println("error buscar:" + e.getMessage());
            return null;
        }
    }

}