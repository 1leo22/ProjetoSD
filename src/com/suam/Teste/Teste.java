package com.suam.Teste;

import com.suam.Cliente.Mensagem;

public class Teste {

	public static void main(String[] args) {
		
		//String m = JOptionPane.showInputDialog(null, "Insira um valor");
		
		//boolean teste;
		
        
        
      /* do {
    	   
    	   String m = JOptionPane.showInputDialog(null, "Insira um valor");
    	   System.out.println(m);
    	   teste = m.matches("[1-9]\\.?\\d*");
           System.out.println("Apenas numeros?: "+teste);
       }while(!teste);
        */
		
        
      /*   
        boolean numero = numero = "a".matches("\\d");
        System.out.println("Possui n�mero: "+numero);
         
numero = "2".matches("\\d");
        System.out.println("Possui n�mero: "+numero);
         
        boolean letrasNumeros = "A2".matches("\\w\\d"); 
        System.out.println("Possui letras e n�meros? "+letrasNumeros);
         
        boolean espaco = " ".matches("\\s");
        System.out.println("Possui espa�o? "+espaco);

*/
		Mensagem.entraValorInicial();
		Mensagem.entraAporteMensal();
		Mensagem.entraTaxaDeJuros();
		Mensagem.entraPrazo();		
		
		
		
	}

}
