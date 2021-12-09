import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensaje){

        Conexion conexion_db = new Conexion();

        try{

            Connection conexion = conexion_db.getConnection();

            String query = "INSERT INTO MENSAJES (mensaje, autor_mensaje) VALUES(?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje creado.");

        }catch (Exception e){

            e.printStackTrace();
        }
    }
    public static void leerMensajesDB(){

        Conexion conexion_db = new Conexion();

        try{

            Connection conexion = conexion_db.getConnection();

            String query = "SELECT * FROM MENSAJES";
            PreparedStatement state = conexion.prepareStatement(query);
            ResultSet rs = state.executeQuery();

            while(rs.next()){

                System.out.println("ID: " + rs.getInt(1) + "\n"
                + "Autor: " + rs.getString(3) + "\n"
                + "MENSAJE----> " + rs.getString(2) + "\n" + "Fecha: " + rs.getDate(4).toString() );
                System.out.println();

            }

        }catch (Exception e) {

            e.printStackTrace();
        }
    }
    public static void borrarMensajeDB(int id_mensaje){

        Conexion conexion_db = new Conexion();

        try{

            Connection conexion = conexion_db.getConnection();

            String query = "DELETE FROM MENSAJES WHERE id_mensaje = ?";
            PreparedStatement state = conexion.prepareStatement(query);
            state.setInt(1, id_mensaje);
            Integer rows = state.executeUpdate();
            if(rows != 0){

                System.out.println("..se eliminó correctamente. ");
            }else {

                System.out.println("...no funcionó.");
            }

        }catch (Exception e) {

            e.printStackTrace();
        }
    }
    public static void editarMensajeDB(int id_mensaje, String mensaje){

        Conexion conexion_db = new Conexion();

        try{

            Connection conexion = conexion_db.getConnection();

            String query = "UPDATE MENSAJES SET MENSAJE=? WHERE id_mensaje=?";
            PreparedStatement state = conexion.prepareStatement(query);
            state.setString(1, mensaje);
            state.setInt(2, id_mensaje);
            Integer rows = state.executeUpdate();
            if(rows != 0){

                System.out.println("..se actualizó correctamente. ");
            }else {

                System.out.println("...no funcionó.");
            }

        }catch (Exception e) {

            e.printStackTrace();
        }

    }
}
