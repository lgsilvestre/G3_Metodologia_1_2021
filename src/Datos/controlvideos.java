package Datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import Vista.principal;

public class controlvideos {
    // La ruta de todos los archivos vinculados con los videos
    String f_ruta = "datos_txt/ruta_videos.txt";
    String f_nombre = "datos_txt/nombre_videos.txt";
    String f_autores = "datos_txt/autores_videos.txt";
    String f_portada = "datos_txt/portada_videos.txt";
    String f_auxiliar = "datos_txt/auxiliar.txt";

    File file;
    char[] validacion;

    // Constructor
    public controlvideos() {
    }

    // Funcion que nos servira para la reproduccion del video
    public void reproducirVideoSeleccionado(String nombreVideo) {
        boolean a = false;
        int index = 0;
        // Primero se busca si el video esta en la base de datos
        for (int i = 0; i < principal.base_datos.nombre_videos.size(); i++) {
            if (principal.base_datos.nombre_videos.get(i).equals(nombreVideo)) {
                a = true;
                index = i;
            }
        }
        // De acuerdo al indice se reproducira el video
        if (a) {
            principal.buscador_videos.setVisible(false);
            principal.reproductor_video.setVisible(true);
            principal.reproductor_video.init_reproductorvideo();
            principal.reproductor_video.ejecutarReproduccion(principal.base_datos.ruta_videos.get(index));
        }
    }

    public void anadirVideo(String nombreVideo, String rutaVideo, String autoresVideo, String portadaVideo) {
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
        // Añadimos las portadas
        pw = null;
        fw = null;
        try {
            // Escribe en los nombres de los videos
            fw = new FileWriter(f_portada, true);
            pw = new PrintWriter(fw);
            pw.println(portadaVideo);
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

        // Se borra todo y se lee nuevamente
        principal.base_datos.borrarDatosVideosListas();
        principal.base_datos.leerRutaVideos();
        principal.base_datos.leerAutoresVideos();
        principal.base_datos.leerNombreVideos();
        principal.base_datos.leerPortadaVideos();
    }

    // NO FUNCIONA EL ELIMINAR TODAVIA
    public void eliminarVideo(String rutaVideo, String nombreVideo, String autorVideo, String rutaPortada) {
        Scanner in = new Scanner(System.in);
        // Se utilizara el mismo metodo que en el eliminar los usuarios, esta vez
        // eliminaremos la ruta de video, nombrevideo, autor video y la ruta de la
        // portada
        // Se elimina la ruta del video
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_ruta));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_auxiliar));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(rutaVideo)) {
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
        // Se elimina el nombre del video de la base de datos y del txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_nombre));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_nombre));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Se elimina los autores del video de la base de datos y del txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_autores));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_auxiliar));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(autorVideo)) {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_autores));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Se elimina la ruta de portada del video de la base de datos y del txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_portada));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_auxiliar));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(rutaPortada)) {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_portada));

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
        // Se borra todas las listas
        principal.base_datos.borrarDatosVideosListas();

        // se eliminan los videos y las portadas
        file = new File(rutaVideo);
        file.delete();

        file = new File(rutaPortada);
        file.delete();

        // Se lee todo nuevamente con los cambios aplicados
        principal.base_datos.leerRutaVideos();
        principal.base_datos.leerAutoresVideos();
        principal.base_datos.leerNombreVideos();
        principal.base_datos.leerPortadaVideos();
    }

    // Funcion que nos servira para validar la inserccion de un video
    public boolean validarInserccionVideo(String rutaVideo, String nombreVideo, String autorVideo,
            String portadaVideo) {
        // Revisamos si estan correctamente los datos ingresados
        validacion = rutaVideo.toCharArray();
        if (validacion.length >= 70) {
            return false;
        } else {
            if (rutaVideo.equals("videos//") || rutaVideo == " ") {
                return false;
            }

        }

        // Revisamos si las letras no tienen : o tienen espacios, ya que esto seria lo
        // queremos evitar
        validacion = nombreVideo.toCharArray();
        if (validacion.length >= 70) {
            return false;
        } else if (nombreVideo.equals("")) {
            return false;
        } else {
            for (int i = 0; i < validacion.length; i++) {
                if (validacion[i] == ' ' || validacion[i] == ':') {
                    return false;
                }
            }
        }

        // Revisamos si estan correctamente los datos ingresados
        validacion = autorVideo.toCharArray();
        if (validacion.length >= 70) {
            return false;
        } else if (autorVideo.equals("")) {
            return false;
        } else {
            for (int i = 0; i < validacion.length; i++) {
                if (validacion[i] == ' ' || validacion[i] == ':') {
                    return false;
                }
            }
        }

        // Revisamos si estan correctamente los datos ingresados
        if (validacion.length >= 70) {
            return false;
        } else {
            if (portadaVideo.equals("imagenes//Portada//") || portadaVideo.equals("")) {
                return false;
            }
        }

        return true;
    }

}