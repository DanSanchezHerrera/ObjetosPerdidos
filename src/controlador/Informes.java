package controlador;

import enumeradores.EnumColor;
import enumeradores.EnumTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Objeto;

public class Informes {
    private Connection cone;

    public Informes() {
        cone = new Conexion().getCone();
    }
    
    public ArrayList <Objeto> Informe1 (int id_sala) {
        try {
            String sql = "SELECT id_sala, count (id_objeto) as cuenta from "
                    + "objeto where id_sala=? group by id_sala;";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_sala);
            ResultSet reg = pstm.executeQuery();
            ArrayList <Objeto> lista = new ArrayList<>();
            while(reg.next()){
                Objeto objt = new Objeto();
                objt.setSala(new DaoSala().Buscar(reg.getInt("id_sala")));
                objt.setId_objeto(reg.getInt("id_objeto"));
                objt.setFecha_encontrado(new java.util.Date(reg.getDate("fecha_encontrado").getTime()));
                lista.add(objt);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error informe1:"+e.getMessage());
            return null;
        }
    
    }
    
    public ArrayList <Objeto> Informe2 () {
        try {
            String sql = "SELECT tipo, count (*) as cuenta from objeto group by tipo;";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList <Objeto> lista = new ArrayList<>();
            while(reg.next()){
                Objeto ob = new Objeto();
                String tipo = reg.getString("tipo");
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
                ob.setFecha_encontrado(new java.util.Date(reg.getDate("fecha_encontrado").getTime()));
                lista.add(ob);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error informe2:"+e.getMessage());
            return null;
        }
    
    }
        
    public ArrayList <Objeto> Informe3 () {
        try {
            String sql = "SELECT color, count (*) as cuenta from objeto group by color;";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList <Objeto> lista = new ArrayList<>();
            while(reg.next()){
                Objeto ob = new Objeto();
                ob.setId_objeto(reg.getInt("id_objeto"));
                                String color = reg.getString("color");
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
                ob.setFecha_encontrado(new java.util.Date(reg.getDate("fecha_encontrado").getTime()));
                lista.add(ob);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error informe1:"+e.getMessage());
            return null;
        }
    
    }
}
