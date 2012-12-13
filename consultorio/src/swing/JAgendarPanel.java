package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.action.JAgendarPanelAction;
import swing.action.JAgendarPanelCloseAction;

public class JAgendarPanel extends JPanel {

	JTextField nomep;
	public JAgendarPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Nome do paciente:"));
		nomep = new JTextField(8);
		add(nomep);
		add(new JButton(new JAgendarPanelAction(principal, cards, nomep)));
		add(new JButton(new JAgendarPanelCloseAction(principal, cards)));
	}

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JAgendarPanel::setVisible %b\n", aFlag);
		nomep.setText("");
	}

	public JAgendarPanel() {
		this(null, null);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Consultório");
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
