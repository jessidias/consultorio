package swing;

import javax.swing.*;

public class Agenda {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Agenda");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("TODO: completar painel");
		frame.getContentPane().add(label);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu agenda = new JMenu("Agenda");
		menubar.add(agenda);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);

		JMenuItem exit = new JMenuItem("Sair");
		file.add(exit);

		Action agendaAction = new JAgendarAction();
		agenda.add(agendaAction);
		Action aboutAction = new JAboutAction();
		help.add(aboutAction);

		frame.setJMenuBar(menubar);

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
