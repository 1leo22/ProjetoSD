import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClienteInter extends Remote{
	
	public void setValorInicial() throws RemoteException;
	public void setAporteMensal() throws RemoteException;
	public void setTaxaJuros() throws RemoteException;
	public void setPrazo() throws RemoteException;
	
	
	public double getValorInicial() throws RemoteException;
	public double getAporteMensal() throws RemoteException;
	public double getTaxaJuros() throws RemoteException;
	public int getPrazo() throws RemoteException;
	public void aguardandoOutroCliente(boolean troca) throws RemoteException;
	
	public void recebeMensagem(String mensagem) throws RemoteException;
	
}
