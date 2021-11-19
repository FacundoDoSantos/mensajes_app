import java.sql.Connection;

public class Inicio {

    public static void main(String[] args) {

        Conexion conexion1 = new Conexion();

        try{

            Connection cnx = conexion1.getConnection();

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}
