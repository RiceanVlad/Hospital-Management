import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
/**
 * Clasa ClinicaGUI reprezinta interfata grafica prin care se poate adauga o clinica in spital
 *
 */
public class ClinicaGUI extends Test{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void fereastraClinica() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicaGUI window = new ClinicaGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClinicaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 361, 253);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formular adaugare clinica");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 13));
		lblNewLabel.setBounds(45, 10, 186, 35);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField("nume");
		textField.setFont(new Font("Century", Font.PLAIN, 11));
		textField.setBounds(45, 55, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("Spitalul Municipal Medias");
		textField_1.setFont(new Font("Century", Font.PLAIN, 11));
		textField_1.setBounds(45, 84, 148, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add clinica");
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nrClinica = 0;
				int dim = clinici.size();
				if(dim!=0) {
					nrClinica = clinici.get(dim-1).getClno() + 100;
				}
				else
					nrClinica = 100;
				Clinica c = new Clinica(nrClinica,textField.getText(),1000);
				addClinica(c);
				SuccesGUI nw = new SuccesGUI();
				nw.fereastraSucces();
			}
		});
		btnNewButton.setBounds(220, 156, 102, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
