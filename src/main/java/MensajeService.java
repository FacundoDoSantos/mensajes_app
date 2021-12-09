import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println();
        System.out.println("Tu nombre: ");
        String autor = sc.nextLine();

        LocalDate ld = LocalDate.now();
        String date = ld.toString();

        Mensaje mensaje_obj = new Mensaje(mensaje, autor, date);
        MensajeDAO.crearMensajeDB(mensaje_obj);




    }
    public static void listarMensajes(){

        MensajeDAO.leerMensajesDB();
    }
    public static void borrarMensaje(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el ID del mensaje a borrar, para ver la lista de mensajes " +
                "y sus respectivos ID selecciona listar mensajes.");

        int id = sc.nextInt();
        MensajeDAO.borrarMensajeDB(id);
    }
    public static void editarMensaje() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje" );
        String mensaje = sc.nextLine();

        System.out.println("Indica ID del mensaje a editar: ");
        int id = sc.nextInt();

        MensajeDAO.editarMensajeDB(id, mensaje);
    }

}
