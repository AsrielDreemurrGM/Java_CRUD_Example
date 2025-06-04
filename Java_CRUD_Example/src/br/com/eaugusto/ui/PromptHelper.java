package br.com.eaugusto.ui;

import javax.swing.JOptionPane;

public class PromptHelper {

	private PromptHelper() {
	    // Utility class, must not be instantiated.
	}
	
	public static String showDashboardPrompt() {
		return JOptionPane.showInputDialog(
				null,
				"Digite 1 para cadastro, 2 para consultar, 3 para exclusão, "
						+ "4 para alteração ou 5 para sair.",
						"Dashboard",
						JOptionPane.INFORMATION_MESSAGE
				);
	}

	public static String showInvalidOptionPrompt() {
		return JOptionPane.showInputDialog(
				null,
				"""
				Opção inválida. Por favor, escolha entre:
				1 - Cadastrar 2 - Consultar 3 - Excluir 4 - Alterar 5 - Sair
				""",
				"Opção Inválida",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void showMissingCpfPrompt() {
		JOptionPane.showMessageDialog(
				null,
				"CPF não pode estar vazio.",
				"CPF - Erro de Entrada",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void showMissingProductPrompt() {
		JOptionPane.showMessageDialog(
				null,
				"Código do produto não pode estar vazio.",
				"Erro de Entrada",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void showClientNotFoundPrompt() {
		JOptionPane.showMessageDialog(
				null,
				"Cliente não encontrado.",
				"Erro - Cliente Não Encontrado",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void showProductNotFoundPrompt() {
		JOptionPane.showMessageDialog(
				null,
				"Produto não encontrado.",
				"Erro - Produto Não Encontrado",
				JOptionPane.WARNING_MESSAGE);
	}

	public static void showNoValueInsertedPrompt() {
		JOptionPane.showMessageDialog(
				null,
				"Nenhum valor foi inserido.",
				"Erro de Entrada",
				JOptionPane.WARNING_MESSAGE);
	}
}

