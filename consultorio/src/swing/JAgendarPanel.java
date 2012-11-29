package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.action.JAgendarPanelAction;

public class JAgendarPanel extends JPanel {

	public JAgendarPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Nome paciente:"));
		JTextField nome = new JTextField(8);
		add(nome);
		add(new JButton(new JAgendarPanelAction(principal, cards, nome)));
		add(new JButton("Cancelar"));
	}

	public JAgendarPanel() {
		this(null, null);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Consultório - Teste do Painel Agendr");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JAgendarPanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
