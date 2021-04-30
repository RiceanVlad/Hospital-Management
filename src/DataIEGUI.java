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
 * Clasa DadaIEGUI reprezinta interfata grafica prin care se poate adauga data de internare/externare a unui pacient
 *
 */
public class DataIEGUI extends Test{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void fereastraDataIE() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataIEGUI window = new DataIEGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private int index;
	/**
	 * Create the application.
	 */
	public DataIEGUI() {
		this.index = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 382, 326);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formular adaugare data internare/externare");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 21, 312, 43);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField("nume");
		textField.setFont(new Font("Century", Font.PLAIN, 11));
		textField.setBounds(33, 74, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("prenume");
		textField_1.setFont(new Font("Century", Font.PLAIN, 11));
		textField_1.setBounds(33, 103, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("cnp");
		textField_2.setFont(new Font("Century", Font.PLAIN, 11));
		textField_2.setBounds(33, 132, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("abonament");
		textField_3.setFont(new Font("Century", Font.PLAIN, 11));
		textField_3.setBounds(33, 161, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField("sectie");
		textField_4.setFont(new Font("Century", Font.PLAIN, 11));
		textField_4.setBounds(33, 190, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index<pacienti.size()-1) {
					index++;
				}
				textField.setText(pacienti.get(index).getNume());
				textField_1.setText(pacienti.get(index).getPrenume());
				textField_2.setText(pacienti.get(index).getCnp());
				textField_3.setText(String.valueOf(pacienti.get(index).getAbonament()));
				textField_4.setText(String.valueOf(pacienti.get(index).getSectno()));
				
			}
		});
		btnNewButton.setBounds(83, 219, 46, 19);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index>0) {
					index--;
				}
				textField.setText(pacienti.get(index).getNume());
				textField_1.setText(pacienti.get(index).getPrenume());
				textField_2.setText(pacienti.get(index).getCnp());
				textField_3.setText(String.valueOf(pacienti.get(index).getAbonament()));
				textField_4.setText(String.valueOf(pacienti.get(index).getSectno()));
				
			}
		});
		btnNewButton_1.setBounds(33, 219, 51, 19);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_5 = new JTextField("data internare");
		textField_5.setFont(new Font("Century", Font.PLAIN, 11));
		textField_5.setBounds(186, 74, 96, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField("data externare");
		textField_6.setFont(new Font("Century", Font.PLAIN, 11));
		textField_6.setBounds(186, 103, 96, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Add internare/externare");
		btnNewButton_2.setFont(new Font("Century", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDataIE(pacienti.get(index).getCnp(),textField_5.getText(),textField_6.getText());
				SuccesGUI nw = new SuccesGUI();
				nw.fereastraSucces();
			}
		});
		btnNewButton_2.setBounds(186, 211, 159, 33);
		frame.getContentPane().add(btnNewButton_2);
	}

}
