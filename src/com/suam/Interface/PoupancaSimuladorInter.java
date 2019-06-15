package com.suam.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PoupancaSimuladorInter extends Remote{
	
	
	/*Metodos para realizar o calculo 
	 * */
	
	public double totalPoupado() throws RemoteException;
	public double jurosRecebido() throws RemoteException;
	public double montanteFinal() throws RemoteException;

	
	
	/*Metodos para alternar entre os clientes
	 * */
	public void setPassos(int passos) throws RemoteException;
	public int contaPassos() throws RemoteException;
	public void setCliente(int valor) throws RemoteException;
	public int getCliente() throws RemoteException;
	
	
	/* Metodos get e set do cliente
	 * */
	public void setValorInicial(String valorInicial) throws RemoteException;
	public void setAporteMensal(String aporteMensal) throws RemoteException;
	public void setTaxaJuros(String taxaDeJuros) throws RemoteException;
	public void setPrazo(String prazo) throws RemoteException;
	
	
	public double getValorInicial() throws RemoteException;
	public double getAporteMensal() throws RemoteException;
	public double getTaxaJuros() throws RemoteException;
	public int getPrazo() throws RemoteException;
	
	public void zeraContador() throws RemoteException;
	

}
