package Datos;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Vista.principal;

public class eliminarvideo extends JFrame {
    public int tamano = principal.v_principal.largo;
    public JPanel panel_eliminarVideo = new JPanel();
    JScrollPane scroll = new JScrollPane();

    public eliminarvideo() {
        // Tamaño de la ventana
        setSize(principal.v_principal.ancho, principal.v_principal.largo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        panel_eliminarVideo.setLayout(null);
        panel_eliminarVideo.setBackground(Color.BLACK);
        scroll.setViewportView(panel_eliminarVideo);
        this.add(scroll);
        componentes();
        mostrarVideosParaEliminar();
    }

    public void init_eliminarvideo() {
        this.setSize(principal.v_principal.ancho, principal.v_principal.largo);
    }

    public void actualizarFrame() {
        panel_eliminarVideo.removeAll();
        principal.eliminar_video.setVisible(false);
        principal.eliminar_video.setVisible(true);
        componentes();
        mostrarVideosParaEliminar();
    }

    public void componentes() {
        JLabel titulo_eliminarvideo = new JLabel("Eliminar Videos");
        titulo_eliminarvideo.setForeground(Color.white);
        titulo_eliminarvideo.setBounds(300, 100, 200, 100);
        panel_eliminarVideo.add(titulo_eliminarvideo);

        JButton atras = new JButton("Atras");
        ActionListener actionBottonAtras = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.eliminar_video.setVisible(false);
                principal.v_principal.setVisible(true);
            }
        };
        atras.addActionListener(actionBottonAtras);
        atras.setBounds(100, 20, 100, 30);
        atras.setBackground(Color.orange);
        panel_eliminarVideo.add(atras);
    }

    public void mostrarVideosParaEliminar() {
        int tope = 200;
        for (int i = 0; i < principal.base_datos.ruta_videos.size(); i++) {
            final Integer j = new Integer(i);
            JButton eliminar = new JButton("Eliminar");
            ActionListener actionBotton = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    principal.control_videos.eliminarVideo(principal.base_datos.ruta_videos.get(j),
                            principal.base_datos.nombre_videos.get(j), principal.base_datos.autores_videos.get(j),
                            principal.base_datos.ruta_portada.get(j));
                    actualizarFrame();
                }
            };
            eliminar.addActionListener(actionBotton);
            JLabel foto_portada = new JLabel(new ImageIcon(principal.base_datos.ruta_portada.get(j)));
            JLabel titulo = new JLabel(principal.base_datos.nombre_videos.get(j));
            if (tope >= tamano) {
                tamano += 200;
                panel_eliminarVideo.setPreferredSize(new Dimension(0, tamano));
            }
            titulo.setForeground(Color.white);
            titulo.setBounds(300, tope, 120, 30);

            foto_portada.setBounds(200, tope - 30, 100, 93);

            eliminar.setBounds(450, tope, 100, 30);
            eliminar.setBackground(Color.orange);
            panel_eliminarVideo.add(foto_portada);
            panel_eliminarVideo.add(titulo);
            panel_eliminarVideo.add(eliminar);
            tope += 200;
        }
    }
}
