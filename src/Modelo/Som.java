package Modelo;


import java.net.URL;
import javax.sound.sampled.*;

/**
 * Created by Diego on 20/05/2017.
 */
public class Som {
    Clip comendo;

    /* Manter o controle de se ou não o som de comer está jogando */
    boolean stopped;

    public Som() {
        stopped = true;
        URL url;
        AudioInputStream audioIn;

        try {
            // Pacman comendo som
            url = this.getClass().getClassLoader().getResource("Audio/nomnom.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            comendo = AudioSystem.getClip();
            comendo.open(audioIn);
        }catch(Exception e){}
    }

   /* Se já jogando, não comece a tocar novamente*/
    public void comendoMoeda(){
        /* Se já estiver jogando, não comece a tocar novamente! */
        if (!stopped)
            return;

        stopped=false;
        comendo.stop();
        comendo.setFramePosition(0);
        comendo.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void parado(){
        stopped=true;
        comendo.stop();
        comendo.setFramePosition(0);
    }
}