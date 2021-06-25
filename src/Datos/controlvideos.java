package Datos;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import Vista.principal;

public class controlvideos {
    String f_ruta = "src/Datos/ruta_videos.txt";
    String f_nombre = "src/Datos/nombre_videos.txt";
    String f_autores = "src/Datos/autores_videos.txt";
    String f_auxiliar = "src/Datos/auxiliar.txt";

    // Constructor
    public controlvideos() {
    }

    public void reproducirVideoSeleccionado(String nombreVideo) {
        boolean a = false;
        int index = 0;
        for (int i = 0; i < principal.base_datos.nombre_videos.size(); i++) {
            if (principal.base_datos.nombre_videos.get(i).equals(nombreVideo)) {
                a = true;
                index = i;
            }
        }
        if (a) {
            principal.reproductor_video.setVisible(true);
            principal.reproductor_video.ejecutarReproduccion(principal.base_datos.ruta_videos.get(index));
        }
    }

    public void anadirVideo(String nombreVideo, String rutaVideo, String autoresVideo) {
        // Añadimos la ruta

        PrintWriter pw = null;
        FileWriter fw = null;
        try {
            // Escribe en la ruta de videos
            fw = new FileWriter(f_ruta, true);
            pw = new PrintWriter(fw);
            pw.println(rutaVideo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fw)
                    fw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        // Añadimos los autores
        pw = null;
        fw = null;
        try {
            // Escribe en los autores de videos
            fw = new FileWriter(f_autores, true);
            pw = new PrintWriter(fw);
            pw.println(autoresVideo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fw)
                    fw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        // Añadimos los nombres
        pw = null;
        fw = null;
        try {
            // Escribe en los nombres de los videos
            fw = new FileWriter(f_nombre, true);
            pw = new PrintWriter(fw);
            pw.println(nombreVideo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fw)
                    fw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        principal.base_datos.borrarDatosVideos();
        principal.base_datos.leerRutaVideos();
        principal.base_datos.leerAutoresVideos();
        principal.base_datos.leerNombreVideos();
        imprimir();
    }

    // NO FUNCIONA EL ELIMINAR TODAVIA
    public void eliminarVideo(String nombreVideo) {
        Scanner in = new Scanner(System.in);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_ruta));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_auxiliar));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(nombreVideo)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_auxiliar));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_ruta));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
        principal.base_datos.borrarDatosVideos();

        principal.base_datos.leerRutaVideos();
        principal.base_datos.leerAutoresVideos();
        principal.base_datos.leerNombreVideos();
        imprimir();
    }

    public void imprimir() {
        for (int i = 0; i < principal.base_datos.ruta_videos.size(); i++) {
            System.out.println("rutaVideo:" + principal.base_datos.ruta_videos.get(i));
        }
    }
}