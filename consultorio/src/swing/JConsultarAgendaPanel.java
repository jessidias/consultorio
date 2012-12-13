package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import swing.action.JConsultarAgendaPanelCancelAction;
import consultorio.AgendaDAO;
import consultorio.Agenda;
import consultorio.Pacientes;

@SuppressWarnings("serial")
public class JConsultarAgendaPanel extends JPanel {
	JTextArea dados;

	public JConsultarAgendaPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20, 60);
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JConsultarAgendaPanelCancelAction(principal, cards)));
	}

	public JConsultarAgendaPanel() {
		this(null, null);
	}

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JConsultarPanel::setVisible %b\n", aFlag);

		AgendaDAO ag = new AgendaDAO();
		List<consultorio.Pacientes> c = ag.findAgenda("Jessica Dias");
		if (c == null) {
			System.out.println("Nome do paciente não encontrado!");
			
		} else {
			System.out.println(c);
            String s = "";
            for (Pacientes operacao : c) {
                s += String.format(" %s\n", operacao.getNome_paciente());
			System.out.println(c);
			
		}
		dados.setText(s);

	}
	}
	private static void createAndShowGUI() {
		JFrame frame = new JFrame(
				"Consultório");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarAgendaPanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
		painel.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}