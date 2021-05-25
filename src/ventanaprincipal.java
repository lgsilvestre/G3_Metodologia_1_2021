import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaprincipal extends JFrame{
    private JPanel panel_principal = new JPanel();
    private int portadaseleccionada=1;
    public ventanaprincipal(){
        this.setSize(800,800);
        
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel_principal.setLayout(null);
        
        add(panel_principal);
        componentes();
    }
    private void componentes(){
        // Cajas de texto
        JTextField buscar_caja= new JTextField("");
        buscar_caja.setBounds(200,60,400,30);
        buscar_caja.setBackground(Color.ORANGE);
        panel_principal.add(buscar_caja);

        // Logo Triviño
        JLabel logotrivino = new JLabel(new ImageIcon("imagenes\\LogoGrupoTrivino_pagina.png"));
        logotrivino.setBounds(0,0,150,113);
        panel_principal.add(logotrivino);

        // Imagen portada principal
        JLabel portadapotter = new JLabel(new ImageIcon("imagenes_portada\\potter.jpg"));
        portadapotter.setBounds(150,150,500,300);
        portadapotter.setVisible(true);
        panel_principal.add(portadapotter);
        
        // Imagen portada principal
        JLabel portadapajaroconlepra = new JLabel(new ImageIcon("imagenes_portada\\elpajaroconlepra.png"));
        portadapajaroconlepra.setBounds(150,150,500,300);
        portadapajaroconlepra.setVisible(false);
        panel_principal.add(portadapajaroconlepra);

        // Botones
        JButton buscar = new JButton(new ImageIcon("imagenes//imagen_buscar.png"));
        buscar.setBackground(Color.ORANGE);
        buscar.setBounds(610,60,30,30);
        panel_principal.add(buscar);
        // Action para el boton buscar
        ActionListener actionbuscar = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.out.println("buscar");
            }
        };buscar.addActionListener(actionbuscar);

        JButton siguiente = new JButton(new ImageIcon("imagenes//siguiente.png"));     
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

        JButton atras = new JButton(new ImageIcon("imagenes//atras.png"));
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
        JLabel fondo_frame = new JLabel(new ImageIcon("imagenes//fondo_frame.jpg"));
        fondo_frame.setBounds(0,0,800,800);
        panel_principal.add(fondo_frame);
    }
}