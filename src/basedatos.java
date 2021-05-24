public class basedatos {
    // Datos
    public String[] nombres_usuario={"jose"};
    public String[] contrasena_usuario={"holacomoestas"};
    public String[] codigo_admin={null};
    public basedatos(){}
    
    // Retornar Listas
    public String[] getNombres_usuario(){return nombres_usuario;}
    public String[] getContrasena_usuario(){return contrasena_usuario;}
    public String[] getCodigo_admin(){return codigo_admin;}

    // Retornar tamaño de las listas
    public int getTamNU(){return nombres_usuario.length;}
    public int getTamCU(){return contrasena_usuario.length;}
    public int getTamCA(){return codigo_admin.length;}
}