package com.suam.Cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import com.suam.Interface.PoupancaSimuladorInter;

public class Cliente {


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {
			
			String nomeServico = "PoupancaServico";
			int porta = 1099;
			String ip = retornaIP();

		
			Registry registry = LocateRegistry.getRegistry(ip, porta);
			PoupancaSimuladorInter	stub = (PoupancaSimuladorInter) registry.lookup(nomeServico);
		
			//cria um stub que recebe o servico contendo os metodos remotos do servidor
		
			JOptionPane.showMessageDialog(null, "=====================================\n"
					+ "Conectado no servidor -> " +ip+"\n"
					+ "=====================================");


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
			JOptionPane.showMessageDialog(null, "ERRO 404 - Servidor não encontrado: \n" + e);
		}

	}
	
	
	

	public static String retornaIP() {

		String[] servidor = {"Servidor 1", "Servidor 2"};
		String op = (String) JOptionPane.showInputDialog(null, "Escolha o servidor", "Servidores", JOptionPane.QUESTION_MESSAGE,null, servidor, servidor[0]);

			if(op == servidor[0]) {
				return "192.168.11.7";
			}else {
				return "10.0.200.28";
			}
		
	}




}
