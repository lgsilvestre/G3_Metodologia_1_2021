import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaprincipal extends JFrame{
    private JPanel panel_principal = new JPanel();
    private int portadaseleccionada=1;
    // Cajas de texto
    JTextField buscar_caja= new JTextField("");
    // Logo Triviño
    JLabel logotrivino = new JLabel(new ImageIcon("imagenes\\LogoGrupoTrivino_pagina.png"));
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
        panel_principal.add(logotrivino);

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
                System.out.println("buscar");
                invisible_componentesprincipal();
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
            // Cajas de texto
        buscar_caja.setVisible(false);
            // Imagen portada potter principal
        portadapotter.setVisible(false);
            // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(false);
            // Botones
        buscar.setVisible(false);
        siguiente.setVisible(false);
        atras.setVisible(false);
    }
    public void componentesbusqueda(){

    }
}