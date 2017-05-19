import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_LEFT;


public class Tela extends JFrame{
   JPanel painel;
   JTextArea texto;
   JLabel label;

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
