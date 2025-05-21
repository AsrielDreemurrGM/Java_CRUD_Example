import javax.swing.JOptionPane;

import br.com.eaugusto.dao.ClientMapDAO;
import br.com.eaugusto.dao.IClientDAO;
import br.com.eaugusto.domain.Client;

public class App {
	
	private static IClientDAO iClientDAO;

	public static void main(String[] args) {
		iClientDAO = new ClientMapDAO();
		
		String option = JOptionPane.showInputDialog(
				null, 
				"Digite 1 para cadastro, 2 para consultar, 3 para exclusão, "
				+ "4 para alteração ou 5 para sair.",
				"Dashboard", 
				JOptionPane.INFORMATION_MESSAGE
				);
		
		while (!isValidOption(option)) {
			option = JOptionPane.showInputDialog(
					null, 
					"Opção inválida. \n"
					+ "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, "
					+ "4 para alteração ou 5 para sair.",
					"Dashboard - Tente Novamente", 
					JOptionPane.INFORMATION_MESSAGE
					);
		}
		
		while (isValidOption(option)) {
			if (isExitOption(option)) {
				exit();
			} else if (isRegisterOption(option)) {
				String data = JOptionPane.showInputDialog(
						null, 
						"Digite os dados do cliente separados por vírgula, conforme o exemplo: \n"
						+ "Nome, CPF, Telefone, Endereço, Número do Endereço, Cidade e Estado",
						"Cadastrar", 
						JOptionPane.INFORMATION_MESSAGE
						);
				register(data);
			} else if (isSearchOption(option)) {
				String data = JOptionPane.showInputDialog(
						null, 
						"Digite o CPF:",
						"Pesquisar", 
						JOptionPane.INFORMATION_MESSAGE
						);
				search(data);
			}
			
			option = JOptionPane.showInputDialog(
					null, 
					"Opção inválida. \n"
					+ "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, "
					+ "4 para alteração ou 5 para sair.",
					"Dashboard - Tente Novamente", 
					JOptionPane.INFORMATION_MESSAGE
					);
		}
		
		if (isRegisterOption(option)) {
			JOptionPane.showInputDialog(null, "Opção " + option,"Cadastro", JOptionPane.INFORMATION_MESSAGE);			
		}
	}

	private static void search(String data) {
		Client client = iClientDAO.search(data);
		if (client != null) {
			JOptionPane.showMessageDialog(
					null,
					"Cliente encontrado: \n"
					+ client.toString(),
					"Informações do Cliente",
					JOptionPane.INFORMATION_MESSAGE);			
		} else {
			JOptionPane.showMessageDialog(
					null,
					"Cliente não encontrado.",
					"Erro - Cliente Não Encontrado",
					JOptionPane.INFORMATION_MESSAGE);	
		}
	}

	private static boolean isSearchOption(String option) {
		return "2".equals(option);
	}

	private static void register(String data) {
		String[] splitData = data.split(",");
		
		Client client = new Client(
				splitData[0], 
				splitData[1], 
				splitData[2], 
				splitData[3], 
				splitData[4], 
				splitData[5],
				splitData[6]);
		
		boolean isRegistered = iClientDAO.register(client);
		if (isRegistered) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);			
		} else {
			JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);			
		}
	}

	private static boolean isExitOption(String option) {
		return "5".equals(option);
	}

	private static void exit() {
		JOptionPane.showMessageDialog(null, "Até logo :) ","Saindo", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	private static boolean isValidOption(String option) {
		int optionNumber = Integer.parseInt(option);
		return optionNumber >= 0 && optionNumber <= 5;
	}

	private static boolean isRegisterOption(String option) {
		return "1".equals(option);
	}

}
