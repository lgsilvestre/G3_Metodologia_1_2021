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
        //Texto
        JLabel error_campo = new JLabel("Error en el campo de usuario o contraseña");
        error_campo.setBounds(250,465,250,40);
        error_campo.setForeground(Color.RED);
        error_campo.setVisible(false);
        panel_inicio.add(error_campo);

        JLabel usuario = new JLabel("Usuario");
        usuario.setBounds(250,270, 70, 100);
        panel_inicio.add(usuario);

        JLabel contrasena = new JLabel("Contraseña");
        contrasena.setBounds(250,315, 70, 100);
        panel_inicio.add(contrasena);

        JLabel codigo_admin = new JLabel("Codigo Admin");
        codigo_admin.setBounds(250,360, 100, 100);
        codigo_admin.setVisible(false);
        panel_inicio.add(codigo_admin);

        JLabel titulo_frame = new JLabel("Triviño Prime Video");
        titulo_frame.setBounds(250,120, 500, 100);
        titulo_frame.setFont(new Font("arial",Font.PLAIN, 30));
        titulo_frame.setForeground(Color.ORANGE);
        panel_inicio.add(titulo_frame);
        
        // Botones
        /* no se si lo ocuparemos xd
            JButton salir = new JButton();
            salir.setText("Salir");
            salir.setBounds(100,600, 100, 30);
            panel_inicio.add(salir);
        */
        JButton iniciarseccion = new JButton();
        iniciarseccion.setText("Iniciar Seccion");
        iniciarseccion.setBounds(300,450,150,20);
        panel_inicio.add(iniciarseccion);

        // Cajas de texto
        JTextField usuario_caja= new JTextField("");
        usuario_caja.setBounds(340,315,160,20);
        panel_inicio.add(usuario_caja);
        
        JTextField contrasena_caja= new JTextField("");
        contrasena_caja.setBounds(340,355,160,20);
        panel_inicio.add(contrasena_caja);

        JTextField codigoadmin_caja= new JTextField("");
        codigoadmin_caja.setBounds(340,400,160,20);
        codigoadmin_caja.setVisible(false);
        panel_inicio.add(codigoadmin_caja);

        // Combo Box
        JComboBox tipo_usuario = new JComboBox<>(new String[]{"Usuario", "Administrador"});
        tipo_usuario.setBounds(250,230,110,20);
        tipo_usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tipo_usuario.getSelectedIndex()) {
                    case 0:
                        principal.tipo_usuario=false;
                        codigo_admin.setVisible(false);
                        codigoadmin_caja.setVisible(false);
                        break;
                    case 1:
                        principal.tipo_usuario=true;
                        codigo_admin.setVisible(true);
                        codigoadmin_caja.setVisible(true);
                        break;
                    default:
                    codigo_admin.setVisible(false);
                        codigoadmin_caja.setVisible(false);
                        principal.tipo_usuario=false;
                        break;
                }
            }
        });
        panel_inicio.add(tipo_usuario);

        // ActionListener
        ActionListener action_reserva = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                    JButton source = (JButton)ae.getSource();
                    if(iniciarseccion.getText()==source.getText()){
                        if(usuario_caja.getText().equals("") || contrasena_caja.getText().equals("") || (principal.tipo_usuario==true && codigoadmin_caja.getText().equals(""))){
                            error_campo.setVisible(true);
                        }else{
                            error_campo.setVisible(false);
                            if(principal.tipo_usuario){
                                if(validarusuario(usuario_caja.getText(), contrasena_caja.getText(), codigoadmin_caja.getText())){
                                    // Si es que el usuario ingresa correctamente todos los campos
                                    principal.v_inicio.setVisible(false);
                                    principal.v_principal.setVisible(true);
                                }else{
                                    error_campo.setVisible(true);
                                }
                            }else{
                                if(validarusuario(usuario_caja.getText(), contrasena_caja.getText(), null)){
                                    // Si es que el usuario ingresa correctamente todos los campos
                                    principal.v_inicio.setVisible(false);
                                    principal.v_principal.setVisible(true);
                                }else{
                                    error_campo.setVisible(true);
                                }
                            }
                        }
                    }
            }
        };
        //salir.addActionListener(action_reserva);
        iniciarseccion.addActionListener(action_reserva);

        // Logo Triviño
        JLabel logotrivino = new JLabel(new ImageIcon("imagenes\\LogoGrupoTrivino.png"));
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
    public boolean validarusuario(String usuario, String contrasena, String codigoadmin){
        int buscarindice = -1;
        boolean usuariovalido=false;
        for(int i=0; i<principal.base_datos.getTamNU(); i++){
            if(principal.base_datos.getNombres_usuario()[i].equals(usuario)){
                buscarindice=i;
            }
        }
        System.out.println(buscarindice);
        if(buscarindice!=-1){
            if(principal.tipo_usuario==true){
                if(principal.base_datos.getContrasena_usuario()[buscarindice].equals(contrasena) && principal.base_datos.getCodigo_admin()[buscarindice].equals(codigoadmin)){
                    usuariovalido=true;
                }else{
                    usuariovalido=false;
                }
            }else{
                if(principal.base_datos.getContrasena_usuario()[buscarindice].equals(contrasena) && principal.base_datos.getCodigo_admin()[buscarindice]==null){
                    usuariovalido=true;
                }else{
                    usuariovalido=false;
                }
            }
            
        }
        return usuariovalido;
    }
}