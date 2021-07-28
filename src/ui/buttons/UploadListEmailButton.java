package ui.buttons;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import ui.Command;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import date.Persoana;
import date.XLSXReaderExample;

public class UploadListEmailButton extends JButton implements Command {

	JLabel text;

	public UploadListEmailButton(JLabel txt) {
		super("Incarca fisier");

		this.text = txt;

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