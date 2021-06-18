package Datos;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class basedatos {
    // Datos de los usuarios y los videos
    public ArrayList<String> nombres_usuario = new ArrayList<String>();
    public ArrayList<String> contrasena_usuario = new ArrayList<String>();
    public ArrayList<String> codigo_admin = new ArrayList<String>();
    public ArrayList<String> ruta_videos = new ArrayList<String>();

    // Leemos el txt donde se encontraran todos los nombres, contraseñas y codigo de
    // admin
    File f = new File("src//Datos//datos.txt");
    File f_auxiliar = new File("src//Datos//auxiliar.txt");
    // El txt con la ruta de los videos
    File f_videos = new File("src//Datos//info_videos.txt");

    // Constructor
    public basedatos() {
        leerUsuarios();
        leerRutaVideos();
    }

    // Para leer el txt donde estaran la ruta de los videos
    private void leerRutaVideos() {
        String rutaVideo = "";
        try {
            Scanner leer = new Scanner(f_videos);
            while (leer.hasNext()) { // mientras no se llegue al final del fichero
                rutaVideo = leer.next();
                ruta_videos.add(rutaVideo);
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

    // Imprimir TODO de las listas (PARA PRUEBA)
    public void imprimir() {
        for (int i = 0; i < nombres_usuario.size(); i++) {
            System.out.println("Nombre:" + nombres_usuario.get(i) + ", Contraseña: " + contrasena_usuario.get(i)
                    + ", CodigoADM: " + codigo_admin.get(i));
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