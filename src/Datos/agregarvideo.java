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
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import Vista.principal;

public class agregarvideo extends JFrame {
    JPanel panel_agregarVideo = new JPanel();
    String origenArchivo = new String();
    String destinoArchivo = new String();

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

    public void init_agregarvideo() {
        this.setSize(principal.v_principal.ancho, principal.v_principal.largo);
    }

    public void componentes() {
        JLabel titulo_agregarvideo = new JLabel("Agregar Videos");
        titulo_agregarvideo.setForeground(Color.white);
        titulo_agregarvideo.setBounds(300, 100, 200, 100);
        panel_agregarVideo.add(titulo_agregarvideo);

        JLabel nombre_video = new JLabel("Ingrese el nombre: ");
        nombre_video.setForeground(Color.orange);
        nombre_video.setBounds(200, 200, 200, 100);
        panel_agregarVideo.add(nombre_video);

        JTextField nombre_video_caja = new JTextField();
        nombre_video_caja.setBounds(400, 240, 100, 20);
        panel_agregarVideo.add(nombre_video_caja);

        JLabel nombre_autores = new JLabel("Autores: ");
        nombre_autores.setForeground(Color.orange);
        nombre_autores.setBounds(200, 300, 200, 100);
        panel_agregarVideo.add(nombre_autores);

        JTextField nombre_autores_caja = new JTextField();
        nombre_autores_caja.setBounds(400, 340, 100, 20);
        panel_agregarVideo.add(nombre_autores_caja);

        JLabel direccion_video = new JLabel("Direccion del video: ");
        direccion_video.setForeground(Color.orange);
        direccion_video.setBounds(200, 400, 200, 100);
        panel_agregarVideo.add(direccion_video);

        JTextField direccion_video_caja = new JTextField();
        direccion_video_caja.setBounds(400, 440, 100, 20);
        direccion_video_caja.setEnabled(false);
        panel_agregarVideo.add(direccion_video_caja);

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

        JButton agregarVideo = new JButton("Agregar");
        ActionListener actionBottonAgregar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Agregar");
                moverArchivo(origenArchivo, "videos");
                if (principal.control_videos.validarInserccionVideo(destinoArchivo, nombre_video_caja.getText(),
                        nombre_autores_caja.getText())) {
                    principal.control_videos.anadirVideo(nombre_video_caja.getText(), destinoArchivo,
                            nombre_autores_caja.getText());
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

        JButton buscarDirectorio = new JButton("Buscar");
        ActionListener actionBottonBuscar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                origenArchivo = selector();
                direccion_video_caja.setText(origenArchivo);
                System.out.println(origenArchivo);

            }
        };
        buscarDirectorio.addActionListener(actionBottonBuscar);
        buscarDirectorio.setBounds(530, 440, 80, 20);
        buscarDirectorio.setBackground(Color.orange);
        panel_agregarVideo.add(buscarDirectorio);
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

    public void moverArchivo(String origen, String destino) {
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(destino + "//" + origenPath.getFileName());
        destinoArchivo = "videos//" + origenPath.getFileName();

        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
