package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

import swing.action.JAboutMenuAction;
import swing.action.JAgendarMenuAction;
import swing.action.JConsultarAgendaMenuAction;
import swing.action.JSairMenuAction;

public class Agenda {

	public static final String PRINCIPAL = "PRINCIPAL";

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Agenda");
		CardLayout cards = new CardLayout();
		JPanel principal = new JPanel(cards);

		JPanel consultar = new JConsultarAgendaPanel(principal, cards);
		JPanel agendar = new JAgendarPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel("Consultório");
		vazio.add(label);

		principal.add(vazio, PRINCIPAL);
		principal.add(agendar, JAgendarMenuAction.AGENDAR1);
		principal.add(consultar, JConsultarAgendaMenuAction.CONSULTAR1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("pindorama.jpg").getImage());

		frame.getContentPane().add(principal);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu agenda = new JMenu("Agenda");
		menubar.add(agenda);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);

		Action exitAction = new JSairMenuAction();
		file.add(exitAction);

		Action consultarAction = new JConsultarAgendaMenuAction(principal, cards);
		agenda.add(consultarAction);
		Action agendarAction = new JAgendarMenuAction(principal, cards);
		agenda.add(agendarAction);
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);

		frame.setJMenuBar(menubar);

		frame.setMinimumSize(new Dimension(400, 200));

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
