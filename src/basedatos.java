public class basedatos {
    // Datos
    public String[] nombres_usuario={"AmparoLeiva01","JoseFlores02","AlvaroHerrera03","VictorCornejo04","PaulQuezada05","MiguelContardo06","PaoloAmaro07",
        "PatricioBustamante08","Mclovin09","RosaEspinoza10","ArmandoBarreda11","HumbertoSuazo12","JavieraCastro13","AlexisSanchez14","FelipeCerpa15","FernandaMorales16",
        "LionelMessi17","RafaelGonzalez18","RodrigoParedes19","JaimeLizana20","JohnCena21","JuanSierra22","LuisTorres23","FranklinClinton24","MiguelPiñera25","EduardoVargas26",
        "KennyOmega27","AndreaCruz28","PabloUribe29","DavidLabra30","SergioLozano31","JuanVilchez32","MiguelSalas33","MarcelaRincon34","LuisSilvestre35"};
    public String[] contrasena_usuario={"07/11/2006","07/11/2006","07/11/2006","07/11/2006","07/11/2006","07/11/2006","23/05/2008","23/05/2008","23/05/2008","23/05/2008",
        "01/09/2010","01/09/2010","01/09/2010","01/09/2010","15/04/2012","15/04/2012","15/04/2012","15/04/2012","15/04/2012","18/07/2019","18/07/2019","18/07/2019","18/07/2019",
        "18/07/2019","18/07/2019","28/04/2020","28/04/2020","28/04/2020","28/04/2020","28/04/2020","23/05/2021","23/05/2021","23/05/2021","23/05/2021","23/05/2021"}; 
    public String[] codigo_admin={null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
        null,null,null,null,"SergioLozano31ad","JuanVilchez32ad","MiguelSalas33ad","MarcelaRincon34ad","LuisSilvestre35ad"};
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