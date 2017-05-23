package bin;

import Lib.Execute;

import javax.swing.JOptionPane;


public class Index {

	
	
	public static void main(String[] args){
		
		Execute ma = new Execute();//cria objeto classe
	    System.out.println("Iniciando..... ");
	    if (!ma.carregarMesa())  // Se o Arquivo n�o abrir o programa � encerrado
	        JOptionPane.showMessageDialog(null,"Arquivo \"mesa.txt\" n�o encontrado ou n�o existe !");
	    	
	    
	   try {
		         /*
		          if (!ma.carregarAutomato())  // Se o Arquivo n�o abrir o programa � encerrado
		          JOptionPane.showMessageDialog(null,"Arquivo \"auto.txt\" nao encontrado ou nao existe ! ");
		          */

	   } catch (Exception e) {
		// TODO: handle exception
	}
	    
	   try {
		   ma.movimenta();
			
		   
	} catch (Exception e) {
		// TODO: handle exception
	}

	    return;
	}
}
