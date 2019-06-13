import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class PoupancaSimuladorImp implements PoupancaSimuladorInter{
	private static int contaPassos=1;
	private static int contaCliente=0;

	private double totalPoupado;
	private double jurosRecebido;
	private double montanteFinal;

	private double valorInicial;
	private double aporteMensal;
	private double taxaJuros;
	private int prazo;


	public PoupancaSimuladorImp() {

	}

	
	/*---------------------------------------------------------------------------------------------*/
	/*
	 * Métodos get e set do cliente
	 * 
	 * */

	public void setValorInicial(String valorInicial) throws RemoteException {
		//System.out.print("Entre com o valor inicial: ");
		//this.valorInicial = sc.nextDouble();
		this.valorInicial = Double.parseDouble(valorInicial);

	}

	@Override
	public void setAporteMensal(String aporteMensal) throws RemoteException {
		//System.out.print("Entre com o aporte mensal: ");
		//this.aporteMensal = sc.nextDouble();
		this.aporteMensal = Double.parseDouble(aporteMensal);

	}

	@Override
	public void setTaxaJuros(String taxaDeJuros) throws RemoteException {
		//System.out.print("Entre com a taxa de juros: ");
		//this.taxaJuros = sc.nextDouble()/100;
		this.taxaJuros = Double.parseDouble(taxaDeJuros);

	}

	@Override
	public void setPrazo(String prazo) throws RemoteException {
		//System.out.print("Entre com o prazo: ");
		//this.prazo = sc.nextInt();
		this.prazo = Integer.parseInt(prazo);

	}

	@Override
	public double getValorInicial() throws RemoteException {
		// TODO Auto-generated method stub
		return this.valorInicial;
	}

	@Override
	public double getAporteMensal() throws RemoteException {
		// TODO Auto-generated method stub
		return this.aporteMensal;
	}

	@Override
	public double getTaxaJuros() throws RemoteException {
		// TODO Auto-generated method stub
		return this.taxaJuros;
	}

	@Override
	public int getPrazo() throws RemoteException {
		// TODO Auto-generated method stub
		return this.prazo;
	}

	
	
	
/*---------------------------------------------------------------------------------------------*/

	@Override
	public double totalPoupado() throws RemoteException{

		//this.totalPoupado = this.valorInicial + this.aporteMensal * this.prazo;
		return this.totalPoupado = this.valorInicial + this.aporteMensal * this.prazo;

	}

/*---------------------------------------------------------------------------------------------*/

	@Override
	public double jurosRecebido()  throws RemoteException{		

		double aux=0.0;
		
		for(int i = 1; i <= this.prazo; i++) {
			if(i == 1) {
				this.jurosRecebido = this.valorInicial * this.taxaJuros;
				aux = this.aporteMensal + this.jurosRecebido + this.valorInicial;
			}else {
				aux += aux * this.taxaJuros + this.aporteMensal;

			}
		}
		return this.jurosRecebido = aux - this.totalPoupado;
	}


/*---------------------------------------------------------------------------------------------*/

	@Override
	public double montanteFinal()  throws RemoteException{
		return this.montanteFinal = this.totalPoupado + this.jurosRecebido;
	}




/*---------------------------------------------------------------------------------------------*/
/*
 * Implementação dos metodos de para auxilio no controle de acesso entre os clientes
 * (non-Javadoc)
 * @see PoupancaSimuladorInter#setPassos(int)
 */
	
	@Override
	public void setPassos(int passos) throws RemoteException{
		this.contaPassos += passos;
	}

/*---------------------------------------------------------------------------------------------*/	
	
	@Override
	public int contaPassos() throws RemoteException{
		return contaPassos;
	}

	
/*---------------------------------------------------------------------------------------------*/	
	
	@Override
	public void setCliente(int valor) throws RemoteException{
		this.contaCliente += valor;
	}

/*---------------------------------------------------------------------------------------------*/	

	@Override
	public int getCliente() throws RemoteException{
		return this.contaCliente;
	}
  
	@Override
	public void zeraContador() throws RemoteException{
		this.contaCliente = 0;
		this.contaPassos = 1;
	}


}
