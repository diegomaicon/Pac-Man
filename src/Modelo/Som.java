package Modelo;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 * Created by Diego on 20/05/2017.
 */
public class Som {
    Clip comendo;
    Clip fruit;
    Clip gamOver;

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



            // Pacman Fruta som
            url = this.getClass().getClassLoader().getResource("Audio/fruit.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            fruit = AudioSystem.getClip();
            fruit.open(audioIn);

            // Game Over
            url = this.getClass().getClassLoader().getResource("Audio/fim.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            gamOver = AudioSystem.getClip();
            gamOver.open(audioIn);

        }catch(Exception e){}
    }

    /**
     * Se já jogando, não comece a tocar novamente
     */
    public synchronized void comendoMoeda() {
        /* Se já estiver jogando, não comece a tocar novamente! */
        if (!stopped)
            return;
        stopped=false;
        comendo.stop();
        comendo.setFramePosition(0);
        comendo.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Não reproduz som quando não tem moeda
     */
    public synchronized void parado(){
        stopped=true;
        comendo.stop();
        comendo.setFramePosition(0);
    }

    /**
     * Reproduz com quando come Bônus
     */
    public synchronized void comendoFruta(){
        fruit.stop();
        fruit.setFramePosition(0);
        fruit.loop(0);
    }

    /**
     * Reproduz som fim de Jogo
     */
    public synchronized void gameOver() {
        gamOver.setFramePosition(0);
        gamOver.loop(0);
    }
}