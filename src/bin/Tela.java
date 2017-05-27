package bin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_LEFT;
public class Tela extends JFrame{
   private JPanel painel;
   private JPanel pMesa;
   private JPanel pPlacar;

   public static JTextArea texto;
   public static JLabel label;
   public static JLabel gameOver;

	/**
	 * Metodo construdor da tela principal
	 */
   public Tela(){
       Icon icon = new ImageIcon(this.getClass().getResource("/icon/gameover.png"));
	   gameOver = new JLabel(icon);
	   label = new JLabel("Score: ");
	   gameOver.setVisible(false);
	   label.setFont(new Font("Consolas", Font.BOLD, 30));


	   painel = new JPanel();
	   pMesa = new JPanel();
	   pPlacar = new JPanel();
	   texto = new JTextArea();

	   pMesa.add(texto);

	   pPlacar.setLayout(new BorderLayout());
	   pPlacar.add(label,BorderLayout.WEST);
	   pPlacar.add(gameOver,BorderLayout.EAST);

	   painel.setLayout(new BorderLayout());
	   painel.add(pMesa, BorderLayout.NORTH);
	   painel.add(pPlacar, BorderLayout.SOUTH);

	   this.add(painel);

   }



}
