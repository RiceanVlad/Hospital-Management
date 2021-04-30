import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
/**
 * 
 * Clasa PacientGUI reprezinta interfata grafica prin care se poate adauga un pacient intr-o sectie
 *
 */
public class PacientGUI extends Test{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void fereastraPacient() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacientGUI window = new PacientGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private int index;
	private JTextField textField_6;
	/**
	 * Create the application.
	 */
	public PacientGUI() {
		this.index = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 350, 361);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField("nume");
		textField.setFont(new Font("Century", Font.PLAIN, 11));
		textField.setBounds(39, 45, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("prenume");
		textField_1.setFont(new Font("Century", Font.PLAIN, 11));
		textField_1.setBounds(39, 91, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("cnp");
		textField_2.setFont(new Font("Century", Font.PLAIN, 11));
		textField_2.setBounds(39, 120, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("data internare");
		textField_3.setFont(new Font("Century", Font.PLAIN, 11));
		textField_3.setBounds(39, 149, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField("data externare");
		textField_4.setFont(new Font("Century", Font.PLAIN, 11));
		textField_4.setBounds(39, 178, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField("sectii");
		textField_5.setFont(new Font("Century", Font.PLAIN, 11));
		textField_5.setBounds(39, 237, 96, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index<sectii.size()-1)
					index++;
				textField_5.setText(String.valueOf(sectii.get(index).getSectno()));
			}
		});
		btnNewButton.setBounds(88, 266, 47, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index>0)
					index--;
				textField_5.setText(String.valueOf(sectii.get(index).getSectno()));
			}
		});
		btnNewButton_1.setBounds(39, 266, 49, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Pacient");
		btnNewButton_2.setFont(new Font("Century", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pacient p = new Pacient(textField_2.getText(),textField.getText(),textField_1.getText(),
						Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_5.getText()));
				addPacient(p);
				addDataIE(p.getCnp(),textField_3.getText(),textField_4.getText());
				SuccesGUI nw = new SuccesGUI();
				nw.fereastraSucces();
			}
		});
		btnNewButton_2.setBounds(206, 267, 111, 19);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Formular adaugare pacient");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 0, 198, 41);
		frame.getContentPane().add(lblNewLabel);
		
		textField_6 = new JTextField("abonament");
		textField_6.setFont(new Font("Century", Font.PLAIN, 11));
		textField_6.setBounds(39, 207, 96, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
