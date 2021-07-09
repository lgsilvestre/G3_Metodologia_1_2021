package Vista;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class filtroFrame extends JFrame {
    JPanel panel_filtro = new JPanel();
    JRadioButton opcion_tituloVideo;
    JRadioButton opcion_AutorVideo;
    ButtonGroup grupo_botones;

    public filtroFrame() {
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        setUndecorated(true);
        panel_filtro.setLayout(null);
        panel_filtro.setBorder(BorderFactory.createLineBorder(Color.orange, 1));
        // Fondo del Frame
        panel_filtro.setBackground(Color.black);
        // Añadimos el panel a la ventana
        add(panel_filtro);
        componentes();
    }

    // Componentes que tendra el panel
    public void componentes() {
        // Titulo del frame
        JLabel titulo_frame = new JLabel("Filtro de busqueda");
        titulo_frame.setBounds(150, 20, 150, 20);
        titulo_frame.setForeground(Color.orange);
        panel_filtro.add(titulo_frame);
        // Opcion de filtro: Titulo
        opcion_tituloVideo = new JRadioButton("Titulo", true);
        opcion_tituloVideo.setBounds(80, 100, 100, 20);
        opcion_tituloVideo.setBackground(Color.orange);
        panel_filtro.add(opcion_tituloVideo);
        // Opcion de filtro: Autores
        opcion_AutorVideo = new JRadioButton("Autor");
        opcion_AutorVideo.setBounds(80, 150, 100, 20);
        opcion_AutorVideo.setBackground(Color.orange);
        panel_filtro.add(opcion_AutorVideo);

        // Agrupamos los botones
        grupo_botones = new ButtonGroup();
        grupo_botones.add(opcion_tituloVideo);
        grupo_botones.add(opcion_AutorVideo);

        // Boton para ademas de cerrar el frame servira para aplicar los cambios
        JButton aceptar = new JButton("Aceptar");
        ActionListener actionaceptar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                botonSeleccionado();
                principal.filtro_frame.setVisible(false);
                principal.v_principal.desbloquearBotones();
            }
        };
        aceptar.addActionListener(actionaceptar);
        aceptar.setBounds(80, 280, 80, 20);
        aceptar.setBackground(Color.orange);
        panel_filtro.add(aceptar);

    }

    // Tipo de action que servira para ver que boton fue seleccionado
    public void botonSeleccionado() {
        if (opcion_tituloVideo.isSelected()) {
            principal.filtro_seleccionado = false;
        } else if (opcion_AutorVideo.isSelected()) {
            principal.filtro_seleccionado = true;
        }
    }
}
