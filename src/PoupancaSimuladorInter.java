import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PoupancaSimuladorInter extends Remote{
	
	public void iniciarProcesso() throws RemoteException;
	public double totalPoupado() throws RemoteException;

	public double jurosRecebido() throws RemoteException;
	
	public double montanteFinal() throws RemoteException;
	
	public void adicionarCliente(ClienteInter cliente) throws RemoteException;
	
	public void enviaMensagem(String mensagem) throws RemoteException;
}
