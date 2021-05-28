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
    JButton siguiente_img = new JButton(new ImageIcon("imagenes//siguiente.png"));
    JButton atras_img = new JButton(new ImageIcon("imagenes//atras.png"));
    JButton atras_vent = new JButton("Atras");
        // Action Listener de el boton atras
    ActionListener action_atras_vent;
        // Fondo del frame
    JLabel fondo_frame = new JLabel(new ImageIcon("imagenes//fondo_frame.jpg"));
        // Ajustes
    JButton ajustes = new JButton(new ImageIcon("imagenes//ajuste.png"));
    // Componentes del buscar
        // Texto 
    JLabel busqueda= new JLabel();
    // Componentes de ajuste
        // Texto
    JLabel text_ajuste = new JLabel();
    JLabel text_tam_pant = new JLabel();
        // ComboBox
    JComboBox tam_pant = new JComboBox<>(new String[]{"800x800", "800x600"});
    // Ancho y Largo del frame
    public int ancho=800, largo=800;

    public void init_ventanaprincipal(){
        // Tamaño de la ventana
        this.setSize(ancho,largo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes\\LogoGrupoTrivino.png").getImage());
        panel_principal.setLayout(null);

        // Añadimos el panel a la ventana
        add(panel_principal);
    }
    public void iniciarcomponentes(){
        componentesprincipal();
    }
    private void componentesprincipal(){
        // Cajas de texto
        buscar_caja.setBounds(200,60,400,30);
        buscar_caja.setBackground(Color.ORANGE);
        panel_principal.add(buscar_caja);

        // Ajustes
        ajustes.setBounds(723,10,30,30);
        ajustes.setBackground(Color.ORANGE);
        panel_principal.add(ajustes);
        ActionListener actionajustes= new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                invisible_componentesprincipal();
                componentesajustes();

            }
        };ajustes.addActionListener(actionajustes);

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
                invisible_componentesajuste();
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
                principal.base_datos.getRegistrar_busqueda().add(buscar_caja.getText());
            }
        };buscar.addActionListener(actionbuscar);
 
        siguiente_img.setBackground(Color.ORANGE);
        siguiente_img.setBounds(700,300,40,40);
        panel_principal.add(siguiente_img);
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
        };siguiente_img.addActionListener(actionsiguiente);
        // Boton atras(para las portadas de los videos)
        atras_img.setBackground(Color.ORANGE);
        atras_img.setBounds(70,300,40,40);
        panel_principal.add(atras_img);
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
        };atras_img.addActionListener(actionatras);
        // Fondo del frame
        fondo_frame.setBounds(0,0,800,800);
        fondo_frame.setVisible(true);
        panel_principal.add(fondo_frame);
        System.out.print("");
    }
    public void invisible_componentesprincipal(){
        // Se oculta todo para cambiar los componentes del frame principal
            // Imagen portada potter principal
        portadapotter.setVisible(false);
            // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(false);
            // Fondo del frame
        fondo_frame.setVisible(false);
            // Botones
        siguiente_img.setVisible(false);
        atras_img.setVisible(false);
        ajustes.setVisible(false);
        // Se muestran los componentes de busqueda
            // Texto
        busqueda.setVisible(true);
        atras_vent.setVisible(true);
    }
    public void invisible_componentesbusqueda(){
        // Se ocultan todos los componentes de busqueda
             // Texto 
        busqueda.setVisible(false);
        atras_vent.setVisible(false);
        // Se muestra todos los componentes de principal
            // Imagen portada potter principal
        portadapotter.setVisible(true);
            // Imagen portada el pajaro con lepra principal
        portadapajaroconlepra.setVisible(true);
            // Fondo del frame
        fondo_frame.setVisible(true);
            // Botones
        siguiente_img.setVisible(true);
        atras_img.setVisible(true);
        ajustes.setVisible(true);
            // Caja de busqueda
        buscar_caja.setVisible(true);
        buscar.setVisible(true);

    }
    public void invisible_componentesajuste(){
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
            // Fondo del frame
        fondo_frame.setVisible(true);
            // Botones
        siguiente_img.setVisible(true);
        atras_img.setVisible(true);
    }
    public void componentesbusqueda(){
        // Texto 
        busqueda.setText("Resultados de "+buscar_caja.getText()+":");
        busqueda.setForeground(Color.WHITE);
        busqueda.setBounds(200,100,200,40);
        panel_principal.add(busqueda);

        // Botones   
        atras_vent.setBounds(200,500,100,40);
        panel_principal.add(atras_vent);
        // Action para el boton atras ventana
        action_atras_vent = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                invisible_componentesbusqueda();
                invisible_componentesajuste();
            }
        };atras_vent.addActionListener(action_atras_vent);
        // Fondo del frame
        fondo_frame.setVisible(true);
        panel_principal.add(fondo_frame);
    }
    public void componentesajustes(){
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
        text_ajuste.setFont(new Font("arial",Font.PLAIN, 30));
        text_ajuste.setForeground(Color.ORANGE);
        text_ajuste.setBounds(200,100,200,60);
        panel_principal.add(text_ajuste);

        text_tam_pant.setText("Tamaño de pantalla");
        text_tam_pant.setBounds(50,170,180,100);
        panel_principal.add(text_tam_pant);
        
        // Botones
        atras_vent.setBounds(200,500,100,40);
        panel_principal.add(atras_vent);
        // Action para el boton atras ventana
        action_atras_vent = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                invisible_componentesbusqueda();
                invisible_componentesajuste();
            }
        };atras_vent.addActionListener(action_atras_vent);
        // ComboBox en donde seleccionara el tamaño de el frame
        tam_pant.setBounds(200,200,100,40);
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
        // Fondo del frame
        fondo_frame.setVisible(true);
        panel_principal.add(fondo_frame);
    }
}