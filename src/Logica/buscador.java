package Logica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import Vista.principal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buscador extends JFrame {
    public int index;
    public JPanel panel_busqueda = new JPanel();
    public int tamano = principal.v_principal.largo;
    public JLabel busqueda = new JLabel();
    public JButton atras_vent = new JButton();
    public ActionListener action_atras_vent;
    public JScrollPane scroll = new JScrollPane();

    public buscador() {
        // Tamaño de la ventana
        this.setSize(principal.v_principal.ancho, principal.v_principal.largo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        panel_busqueda.setPreferredSize(new Dimension(0, tamano));
        panel_busqueda.setLayout(null);
        componentes();
        scroll.setViewportView(panel_busqueda);
        add(scroll);
    }

    public void init_buscador() {
        this.setSize(principal.v_principal.ancho, principal.v_principal.largo);
    }

    public void filtro_Buscador(String busqueda_realizada) {
        if (principal.filtro_seleccionado) {
            // Autor
            mostrarContenidoReproducibleAutor(busqueda_realizada);
        } else {
            // Titulo
            mostrarContenidoReproducibleTitulo(busqueda_realizada);
        }
    }

    public void componentes() {
        // Texto
        busqueda.setForeground(Color.WHITE);
        busqueda.setBounds(200, 100, 200, 40);
        panel_busqueda.add(busqueda);

        // Botones
        atras_vent.setText("Atrás");
        atras_vent.setBounds(20, 600, 100, 40);
        atras_vent.setBackground(Color.ORANGE);
        panel_busqueda.add(atras_vent);
        // Action para el boton atras ventana
        action_atras_vent = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.buscador_videos.limpiarVentana();
                principal.buscador_videos.setVisible(false);
                principal.v_principal.setVisible(true);
            }
        };
        atras_vent.addActionListener(action_atras_vent);
        // Fondo del frame
        panel_busqueda.setBackground(Color.BLACK);
    }

    public void mostrarContenidoReproducibleTitulo(String busqueda_realizada) {
        int tope = 200;
        busqueda.setText("Resultados de " + busqueda_realizada + " :");
        for (int i = 0; i < principal.base_datos.nombre_videos.size(); i++) {
            if (principal.base_datos.nombre_videos.get(i).equals(busqueda_realizada)) {
                JButton verContenido = new JButton("Ver");

                ActionListener actionBotton = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        principal.control_videos.reproducirVideoSeleccionado(busqueda_realizada);
                    }
                };
                verContenido.addActionListener(actionBotton);

                JLabel foto_portada = new JLabel(new ImageIcon(principal.base_datos.ruta_portada.get(i)));
                JLabel titulo = new JLabel(busqueda_realizada);
                if (tope >= tamano) {
                    tamano += 200;
                    panel_busqueda.setPreferredSize(new Dimension(0, tamano));
                }
                titulo.setForeground(Color.white);
                titulo.setBounds(300, tope, 120, 30);

                foto_portada.setBounds(200, tope - 30, 100, 93);

                verContenido.setBounds(450, tope, 100, 30);
                verContenido.setBackground(Color.orange);
                panel_busqueda.add(foto_portada);
                panel_busqueda.add(titulo);
                panel_busqueda.add(verContenido);
                tope += 200;
            }
        }
    }

    public void mostrarContenidoReproducibleAutor(String busqueda_realizada) {
        int tope = 200;
        busqueda.setText("Resultados de " + busqueda_realizada + " :");
        for (int i = 0; i < principal.base_datos.autores_videos.size(); i++) {
            if (principal.base_datos.autores_videos.get(i).equals(busqueda_realizada)) {
                index = i;
                JButton verContenido = new JButton("Ver" + i);
                System.out.println(principal.base_datos.nombre_videos.get(i));
                ActionListener actionBottonVer = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        principal.control_videos
                                .reproducirVideoSeleccionado(principal.base_datos.nombre_videos.get(index));
                    }
                };
                verContenido.addActionListener(actionBottonVer);

                JLabel foto_portada = new JLabel(new ImageIcon(principal.base_datos.ruta_portada.get(i)));
                JLabel titulo = new JLabel(principal.base_datos.nombre_videos.get(i));
                if (tope >= tamano) {
                    tamano += 200;
                    panel_busqueda.setPreferredSize(new Dimension(0, tamano));
                }
                titulo.setForeground(Color.white);
                titulo.setBounds(300, tope, 120, 30);

                foto_portada.setBounds(200, tope - 30, 100, 93);

                verContenido.setBounds(450, tope, 100, 30);
                verContenido.setBackground(Color.orange);
                panel_busqueda.add(foto_portada);
                panel_busqueda.add(titulo);
                panel_busqueda.add(verContenido);
                tope += 200;
            }
        }
    }

    public void limpiarVentana() {
        panel_busqueda.removeAll();
        componentes();
    }

    public void mostrarContenidoArtista(String buqueda) {

    }
}
