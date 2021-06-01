package Vista;

import javax.swing.*;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;


public class reproductorvideo extends javax.swing.JFrame {
	// Declaracion de Variables
    private javax.swing.JToggleButton btnMute;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JSlider sldProgress;
    private javax.swing.JSlider sldVolumen;
    // Termino de declaracion de variables
    
    private EmbeddedMediaPlayerComponent player;
    private String file;
    
    static{
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");

        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }
    //bandera para controlar la reproduccion de video y el cambio en el avance de video
    private boolean band = true;

    public reproductorvideo() {
        componentes();
        setSize(800,800);
        setTitle( "Triviño LTDA");//nombre de reproductor
        setResizable(false);//No sea modificable el frame
        setLocationRelativeTo(null);//centrar en pantalla
        // Icono de la Ventana
        setIconImage(new ImageIcon("imagenes\\LogoGrupoTrivino.png").getImage());
        player = new EmbeddedMediaPlayerComponent();
        //se añade reproductor 
        jPanel2.add(player);        
        player.setSize(jPanel2.getSize());                
        player.setVisible(true);                
        //slider control de volumen
        sldVolumen.setMinimum(0);
        sldVolumen.setMaximum(100);
        //slider control progreso
        sldProgress.setMinimum(0);
        sldProgress.setMaximum(100);
        sldProgress.setValue(0);
        sldProgress.setEnabled(false);
        
        file = "videos//elpajarrako.mp4";                                     
        btnPlay.doClick();

        //Control de reproduccion
        btnPlay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (file!=null){                    
                    player.getMediaPlayer().playMedia(file);    
                    sldVolumen.setValue(  player.getMediaPlayer().getVolume() );
                    sldProgress.setEnabled(true);
                }
            }
        }); 

        //Control de pausa
        btnPause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
               player.getMediaPlayer().setPause( player.getMediaPlayer().isPlaying()?true:false );                                   
            }
        }); 

        //Control detener reproduccion
        btnStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
              player.getMediaPlayer().stop();   
              sldProgress.setValue(0);
              sldProgress.setEnabled(false);
              setTitle("VLCJ Player");
            }
        }); 

       //Control silenciar 
       btnMute.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();                
                player.getMediaPlayer().mute( abstractButton.getModel().isSelected() );                
            }
        });

        //Control slider cambiar volumen
        sldVolumen.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                Object source = e.getSource();                                
                player.getMediaPlayer().setVolume( ((JSlider) source).getValue() );
            }            
        });

        //Listener de reproductor para mostrar el progreso en la reproduccion del video 
        player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void positionChanged(MediaPlayer mp, float pos)
            {
                if(band){
                    int value = Math.min(100, Math.round(pos * 100.0f));            
                    sldProgress.setValue(value);                                                    
                }
            }

            @Override
            public void finished(MediaPlayer mediaPlayer){

            }

        });

        //Listener para el slider progress
        sldProgress.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                band= false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                band = true;
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });

        //Control para cambiar a posicion de reproduccion
        sldProgress.addChangeListener(new ChangeListener(){

            @Override
            public synchronized void stateChanged(ChangeEvent e) {
                if( !band ){
                    Object source = e.getSource();                                
                    float np = ((JSlider) source).getValue() / 100f;                    
                    player.getMediaPlayer().setPosition(np);    
                }

            }            
        });

    }//end: constructor

    @SuppressWarnings("unchecked")
    private void componentes() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        sldProgress = new javax.swing.JSlider();
        jPanel4 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnMute = new javax.swing.JToggleButton();
        sldVolumen = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(sldProgress);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnPlay.setText("Play");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnPlay, gridBagConstraints);

        btnPause.setText("Pause");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnPause, gridBagConstraints);

        btnStop.setText("Stop");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnStop, gridBagConstraints);

        btnMute.setText("Mute");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnMute, gridBagConstraints);

        sldVolumen.setPreferredSize(new java.awt.Dimension(100, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(sldVolumen, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        pack();
    }
}