import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClienteImp extends UnicastRemoteObject implements ClienteInter{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double valorInicial;
	private double aporteMensal;
	private double taxaJuros;
	private int prazo;
	
	public Scanner sc = new Scanner (System.in);
	
	public ClienteImp() throws RemoteException{
		super();
	}

	@Override
	public void setValorInicial() throws RemoteException {
		//System.out.print("Entre com o valor inicial: ");
		//this.valorInicial = sc.nextDouble();
		this.valorInicial = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor inicial"));
		
	}

	@Override
	public void setAporteMensal() throws RemoteException {
		//System.out.print("Entre com o aporte mensal: ");
		//this.aporteMensal = sc.nextDouble();
		this.aporteMensal = Double.parseDouble(JOptionPane.showInputDialog("Entre com o aporte mensal"));
		
	}

	@Override
	public void setTaxaJuros() throws RemoteException {
		//System.out.print("Entre com a taxa de juros: ");
		//this.taxaJuros = sc.nextDouble()/100;
		this.taxaJuros = Double.parseDouble(JOptionPane.showInputDialog("Entre com a taxa de juros"));
		
	}

	@Override
	public void setPrazo() throws RemoteException {
		//System.out.print("Entre com o prazo: ");
		//this.prazo = sc.nextInt();
		this.prazo = Integer.parseInt(JOptionPane.showInputDialog("Entre com o prazo"));
		
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

	@Override
	public void recebeMensagem(String mensagem) throws RemoteException {
		//System.out.printf(mensagem);
		JOptionPane.showMessageDialog(null, mensagem);
		
		
	}

	@Override
	public void aguardandoOutroCliente(boolean troca) throws RemoteException {
		while(!troca) {
			JOptionPane.showMessageDialog(null, "Aguarde o outro Cliente!!");
		}
		
		
	}
	
	

}
