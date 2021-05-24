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

public class ventanainicio extends JFrame{
    private JPanel panel_inicio = new JPanel();

    public ventanainicio(){
        this.setSize(800,800);
        
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel_inicio.setLayout(null);
        
        add(panel_inicio);
        componentes();
    }
    public void componentes(){
        // Combo Box
        JComboBox tipo_usuario = new JComboBox<>(new String[]{"Usuario", "Administrador"});
        tipo_usuario.setBounds(250,230,110,20);
        tipo_usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tipo_usuario.getSelectedIndex()) {
                    case 0:
                        principal.tipo_usuario=false;
                        break;
                    case 1:
                        principal.tipo_usuario=true;
                        break;
                    default:
                        principal.tipo_usuario=false;
                        break;
                }
            }
        });
        panel_inicio.add(tipo_usuario);
        //Texto
        JLabel usuario = new JLabel("Usuario");
        usuario.setBounds(250,270, 70, 100);
        panel_inicio.add(usuario);

        JLabel contrasena = new JLabel("Contraseña");
        contrasena.setBounds(250,315, 70, 100);
        panel_inicio.add(contrasena);

        JLabel titulo_frame = new JLabel("Triviño Prime Video");
        titulo_frame.setBounds(250,120, 500, 100);
        titulo_frame.setFont(new Font("arial",Font.PLAIN, 30));
        titulo_frame.setForeground(Color.ORANGE);
        panel_inicio.add(titulo_frame);
        // Botones
        JButton salir = new JButton();
        salir.setText("Salir");
        salir.setBounds(100,600, 100, 30);
        panel_inicio.add(salir);

        JButton iniciarseccion = new JButton();
        iniciarseccion.setText("Iniciar Seccion");
        iniciarseccion.setBounds(600,600,150,30);
        panel_inicio.add(iniciarseccion);

        // Cajas de texto
        JTextField usuario_cmbox= new JTextField();
        usuario_cmbox.setBounds(340,315,160,20);
        panel_inicio.add(usuario_cmbox);
        
        JTextField contrasena_cmbox= new JTextField();
        contrasena_cmbox.setBounds(340,355,160,20);
        panel_inicio.add(contrasena_cmbox);

        // ActionListener
        ActionListener action_reserva = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                    JButton source = (JButton)ae.getSource();
                    if(salir.getText()==source.getText()){
                        System.exit(0);
                    }else if(iniciarseccion.getText()==source.getText()){
                        //principal.cambio_frame=1;
                        //System.out.println("a");
                    }
            }
        };
        salir.addActionListener(action_reserva);
        iniciarseccion.addActionListener(action_reserva);

        // Logo Triviño
        JLabel logotrivino = new JLabel(new ImageIcon("imagenes//LogoGrupoTrivino.png"));
        logotrivino.setBounds(270,0,200,150);
        panel_inicio.add(logotrivino);

        // NO se xdxd
        JLabel recuadro_inicioseccion = new JLabel(new ImageIcon("imagenes//imagen_inicioseccion.jpg"));
        recuadro_inicioseccion.setBounds(220,200,300,300);
        panel_inicio.add(recuadro_inicioseccion);

        // Fondo del frame
        JLabel fondo_frame = new JLabel(new ImageIcon("imagenes//fondo_frame.jpg"));
        fondo_frame.setBounds(0,0,800,800);
        panel_inicio.add(fondo_frame);

       
    }
}
