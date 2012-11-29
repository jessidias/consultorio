package swing.action;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.Agenda;
import consultorio.AgendaDAO;



public class JAgendarPanelAction extends AbstractAction {

	private JPanel principal;
	private CardLayout cards;

	private JTextField nome;

	public JAgendarPanelAction(JPanel principal, CardLayout cards,
			JTextField nome) {
		super("Agendar");
		this.principal = principal;
		this.cards = cards;
		this.nome = nome;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AgendaDAO ag = new AgendaDAO();
		List<consultorio.Agenda> c = ag.findAgenda("Jessica Dias", "Joao");
		if (c.isEmpty()) {
			System.out.println("Agenda não encontrada!");
			JOptionPane.showMessageDialog(principal.getRootPane(),
					"Agenda não encontrada!", "Operação cancelada",
					JOptionPane.ERROR_MESSAGE);

		} else {
			cards.show(principal, Agenda.PRINCIPAL);
			}
		
		
	}
}