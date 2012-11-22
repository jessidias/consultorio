package swing;

import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class JAboutAction extends AbstractAction {

	public JAboutAction() {
		super("Sobre");
		putValue(SHORT_DESCRIPTION, "Sobre a aplica��o.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Mostrar tela com About...");
	}

}
