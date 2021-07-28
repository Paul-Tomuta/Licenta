package ui.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.ModificaEmailButton;
import ui.buttons.ModificaEmailHtmlButton;
import ui.buttons.ModificaMesajButton;
import ui.combo.ComboSMS;
import ui.combo.ComboEmail;
import ui.combo.ComboEmailHtml;

public class ModificaMesajFrame extends JPanel implements ActionListener {

	JLabel titVechi;
	JLabel titHtml;
	
	ComboSMS combo;
	ComboEmail comboEmail;
	ComboEmailHtml comboHtml;
	
	ModificaEmailButton buttonEmail;
	ModificaMesajButton button;
	ModificaEmailHtmlButton buttonHtml;
	
	JLabel titluVechiLabel;
	JLabel txtVechiLabel;
	
	JTextField txtNouField;
	JTextField titNou;
	
	JPanel email;
	JPanel mesaj;
	JPanel html;
	
	JLabel emailTitluLabel;
	JLabel emailTextLabel;
	
	JTextField emailTitluField;
	JTextField emailTextField;
	
	JLabel emailTitluHtmlLabel;
	JLabel emailTextHtmlLabel;
	JTextField emaiHtmlTitluField;
	JTextField emailHtmlTextField;
	

	public ModificaMesajFrame() {
		
		this.mesaj = new JPanel();
		mesaj.setLayout(new BoxLayout(mesaj, BoxLayout.Y_AXIS));
		this.add(mesaj);
		this.titVechi = new JLabel("Selectati SMS");
		this.mesaj.add(titVechi);
		
		this.combo = new ComboSMS(titVechi);
		this.mesaj.add(combo);
		
		this.titluVechiLabel = new JLabel("Introduceti noul titlu");
		this.mesaj.add(titluVechiLabel);
		
		this.titNou = new JTextField(15);
		this.mesaj.add(titNou);
		
		this.txtVechiLabel = new JLabel("Adaugati textul nou");
		this.mesaj.add(txtVechiLabel);
		
		this.txtNouField = new JTextField(15);
		this.mesaj.add(txtNouField);
		
		
		this.email = new JPanel();
		email.setLayout(new BoxLayout(email, BoxLayout.Y_AXIS));
		
///////////////
		this.add(email);
		
		this.emailTitluLabel = new JLabel("Selectati Email");
		this.email.add(emailTitluLabel);
		this.comboEmail = new ComboEmail(emailTitluLabel);
	
		this.email.add(comboEmail);
		
		
		
		this.emailTitluLabel = new JLabel("Introduceti noul titlu");
		this.email.add(emailTitluLabel);
		this.emailTitluField = new JTextField(15);
		this.email.add(emailTitluField);
		
		this.emailTextLabel = new JLabel("Introduceti nou text");
		this.email.add(emailTextLabel);
		this.emailTextField = new JTextField(15);
		this.email.add(emailTextField);
		
///////////
		
		this.html = new JPanel();
		html.setLayout(new BoxLayout(html, BoxLayout.Y_AXIS));
		this.add(html);
		this.titHtml = new JLabel("Selectati mesaj Html");
		this.html.add(titHtml);
		this.comboHtml = new ComboEmailHtml(titHtml);
		this.html.add(comboHtml);
		
	
		this.emailTitluHtmlLabel = new JLabel("Introduceti titlu");
		this.html.add(emailTitluHtmlLabel);
		this.emaiHtmlTitluField = new JTextField(15);
		this.html.add(emaiHtmlTitluField);
		
		this.emailTextHtmlLabel = new JLabel("Introduceti text");
		this.html.add(emailTextHtmlLabel);
		this.emailHtmlTextField = new JTextField(15);
		this.html.add(emailHtmlTextField);
		
		this.buttonHtml = new ModificaEmailHtmlButton(comboHtml, emaiHtmlTitluField, emailHtmlTextField);
		this.html.add(buttonHtml);
		this.buttonHtml.addActionListener(this);

		
		
		this.buttonEmail = new ModificaEmailButton(comboEmail,emailTitluField , emailTextField);
		this.email.add(buttonEmail);
		this.buttonEmail.addActionListener(this);
		
		this.button = new ModificaMesajButton(this.combo, this.titNou, this.txtNouField);
		this.mesaj.add(button);
		this.button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
