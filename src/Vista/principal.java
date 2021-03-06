package Vista;

import Datos.agregarvideo;
import Datos.basedatos;
import Datos.controlusuarios;
import Datos.controlvideos;
import Datos.eliminarvideo;
import Logica.buscador;

public class principal {
    // Variables globales que nos serviran para la gestion de los videos, musica,
    // etc
    // Si el usuario que ingresa es ADMINISTRADOR entonces el tipo_usuario sera
    // TRUE, del caso contrario es FALSE
    public static boolean tipo_usuario = false;
    // Si el usuario busca a partir de los titulos de los videos el
    // filtro_seleccionado sera false, de caso contrario es true
    public static boolean filtro_seleccionado = false;
    // Ventanas que manejaremos que mostraran y reproduciran el contenido que el
    // usuario quiera ver
    public static ventanainicio v_inicio = new ventanainicio();
    public static ventanaprincipal v_principal = new ventanaprincipal();
    public static basedatos base_datos = new basedatos();
    public static reproductorvideo reproductor_video = new reproductorvideo();
    public static controlusuarios control_usuario = new controlusuarios();
    public static controlvideos control_videos = new controlvideos();
    public static buscador buscador_videos = new buscador();
    public static filtroFrame filtro_frame = new filtroFrame();
    public static eliminarvideo eliminar_video = new eliminarvideo();
    public static agregarvideo agregar_video = new agregarvideo();

    public static void main(String[] args) {
        // Se muestra el login
        v_inicio.setVisible(true);
    }
}