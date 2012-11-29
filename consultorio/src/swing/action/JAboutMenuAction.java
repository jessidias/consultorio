package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class JAboutMenuAction extends AbstractAction {

	private JFrame frame;
	public JAboutMenuAction(JFrame frame) {
		super("Sobre");
		this.frame = frame;
		putValue(SHORT_DESCRIPTION, "Sobre a aplicação.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Mostrar tela com About...");
		JOptionPane.showMessageDialog(frame, "Consultório.\n(c) 2012 Jéssica Dias", "Sobre...", JOptionPane.INFORMATION_MESSAGE);	
	}

}
