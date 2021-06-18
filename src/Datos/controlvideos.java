package Datos;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Vista.principal;

public class controlvideos {
    // Constructor
    public controlvideos() {
    }

    public void reproducirVideoSeleccionado(String nombre) {
        boolean a = false;
        for (int i = 0; i < principal.base_datos.ruta_videos.size(); i++) {
            if (principal.base_datos.ruta_videos.get(i).equals(nombre)) {
                a = true;

            }
        }
        if (a) {
            principal.reproductor_video.setVisible(true);
            principal.reproductor_video.ejecutarReproduccion(nombre);
        }
    }

    public void imprimir() {
        for (int i = 0; i < principal.base_datos.ruta_videos.size(); i++) {
            System.out.println("rutaVideo:" + principal.base_datos.ruta_videos.get(i));
        }
    }
}