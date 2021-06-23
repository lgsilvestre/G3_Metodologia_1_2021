package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.controlusuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaprincipal extends JFrame {
    // Panel de la ventana Principal
    private JPanel panel_principal = new JPanel();
    private int portadaseleccionada = 1;
    // Componentes del principal
    // Cajas de texto
    public JTextField buscar_caja = new JTextField();
    // Logo Triviño
    public JButton logotrivino = new JButton(new ImageIcon("imagenes//Frame//LogoGrupoTrivino_pagina.png"));
    // Imagen usuario (por mientras)
    public JLabel imagen_usuario = new JLabel(new ImageIcon("imagenes//Frame//foto_usuario.png"));
    // Imagen portada potter principal
    public JLabel portadapotter = new JLabel(new ImageIcon("imagenes//Portada//potter.jpg"));
    // Imagen portada el pajaro con lepra principal
    public JLabel portadapajaroconlepra = new JLabel(new ImageIcon("imagenes//Portada//elpajaroconlepra.png"));
    // Botones
    public JButton buscar = new JButton(new ImageIcon("imagenes//Frame//imagen_buscar.png"));
    public JButton siguiente_img = new JButton(new ImageIcon("imagenes//Frame//siguiente.png"));
    public JButton atras_img = new JButton(new ImageIcon("imagenes//Frame//atras.png"));
    public JButton atras_vent = new JButton("Atrás");
    // Componentes de la seccion para el admin
    // Texto
    public JLabel titulo_admin = new JLabel("CONTROL DE USUARIOS Y VIDEOS");
    // Botones
    public JButton controlusuarios_btn = new JButton("Control Usuarios");
    public JButton controlvideos_btn = new JButton("Control Videos");
    // Action Listener de los botones
    // atras
    public ActionListener action_atras_vent;
    // control usuarios
    public ActionListener action_controlusuarios;
    // control videos
    public ActionListener action_controlvideos;
    // Ajustes
    public JButton ajustes = new JButton(new ImageIcon("imagenes//Frame//ajuste.png"));
    // Admin
    public JButton admin = new JButton(new ImageIcon("imagenes//Frame//admin.png"));
    // Texto
    public JLabel busqueda = new JLabel();
    // Componentes de ajuste
    // Texto
    public JLabel text_ajuste = new JLabel();
    public JLabel text_tam_pant = new JLabel();
    // ComboBox
    public JComboBox tam_pant = new JComboBox<>(new String[] { "800x800", "800x600" });
    // Ancho y Largo del frame
    public int ancho = 800, largo = 800;

    public void init_ventanaprincipal() {
        // Tamaño de la ventana
        this.setSize(ancho, largo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        panel_principal.setLayout(null);
        // Fondo del Frame
        panel_principal.setBackground(Color.black);
        // Añadimos el panel a la ventana
        add(panel_principal);
    }

    public void iniciarcomponentes() {
        componentesprincipal();
    }

    private void componentesprincipal() {
        // Cajas de texto
        buscar_caja.setBounds(200, 60, 400, 30);
        buscar_caja.setBackground(Color.ORANGE);
        panel_principal.add(buscar_caja);

        // Ajustes
        ajustes.setBounds(723, 10, 30, 30);
        ajustes.setBackground(Color.ORANGE);
        panel_principal.add(ajustes);
        ActionListener actionajustes = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                invisible_componentesprincipal();
                componentesajustes();

            }
        };
        ajustes.addActionListener(actionajustes);

        // Boton para Administracion
        if (principal.tipo_usuario) {
            admin.setBounds(680, 10, 30, 30);
            admin.setBackground(Color.ORANGE);
            panel_principal.add(admin);
            ActionListener actionadmin = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    invisible_componentesprincipal();
                    componentes_admin();
                }
            };
            admin.addActionListener(actionadmin);
        }
        // Logo Triviño
        logotrivino.setBounds(0, 0, 150, 113);
        logotrivino.setBackground(Color.BLACK);
        logotrivino.setOpaque(false);
        logotrivino.setContentAreaFilled(false);
        logotrivino.setBorderPainted(false);
        panel_principal.add(logotrivino);
        ActionListener actionprincipal = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                invisible_componentesajuste();
            }
        };
        logotrivino.addActionListener(actionprincipal);

        // Imagen usuario (por mientras)
        imagen_usuario.setBounds(680, 20, 100, 93);
        panel_principal.add(imagen_usuario);

        // Imagen portada principal
        portadapotter.setBounds(150, 150, 500, 300);
        portadapotter.setVisible(true);
        panel_principal.add(portadapotter);

        // Imagen portada principal
        portadapajaroconlepra.setBounds(150, 150, 500, 300);
        portadapajaroconlepra.setVisible(false);
        panel_principal.add(portadapajaroconlepra);

        // Botones
        buscar.setBackground(Color.ORANGE);
        buscar.setBounds(610, 60, 30, 30);
        panel_principal.add(buscar);
        // Action para el boton buscar
        ActionListener actionbuscar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.buscador_videos.setVisible(true);
                principal.buscador_videos.mostrarContenidoReproducible(buscar_caja.getText());
                principal.v_principal.setVisible(false);
            }
        };
        buscar.addActionListener(actionbuscar);

        siguiente_img.setBackground(Color.ORANGE);
        siguiente_img.setBounds(700, 300, 40, 40);
        panel_principal.add(siguiente_img);
        // Action para el boton siguiente
        ActionListener actionsiguiente = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (portadaseleccionada == 1) {
                    portadapotter.setVisible(false);
                    portadapajaroconlepra.setVisible(true);
                    portadaseleccionada = 2;
                } else {
                    portadapotter.setVisible(true);
                    portadapajaroconlepra.setVisible(false);
                    portadaseleccionada = 1;
                }
            }
        };
        siguiente_img.addActionListener(actionsiguiente);
        // Boton atras(para las portadas de los videos)
        atras_img.setBackground(Color.ORANGE);
        atras_img.setBounds(70, 300, 40, 40);
        panel_principal.add(atras_img);
        // Action para el boton atras
        ActionListener actionatras = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (portadaseleccionada == 1) {
                    portadapotter.setVisible(false);
                    portadapajaroconlepra.setVisible(true);
                    portadaseleccionada = 2;
                } else {
                    portadapotter.setVisible(true);
                    portadapajaroconlepra.setVisible(false);
                    portadaseleccionada = 1;
                }
            }
        };
        atras_img.addActionListener(actionatras);
    }

    public void componentesajustes() {
        // Invisivilizamos los componentes de busqueda
        busqueda.setVisible(false);
        buscar_caja.setVisible(false);
        buscar.setVisible(false);
        // Visivilizamos los componentes de ajustes
        text_ajuste.setVisible(true);
        text_tam_pant.setVisible(true);
        tam_pant.setVisible(true);
        // Texto
        text_ajuste.setText("Ajustes");
        text_ajuste.setFont(new Font("arial", Font.PLAIN, 30));
        text_ajuste.setForeground(Color.ORANGE);
        text_ajuste.setBounds(200, 100, 200, 60);
        panel_principal.add(text_ajuste);

        text_tam_pant.setText("Tamaño de pantalla");
        text_tam_pant.setForeground(Color.ORANGE);
        text_tam_pant.setBounds(50, 170, 180, 100);
        panel_principal.add(text_tam_pant);

        // Botones
        atras_vent.setVisible(true);
        atras_vent.setBounds(200, 500, 100, 40);
        atras_vent.setBackground(Color.ORANGE);
        panel_principal.add(atras_vent);
        // Action para el boton atras ventana
        action_atras_vent = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                invisible_componentesajuste();
            }
        };
        atras_vent.addActionListener(action_atras_vent);
        // ComboBox en donde seleccionara el tamaño de el frame
        tam_pant.setBounds(200, 200, 100, 40);
        tam_pant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tam_pant.getSelectedIndex()) {
                    case 0:
                        ancho = 800;
                        largo = 800;
                        init_ventanaprincipal();
                        break;
                    case 1:
                        ancho = 800;
                        largo = 600;
                        init_ventanaprincipal();
                        break;
                    default:
                        ancho = 800;
                        largo = 800;
                        init_ventanaprincipal();
                        break;
                }
            }
        });
        panel_principal.add(tam_pant);
    }

    public void componentes_admin() {
        // Invisivilizamos los componentes de busqueda
        busqueda.setVisible(false);
        buscar_caja.setVisible(false);
        buscar.setVisible(false);
        // Visibilizamos los componentes de admin
        titulo_admin.setVisible(true);
        controlusuarios_btn.setVisible(true);
        controlvideos_btn.setVisible(true);
        // Titulo
        titulo_admin.setBounds(300, 100, 200, 50);
        titulo_admin.setForeground(Color.white);
        panel_principal.add(titulo_admin);
        // Botones
        controlusuarios_btn.setBounds(100, 400, 150, 30);
        controlusuarios_btn.setBackground(Color.orange);
        action_controlusuarios = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.v_principal.setVisible(false);
                principal.control_usuario.setVisible(true);
            }
        };
        controlusuarios_btn.addActionListener(action_controlusuarios);
        panel_principal.add(controlusuarios_btn);

        controlvideos_btn.setBounds(500, 400, 150, 30);
        controlvideos_btn.setBackground(Color.orange);
        action_controlvideos = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                principal.v_principal.setVisible(false);
                principal.control_videos.setVisible(true);
            }
        };
        controlvideos_btn.addActionListener(action_controlvideos);
        panel_principal.add(controlvideos_btn);

        // Botones
        atras_vent.setVisible(true);
        atras_vent.setBounds(100, 600, 100, 40);
        atras_vent.setBackground(Color.ORANGE);
        // Action para el boton atras ventana
        action_atras_vent = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                invisible_componentesadmin();
            }
        };
        atras_vent.addActionListener(action_atras_vent);
        panel_principal.add(atras_vent);
    }

    public void invisible_componentesadmin() {
        // Se ocultan los componentes de admin
        titulo_admin.setVisible(false);
        controlusuarios_btn.setVisible(false);
        controlvideos_btn.setVisible(false);
        atras_vent.setVisible(false);
        // Se muestran los componentes de principal
        // Imagen portada potter principal
        portadapotter.setVisible(true);
        // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(true);
        // Botones
        siguiente_img.setVisible(true);
        atras_img.setVisible(true);
        if (principal.tipo_usuario) {
            admin.setVisible(true);
        }
        // visivilizamos los componentes de busqueda
        busqueda.setVisible(true);
        buscar_caja.setVisible(true);
        buscar.setVisible(true);
        ajustes.setVisible(true);
    }

    public void invisible_componentesprincipal() {
        // Se oculta todo para cambiar los componentes del frame principal
        // Imagen portada potter principal
        portadapotter.setVisible(false);
        // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(false);
        // Botones
        siguiente_img.setVisible(false);
        atras_img.setVisible(false);
        ajustes.setVisible(false);
        if (principal.tipo_usuario) {
            admin.setVisible(false);
        }
    }

    public void invisible_componentesajuste() {
        // Se ocultan todos los componentes de ajuste
        // Texto
        text_ajuste.setVisible(false);
        text_tam_pant.setVisible(false);
        tam_pant.setVisible(false);
        atras_vent.setVisible(false);
        // Se muestran los componentes de principal
        // Imagen portada potter principal
        portadapotter.setVisible(true);
        // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(true);
        // Botones
        siguiente_img.setVisible(true);
        atras_img.setVisible(true);
        if (principal.tipo_usuario) {
            admin.setVisible(true);
        }
        // visivilizamos los componentes de busqueda
        busqueda.setVisible(true);
        buscar_caja.setVisible(true);
        buscar.setVisible(true);
        ajustes.setVisible(true);
    }

}