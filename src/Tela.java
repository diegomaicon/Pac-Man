import javax.swing.*;



public class Tela extends JFrame{
   JPanel painel;
   JTextArea texto;
   JTextArea texto2;
   
   public Tela(){
	   
	   painel = new JPanel();
	   texto = new JTextArea();
	   texto2 = new JTextArea();
	   
	   painel.add(texto);
	   painel.add(texto2);
	   this.add(painel);
   }
   
   
}
