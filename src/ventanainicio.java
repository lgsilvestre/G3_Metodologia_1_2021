import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        //Texto
        JLabel usuario = new JLabel("Usuario");
        usuario.setBounds(70, 180, 70, 100);
        panel_inicio.add(usuario);

        JLabel contrasena = new JLabel("Contraseña");
        contrasena.setBounds(70, 280, 70, 100);
        panel_inicio.add(contrasena);

        JLabel titulo_frame = new JLabel("Inicio Seccion");
        titulo_frame.setBounds(300,20, 500, 100);
        titulo_frame.setFont(new Font("arial",Font.PLAIN, 30));
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
        usuario_cmbox.setBounds(200,200,400,50);
        panel_inicio.add(usuario_cmbox);
        
        JTextField contrasena_cmbox= new JTextField();
        contrasena_cmbox.setBounds(200,300,400,50);
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
    }
}
