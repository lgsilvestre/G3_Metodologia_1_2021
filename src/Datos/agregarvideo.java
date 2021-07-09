package Datos;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import Vista.principal;

public class agregarvideo extends JFrame {
    // Se declara el panel
    JPanel panel_agregarVideo = new JPanel();
    // Se declaran las variables que usaremos para las direcciones de nuestros
    // archivos
    String origenArchivo_video = new String();
    String origenArchivo_portada = new String();
    String destinoArchivo_video = new String();
    String destinoArchivo_portada = new String();

    public agregarvideo() {
        // Tamaño de la ventana
        setSize(principal.v_principal.ancho, principal.v_principal.largo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        panel_agregarVideo.setLayout(null);
        panel_agregarVideo.setBackground(Color.BLACK);
        this.add(panel_agregarVideo);
        componentes();
    }

    // Esta funcion es para cambiar el tamaño de el frame
    public void init_agregarvideo() {
        this.setSize(principal.v_principal.ancho, principal.v_principal.largo);
    }

    // Los componentes del panel
    public void componentes() {
        // Titulo
        JLabel titulo_agregarvideo = new JLabel("Agregar Videos");
        titulo_agregarvideo.setForeground(Color.white);
        titulo_agregarvideo.setBounds(300, 50, 200, 100);
        panel_agregarVideo.add(titulo_agregarvideo);

        // Texto para indicarle al usuario que ingrese el nombre del video
        JLabel nombre_video = new JLabel("Ingrese el nombre: ");
        nombre_video.setForeground(Color.orange);
        nombre_video.setBounds(200, 100, 200, 100);
        panel_agregarVideo.add(nombre_video);

        // Caja en donde se contendra la direccion de este mismo
        JTextField nombre_video_caja = new JTextField();
        nombre_video_caja.setBounds(400, 140, 100, 20);
        panel_agregarVideo.add(nombre_video_caja);

        // Texto para indicarle al usuario que ingrese la portada del video
        JLabel portada_video = new JLabel("Portada: ");
        portada_video.setForeground(Color.orange);
        portada_video.setBounds(200, 200, 200, 100);
        panel_agregarVideo.add(portada_video);

        // Caja en donde se contendra la direccion de este mismo
        JTextField portada_video_caja = new JTextField();
        portada_video_caja.setBounds(400, 240, 100, 20);
        portada_video_caja.setEnabled(false);
        panel_agregarVideo.add(portada_video_caja);

        // Texto para indicarle al usuario que ingrese los autores del video (EN
        // REALIDAD SOLO PODRA INGRESAR UNO)
        JLabel nombre_autores = new JLabel("Autores: ");
        nombre_autores.setForeground(Color.orange);
        nombre_autores.setBounds(200, 300, 200, 100);
        panel_agregarVideo.add(nombre_autores);

        // Caja en donde se contendra la direccion de este mismo
        JTextField nombre_autores_caja = new JTextField();
        nombre_autores_caja.setBounds(400, 340, 100, 20);
        panel_agregarVideo.add(nombre_autores_caja);

        // Texto para indicarle al usuario que ingrese la direccion del video
        JLabel direccion_video = new JLabel("Direccion del video: ");
        direccion_video.setForeground(Color.orange);
        direccion_video.setBounds(200, 400, 200, 100);
        panel_agregarVideo.add(direccion_video);

        // Caja en donde se contendra la direccion de este mismo
        JTextField direccion_video_caja = new JTextField();
        direccion_video_caja.setBounds(400, 440, 100, 20);
        direccion_video_caja.setEnabled(false);
        panel_agregarVideo.add(direccion_video_caja);

        // Boton para retroceder a la ventana anterior
        JButton atras = new JButton("Atras");
        ActionListener actionBottonAtras = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.agregar_video.setVisible(false);
                principal.v_principal.setVisible(true);
            }
        };
        atras.addActionListener(actionBottonAtras);
        atras.setBounds(100, 500, 100, 30);
        atras.setBackground(Color.orange);
        panel_agregarVideo.add(atras);

        // Boton para agregar el video
        JButton agregarVideo = new JButton("Agregar");
        ActionListener actionBottonAgregar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                destinoArchivo_video = "videos//" + FileSystems.getDefault().getPath(origenArchivo_video).getFileName();
                destinoArchivo_portada = "imagenes//Portada//"
                        + FileSystems.getDefault().getPath(origenArchivo_portada).getFileName();
                if (principal.control_videos.validarInserccionVideo(destinoArchivo_video, nombre_video_caja.getText(),
                        nombre_autores_caja.getText(), destinoArchivo_portada)) {

                    principal.control_videos.anadirVideo(nombre_video_caja.getText(), destinoArchivo_video,
                            nombre_autores_caja.getText(), destinoArchivo_portada);
                    moverArchivo(origenArchivo_video, "videos");
                    moverArchivo(origenArchivo_portada, "imagenes//Portada");
                    JOptionPane.showMessageDialog(null, "Video Agregado");
                    principal.agregar_video.setVisible(false);
                    principal.v_principal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error en los campos");
                }

            }
        };
        agregarVideo.addActionListener(actionBottonAgregar);
        agregarVideo.setBounds(600, 500, 100, 30);
        agregarVideo.setBackground(Color.orange);
        panel_agregarVideo.add(agregarVideo);

        // Boton para buscar la direccion del video
        JButton buscarDirectorio_video = new JButton("Buscar");
        ActionListener actionBottonBuscar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                origenArchivo_video = selector();
                direccion_video_caja.setText(origenArchivo_video);

            }
        };
        buscarDirectorio_video.addActionListener(actionBottonBuscar);
        buscarDirectorio_video.setBounds(530, 440, 80, 20);
        buscarDirectorio_video.setBackground(Color.orange);
        panel_agregarVideo.add(buscarDirectorio_video);

        // Boton para buscar la direccion de la portada del video
        JButton buscarDirectorio_portada = new JButton("Buscar");
        ActionListener actionBottonBuscar_portada = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                origenArchivo_portada = selector();
                portada_video_caja.setText(origenArchivo_portada);

            }
        };
        buscarDirectorio_portada.addActionListener(actionBottonBuscar_portada);
        buscarDirectorio_portada.setBounds(530, 240, 80, 20);
        buscarDirectorio_portada.setBackground(Color.orange);
        panel_agregarVideo.add(buscarDirectorio_portada);
    }

    /*
     * En este metodo nos encargamos de crear un selector de archivos para que, para
     * el usuario sea mas sencillo acceder a la ruta de los videos
     */
    public String selector() throws HeadlessException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        try {
            String rute = fileChooser.getSelectedFile().getAbsolutePath();
            return rute;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        } finally {
        }
        return "";
    }

    // Funcion que nos servira para mover archivos
    public void moverArchivo(String origen, String destino) {
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(destino + "//" + origenPath.getFileName());
        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
