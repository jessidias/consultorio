package swing;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class JAgendarAction extends AbstractAction {

	public JAgendarAction() {
		super("Agendar Consulta");
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Agenda...");
	}

}
