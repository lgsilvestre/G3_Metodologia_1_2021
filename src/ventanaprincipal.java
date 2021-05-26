import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaprincipal extends JFrame{
    private JPanel panel_principal = new JPanel();
    private int portadaseleccionada=1;
    // Componentes del principal
        // Cajas de texto
    JTextField buscar_caja= new JTextField();
        // Logo Triviño
    JButton logotrivino = new JButton(new ImageIcon("imagenes\\LogoGrupoTrivino_pagina.png"));
        // Imagen usuario (por mientras)
    JLabel imagen_usuario = new JLabel(new ImageIcon("imagenes\\foto_usuario.png"));
        // Imagen portada potter principal
    JLabel portadapotter = new JLabel(new ImageIcon("imagenes_portada\\potter.jpg"));
        // Imagen portada el pajaro con lepra principal
    JLabel portadapajaroconlepra = new JLabel(new ImageIcon("imagenes_portada\\elpajaroconlepra.png"));
        // Botones
    JButton buscar = new JButton(new ImageIcon("imagenes//imagen_buscar.png"));
    JButton siguiente = new JButton(new ImageIcon("imagenes//siguiente.png"));
    JButton atras = new JButton(new ImageIcon("imagenes//atras.png"));
        // Fondo del frame
    JLabel fondo_frame = new JLabel(new ImageIcon("imagenes//fondo_frame.jpg"));
    
    // Componentes del buscar
        // Texto 
    JLabel busqueda= new JLabel();

    public ventanaprincipal(){
        this.setSize(800,800);
        
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel_principal.setLayout(null);
        
        add(panel_principal);
        componentesprincipal();
    }
    private void componentesprincipal(){
        // Cajas de texto
        buscar_caja.setBounds(200,60,400,30);
        buscar_caja.setBackground(Color.ORANGE);
        panel_principal.add(buscar_caja);

        // Logo Triviño
        logotrivino.setBounds(0,0,150,113);
        logotrivino.setBackground(Color.BLACK);
        logotrivino.setOpaque(false);
        logotrivino.setContentAreaFilled(false);
        logotrivino.setBorderPainted(false);
        panel_principal.add(logotrivino);
        ActionListener actionprincipal = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                invisible_componentesbusqueda();
            }
        };logotrivino.addActionListener(actionprincipal);

        // Imagen usuario (por mientras)
        imagen_usuario.setBounds(680,20,100,93);
        panel_principal.add(imagen_usuario);

        // Imagen portada principal
        portadapotter.setBounds(150,150,500,300);
        portadapotter.setVisible(true);
        panel_principal.add(portadapotter);
        
        // Imagen portada principal
        portadapajaroconlepra.setBounds(150,150,500,300);
        portadapajaroconlepra.setVisible(false);
        panel_principal.add(portadapajaroconlepra);

        // Botones
        buscar.setBackground(Color.ORANGE);
        buscar.setBounds(610,60,30,30);
        panel_principal.add(buscar);
        // Action para el boton buscar
        ActionListener actionbuscar = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                invisible_componentesprincipal();
                componentesbusqueda();
            }
        };buscar.addActionListener(actionbuscar);
 
        siguiente.setBackground(Color.ORANGE);
        siguiente.setBounds(700,300,40,40);
        panel_principal.add(siguiente);
        // Action para el boton siguiente
        ActionListener actionsiguiente = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(portadaseleccionada==1){
                    portadapotter.setVisible(false);
                    portadapajaroconlepra.setVisible(true);
                    portadaseleccionada=2;
                }else{
                    portadapotter.setVisible(true);
                    portadapajaroconlepra.setVisible(false);
                    portadaseleccionada=1;
                }
            }
        };siguiente.addActionListener(actionsiguiente);

        atras.setBackground(Color.ORANGE);
        atras.setBounds(70,300,40,40);
        panel_principal.add(atras);
        // Action para el boton atras
        ActionListener actionatras = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(portadaseleccionada==1){
                    portadapotter.setVisible(false);
                    portadapajaroconlepra.setVisible(true);
                    portadaseleccionada=2;
                }else{
                    portadapotter.setVisible(true);
                    portadapajaroconlepra.setVisible(false);
                    portadaseleccionada=1;
                }
            }
        };atras.addActionListener(actionatras);

        // Fondo del frame
        fondo_frame.setBounds(0,0,800,800);
        panel_principal.add(fondo_frame);
    }
    public void invisible_componentesprincipal(){
        // Se oculta todo para cambiar los componentes del frame
            // Imagen portada potter principal
        portadapotter.setVisible(false);
            // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(false);
            // Fondo del frame
        fondo_frame.setVisible(false);
            // Botones
        siguiente.setVisible(false);
        atras.setVisible(false);
        // Se muestran los componentes de busqueda
            // Texto
        busqueda.setVisible(true);
    }
    public void invisible_componentesbusqueda(){
        // Se muestra todos los componentes de busqueda
             // Texto 
        busqueda.setVisible(false);
        // Se muestra todos los componentes de principal
            // Imagen portada potter principal
            portadapotter.setVisible(true);
            // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(true);
            // Fondo del frame
        fondo_frame.setVisible(true);
            // Botones
        siguiente.setVisible(true);
        atras.setVisible(true);

    }
    public void componentesbusqueda(){
        // Texto 
        busqueda.setText("Resultados de "+buscar_caja.getText()+":");
        busqueda.setForeground(Color.WHITE);
        busqueda.setBounds(200,100,200,40);
        panel_principal.add(busqueda);

        // Fondo del frame
        fondo_frame.setVisible(true);
        panel_principal.add(fondo_frame);
    }
}