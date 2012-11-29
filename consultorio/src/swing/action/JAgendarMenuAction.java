package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JAgendarMenuAction extends AbstractAction {
	public static final String AGENDAR1 = "AGENDAR1";

	private JPanel principal;
	private CardLayout cards;
	
	public JAgendarMenuAction(JPanel principal, CardLayout cards) {
		super("Agendar Consulta");
		this.principal = principal;
		this.cards = cards;
	}

	public void actionPerformed(ActionEvent e) {
		cards.show(principal, AGENDAR1);
	}

}
