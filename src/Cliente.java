import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			String nomeServico = "PoupancaServico";
			int porta = 1099;
			ClienteInter cliente = new ClienteImp();
			String ip = JOptionPane.showInputDialog("Entre com o número do IP:");
			
			Registry registry = LocateRegistry.getRegistry(ip, porta);
			
			//cria um stub que recebe o servico contendo os metodos remotos do servidor
			PoupancaSimuladorInter stub = (PoupancaSimuladorInter) registry.lookup(nomeServico);
			
			
			//stub.setTudo(1000, 500, 0.6, 12, cliente);
			stub.adicionarCliente(cliente);
			
			
			//System.out.printf("%.2f\n",stub.getJurosRecebido());
			//System.out.printf("%.2f",stub.getMontanteFinal());
						
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
