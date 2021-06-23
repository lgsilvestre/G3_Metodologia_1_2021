package Datos;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.io.BufferedWriter;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import Vista.principal;

public class controlvideos extends JFrame {
    private JPanel panelControlVideo = new JPanel();
    public int tamano = principal.v_principal.largo;
    public JScrollPane scroll = new JScrollPane();
    String f_ruta = "src/Datos/ruta_videos.txt";
    String f_nombre = "src/Datos/nombre_videos.txt";
    String f_autores = "src/Datos/autores_videos.txt";
    String f_auxiliar = "src/Datos/auxiliar.txt";

    // Constructor
    public controlvideos() {
        // Tamaño de la ventana
        this.setSize(900, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        panelControlVideo.setLayout(null);
        panelControlVideo.setBackground(Color.BLACK);
        scroll.setViewportView(panelControlVideo);
        this.add(scroll);
        componentes();
        mostrarVideos();
    }

    public void actualizarFrame() {
        panelControlVideo.removeAll();
        this.setVisible(false);
        this.setVisible(true);
        componentes();
        mostrarVideos();
    }

    public void mostrarVideos() {
        int tope = 200;
        for (int i = 0; i < principal.base_datos.ruta_videos.size(); i++) {
            final Integer j = new Integer(i);
            JButton eliminar = new JButton("Eliminar");
            ActionListener actionBotton = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    // eliminarVideo(principal.base_datos.ruta_videos.get(j));
                    // actualizarFrame();
                }
            };
            eliminar.addActionListener(actionBotton);

            JLabel foto_portada = new JLabel(new ImageIcon("imagenes//frame//foto_usuario.png"));
            JLabel titulo = new JLabel(principal.base_datos.nombre_videos.get(j));
            if (tope >= tamano) {
                tamano += 200;
                panelControlVideo.setPreferredSize(new Dimension(0, tamano));
            }
            titulo.setForeground(Color.white);
            titulo.setBounds(300, tope, 120, 30);

            foto_portada.setBounds(200, tope - 30, 100, 93);

            eliminar.setBounds(450, tope, 100, 30);
            eliminar.setBackground(Color.orange);
            panelControlVideo.add(foto_portada);
            panelControlVideo.add(titulo);
            panelControlVideo.add(eliminar);
            tope += 200;
        }
    }

    public void componentes() {
        JLabel titulo_controlvideo = new JLabel("CONTROL VIDEOS");
        titulo_controlvideo.setForeground(Color.white);
        titulo_controlvideo.setBounds(300, 100, 200, 100);
        panelControlVideo.add(titulo_controlvideo);

        JTextField anadir_caja = new JTextField();
        anadir_caja.setBounds(50, 700, 100, 70);
        panelControlVideo.add(anadir_caja);

        JButton anadir = new JButton("Añadir");
        ActionListener actionBottonAnadir = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                anadirVideo(anadir_caja.getText(), "a", "a");
            }
        };
        anadir.addActionListener(actionBottonAnadir);
        anadir.setBounds(100, 700, 100, 20);
        panelControlVideo.add(anadir);

        JButton atras = new JButton("Atras");
        ActionListener actionBottonAtras = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.control_videos.setVisible(false);
                principal.v_principal.setVisible(true);
            }
        };
        atras.addActionListener(actionBottonAtras);
        atras.setBounds(100, 20, 100, 30);
        atras.setBackground(Color.orange);
        panelControlVideo.add(atras);

    }

    public void reproducirVideoSeleccionado(String nombreVideo) {
        boolean a = false;
        int index = 0;
        for (int i = 0; i < principal.base_datos.nombre_videos.size(); i++) {
            if (principal.base_datos.nombre_videos.get(i).equals(nombreVideo)) {
                a = true;
                index = i;
                System.out.println("a" + i + " " + index + " " + principal.base_datos.nombre_videos.get(i));
            }
            System.out.println("b");
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
        actualizarFrame();
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