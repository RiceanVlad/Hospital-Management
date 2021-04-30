import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
/**
 * Clasa SuccesGUI reprezinta interfata grafica care ne arata ca s-a creat o instanta cu succes(pacient, sectie, clinica)
 *
 */
public class SuccesGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void fereastraSucces() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuccesGUI window = new SuccesGUI();
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
	public SuccesGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 195, 161);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adaugare cu succes!");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 34, 161, 53);
		frame.getContentPane().add(lblNewLabel);
	}

}
