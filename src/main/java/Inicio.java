import java.sql.Connection;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {

        Conexion conexion1 = new Conexion();

        try{
            Connection cnx = conexion1.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }

        Scanner sc=new Scanner(System.in);
        int opcion=0;

        do {
            System.out.println("-------------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Eliminar mensaje");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Listar mensajes");
            System.out.println("5. Salir");
            System.out.println();
            opcion = sc.nextInt();

            switch(opcion){

                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.borrarMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.listarMensajes();
                    break;
                default:
                    break;
            }

        }while (opcion!=5);

    }
}
