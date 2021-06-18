package Vista;

import Datos.basedatos;
import Datos.controlusuarios;
import Datos.controlvideos;
import Logica.buscador;

public class principal {
    // Variables globales que nos serviran para la gestion de los videos, musica,
    // etc
    // Si el usuario que ingresa es ADMINISTRADOR entonces el tipo_usuario sera
    // TRUE, del caso contrario es FALSE
    public static boolean tipo_usuario = false;
    // Ventanas que manejaremos que mostraran y reproduciran el contenido que el
    // usuario quiera ver
    public static ventanainicio v_inicio = new ventanainicio();
    public static ventanaprincipal v_principal = new ventanaprincipal();
    public static basedatos base_datos = new basedatos();
    public static reproductorvideo reproductor_video = new reproductorvideo();
    public static controlusuarios control_usuario = new controlusuarios();
    public static controlvideos control_videos = new controlvideos();
    public static buscador buscador_videos = new buscador();

    public static void main(String[] args) {
        // v_inicio.setVisible(true);
        v_principal.setVisible(true);
        v_principal.init_ventanaprincipal();
        v_principal.iniciarcomponentes();
        // reproductor_video.setVisible(true);
        // base_datos.modificarUsuariosExistentes("LuisSilvestre35","LuisSilvestre84",
        // "23/05/2030" ,"LuisSilvestre84ad");
        // base_datos.imprimir();
        // control_usuario.setVisible(true);
        // control_videos.imprimir();
        // control_videos.reproducirVideoSeleccionado("videos//Fnaf_3.mp4");
        // buscador_videos.setVisible(true);
        // buscador_videos.mostrarContenidoReproducible("videos//Mecha_mecha_2.mp4");
        // System.exit(0);
    }
}