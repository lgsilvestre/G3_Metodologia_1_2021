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


        // Logo Triviño
        JLabel logotrivino = new JLabel(new ImageIcon("imagenes\\LogoGrupoTrivino_pagina.png"));
        logotrivino.setBounds(0,0,150,113);
        panel_principal.add(logotrivino);

        // Fondo del frame
        JLabel fondo_frame = new JLabel(new ImageIcon("imagenes//fondo_frame.jpg"));
        fondo_frame.setBounds(0,0,800,800);
        panel_principal.add(fondo_frame);
    }
}
