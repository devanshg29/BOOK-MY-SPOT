import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class loginpage extends JFrame {

	public userbookingdata user;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
					frame.setLocationRelativeTo(null);
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
	public loginpage() {
		user = new userbookingdata();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username - ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(91, 58, 93, 39);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					passwordField.requestFocus();
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(194, 65, 176, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password  - ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(91, 127, 103, 39);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || new String(passwordField.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Required Fields ..  ");
					textField.requestFocus();
					return;
				}
				
				final String url = "jdbc:mysql:///bookmyspot";
				final String user1 = "root";
				final String password = "root";
				final String p = new String(passwordField.getPassword());
				final String u = textField.getText();
				System.out.println(u + "   " + p);
				// establish the connection
				Connection con = null;
				try {
					con = DriverManager.getConnection(url, user1, password);

					// display status message
					if (con == null) {
						System.out.println("JDBC connection is not established");
						return;
					} else
						System.out.println("Congratulations," + " JDBC connection is established successfully.\n");
					String query = "SELECT * FROM users where username='" + u + "' and password = '" + p + "';";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Welcome " + rs.getString(3) + "To Book My Spot App ",
								"Welcome ", JOptionPane.INFORMATION_MESSAGE);
						
						
						user.name = rs.getString(3);
						user.username = rs.getString(1);
						
						selectcity obj = new selectcity(user);
						//obj.user = user;
						System.out.println(obj.user.name +  "  "+ obj.user.username);
						obj.setVisible(true);
						setVisible(false);
					} else
						JOptionPane.showMessageDialog(null, "Invalid Login", "Please Try Again ",
								JOptionPane.INFORMATION_MESSAGE);
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		passwordField.setBounds(194, 134, 176, 32);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("FORGOT PASSWORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = JOptionPane.showInputDialog("enter Username ");
				final String url = "jdbc:mysql:///bookmyspot";
				final String user = "root";
				final String password = "root";
				Connection con = null;
				try {
					con = DriverManager.getConnection(url, user, password);
					// display status message
					if (con == null) {
						System.out.println("JDBC connection is not established");
						return;
					} else
						System.out.println("Congratulations," + " JDBC connection is established successfully.\n");
					String query = "select * from users where username = '" + username + "';";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					// con.commit();
					if (rs.next()) {
						OTP_generate obj = new OTP_generate( );
						obj.username = username;
						setVisible(false);
						obj.setVisible(true);
					} else {
						int opt = JOptionPane.showConfirmDialog(null,
								"User name Doesn't Exist ? Do you want to try again  ");
						System.out.println(opt);
						if (opt == 0)
							return;
						else {
							new homepage().setVisible(true);
							setVisible(false);
						}
					}
					con.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(131, 211, 162, 21);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
