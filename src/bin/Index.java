package bin;

import Lib.Execute;

import javax.swing.*;


public class Index {

	
	
	public static void main(String[] args){
		
		Execute ma = new Execute();//cria objeto classe
	    System.out.println("Iniciando..... ");
	    if (!ma.carregarMesa())  // Se o Arquivo n�o abrir o programa � encerrado
            JOptionPane.showMessageDialog(null, "Arquivo \"mesa.txt\" n�o encontrado ou n�o existe !");

        try {
			Execute e = new Execute();
			Thread threadExecuta = new Thread(e);
			threadExecuta.setPriority(Thread.MIN_PRIORITY);
			threadExecuta.start();
		   
	} catch (Exception e) {
		// TODO: handle exception
	}

	    return;
	}
}
