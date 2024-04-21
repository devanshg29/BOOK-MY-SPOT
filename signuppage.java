import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


/*
 * Author : Devansh 
 */
public class signuppage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signuppage frame = new signuppage();
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
	public signuppage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name - ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(107, 56, 73, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!(Character.isLetter(e.getKeyChar()))){
	                e.consume();
	            }
			}
		});
		textField.setBounds(190, 46, 152, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username - ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(80, 108, 100, 19);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 101, 152, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Create password - ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(38, 158, 142, 29);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 162, 152, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password -");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(28, 221, 152, 29);
		contentPane.add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char[] input1 = passwordField.getPassword();
				char[] input2 = passwordField_1.getPassword();
				if (input1.length!=input2.length || Arrays.equals(input1,input2) != true ) {
					JOptionPane.showMessageDialog(null, "invalid password enter");
					passwordField.setText("");
					passwordField_1.setText("");
					return;
				}	
				
			}
		});
		passwordField_1.setBounds(190, 221, 152, 27);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				         System.out.println("Congratulations," + 
				              " JDBC connection is established successfully.\n");
				     
				      String u = textField.getText();
				      String n = textField.getText();
				      String p1 = new String(passwordField.getPassword());
				      String p2 = new String(passwordField_1.getPassword());
				      String querry =  "insert into users values('"+u+"','" + p1 + "','" +n + "');";
				      Statement st = con.createStatement();
					  st.executeUpdate(querry);
					  
					  loginpage obj = new loginpage();
					  dispose();
					  obj.setVisible(true);
			      } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    		  
			}
		});
		btnNewButton.setBounds(190, 269, 129, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(359, 269, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
