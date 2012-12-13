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

	private JTextField nomep;

	public JAgendarPanelAction(JPanel principal, CardLayout cards,
			JTextField nomep) {
		super("Cadastrar");
		this.principal = principal;
		this.cards = cards;
		this.nomep = nomep;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AgendaDAO ag = new AgendaDAO();
		ag.insertAgenda(nomep.getText());
		//if (c == null) {
			//System.out.println("Agenda não encontrada!");
			//JOptionPane.showMessageDialog(principal.getRootPane(),
				//	"Agenda não encontrada!", "Operação cancelada",
				//	JOptionPane.ERROR_MESSAGE);

		//} 	if (principal != null) {
			//cards.show(principal, Agenda.PRINCIPAL);
			//}
		
	
	
	if (principal != null){
		
		cards.show(principal,Agenda.PRINCIPAL);
	}
	}
}