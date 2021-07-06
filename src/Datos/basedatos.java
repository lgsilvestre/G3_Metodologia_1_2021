package Datos;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class basedatos {
    // Datos de los usuarios y los videos
    public ArrayList<String> nombres_usuario = new ArrayList<String>();
    public ArrayList<String> contrasena_usuario = new ArrayList<String>();
    public ArrayList<String> codigo_admin = new ArrayList<String>();

    public ArrayList<String> nombre_videos = new ArrayList<String>();
    public ArrayList<String> autores_videos = new ArrayList<String>();
    public ArrayList<String> ruta_videos = new ArrayList<String>();

    // Leemos el txt donde se encontraran todos los nombres, contraseñas y codigo de
    // admin
    File f = new File("datos_txt//datos.txt");
    File f_auxiliar = new File("datos_txt//auxiliar.txt");
    // El txt con la ruta de los videos
    File f_ruta_v = new File("datos_txt//ruta_videos.txt");
    // el txt con los nombre de los videos
    File f_nombre_v = new File("datos_txt//nombre_videos.txt");
    // el txt con los autores de los videos
    File f_autores_v = new File("datos_txt//autores_videos.txt");

    // Constructor
    public basedatos() {
        leerUsuarios();
        leerRutaVideos();
        leerAutoresVideos();
        leerNombreVideos();
    }

    // Para leer el txt donde estaran la ruta de los videos
    public void leerRutaVideos() {
        String rutaVideo = "";
        try {
            Scanner leer = new Scanner(f_ruta_v);
            while (leer.hasNext()) { // mientras no se llegue al final del fichero
                rutaVideo = leer.next();
                ruta_videos.add(rutaVideo);
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    // Para leer el txt donde estaran los autores de los videos
    public void leerAutoresVideos() {
        String autoresVideo = "";
        try {
            Scanner leer = new Scanner(f_autores_v);
            while (leer.hasNext()) { // mientras no se llegue al final del fichero
                autoresVideo = leer.next();
                autores_videos.add(autoresVideo);
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    // Para leer el txt donde estaran los nombres de los videos
    public void leerNombreVideos() {
        String nombreVideo = "";
        try {
            Scanner leer = new Scanner(f_nombre_v);
            while (leer.hasNext()) { // mientras no se llegue al final del fichero
                nombreVideo = leer.next();
                nombre_videos.add(nombreVideo);
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    // Para leer el txt donde estaran todos los usuarios
    public void leerUsuarios() {
        String dato = "";
        int i = 0;
        try {
            Scanner leer = new Scanner(f);
            while (leer.hasNext()) { // mientras no se llegue al final del fichero
                dato = leer.next();
                // El primer dato siempre sera el nombre de usuario
                if (i == 0) {
                    nombres_usuario.add(dato);
                } else if (i == 1) { // El segundo dato es la contraseña
                    contrasena_usuario.add(dato);
                } else if (i == 2) { // EL tercer y ultimo dato es el codigo de admin(si es que no tiene se rellena
                                     // con un null)
                    codigo_admin.add(dato);
                }
                i += 1;
                if (i == 3) {
                    i = 0;
                }
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    // Borrar los datos de las listas
    public void borrarDatosUsuariosListas() {
        nombres_usuario = new ArrayList<String>();
        contrasena_usuario = new ArrayList<String>();
        codigo_admin = new ArrayList<String>();
    }

    public void borrarDatosVideosListas() {
        nombre_videos = new ArrayList<String>();
        autores_videos = new ArrayList<String>();
        ruta_videos = new ArrayList<String>();
    }

    // Imprimir TODO de las listas (PARA PRUEBA)
    public void imprimir() {
        for (int i = 0; i < nombres_usuario.size(); i++) {
            System.out.println("Nombre:" + nombres_usuario.get(i) + ", Contraseña: " + contrasena_usuario.get(i)
                    + ", CodigoADM: " + codigo_admin.get(i));
        }
    }

    public void imprimirautores() {
        for (int i = 0; i < autores_videos.size(); i++) {
            System.out.println("Autores:" + autores_videos.get(i));
        }
    }

    // Retornar Listas
    public ArrayList<String> getNombres_usuario() {
        return nombres_usuario;
    }

    public ArrayList<String> getContrasena_usuario() {
        return contrasena_usuario;
    }

    public ArrayList<String> getCodigo_admin() {
        return codigo_admin;
    }

    // Retornar Tamaño de las Listas
    public int getTamNU() {
        return nombres_usuario.size();
    }

    public int getTamCU() {
        return contrasena_usuario.size();
    }

    public int getTamCA() {
        return codigo_admin.size();
    }

    // ArrayList de las busquedas (ES IRRELEVANTE SI FUNCIONA O NO)
    // public ArrayList<String> getRegistrar_busqueda(){return registrar_busqueda;}

}