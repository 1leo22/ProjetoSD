import javax.swing.JOptionPane;

public class Mensagem {

	public static void mensagemAguardaSegundoCliente() {
		JOptionPane.showMessageDialog(null, "Aguarde o segundo cliente logar!!");
	}

	public static String entraValorInicial() {
		return JOptionPane.showInputDialog(null, "Entre com o valor incial." + "\n" + "Ex: 1000");
	}

	public static String entraAporteMensal() {
		return JOptionPane.showInputDialog(null, "Entre com o aporte mensal." + "\n" + "Ex: 500");
	}

	public static String entraTaxaDeJuros() {
		return JOptionPane.showInputDialog(null, "Entre com a taxa de juros." + "\n" + "Ex: 0.6%");
	}

	public static String entraPrazo() {
		return JOptionPane.showInputDialog(null, "Entre com o prazo e meses." + "\n" + "Ex: 12");
	}


	public static void mensagemFinalCliente1(double valorInicial, double taxaDeJuros, double totalPoupado, double jurosRecebidos, double montanteFinal) {
		JOptionPane.showMessageDialog(null, "------------------Cliente 1------------------\n"
				+ "-------------Valores Inseridos-------------\n"
				+ "Valor Inicial: " + String.format("%.2f",valorInicial) + "\n" 
				+ "Taxa de Juros: " + String.format("%.2f",taxaDeJuros) + "\n" 
				+ "Total poupado: " + String.format("%.2f",totalPoupado) + "\n"
				+ "Juros recebidos:"+ String.format("%.2f",jurosRecebidos) + "\n"
				+ "Montante final:" + String.format("%.2f",montanteFinal) + "\n"
				+ "--------------------------------------------");

	}
	public static void mensagemFinalCliente2(double aporteMensal, Integer prazo, double totalPoupado, double jurosRecebidos, double montanteFinal) {
		JOptionPane.showMessageDialog(null, "------------------Cliente 2------------------\n"
				+ "-------------Valores Inseridos-------------\n"
				+ "Valor Inicial: " + String.format("%.2f",aporteMensal) + "\n" 
				+ "Taxa de Juros: " + prazo.toString() + "\n" 
				+ "Total poupado: " + String.format("%.2f",totalPoupado) + "\n"
				+ "Juros recebidos:"+ String.format("%.2f",jurosRecebidos) + "\n"
				+ "Montante final:" + String.format("%.2f",montanteFinal) + "\n"
				+ "-----------------------------------------------");

		
	}


}
