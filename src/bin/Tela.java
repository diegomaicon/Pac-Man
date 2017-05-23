package bin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_LEFT;
public class Tela extends JFrame{
   private JPanel painel;
   public static JTextArea texto;
   public static JLabel label;

	/**
	 * Metodo construdor da tela principal
	 */
   public Tela(){
	   label = new JLabel("Score: ");
	   label.setFont(new Font("Consolas", Font.BOLD, 30));
	   painel = new JPanel();
	   texto = new JTextArea();

	   painel.setLayout(new BorderLayout());

	   painel.add(texto, BorderLayout.NORTH);
	   painel.add(label, BorderLayout.SOUTH);
	   this.add(painel);

   }



}
