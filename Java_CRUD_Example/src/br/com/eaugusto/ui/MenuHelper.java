package br.com.eaugusto.ui;

import javax.swing.JOptionPane;

public class MenuHelper {

	private MenuHelper() {
		// Utility class, must not be instantiated.
	}

	private static final Object[] ENTITY_OPTIONS = {"Cliente", "Produto"};
	private static final String[] DASHBOARD_OPTIONS = {"1", "2", "3", "4", "5"};

	public static boolean isValidOption(String option) {
		if (option == null || option.trim().isEmpty()) return false;
		for (String validOption : DASHBOARD_OPTIONS) {
			if (validOption.equals(option.trim())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isRegisterOption(String option) {
		return "1".equals(option);
	}

	public static boolean isSearchOption(String option) {
		return "2".equals(option);
	}

	public static boolean isDeleteOption(String option) {
		return "3".equals(option);
	}

	public static boolean isModifyOption(String option) {
		return "4".equals(option);
	}

	public static boolean isExitOption(String option) {
		return "5".equals(option);
	}

	public static boolean isClientSelected(int entityChoice) {
		return entityChoice == 0;
	}

	public static int showEntitySelection() {
		return JOptionPane.showOptionDialog(
				null,
				"Você quer trabalhar com Cliente ou Produto?",
				"Escolha de Entidade",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				ENTITY_OPTIONS,
				ENTITY_OPTIONS[0]);
	}

	public static String showDashboardPrompt() {
		return JOptionPane.showInputDialog(
				null,
				"Escolha uma opção:\n"
						+ "1 - Cadastrar "
						+ "2 - Buscar "
						+ "3 - Excluir "
						+ "4 - Alterar "
						+ "5 - Sair",
						"Menu Principal",
						JOptionPane.QUESTION_MESSAGE);
	}

	public static String showInvalidOptionPrompt() {
		return JOptionPane.showInputDialog(
				null,
				"Opção inválida. Digite uma opção válida:\n"
						+ "1 - Cadastrar "
						+ "2 - Buscar "
						+ "3 - Excluir "
						+ "4 - Alterar "
						+ "5 - Sair",
						"Opção Inválida",
						JOptionPane.WARNING_MESSAGE);
	}
}
