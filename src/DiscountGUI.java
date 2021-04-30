import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
/**
 * Clasa DiscountGUI reprezinta interfata grafica care ne permite sa adaugam discount tuturor pacientilor
 * care au cel putin 2 vizite anuale la spital.
 *
 */
public class DiscountGUI extends Test{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void fereastraDiscount() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscountGUI window = new DiscountGUI();
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
	public DiscountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 289, 150);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(201,236,255));
		textPane.setFont(new Font("Century", Font.PLAIN, 13));
		textPane.setBounds(10, 10, 265, 103);
		frame.getContentPane().add(textPane);
		textPane.setText("S-a adaugat discount tuturor pacientilor care au cel putin 2 vizite anul acesta!");
	}

}
