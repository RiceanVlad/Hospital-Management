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
 * Clasa SectieGUI reprezinta interfata grafica prin care putem sa adaugam o sectie intr-o clinica
 *
 */
public class SectieGUI extends Test{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void fereastraSectie() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SectieGUI window = new SectieGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private int index;
	private JTextField textField_3;
	/**
	 * Create the application.
	 */
	public SectieGUI() {
		this.index = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 340, 254);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formular adaugare sectie");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 13));
		lblNewLabel.setBounds(44, 10, 177, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField("nr locuri");
		textField.setFont(new Font("Century", Font.PLAIN, 11));
		textField.setBounds(44, 92, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField("clinica");
		textField_2.setFont(new Font("Century", Font.PLAIN, 11));
		textField_2.setBounds(44, 121, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index>0)
					index--;
				textField_2.setText(String.valueOf(clinici.get(index).getClno()));
			}
		});
		btnNewButton.setBounds(44, 150, 51, 21);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index<clinici.size()-1)
					index++;
				textField_2.setText(String.valueOf(clinici.get(index).getClno()));
			}
		});
		btnNewButton_1.setBounds(94, 150, 46, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Add sectie");
		btnNewButton_2.setFont(new Font("Century", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nrSectie=0;
				if(sectii.size()==0) {
					nrSectie = 10;
				}
				else
					nrSectie = sectii.get(sectii.size()-1).getSectno()+10;
				Sectie s = new Sectie(nrSectie,Integer.parseInt(textField.getText()),textField_3.getText(),Integer.parseInt(textField_2.getText()));
				addSectie(s);
				SuccesGUI nw = new SuccesGUI();
				nw.fereastraSucces();
			}
		});
		btnNewButton_2.setBounds(197, 150, 96, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		textField_3 = new JTextField("tip");
		textField_3.setFont(new Font("Century", Font.PLAIN, 11));
		textField_3.setBounds(44, 63, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}

}
