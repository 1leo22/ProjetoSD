package com.suam.Cliente;

import javax.swing.JOptionPane;

public class Mensagem {
	static String mensagem;

	
	/*=====================================================================================================================
	 *  									METODO PARA VALIDAÇÃO DOS DADOS
	 * Método para validar as entradas do cliente
	 * Ex: Valor negativo e nulos, alem de pontos e caracteres invalidos.
	 */
	public static boolean validaEntrada(String entrada) {

		boolean retorno=false;

		try {
			if((Double.parseDouble(entrada) <= 0) ||  (!entrada.matches("\\d*[.]?[0-9]*"))) {
				retorno = false;
			}else {
				retorno = true;
			}
		}catch(Exception e) {
			retorno = false;
		}
		return retorno;

	}

	/*=====================================================================================================================
	 * 									METODOS PARA ENTRADA DE DADOS
	 */
	public static void mensagemAguardaSegundoCliente() {
		JOptionPane.showMessageDialog(null, "Aguarde o segundo cliente logar!!");
	}

	public static String entraValorInicial() {
		mensagem = JOptionPane.showInputDialog(null, "Entre com o valor incial." + "\n" + "Ex: R$ 1000,00").replace(",",".");

		if(!validaEntrada(mensagem)) {
			mensagemErro();
			entraValorInicial();
		}
		return mensagem;
	}

	public static String entraAporteMensal() {
		mensagem = JOptionPane.showInputDialog(null, "Entre com o aporte mensal." + "\n" + "Ex: R$ 500,00").replace(",",".");
		
		if(!validaEntrada(mensagem)) {
			mensagemErro();
			entraAporteMensal();
		}
		
		return mensagem;
	}

	public static String entraTaxaDeJuros() {
		mensagem = JOptionPane.showInputDialog(null, "Entre com a taxa de juros." + "\n" + "Ex: 0.6%").replace(",",".");
		
		if(!validaEntrada(mensagem)) {
			mensagemErro();
			entraTaxaDeJuros();
		}
		
		return mensagem;
	}

	public static String entraPrazo() {
		
		mensagem = JOptionPane.showInputDialog(null, "Entre com o prazo e meses." + "\n" + "Ex: 12 meses");
		
		try {
			int valor = Integer.parseInt(mensagem);
			if(valor <= 0) {
				mensagemErro();
				entraPrazo();
			}
		}catch(Exception e) {
			mensagemErro();
			entraPrazo();
		}
		
		return mensagem;
		
	}
	/*=====================================================================================================================
	 * 									METODO PARA EXIBIR MENSAGEM DE ERRO
	 */
	public static void mensagemErro() {
		JOptionPane.showMessageDialog(null,"Insira um valor válido!!");
	}

	/*=====================================================================================================================
	 * 									METODOS PARA RESULTADO FINAL
	 */	
	
	public static void mensagemFinalCliente1(double valorInicial, double taxaDeJuros, double totalPoupado, double jurosRecebidos, double montanteFinal) {
		JOptionPane.showMessageDialog(null, "------------------Cliente 1--------------------\n"
				+ "-------------Valores Inseridos-------------\n"
				+ "Valor Inicial: " + String.format("%.2f",valorInicial) + "\n" 
				+ "Taxa de Juros: " + String.format("%.1f",taxaDeJuros) + "\n"
				+"----------------Resultado final-------------\n"
				+ "Total poupado: " + String.format("%.2f",totalPoupado) + "\n"
				+ "Juros recebidos: "+ String.format("%.2f",jurosRecebidos) + "\n"
				+ "Montante final: " + String.format("%.2f",montanteFinal) + "\n"
				+ "----------------------------------------------");

	}
	public static void mensagemFinalCliente2(double aporteMensal, Integer prazo, double totalPoupado, double jurosRecebidos, double montanteFinal) {
		JOptionPane.showMessageDialog(null, "------------------Cliente 2--------------------\n"
				+ "-------------Valores Inseridos-------------\n"
				+ "Aporte Mensal: " + String.format("%.2f",aporteMensal) + "\n" 
				+ "Pazo: " + prazo.toString() + "\n" 
				+"----------------Resultado final-------------\n"
				+ "Total poupado: " + String.format("%.2f",totalPoupado) + "\n"
				+ "Juros recebidos: "+ String.format("%.2f",jurosRecebidos) + "\n"
				+ "Montante final: " + String.format("%.2f",montanteFinal) + "\n"
				+ "-------------------------------------------------");


	}


}
