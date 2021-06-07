package Vista;
import Datos.basedatos;
import Datos.controlusuarios;

public class principal {
    // Variables globales que nos serviran para la gestion de los videos, musica, etc
        // Si el usuario que ingresa es ADMINISTRADOR entonces el tipo_usuario sera TRUE, del caso contrario es FALSE
    public static boolean tipo_usuario =false;
    // Ventanas que manejaremos que mostraran y reproduciran el contenido que el usuario quiera ver
    public static ventanainicio v_inicio = new ventanainicio();
    public static ventanaprincipal v_principal = new ventanaprincipal();
    public static basedatos base_datos = new basedatos(); 
    public static reproductorvideo reproductor_video = new reproductorvideo(); 
    public static controlusuarios control_usuario = new controlusuarios();
    public static void main(String[] args){
        v_inicio.setVisible(true);
        v_principal.setVisible(false);
        v_principal.init_ventanaprincipal();
        v_principal.iniciarcomponentes();
        //reproductor_video.setVisible(true);
        //base_datos.ingresarUsuario("JUAN", "123", "null");
        //base_datos.imprimir();
        //System.exit(0);
        //control_usuario.setVisible(true);
    }
}