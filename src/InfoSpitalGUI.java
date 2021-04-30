import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
/**
 * Clasa InfoSpitalGUI reprezinta interfata graficac prin care se pot afla informatii despre fiecare clinica in parte
 * sau despre intreg spitalul
 *
 */
public class InfoSpitalGUI extends Test{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void fereastraInfoSpital() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoSpitalGUI window = new InfoSpitalGUI();
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
	public InfoSpitalGUI() {
		this.index = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 600, 531);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField("clinica");
		textField.setFont(new Font("Century", Font.PLAIN, 11));
		textField.setBounds(53, 75, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(201,236,255));
		textPane.setFont(new Font("Century", Font.PLAIN, 12));
		textPane.setBounds(245, 40, 312, 411);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index<clinici.size()-1)
					index++;
				textField.setText(clinici.get(index).getNume());
			}
		});
		btnNewButton.setBounds(101, 104, 48, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index>0)
					index--;
				textField.setText(clinici.get(index).getNume());
			}
		});
		btnNewButton_1.setBounds(52, 104, 53, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Info clinica");
		btnNewButton_2.setFont(new Font("Century", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String continut = addPacientiInSectii(clinici.get(index));
				textPane.setText(continut);
			}
		});
		btnNewButton_2.setBounds(53, 135, 96, 19);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Info spital");
		btnNewButton_3.setFont(new Font("Century", Font.PLAIN, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infoSpital = internariExternari();
				textPane.setText(infoSpital);
			}
		});
		btnNewButton_3.setBounds(53, 378, 96, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Informatii spital");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 26, 148, 21);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
