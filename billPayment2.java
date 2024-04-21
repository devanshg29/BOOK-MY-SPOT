import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * Author : Devansh 
 */
public class billPayment2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billPayment2 frame = new billPayment2(new userbookingdata());
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
	userbookingdata user ;
	private JTextField txtCardNumber;
	private JTextField txtCvc;
	private JTextField txtEnterPhoneOr;
	private JTextField txtMmyy;
	public billPayment2(userbookingdata user ) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.user = user;
		getContentPane().setLayout(null);
		user.billamount = user.selectedseats.size()*100;
		String labeltext = user.selectedseats.size() +" cars booking \nYour Bill = " + (user.selectedseats.size()*100);
		JLabel lblNewLabel = new JLabel(labeltext);
		lblNewLabel.setBounds(10, 11, 254, 39);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 61, 278, 188);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Debit/Credit Details", null, panel, null);
		panel.setLayout(null);
		
		txtCardNumber = new JTextField();
		txtCardNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
					e.consume();
				}
				if(txtCardNumber.getText().length() == 12)
					e.consume();
				
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCardNumber.getText().length() == 3 || txtCardNumber.getText().length() == 7)
					txtCardNumber.setText(txtCardNumber.getText()+" ");
			}
		});
		txtCardNumber.setText("Card Number");
		txtCardNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCardNumber.getText().trim().equals(""))
					txtCardNumber.setText("Card Number");
			     
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCardNumber.getText().trim().equals("Card Number"))
					txtCardNumber.setText("");
			}
		});
		txtCardNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtCardNumber.setBounds(45, 11, 144, 20);
		panel.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtCvc = new JTextField();
		txtCvc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
					e.consume();
				}
				if(txtCvc.getText().length() == 3)
					e.consume();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtCvc.getText().length() == 3)
					e.consume();
			}
		});
		txtCvc.setText("CVC");
		txtCvc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCvc.getText().trim().equals("CVC"))
					txtCvc.setText("");
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCvc.getText().trim().equals(""))
					txtCvc.setText("CVC");
			}
		});
		txtCvc.setBounds(43, 39, 86, 20);
		panel.add(txtCvc);
		txtCvc.setColumns(10);
		
		txtMmyy = new JTextField();
		txtMmyy.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtMmyy.getText().length() == 2 )
					txtMmyy.setText(txtMmyy.getText()+"/");
				
				if(txtMmyy.getText().length() == 5)
					e.consume();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
					e.consume();
				}
				if(txtMmyy.getText().length() == 5)
					e.consume();
			}
		});
		txtMmyy.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMmyy.getText().trim().equals("MM/YY"))
					txtMmyy.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMmyy.getText().trim().equals(""))
					txtMmyy.setText("MM/YY");
			}
		});
		txtMmyy.setText("MM/YY");
		txtMmyy.setBounds(43, 64, 86, 20);
		panel.add(txtMmyy);
		txtMmyy.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("UPI/Wallet", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtEnterPhoneOr = new JTextField();
		txtEnterPhoneOr.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtEnterPhoneOr.getText().trim().equals("Enter Phone or UPI ID"))
					txtEnterPhoneOr.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterPhoneOr.getText().trim().equals(""))
					txtEnterPhoneOr.setText("Enter Phone or UPI ID");
			}
		});
		txtEnterPhoneOr.setText("Enter Phone or UPI ID");
		txtEnterPhoneOr.setBounds(40, 11, 142, 20);
		panel_1.add(txtEnterPhoneOr);
		txtEnterPhoneOr.setColumns(10);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabbedPane.getSelectedIndex() == 0)
				{
					if ( txtCardNumber.getText().trim().equals("") ||  txtCardNumber.getText().trim().equals("Card Number"))
					{
						JOptionPane.showMessageDialog(null, "Please Enter Card Number ");
						return;
					}
					if ( txtCvc.getText().trim().equals("") ||  txtCvc.getText().trim().equals("CVC")) 
					{
						JOptionPane.showMessageDialog(null, "Please Enter CVC Number ");
						return;
					}
					if (txtCvc.getText().trim().equals("") ||  txtCvc.getText().trim().equals("MM/YY") )
					{
						JOptionPane.showMessageDialog(null, "Please Valid Date ");
						return;
						
					}
				}
				else if (tabbedPane.getSelectedIndex() == 1) {
				if ( (txtEnterPhoneOr.getText().equals("") ||  txtEnterPhoneOr.getText().equals("Enter Phone or UPI ID")))
						
					JOptionPane.showMessageDialog(null, "Please Enter Phone number or UPI ID ");
					return;
				}
				
				//System.out.print(txtCardNumber.getText() + txtCardNumber.getText()+ txtEnterPhoneOr.getText() + dateChooser.getDateEditor().getDate());
				final String url = "jdbc:mysql:///bookmyspot";
				final String user1 = "root";
				final String password = "root";
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
					
					String query = "select count(*) from bookingdata ";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					rs.next();
					int i = rs.getInt(1);			
					System.out.println("Booking " + i);
					for (int j= 0; j< user.selectedseats.size() ; j++)
					{
						String insertQ = "insert into bookingdata values ( " + ++i + ",' "+user.selectedseats.get(j)+ "', '" + (String)user.carnumbers.get(j) +" ', '" 
								+  user.bookingdate +"' , '" + user.username + "', '"+ user.mallid + "' );"; 
						System.out.println(user.mallid);
						st.executeUpdate(insertQ);
					}
					
					query = "update mallparking set " ;
					for (String s : user.selectedvar)
					{
						query += s +" = 'Y' ,";
					}
					query = query.substring(0, query.length()-1);
					query += " where mallname = '"+ user.mallname+ "';";
					
					st.executeUpdate(query);
					
					con.close();
					finalBill obj = new finalBill(user);
					obj.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(291, 19, 89, 23);
		contentPane.add(btnNewButton);
	}
}
