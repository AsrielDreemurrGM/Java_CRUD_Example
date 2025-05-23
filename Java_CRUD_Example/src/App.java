import javax.swing.JOptionPane;

import br.com.eaugusto.dao.ClientMapDAO;
import br.com.eaugusto.dao.IClientDAO;
import br.com.eaugusto.domain.Client;

public class App {
	
	private static IClientDAO iClientDAO;

	public static void main(String[] args) {
		iClientDAO = new ClientMapDAO();
		
		String option = showDashboardPrompt();
		
		while (!isValidOption(option)) {
			if (option == null) {
				exit();
			}
			option = showInvalidOptionPrompt();
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
			
			option = showDashboardPrompt();
		}
		
		if (isRegisterOption(option)) {
			JOptionPane.showInputDialog(null, "Opção " + option,"Cadastro", JOptionPane.INFORMATION_MESSAGE);			
		}
	}

	private static String showDashboardPrompt() {
		return JOptionPane.showInputDialog(
		        null,
		        "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, "
		        + "4 para alteração ou 5 para sair.",
		        "Dashboard",
		        JOptionPane.INFORMATION_MESSAGE
		    );
	}

	private static String showInvalidOptionPrompt() {
		return JOptionPane.showInputDialog(
				null,
				"""
				Opção inválida. Por favor, escolha entre:
				1 - Cadastrar 2 - Consultar 3 - Excluir 4 - Alterar 5 - Sair
				""",
				"Opção Inválida",
				JOptionPane.WARNING_MESSAGE);
	}

	private static void search(String data) {
		if(data == null || data.trim().isEmpty()) {
			JOptionPane.showMessageDialog(
					null,
					"CPF não pode estar vazio.",
					"Erro de Entrada",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Client client = iClientDAO.search(data);
		if (client != null) {
			JOptionPane.showMessageDialog(
					null,
					"Cliente encontrado. \n"
					+ client.toString(),
					"Informações do Cliente",
					JOptionPane.INFORMATION_MESSAGE);			
		} else {
			JOptionPane.showMessageDialog(
					null,
					"Cliente não encontrado.",
					"Erro - Cliente Não Encontrado",
					JOptionPane.WARNING_MESSAGE);	
		}
	}

	private static boolean isSearchOption(String option) {
		return "2".equals(option);
	}

	private static void register(String data) {
		if (data == null || data.trim().isEmpty()) {
			JOptionPane.showMessageDialog(
					null,
					"Nenhum dado inserido.",
					"Erro de Entrada",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String[] splitData = data.split(",");
		
		for (int i = 0; i < splitData.length; i++) {
			String field = splitData[i].trim();
			if (field.isEmpty()) {
				splitData[i] = "Não informado";
			} else {
				splitData[i] = field;
			}
		}
		
		while (splitData.length < 7) {
			int originalLength = splitData.length;
			splitData = java.util.Arrays.copyOf(splitData, 7);
			for (int i = originalLength; i < 7; i++) {
				splitData[i] = null;
			}
		}
		
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
			JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);			
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
		if (option == null || option.trim().isEmpty()) {
			return false;
		}
		
		int optionNumber = Integer.parseInt(option);
		return optionNumber >= 1 && optionNumber <= 5;
	}

	private static boolean isRegisterOption(String option) {
		return "1".equals(option);
	}
}
