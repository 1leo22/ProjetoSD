import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Cliente extends Thread{
	private static int contaPassos = 1;
	private static int contaCliente=0;



	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {

			String nomeServico = "PoupancaServico";
			int porta = 1099;


			Registry registry = LocateRegistry.getRegistry("192.168.11.5", porta);

			//cria um stub que recebe o servico contendo os metodos remotos do servidor
			PoupancaSimuladorInter stub = (PoupancaSimuladorInter) registry.lookup(nomeServico);



			//stub.adicionarCliente(cliente);
			try {
				if(stub.getCliente() == 0) {
					//while(stub.contaPassos() <= 6) {
					stub.setCliente(1);
					stub.setPassos(1);//2

					while(stub.contaPassos() == 2) {
						Mensagem.mensagemAguardaSegundoCliente();
					}

					stub.setValorInicial(Mensagem.entraValorInicial());
					stub.setPassos(1);//4

					while(stub.contaPassos() == 4) {}
					stub.setTaxaJuros(Mensagem.entraTaxaDeJuros());
					stub.setPassos(1);//6

					while(stub.contaPassos() == 6) {}

					Mensagem.mensagemFinalCliente1(stub.getValorInicial(), stub.getTaxaJuros(), stub.totalPoupado(), stub.jurosRecebido(), stub.montanteFinal());

					stub.zeraContador();

					//}
				}else
					if(stub.getCliente() == 1) {
						//while(stub.contaPassos() <= 6) {

						stub.setPassos(1);//3

						while(stub.contaPassos() == 3) {}

						stub.setAporteMensal(Mensagem.entraAporteMensal());
						stub.setPassos(1);//5


						while(stub.contaPassos() == 5) {}
						stub.setPrazo(Mensagem.entraPrazo());
						stub.setPassos(1);//7
						
						Mensagem.mensagemFinalCliente2(stub.getAporteMensal(), stub.getPrazo(), stub.totalPoupado(), stub.jurosRecebido(), stub.montanteFinal());
						
						stub.zeraContador();
					}
			}catch(Exception e) {
				stub.zeraContador();
				e.printStackTrace();
			}

			//}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}



}
