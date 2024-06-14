package controlador;

import enumeradores.EnumColor;
import enumeradores.EnumTipo;
import java.sql.Connection;
import modelo.Objeto;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class DaoObjeto {
    private Connection cone;

    public DaoObjeto() {
        
        cone = new Conexion().getCone();
    }
    
    public boolean Grabar (Objeto objeto){ 
        try {
            String sql= "insert into OBJETO values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, objeto.getId_objeto());
            pstm.setString(2, objeto.getDescripcion_objeto());
            pstm.setString(3, objeto.getTipo().toString());
            pstm.setString(4, objeto.getColor().toString());
            java.sql.Date fecha = new java.sql.Date(objeto.getFecha_encontrado().getTime());
            pstm.setDate(5, fecha);
            pstm.setInt(6, objeto.getSala().getId_sala());
            pstm.setString(7, objeto.getEncontrado().getRut_encontrado());
            pstm.setString(8, objeto.getRecibido().getRut_recibido());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error grabar objeto: "+ e.getMessage());
            return false;
        }
    }
    
    public boolean Modificar (Objeto objeto){ 
        try {
            String sql= "update OBJETO set descripcion_objeto=?,"
                    +"tipo=?,"
                    +"color=?,"
                    +"fecha_encontrado=?,"
                    +"id_sala=?,"
                    +"rut_recibido=?,"
                    +"rut_encontrado=? where id_objeto=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(8, objeto.getId_objeto());
            pstm.setString(1, objeto.getDescripcion_objeto());
            pstm.setString(2, objeto.getTipo().toString());
            pstm.setString(3, objeto.getColor().toString());
            java.sql.Date fecha = new java.sql.Date(objeto.getFecha_encontrado().getTime());
            pstm.setDate(4, fecha);
            pstm.setInt(5, objeto.getSala().getId_sala());
            pstm.setString(6, objeto.getRecibido().getRut_recibido());
            pstm.setString(7, objeto.getEncontrado().getRut_encontrado());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error modificar objeto: "+ e.getMessage());
            return false;
        }
    }
    
    public ArrayList <Objeto> Listar (){
        try {
            String sql = "select * from OBJETO";
            ResultSet rs = cone.createStatement().executeQuery(sql);
            ArrayList <Objeto> lista_objeto = new ArrayList<>();
            
            while (rs.next()){
                Objeto ob = new Objeto();
                ob.setId_objeto(rs.getInt("Id_objeto"));
                ob.setDescripcion_objeto(rs.getString("descripcion_objeto"));
                String tipo = rs.getString("tipo");
                switch (tipo) {
                    case "Teconlogia":
                        ob.setTipo(EnumTipo.Teconlogia);
                        break;
                    case "Cuadernos_Libros":
                        ob.setTipo(EnumTipo.Cuadernos_Libros);
                        break;
                    case "Mochilas_Bolsos":
                        ob.setTipo(EnumTipo.Mochilas_Bolsos);
                        break;
                    case "Ropa":
                        ob.setTipo(EnumTipo.Ropa);
                        break;
                    case "Accesorios":
                        ob.setTipo(EnumTipo.Accesorios);
                        break;
                    case "Otros":
                        ob.setTipo(EnumTipo.Otros);
                        break;
                }
                String color = rs.getString("color");
                switch (color) {
                    case "Negro":
                        ob.setColor(EnumColor.Negro);
                        break;
                    case "Blanco":
                        ob.setColor(EnumColor.Blanco);
                        break;
                    case "Rojo":
                        ob.setColor(EnumColor.Rojo);
                        break;
                    case "Azul":
                        ob.setColor(EnumColor.Azul);
                        break;
                    case "Amarillo":
                        ob.setColor(EnumColor.Amarillo);
                        break;
                    case "Naranja":
                        ob.setColor(EnumColor.Naranja);
                        break;
                    case "Rosado":
                        ob.setColor(EnumColor.Rosado);
                        break;
                    case "Morado":
                        ob.setColor(EnumColor.Morado);
                        break;
                    case "Otros":
                        ob.setColor(EnumColor.Otros);
                        break;
                }
                ob.setFecha_encontrado(rs.getDate("fecha_encontrado"));
                ob.setSala(new DaoSala().Buscar(rs.getInt("id_sala")));
                ob.setEncontrado(new DaoEncontrado().Buscar(rs.getString("rut_encontrado")));
                ob.setRecibido(new DaoRecibido().Buscar(rs.getString("rut_recibido")));
                lista_objeto.add(ob);
            }
            return lista_objeto;
        } catch (Exception e) {
            System.out.println("Error listar objeto: "+e.getMessage());
            return null;
        }
    }
    
    public Objeto Buscar (int id_objeto) {
        try {
            String sql = "select * from OBJETO where id_objeto=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_objeto);
            ResultSet rs = pstm.executeQuery();
            Objeto ob = null;
            
            while (rs.next()){
                ob = new Objeto();
                ob.setId_objeto(rs.getInt("Id_objeto"));
                ob.setDescripcion_objeto(rs.getString("descripcion_objeto"));
                String tipo = rs.getString("tipo");
                switch (tipo) {
                    case "Teconlogia":
                        ob.setTipo(EnumTipo.Teconlogia);
                        break;
                    case "Cuadernos_Libros":
                        ob.setTipo(EnumTipo.Cuadernos_Libros);
                        break;
                    case "Mochilas_Bolsos":
                        ob.setTipo(EnumTipo.Mochilas_Bolsos);
                        break;
                    case "Ropa":
                        ob.setTipo(EnumTipo.Ropa);
                        break;
                    case "Accesorios":
                        ob.setTipo(EnumTipo.Accesorios);
                        break;
                    default:
                        ob.setTipo(EnumTipo.Otros);
                }
                String color = rs.getString("color");
                switch (color) {
                    case "Negro":
                        ob.setColor(EnumColor.Negro);
                        break;
                    case "Blanco":
                        ob.setColor(EnumColor.Blanco);
                        break;
                    case "Rojo":
                        ob.setColor(EnumColor.Rojo);
                        break;
                    case "Azul":
                        ob.setColor(EnumColor.Azul);
                        break;
                    case "Amarillo":
                        ob.setColor(EnumColor.Amarillo);
                        break;
                    case "Naranja":
                        ob.setColor(EnumColor.Naranja);
                        break;
                    case "Rosado":
                        ob.setColor(EnumColor.Rosado);
                        break;
                    case "Morado":
                        ob.setColor(EnumColor.Morado);
                        break;
                    default:
                        ob.setColor(EnumColor.Otros);
                }
                ob.setFecha_encontrado(rs.getDate("fecha_encontrado"));
                ob.setSala(new DaoSala().Buscar(rs.getInt("id_sala")));
                ob.setRecibido(new DaoRecibido().Buscar(rs.getString("rut_recibido")));
                ob.setEncontrado(new DaoEncontrado().Buscar(rs.getString("rut_encontrado")));
            }
            return ob;
        } catch (Exception e) {
            System.out.println("Error buscar objeto: "+e.getMessage());
            return null;
        }
    }
    
    public boolean Eliminar (int id_objeto) {
        try {
            String sql = "delete from OBJETO where id_objeto=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_objeto);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error eliminar objeto"+ e.getMessage());
            return false;
        }
    }
}
    
    

