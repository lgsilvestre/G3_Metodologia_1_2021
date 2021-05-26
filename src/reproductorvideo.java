import java.awt.Component;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;

/////////////////////
// NO FUNCIONA :C //
/////////////////////


public class reproductorvideo extends JFrame{
    JPanel panel_reproductor = new JPanel();
    Player mediaPlayer;
    Component video;
    Component controles;
    
    public reproductorvideo(){
        setTitle("Empresa Triviño LTDA");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        componentes();
    }
    private void componentes(){

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
    }
}