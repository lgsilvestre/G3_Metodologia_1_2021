package Datos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Vista.principal;
import java.util.Scanner;
import java.io.File;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class controlusuarios extends JFrame{
    File f = new File("src//Datos//datos.txt");
    JPanel panelusuario = new JPanel();
    JPanel otropanel = new JPanel();
    JPanel otropanel2 = new JPanel();
    Object[] row = new Object[3];
    DefaultTableModel model = new DefaultTableModel();
    String eliminar="";
    public controlusuarios(){
        // Tamaño de la ventana
        this.setSize(900,800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Empresa Triviño LTDA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes//Frame//LogoGrupoTrivino.png").getImage());
        panelusuario.setLayout(null);
        // Añadimos los dos paneles a la ventana
        panelusuario.setBounds(0,400,900,400);
        otropanel.setBounds(0,0,900,400);
        otropanel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Lista de Usuarios", TitledBorder.CENTER, TitledBorder.TOP));
        add(panelusuario);
        otropanel2.setBounds(194,60,500,150);
        panelusuario.add(otropanel2);
        componentes();
        agregarUsuariosExistentes();
        // Color de la ventana y el panel
        otropanel.setBackground(Color.black);
        otropanel2.setBackground(Color.yellow);
        panelusuario.setBackground(Color.black);
    }
    public void agregarUsuariosExistentes(){
        String dato="";
        int i=0;
        try {
            Scanner leer= new Scanner(f);
            while (leer.hasNext()) { //mientras no se llegue al final del fichero
                dato=leer.next();
                row[i]=dato;  
                i+=1;
                if(i==3){
                    i=0;
                    model.addRow(row);
                }
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    public void componentes(){
        // Nuestro JTable
		JTable table = new JTable(); 
        // Crear las columnas
        Object[] columns = {"Nombre","Contraseñas","Codigo Admin"};
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField textNombre = new JTextField();
        JTextField textContrasena = new JTextField();
        JTextField textCodigoAdm = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Añadir Usuario");
        JButton btnDelete = new JButton("Eliminar Usuario");
        JButton btnUpdate = new JButton("Modificar Usuario");     
        
        textNombre.setBounds(295, 80, 100, 25);
        textContrasena.setBounds(295, 120, 100, 25);
        textCodigoAdm.setBounds(295, 160, 100, 25);
        
        btnAdd.setBounds(475, 80, 130, 25);
        btnUpdate.setBounds(475, 120, 130, 25);
        btnDelete.setBounds(475, 160, 130, 25);
        
        // add JTextFields to the jframe
        add(table);
        panelusuario.add(textNombre);
        panelusuario.add(textContrasena);
        panelusuario.add(textCodigoAdm);
    
        // add JButtons to the jframe
        panelusuario.add(btnAdd);
        panelusuario.add(btnDelete);
        panelusuario.add(btnUpdate);
        panelusuario.add(otropanel2);
        
        // create JScrollPane
        otropanel.add(new JScrollPane(table));
        add(otropanel);
        
        // create an array of objects to set the row data
        
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textNombre.getText();
                row[1] = textContrasena.getText();
                row[2] = textCodigoAdm.getText();
                principal.base_datos.ingresarUsuario(textNombre.getText(), textContrasena.getText(), textCodigoAdm.getText());
                // add row to the model
                model.addRow(row);
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    eliminar = model.getValueAt(i, 0).toString();
                    model.removeRow(i);
                    principal.base_datos.eliminarUsuarioExistentes(eliminar);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textNombre.setText(model.getValueAt(i, 0).toString());
            textContrasena.setText(model.getValueAt(i, 1).toString());
            textCodigoAdm.setText(model.getValueAt(i, 2).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0) 
                {
                    principal.base_datos.modificarUsuariosExistentes(model.getValueAt(i, 0).toString(), textNombre.getText(), textContrasena.getText(), textCodigoAdm.getText());
                    model.setValueAt(textNombre.getText(), i, 0);
                    model.setValueAt(textContrasena.getText(), i, 1);
                    model.setValueAt(textCodigoAdm.getText(), i, 2);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
    }
}