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
// NO FUNCIONA :C //
/////////////////////


public class reproductorvideo extends JFrame{
    JPanel panel_reproductor = new JPanel();
    URL urlArchivoMusica;
    Player reproductor;
    
    public reproductorvideo(){
        setTitle("Empresa Triviño LTDA");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try{
            urlArchivoMusica= new URL ("file:/C:/Users/Paul Quezada/Documents/GitHub/G3_Metodologia_1_2021/videos/elpajarrako.wav");
            reproductor = Manager.createRealizedPlayer(urlArchivoMusica);
            Component controles = reproductor.getControlPanelComponent();

            if(controles!=null){
                panel_reproductor.add(controles);
                controles.setLocation(0,185);
                controles.setSize(320,25);
                //panel_reproductor.add(controles);
            }
            System.out.println("a");
            reproductor.start();
        }catch(Exception e){
            System.out.println("error al reproducir el mp3");
        }
    }
    /*private void componentes(){

        URL url = null;
        try {
            url = new URL("file:///C:/Users/Paul Quezada/Documents/GitHub/G3_Metodologia_1_2021/videos/elpajarrako.mjpeg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(reproductorvideo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{

            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
            mediaPlayer = Manager.createRealizedPlayer(url);
            video = mediaPlayer.getVisualComponent();
            video.setSize(800,800);
            video.setVisible(true);
            panel_reproductor.add(video);
            mediaPlayer.start();
            

        }catch(IOException | NoPlayerException | CannotRealizeException ex){
            Logger.getLogger(reproductorvideo.class.getName()).log(Level.SEVERE,null, ex);
        }
    }*/

    /////////////////
    // No funciona //
    ////////////////

    /*private void crearesena(){
        Platform.runLater(new Runnable(){
            @Override

            public void run(){
                File file = new File("C:\\Users\\Paul Quezada\\Documents\\GitHub\\G3_Metodologia_1_2021\\videos\\elpajarrako.mp4");
                MediaPlayer oracleVid = MediaPlayer(new Media(file.toURI().toString()));
                panel_reproductor.setScene(new Scene (new Group(new MediaPlayer(oracleVid))));
                oracleVid.setVolumeLevel(0.7);
                oracleVid.setCycleCount(MediaPlayer.INDEFINITE);
                oracleVid.play();
            }});
        }
    }*/
    /////////////////
    // NO FUNCIONA //
    /////////////////
    /*private void reproducirvideo(){
        rep = new Player (new FileInputStream("C:\\Users\\Paul Quezada\\Documents\\GitHub\\G3_Metodologia_1_2021\\videos\\elpajarrako.mp4"));
        rep.play();
    }*/

    // FUNCIONAL //
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