// Libreria importadas: JMF, MEDIAPLAYER, MULTIPLAYER, SOUND (fueron añadidas para reproducir videos y sonido)
// Lamentablemente esta libreria es muy vieja para reproducir mp4 o mpeg

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.bean.playerbean.MediaPlayer;
import javax.print.attribute.standard.Media;
import javax.swing.JFrame;
import javax.swing.JPanel;

/////////////////////
// NO FUNCIONA AUN //
/////////////////////


public class reproductorvideo extends JFrame{
    JPanel panel_reproductor = new JPanel();
    URL urlArchivoMusica;
    Player reproductor;
    
    public reproductorvideo(){
        this.setResizable(false);
        setTitle("Empresa Triviño LTDA");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes\\LogoGrupoTrivino.png").getImage());
    }
    // FUNCIONAL //
    // EL PROBLEMA ES QUE SOLO REPRODUCE WAV //
    /*
    URL urlArchivoMusica;
    Player reproductor;
    public void reproductor_audio(){
        try{
            urlArchivoMusica= new URL ("file:/C:/Users/Paul Quezada/Documents/GitHub/G3_Metodologia_1_2021/videos/elpajarrako.wav");
            reproductor = Manager.createRealizedPlayer(urlArchivoMusica);
            Component controles = reproductor.getControlPanelComponent();

            if(controles!=null){
                this.add(controles);
                controles.setLocation(0,185);
                controles.setSize(320,15);
                //panel_reproductor.add(controles);
            }
            System.out.println("a");
            reproductor.start();
        }catch(Exception e){
            System.out.println("error al reproducir el mp3");
        }
    }
    */
}