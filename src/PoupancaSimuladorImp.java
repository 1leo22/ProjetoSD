import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class PoupancaSimuladorImp implements PoupancaSimuladorInter{
	private static int cont;
	private static Map<Integer, ClienteInter> clienteMap;
	private static int contaPassos=0;


	private double totalPoupado;
	private double jurosRecebido;
	private double montanteFinal;

	public PoupancaSimuladorImp() {
		clienteMap = new HashMap <Integer, ClienteInter>();
		cont = 0;
	}





	@Override
	public double totalPoupado() throws RemoteException{
		double valorInicial = clienteMap.get(0).getValorInicial();
		double aporteMensal = clienteMap.get(1).getAporteMensal();
		System.out.println("-------Funcao Total Poupado------");
		System.out.println("Valor Inicial: "+ valorInicial);
		System.out.println("Aporte Mensal: "+ aporteMensal);
		System.out.println("---------------------------------");
		int prazo = clienteMap.get(1).getPrazo();
		//this.totalPoupado = this.valorInicial + this.aporteMensal * this.prazo;
		return this.totalPoupado = valorInicial + aporteMensal * prazo;

	}




	@Override
	public double jurosRecebido()  throws RemoteException{		

		double aux=0.0;
		double valorInicial = clienteMap.get(0).getValorInicial();
		double aporteMensal = clienteMap.get(1).getAporteMensal();
		double taxaJuros = clienteMap.get(0).getTaxaJuros();
		int prazo = clienteMap.get(1).getPrazo();

		System.out.println("------Funcao Juros Recebido-----");
		System.out.println("Valor Inicial: "+ valorInicial);
		System.out.println("Aporte Mensal: "+ aporteMensal);
		System.out.println("Taxa Juros: "+ taxaJuros);
		System.out.println("Prazo: "+ prazo);
		System.out.println("--------------------------------");

		for(int i = 1; i <= prazo; i++) {
			if(i == 1) {
				this.jurosRecebido = valorInicial * taxaJuros;
				aux = aporteMensal + this.jurosRecebido + valorInicial;
			}else {
				aux += aux * taxaJuros + aporteMensal;

			}
		}
		return this.jurosRecebido = aux - this.totalPoupado;
	}




	@Override
	public double montanteFinal()  throws RemoteException{
		return this.montanteFinal = this.totalPoupado + this.jurosRecebido;
	}



	@Override
	public void adicionarCliente(ClienteInter cliente) throws RemoteException {	
		if(clienteMap.size() == 0){
			clienteMap.put(cont, cliente);
			enviaMensagem("Aguarde o segundo cliente....");
			cont++;
		}else
			if(clienteMap.size() == 1){
				clienteMap.put(cont, cliente);
				enviaMensagem("Segundo cliente logado com sucesso!!!");
				cont++;
				System.out.println(cont);
			}
		if(clienteMap.size() == 2){
			iniciarProcesso();
		}	
	}




	@Override
	public void iniciarProcesso() throws RemoteException {
		/*clienteMap.get(0).setValorInicial();
		clienteMap.get(1).setAporteMensal();
		clienteMap.get(0).setTaxaJuros();
		clienteMap.get(1).setPrazo();*/
		
		while(contaPassos < 4) {
			if(contaPassos == 0) {
				clienteMap.get(1).recebeMensagem("Cliente 2 - Aguardando outro Cliente!!");
				clienteMap.get(0).setValorInicial();
				contaPassos++;
				
			}
			if(contaPassos == 1) {
				clienteMap.get(0).recebeMensagem("Cliente 1 - Aguardando outro Cliente!!");
				clienteMap.get(1).setAporteMensal();
				contaPassos++;

			}
			if(contaPassos == 2) {
				clienteMap.get(1).recebeMensagem("Cliente 2 - Aguardando outro Cliente!!");
				clienteMap.get(0).setTaxaJuros();
				contaPassos++;

			}
			if(contaPassos == 3) {
				clienteMap.get(0).recebeMensagem("Cliente 1 - Aguardando outro Cliente!!");
				clienteMap.get(1).setPrazo();
				contaPassos++;

			}		
		}
		enviaMensagem("calculoFinal");
	}








	@Override
	public void enviaMensagem(String mensagem) throws RemoteException {
		if(cont == 0){
				clienteMap.get(cont).recebeMensagem(mensagem);
		}else 
			if (cont == 1){
				clienteMap.get(cont).recebeMensagem(mensagem);
			}else{
					clienteMap.get(0).recebeMensagem(
							"------------------Cliente 1-----------------\n"+
							"Valor Inicial: "+ clienteMap.get(0).getValorInicial()+"\n"+
							"Taxa de Juros: "+ clienteMap.get(0).getTaxaJuros() +"\n"+
							"TOTAL POUPADO: "+ totalPoupado()+"\n"+
							"JUROS RECEBIDO: "+ jurosRecebido()+"\n"+
							"MONTANTE FINAL: "+ montanteFinal()+"\n"
					);	

					clienteMap.get(1).recebeMensagem(
							"------------------Cliente 2-----------------\n"+
							"Aporte Mensal: "+ clienteMap.get(1).getAporteMensal()+"\n"+
							"Prazo: "+ clienteMap.get(1).getPrazo() +"\n"+
							"TOTAL POUPADO: "+ totalPoupado()+"\n"+
							"JUROS RECEBIDO: "+ jurosRecebido()+"\n"+
							"MONTANTE FINAL: "+ montanteFinal()+"\n"
					);	


				}


	}





}
