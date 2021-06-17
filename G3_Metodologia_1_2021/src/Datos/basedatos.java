package Datos;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class basedatos {
    // Datos en donde estaran los usuarios con sus respectivas contraseñas y codigo de administrador(si es que tienen)
    /*public String[] nombres_usuario={"AmparoLeiva01","JoseFlores02","AlvaroHerrera03","VictorCornejo04","PaulQuezada05","MiguelContardo06","PaoloAmaro07",
        "PatricioBustamante08","Mclovin09","RosaEspinoza10","ArmandoBarreda11","HumbertoSuazo12","JavieraCastro13","AlexisSanchez14","FelipeCerpa15","FernandaMorales16",
        "LionelMessi17","RafaelGonzalez18","RodrigoParedes19","JaimeLizana20","JohnCena21","JuanSierra22","LuisTorres23","FranklinClinton24","MiguelPinera25","EduardoVargas26",
        "KennyOmega27","AndreaCruz28","PabloUribe29","DavidLabra30","SergioLozano31","JuanVilchez32","MiguelSalas33","MarcelaRincon34","LuisSilvestre35"};
    public String[] contrasena_usuario={"07/11/2006","07/11/2006","07/11/2006","07/11/2006","07/11/2006","07/11/2006","23/05/2008","23/05/2008","23/05/2008","23/05/2008",
        "01/09/2010","01/09/2010","01/09/2010","01/09/2010","15/04/2012","15/04/2012","15/04/2012","15/04/2012","15/04/2012","18/07/2019","18/07/2019","18/07/2019","18/07/2019",
        "18/07/2019","18/07/2019","28/04/2020","28/04/2020","28/04/2020","28/04/2020","28/04/2020","23/05/2021","23/05/2021","23/05/2021","23/05/2021","23/05/2021"}; 
    public String[] codigo_admin={null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
        null,null,null,null,"SergioLozano31ad","JuanVilchez32ad","MiguelSalas33ad","MarcelaRincon34ad","LuisSilvestre35ad"};
    // POR MIENTRAS PARA REGISTRAR TODAS LAS BUSQUEDAS (ALMACENARA HASTA 1000 elementos)
    //ArrayList<String> registrar_busqueda = new ArrayList<String>();
    */

    // Datos de prueba
    public ArrayList<String> nombres_usuario = new ArrayList<String>();
    public ArrayList<String> contrasena_usuario = new ArrayList<String>();
    public ArrayList<String> codigo_admin = new ArrayList<String>();
    
    // Leemos el txt donde se encontraran todos los nombres, contraseñas y codigo de admin
    File f = new File("src//Datos//datos.txt");
    File f_auxiliar = new File("src//Datos//auxiliar.txt");

    // Constructor
    public basedatos(){
        leerUsuarios();
    }

    // Para leer el txt donde estaran todos los usuarios
    private void leerUsuarios(){
        String dato="";
        int i=0;
        try {
            Scanner leer= new Scanner(f);
            while (leer.hasNext()) { //mientras no se llegue al final del fichero
                dato=leer.next();
                // El primer dato siempre sera el nombre de usuario
                if(i==0){
                    nombres_usuario.add(dato);
                }else if(i==1){ // El segundo dato es la contraseña
                    contrasena_usuario.add(dato);
                }else if(i==2){ // EL tercer y ultimo dato es el codigo de admin(si es que no tiene se rellena con un null)
                    codigo_admin.add(dato);
                }
                i+=1;
                if(i==3){
                    i=0;
                }
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    // Para ingresar usuarios nuevos
    public void ingresarUsuario(String nombreU, String contrasenaU, String codigoAdmn){
        PrintWriter pw = null;
        FileWriter fw = null;
        try
        {
            fw=new FileWriter(f, true);
            pw = new PrintWriter(fw);
            pw.println(nombreU+ " "+contrasenaU+" "+codigoAdmn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fw)
              fw.close();
           } catch (Exception e2) {
              e2.printStackTrace(); 
           }
        }
        borrarDatosListas();
        leerUsuarios();
    }
    public void eliminarUsuarioExistentes(String lineToRemove){ 
        Scanner in = new Scanner(System.in);
        /*while(true){
            if (lineToRemove.length() < 5){
                lineToRemove = in.next();
                continue;
            } else{
                break;
            }
        }
        in.close();*/
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f_auxiliar));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {                        
                if(currentLine.contains(lineToRemove)){ 
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }  

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f_auxiliar));
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            String currentLine;

            while((currentLine = reader.readLine()) != null) { 
                writer.write(currentLine + System.getProperty("line.separator"));
            }  

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        borrarDatosListas();
        leerUsuarios();
    }
    public void modificarUsuariosExistentes(String nombre_usuario, String nombre_usuario_Modificado, String contrasena_usuario_Modificado, String codigo_Admin_Modificado){
        eliminarUsuarioExistentes(nombre_usuario);
        ingresarUsuario(nombre_usuario_Modificado, contrasena_usuario_Modificado, codigo_Admin_Modificado);
        borrarDatosListas();
        leerUsuarios();
    }
    // Imprimir TODO de las listas (PARA PRUEBA)
    public void imprimir(){
        for(int i =0; i<nombres_usuario.size(); i++){
            System.out.println("Nombre:"+nombres_usuario.get(i)+", Contraseña: "+contrasena_usuario.get(i)+", CodigoADM: "+codigo_admin.get(i));
        }
    }
    // Retornar Listas
    public ArrayList<String> getNombres_usuario(){return nombres_usuario;}
    public ArrayList<String> getContrasena_usuario(){return contrasena_usuario;}
    public ArrayList<String> getCodigo_admin(){return codigo_admin;}
    
    // Retornar Tamaño de las Listas
    public int getTamNU(){return nombres_usuario.size();}
    public int getTamCU(){return contrasena_usuario.size();}
    public int getTamCA(){return codigo_admin.size();}
    
    // Borrar los datos de las listas
    public void borrarDatosListas(){
        nombres_usuario = new ArrayList<String>();
        contrasena_usuario = new ArrayList<String>();
        codigo_admin = new ArrayList<String>();
    }
    // ArrayList de las busquedas (ES IRRELEVANTE SI FUNCIONA O NO)
    //public ArrayList<String> getRegistrar_busqueda(){return registrar_busqueda;}


}