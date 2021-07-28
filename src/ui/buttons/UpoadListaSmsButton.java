package ui.buttons;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

import date.Persoana;
import date.XLSXReaderExample;
import ui.Command;

public class UpoadListaSmsButton extends JButton implements Command {

	JLabel text;

	public UpoadListaSmsButton(JLabel t) {
		super("Incara Lista sms");

		this.text = t;
	}

	public void execute() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String file_path = selectedFile.getAbsolutePath();
			ArrayList<Persoana> persoane = XLSXReaderExample.incarcaFisier(file_path);
			for (Persoana persoana : persoane) {
				persoana.insertPersoana();
			}
		}

	}

}
