package br.com.eaugusto.app;
import javax.swing.JOptionPane;

import br.com.eaugusto.dao.ClientMapDAO;
import br.com.eaugusto.dao.ClientSetDAO;
import br.com.eaugusto.dao.IClientDAO;
import br.com.eaugusto.dao.IProductDAO;
import br.com.eaugusto.dao.ProductMapDAO;
import br.com.eaugusto.domain.Client;
import br.com.eaugusto.domain.Product;
import br.com.eaugusto.ui.MenuHelper;
import br.com.eaugusto.ui.PromptHelper;

public class App {

	// Toggle this flag for quick switching between using Set or Map for storage
	private static final String NOTINFORMEDERROR = "Não informado";
	private static final String ENTRYERROR = "Erro de Entrada";
	boolean useMap = true;
	IClientDAO clientDAO = useMap ? new ClientMapDAO() : new ClientSetDAO();

	private static IClientDAO iClientDAO;
	private static IProductDAO iProductDAO;

	public static void main(String[] args) {

		iClientDAO = new ClientMapDAO();
		iProductDAO = new ProductMapDAO();

		int entityChoice = MenuHelper.showEntitySelection();

		boolean isClient = MenuHelper.isClientSelected(entityChoice);

		String option = MenuHelper.showDashboardPrompt();

		while (!MenuHelper.isValidOption(option)) {
			if (option == null) {
				PromptHelper.exitPrompt();
			}
			option = MenuHelper.showInvalidOptionPrompt();
		}

		while (MenuHelper.isValidOption(option)) {
			if (MenuHelper.isExitOption(option)) {
				PromptHelper.exitPrompt();
			} else if (MenuHelper.isRegisterOption(option)) {
				String data = JOptionPane.showInputDialog(
						null,
						isClient ?
								"Digite os dados do cliente separados por vírgula:\nNome, CPF, Telefone, Endereço, Número, Cidade, Estado" :
									"Digite os dados do produto separados por vírgula:\nNome, Código, Descrição, Valor, Marca",
									"Cadastrar", 
									JOptionPane.INFORMATION_MESSAGE
						);
				if (isClient) {
					register(data);

				} else {
					registerProduct(data);
				}
			} else if (MenuHelper.isSearchOption(option)) {
				String data = JOptionPane.showInputDialog(
						null, 
						isClient ? "Digite o CPF:" : "Digite o código do produto:",
								"Pesquisar", 
								JOptionPane.INFORMATION_MESSAGE
						);
				if (isClient) {
					search(data);
				} else {
					searchProduct(data);
				}
			} else if (MenuHelper.isDeleteOption(option)) {
				String codeOrCpf = JOptionPane.showInputDialog(
						null,
						isClient ? "Digite o CPF do cliente a excluir:" : "Digite o código do produto a excluir:",
								"Excluir",
								JOptionPane.INFORMATION_MESSAGE);
				if (isClient) {
					delete(codeOrCpf);
				} else {
					deleteProduct(codeOrCpf);
				}
			} else if (MenuHelper.isModifyOption(option)) {
				String codeOrCpf = JOptionPane.showInputDialog(
						null,
						isClient ? "Digite o CPF do cliente a alterar:" : "Digite o código do produto a alterar:",
								"Alterar",
								JOptionPane.INFORMATION_MESSAGE);
				if (isClient) {
					modify(codeOrCpf);
				} else {
					modifyProduct(codeOrCpf);
				}
			}
			option = MenuHelper.showDashboardPrompt();
		}
	}

	private static void search(String data) {
		if(data == null || data.trim().isEmpty()) {
			PromptHelper.showMissingCpfPrompt();
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
			PromptHelper.showClientNotFoundPrompt();
		}
	}

	private static void register(String data) {
		if (data == null || data.trim().isEmpty()) {
			PromptHelper.showNoValueInsertedPrompt();
			return;
		}

		String[] splitData = data.split(",");

		for (int i = 0; i < splitData.length; i++) {
			String field = splitData[i].trim();
			if (field.isEmpty()) {
				splitData[i] = NOTINFORMEDERROR;
			} else {
				splitData[i] = field;
			}
		}

		while (splitData.length < 7) {
			int originalLength = splitData.length;
			splitData = java.util.Arrays.copyOf(splitData, 7);
			for (int i = originalLength; i < 7; i++) {
				splitData[i] = NOTINFORMEDERROR;
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
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);			
		} else {
			JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);			
		}
	}

	private static void delete(String cpf) {
		if (cpf == null || cpf.trim().isEmpty()) {
			PromptHelper.showMissingCpfPrompt();
			return;
		}

		Client client = iClientDAO.search(cpf);
		if (client != null) {
			iClientDAO.delete(cpf);
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.", "Sucesso na Exclusão", JOptionPane.INFORMATION_MESSAGE);
		} else {
			PromptHelper.showClientNotFoundPrompt();
		}
	}

	private static void modify(String cpf) {
		if (cpf == null || cpf.trim().isEmpty()) {
			PromptHelper.showMissingCpfPrompt();
			return;
		}

		Client registeredClient = iClientDAO.search(cpf);
		if (registeredClient == null) {
			PromptHelper.showClientNotFoundPrompt();
			return;
		}

		String newData = JOptionPane.showInputDialog(
				null,
				"Digite os novos dados separados por vírgula: \nNome, Telefone, Endereço, Número, Cidade, Estado",
				"Alterar Cliente",
				JOptionPane.INFORMATION_MESSAGE);
		if (newData == null || newData.trim().isEmpty()) {
			PromptHelper.showNoValueInsertedPrompt();
			return;
		}

		String[] splitData = newData.split(",");
		for (int i = 0; i < splitData.length; i++) {
			String field = splitData[i].trim();
			splitData[i] = field.isEmpty() ? NOTINFORMEDERROR : field;
		}

		while (splitData.length < 6) {
			int originalLength = splitData.length;
			splitData = java.util.Arrays.copyOf(splitData, 6);
			for (int i = originalLength; i < 6; i++) {
				splitData[i] = NOTINFORMEDERROR;
			}
		}

		Client updatedClient = new Client(
				splitData[0],
				cpf,
				splitData[1],
				splitData[2],
				splitData[3],
				splitData[4],
				splitData[5]);
		iClientDAO.updateEntity(updatedClient);
		JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.", "Cliente Atualizado", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void searchProduct(String code) {
		if (code == null || code.trim().isEmpty()) {
			PromptHelper.showMissingProductPrompt();
			return;
		}

		Product product = iProductDAO.search(code);
		if (product != null) {
			JOptionPane.showMessageDialog(null, "Produto encontrado:\n" + product.toString(), "Informações do Produto", JOptionPane.INFORMATION_MESSAGE);
		} else {
			PromptHelper.showProductNotFoundPrompt();
		}
	}

	private static void registerProduct(String data) {
		if (data == null || data.trim().isEmpty()) {
			JOptionPane.showMessageDialog(
					null,
					"Nenhum dado inserido.",
					ENTRYERROR,
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		String[] splitData = data.split(",");

		for (int i = 0; i < splitData.length; i++) {
			String field = splitData[i].trim();
			if (field.isEmpty()) {
				splitData[i] = NOTINFORMEDERROR;
			} else {
				splitData[i] = field;
			}
		}

		while (splitData.length < 5) {
			int originalLength = splitData.length;
			splitData = java.util.Arrays.copyOf(splitData, 5);
			for (int i = originalLength; i < 5; i++) {
				splitData[i] = NOTINFORMEDERROR;
			}
		}

		try {
			double value = Double.parseDouble(splitData[3]);
			Product product = new Product(splitData[0], splitData[1], splitData[2], value, splitData[4]);
			boolean isRegistered = iProductDAO.register(product);
			if (isRegistered) {
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Produto já cadastrado.", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido para o campo 'Valor'.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void deleteProduct(String code) {
		if (code == null || code.trim().isEmpty()) {
			PromptHelper.showMissingProductPrompt();
			return;
		}

		Product product = iProductDAO.search(code);
		if (product != null) {
			iProductDAO.delete(code);
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.", "Sucesso na Exclusão", JOptionPane.INFORMATION_MESSAGE);
		} else {
			PromptHelper.showProductNotFoundPrompt();
		}
	}

	private static void modifyProduct(String code) {
		if (code == null || code.trim().isEmpty()) {
			PromptHelper.showMissingProductPrompt();
			return;
		}

		Product registeredProduct = iProductDAO.search(code);
		if (registeredProduct == null) {
			PromptHelper.showProductNotFoundPrompt();
			return;
		}

		String newData = JOptionPane.showInputDialog(
				null,
				"Digite os novos dados separados por vírgula:\nNome, Descrição, Valor, Marca",
				"Modificar Produto",
				JOptionPane.INFORMATION_MESSAGE);

		if (newData == null || newData.trim().isEmpty()) {
			PromptHelper.showNoValueInsertedPrompt();
			return;
		}

		String[] splitData = newData.split(",");
		for (int i = 0; i < splitData.length; i++) {
			String field = splitData[i].trim();
			splitData[i] = field.isEmpty() ? NOTINFORMEDERROR : field;
		}

		while (splitData.length < 4) {
			int originalLength = splitData.length;
			splitData = java.util.Arrays.copyOf(splitData, 4);
			for (int i = originalLength; i < 4; i++) {
				splitData[i] = NOTINFORMEDERROR;
			}
		}

		try {
			double value = Double.parseDouble(splitData[2]);
			Product updatedProduct = new Product(
					splitData[0],
					code,
					splitData[1],
					value,
					splitData[3]
					);

			iProductDAO.updateEntity(updatedProduct);
			JOptionPane.showMessageDialog(
					null,
					"Produto atualizado com sucesso.",
					"Produto Atualizado",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(
					null,
					"Valor inválido para o campo 'Valor'.",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
