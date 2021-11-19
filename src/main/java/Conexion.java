import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection getConnection() {

        Connection conexion = null;

        try{

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_app", "root", "");
            if (conexion!=null){

                System.out.println("conexion exitosa");
            }
        }catch(Exception e){

            e.printStackTrace();
        }

        return conexion;
    }
}
