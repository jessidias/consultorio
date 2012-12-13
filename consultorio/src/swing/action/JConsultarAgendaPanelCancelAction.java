package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.Agenda;

@SuppressWarnings("serial")
public class JConsultarAgendaPanelCancelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JConsultarAgendaPanelCancelAction(JPanel principal, CardLayout cards) {
		super("Sair");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			cards.show(principal, Agenda.PRINCIPAL);
		}

	}
}
