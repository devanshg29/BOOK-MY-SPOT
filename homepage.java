import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homepage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK MY SPOT ");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.ITALIC, 28));
		lblNewLabel.setBounds(105, 86, 230, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				loginpage frame = new loginpage();
				frame.setVisible(true);
				setVisible(false);}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(161, 165, 98, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signuppage frame = new signuppage();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(161, 205, 98, 29);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
		
		
	}
}
