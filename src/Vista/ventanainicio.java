package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ventanainicio extends JFrame{
    // Panel
    private JPanel panel_inicio = new JPanel();
    // La contraseña del usuario en char
    private char[] contrasena_validar_char;
    //la contraseña del usuario
    private String contrasena_validar;
    // Contructor
    public ventanainicio(){
        // Tamaño por defecto de el frame
        this.setSize(800,800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel_inicio.setLayout(null);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        // Añadimos el panel
        add(panel_inicio);
        // Inicializamos los componentes
        componentes();
    }
    public void componentes(){
        //Texto que se añadira en el panel
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
        
        // Boton de inciar seccion
        JButton iniciarseccion = new JButton();
        iniciarseccion.setText("Iniciar Sesión");
        iniciarseccion.setBounds(300,450,150,20);
        panel_inicio.add(iniciarseccion);

        // Cajas de texto
        JTextField usuario_caja= new JTextField("");
        usuario_caja.setBounds(340,315,160,20);
        panel_inicio.add(usuario_caja);
        
        JPasswordField contrasena_caja = new JPasswordField("");
        contrasena_caja.setBounds(340,355,160,20);
        panel_inicio.add(contrasena_caja);
        /*
        JTextField contrasena_caja= new JTextField("");
        contrasena_caja.setBounds(340,355,160,20);
        panel_inicio.add(contrasena_caja);*/

        JTextField codigoadmin_caja= new JTextField("");
        codigoadmin_caja.setBounds(340,400,160,20);
        codigoadmin_caja.setVisible(false);
        panel_inicio.add(codigoadmin_caja);

        // Combo Box para el ingreso de usuario o por el otro lado administrador
        JComboBox tipo_usuario = new JComboBox<>(new String[]{"Usuario", "Administrador"});
        tipo_usuario.setBounds(250,230,110,20);
        tipo_usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tipo_usuario.getSelectedIndex()) {
                    case 0:
                        // El tipo de usuario es USUARIO
                        principal.tipo_usuario=false;
                        codigo_admin.setVisible(false);
                        codigoadmin_caja.setVisible(false);
                        break;
                    case 1:
                        // El tipo de usuario es ADMINISTRADOR
                        principal.tipo_usuario=true;
                        codigo_admin.setVisible(true);
                        codigoadmin_caja.setVisible(true);
                        break;
                    default:
                        // Por default el usuario es USUARIO
                        principal.tipo_usuario=false;
                        codigo_admin.setVisible(false);
                        codigoadmin_caja.setVisible(false);
                        principal.tipo_usuario=false;
                        break;
                }
            }
        });
        panel_inicio.add(tipo_usuario);
        // Si precionan los botones agregamos un oyente de accion
        // ActionListener
        ActionListener action_inicioseccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                    JButton source = (JButton)ae.getSource();
                    contrasena_validar_char = contrasena_caja.getPassword();
                    contrasena_validar= new String(contrasena_validar_char);

                    if(iniciarseccion.getText()==source.getText()){
                        if(usuario_caja.getText().equals("") || contrasena_validar.equals("") || (principal.tipo_usuario==true && codigoadmin_caja.getText().equals(""))){
                            // Si es que no llena los campos para iniciar seccion se le arrojara un error
                            error_campo.setVisible(true);
                        }else{
                            error_campo.setVisible(false);
                            // Si el usuario(ADMINISTRADOR) llena todos los campos para iniciar seccion comprobamos si es que el usuario es correcto
                            if(principal.tipo_usuario){
                                if(validarusuario(usuario_caja.getText(), contrasena_validar, codigoadmin_caja.getText())){
                                    // Si es que el usuario ingresa correctamente todos los campos, se le abrira la ventana para que pueda ver el contenido de la empresa
                                    principal.v_inicio.setVisible(false);
                                    principal.v_principal.setVisible(true);
                                }else{
                                    // si es que el usuario ingresa incorrectamente(porque el usuario no existe), entonces se le arrojara un error 
                                    error_campo.setVisible(true);
                                }
                            // Si el usuario(USUARIO) llena todos los campos para iniciar seccion comprobamos si es que el usuario es correcto
                            }else{
                                if(validarusuario(usuario_caja.getText(), contrasena_validar, null)){
                                    // Si es que el usuario ingresa correctamente todos los campos, se le abrira la ventana para que pueda ver el contenido de la empresa
                                    principal.v_inicio.setVisible(false);
                                    principal.v_principal.setVisible(true);
                                }else{
                                    // si es que el usuario ingresa incorrectamente(porque el usuario no existe), entonces se le arrojara un error 
                                    error_campo.setVisible(true);
                                }
                            }
                        }
                    }
            }
        };
        iniciarseccion.addActionListener(action_inicioseccion);

        // Logo Triviño
        JLabel logotrivino = new JLabel(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png"));
        logotrivino.setBounds(270,0,200,150);
        panel_inicio.add(logotrivino);

        // Recuadro para el incio de seccion
        JLabel recuadro_inicioseccion = new JLabel(new ImageIcon("imagenes//Frame//imagen_inicioseccion.jpg"));
        recuadro_inicioseccion.setBounds(220,200,300,300);
        panel_inicio.add(recuadro_inicioseccion);

        // Fondo del frame
        JLabel fondo_frame = new JLabel(new ImageIcon("imagenes//Frame//fondo_frame.jpg"));
        fondo_frame.setBounds(0,0,800,800);
        panel_inicio.add(fondo_frame);
    }
    // Funcion que valida el usuario, ya sea ADMINISTRADOR o USUARIO
    public boolean validarusuario(String usuario, String contrasena, String codigoadmin){
        // Buscaremos el indice de el arreglo de nombre de usuario
        int buscarindice = -1;
        // La funcion retornara false si el usuario no es valido , de caso contrario retornara un true si es que es valido
        boolean usuariovalido=false;
        // Buscamos en el arreglo de nombres de usuario, si es que encontramos el nombre de usuario guardamos el indice
        for(int i=0; i<principal.base_datos.getTamNU(); i++){
            if(principal.base_datos.getNombres_usuario()[i].equals(usuario)){
                buscarindice=i;
            }
        }
        // Si es que el indice fue encontrado entonces validamos que sean correcto los otros datos(contraseña o codigo admin si es que este es ADMINISTRADOR)
        if(buscarindice!=-1){
            // Si el usuario es ADMINISTRADOR
            if(principal.tipo_usuario==true){
                // Si es que la contraseña y el codigo administrador es la correcta entonces el usuario es valido, de caso contrario no es valido
                if(principal.base_datos.getContrasena_usuario()[buscarindice].equals(contrasena) && principal.base_datos.getCodigo_admin()[buscarindice]==null){
                    usuariovalido=false;
                }else if(principal.base_datos.getContrasena_usuario()[buscarindice].equals(contrasena) && principal.base_datos.getCodigo_admin()[buscarindice].equals(codigoadmin)){
                    usuariovalido=true;
                }
            // Si el usuario es USUARIO
            }else{
                // Si es que la contraseña es la correcta entonces el usuario es valido, de caso contrario no es valido
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