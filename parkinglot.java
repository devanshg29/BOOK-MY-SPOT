import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

class colorToggleButton extends JToggleButton {
	public void paintBackground(Graphics G) {
		Color bg;
		if (isSelected()) {
			bg = Color.GREEN;
		} else {
			bg = Color.GRAY;
		}
		setBackground(bg);
		super.paintComponents(G);
	}
}

public class parkinglot extends JFrame {

	private JPanel contentPane;
	public userbookingdata user;
	public static int count = 0;
	JToggleButton[] var;
	List <String> selectedvar = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parkinglot frame = new parkinglot(new userbookingdata());
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
	public parkinglot(userbookingdata user) {
		this.user = user;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 89, 416, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JToggleButton P1 = new JToggleButton("101");
		
		P1.setBackground(new Color(192, 192, 192));
		P1.setBounds(10, 10, 72, 21);
		panel.add(P1);
		P1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P" + Integer.parseInt(P1.getText()) % 100;
				if(P1.isSelected() && P1.isEnabled()) {
					System.out.println(P1.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P1.getText());
					count++;
					P1.setBackground(Color.green);
				}
				else if (P1.isSelected() == false && P1.isEnabled()) {
					P1.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P1.getText()));
				
					count--;
				}
			}
		});
		JToggleButton P2 = new JToggleButton("102");
		P2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P" + Integer.parseInt(P2.getText()) % 100;
				if(P2.isSelected() && P2.isEnabled()) {
					System.out.println(P2.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P2.getText());
					count++;
					P2.setBackground(Color.green);
				}
				else if (P2.isSelected() == false && P2.isEnabled()) {
					P2.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P2.getText()));

					count--;
				}
			}
		});
		P2.setBackground(new Color(192, 192, 192));
		P2.setBounds(10, 64, 72, 21);
		panel.add(P2);
		
		JToggleButton P3 = new JToggleButton("103");
		P3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P3";// + Integer.parseInt(P3.getText()) % 100;
				if(P3.isSelected() && P3.isEnabled()) {
					System.out.println(P3.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P3.getText());
					count++;
					P3.setBackground(Color.green);
				}
				else if (P3.isSelected() == false && P3.isEnabled()) {
					P3.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P3.getText()));

					count--;
				}
			}
		});
		P3.setBackground(new Color(192, 192, 192));
		P3.setBounds(10, 117, 72, 21);
		panel.add(P3);
		
		JToggleButton P4 = new JToggleButton("201");
		P4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P4";// + Integer.parseInt(P4.getText()) % 100;
				if(P4.isSelected() && P4.isEnabled()) {
					System.out.println(P4.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P4.getText());
					count++;
					P4.setBackground(Color.green);
				}
				else if (P4.isSelected() == false && P4.isEnabled()) {
					P4.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					count--;
					user.selectedseats.remove(user.selectedseats.indexOf(P4.getText()));

				}
			}
		});
		P4.setBackground(new Color(192, 192, 192));
		P4.setBounds(92, 10, 72, 21);
		panel.add(P4);
		
		JToggleButton P5 = new JToggleButton("202");
		P5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P5";// + Integer.parseInt(P5.getText()) % 100;
				if(P5.isSelected() && P5.isEnabled()) {
					System.out.println(P5.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P5.getText());
					count++;
					P5.setBackground(Color.green);
				}
				else if (P5.isSelected() == false && P5.isEnabled()) {
					P5.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P5.getText()));

					count--;
				}
			}
		});
		P5.setBackground(new Color(192, 192, 192));
		P5.setBounds(92, 64, 72, 21);
		panel.add(P5);
		
		JToggleButton P6 = new JToggleButton("203");
		P6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P6";// + Integer.parseInt(P6.getText()) % 100;
				if(P6.isSelected() && P6.isEnabled()) {
					System.out.println(P6.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P6.getText());
					count++;
					P6.setBackground(Color.green);
				}
				else if (P6.isSelected() == false && P6.isEnabled()) {
					P6.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P6.getText()));

					count--;
				}
			}
		});
		P6.setBackground(new Color(192, 192, 192));
		P6.setBounds(92, 117, 72, 21);
		panel.add(P6);
		
		JToggleButton P7 = new JToggleButton("301");
		P7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P7";// + Integer.parseInt(P7.getText()) % 100;
				if(P7.isSelected() && P7.isEnabled()) {
					System.out.println(P7.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P7.getText());
					count++;
					P7.setBackground(Color.green);
				}
				else if (P7.isSelected() == false && P7.isEnabled()) {
					P7.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P7.getText()));

					count--;
				}
			}
		});
		P7.setBackground(new Color(192, 192, 192));
		P7.setBounds(174, 10, 72, 21);
		panel.add(P7);
		
		JToggleButton P8 = new JToggleButton("302");
		P8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P8";// + Integer.parseInt(P8.getText()) % 100;
				if(P8.isSelected() && P8.isEnabled()) {
					System.out.println(P8.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					user.selectedseats.add(P8.getText());
					P8.setBackground(Color.green);
				}
				else if (P8.isSelected() == false && P8.isEnabled()) {
					P8.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P8.getText()));

					count--;
				}
			}
		});
		P8.setBackground(new Color(192, 192, 192));
		P8.setBounds(174, 64, 72, 21);
		panel.add(P8);
		
		JToggleButton P9 = new JToggleButton("303");
		P9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P9";// + Integer.parseInt(P9.getText()) % 100;
				if(P9.isSelected() && P9.isEnabled()) {
					System.out.println(P9.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					user.selectedseats.add(P9.getText());
					P9.setBackground(Color.green);
				}
				else if (P9.isSelected() == false && P9.isEnabled()) {
					P9.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P9.getText()));

					count--;
				}
			}
		});
		P9.setBackground(new Color(192, 192, 192));
		P9.setBounds(174, 117, 72, 21);
		panel.add(P9);
		
		JToggleButton P10 = new JToggleButton("401");
		P10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P10";// + Integer.parseInt(P10.getText()) % 100;
				if(P10.isSelected() && P10.isEnabled()) {
					System.out.println(P10.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					user.selectedseats.add(P10.getText());
					P10.setBackground(Color.green);
				}
				else if (P10.isSelected() == false && P10.isEnabled()) {
					P10.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P10.getText()));

					count--;
				}
			}
		});
		P10.setBackground(new Color(192, 192, 192));
		P10.setBounds(256, 10, 72, 21);
		panel.add(P10);
		
		JToggleButton P11 = new JToggleButton("402");
		P11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P11";// + Integer.parseInt(P11.getText()) % 100;
				if(P11.isSelected() && P11.isEnabled()) {
					System.out.println(P11.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					user.selectedseats.add(P11.getText());
					P11.setBackground(Color.green);
				}
				else if (P11.isSelected() == false && P11.isEnabled()) {
					P11.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P11.getText()));

					count--;
				}
			}
		});
		P11.setBackground(new Color(192, 192, 192));
		P11.setBounds(261, 64, 67, 21);
		panel.add(P11);
		
		JToggleButton P12 = new JToggleButton("403");
		P12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P12";// + Integer.parseInt(P12.getText()) % 100;
				if(P12.isSelected() && P12.isEnabled()) {
					System.out.println(P12.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					P12.setBackground(Color.green);
					user.selectedseats.add(P12.getText());

				}
				else if (P12.isSelected() == false && P12.isEnabled()) {
					P12.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P12.getText()));

					count--;
				}
			}
		});
		P12.setBackground(new Color(192, 192, 192));
		P12.setBounds(256, 117, 72, 21);
		panel.add(P12);
		
		JToggleButton P13 = new JToggleButton("501");
		P13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P13" ;//+ Integer.parseInt(P13.getText()) % 100;
				if(P13.isSelected() && P13.isEnabled()) {
					System.out.println(P13.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					user.selectedseats.add(P13.getText());
					P13.setBackground(Color.green);
				}
				else if (P13.isSelected() == false && P13.isEnabled()) {
					P13.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P13.getText()));

					count--;
				}
			}
		});
		P13.setBackground(new Color(192, 192, 192));
		P13.setBounds(338, 10, 68, 21);
		panel.add(P13);
		
		JToggleButton P14 = new JToggleButton("502");
		P14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P14" ;//+ Integer.parseInt(P14.getText()) % 100;
				if(P14.isSelected() && P14.isEnabled()) {
					System.out.println(P14.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					user.selectedseats.add(P14.getText());
					count++;
					P14.setBackground(Color.green);
				}
				else if (P14.isSelected() == false && P14.isEnabled()) {
					P14.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P14.getText()));

					count--;
				}
			}
		});
		P14.setBackground(new Color(192, 192, 192));
		P14.setBounds(338, 64, 68, 21);
		panel.add(P14);
		
		JToggleButton P15 = new JToggleButton("503");
		P15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new colorToggleButton();
				String name = "P15" ;//+ Integer.parseInt(P15.getText()) % 100;
				if(P15.isSelected() && P15.isEnabled()) {
					System.out.println(P15.isSelected() + "  "+ name );
					selectedvar.add(name+"");
					count++;
					user.selectedseats.add(P15.getText());
					P15.setBackground(Color.green);
				}
				else if (P15.isSelected() == false && P15.isEnabled()) {
					P15.setBackground(new Color(192, 192, 192));
					selectedvar.remove(selectedvar.indexOf(name+""));
					user.selectedseats.remove(user.selectedseats.indexOf(P15.getText()));
					count--;
				}
			}
		});
		P15.setBackground(new Color(192, 192, 192));
		P15.setBounds(338, 117, 68, 21);
		panel.add(P15);
		
		JLabel lblNewLabel = new JLabel("P1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 54, 45, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblP = new JLabel("P2");
		lblP.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP.setBounds(121, 54, 45, 25);
		contentPane.add(lblP);
		
		JLabel lblP_1 = new JLabel("P3");
		lblP_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_1.setBounds(205, 54, 45, 25);
		contentPane.add(lblP_1);
		
		JLabel lblP_2 = new JLabel("P4");
		lblP_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_2.setBounds(288, 54, 45, 25);
		contentPane.add(lblP_2);
		
		JLabel lblP_3 = new JLabel("P5");
		lblP_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_3.setBounds(366, 54, 45, 25);
		contentPane.add(lblP_3);
		
		JLabel lblmallname = new JLabel("New label");
		lblmallname.setHorizontalAlignment(SwingConstants.CENTER);
		lblmallname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblmallname.setBounds(26, 11, 290, 39);
		contentPane.add(lblmallname);
		JLabel lblusername = new JLabel(user.name);
		lblusername.setBounds(326, 11, 85, 14);
		contentPane.add(lblusername);
		
		final String url = "jdbc:mysql:///bookmyspot";
	    final String user1 = "root";
	    final String password = "root";
	    Connection con = null;
	    try {
	    	con = DriverManager.getConnection(url, user1, password);
			lblmallname.setText(user.mallname);
			JButton btnbook = new JButton("Book");
			// display status message
	        if (con == null) {
	         System.out.println("JDBC connection is not established");
	         return;
	        } 
	        else
	         System.out.println("Congratulations," + 
	              " JDBC connection is established successfully.\n");
		      
		    String query = "select * from mallparking where mallname = '"+user.mallname+"';";
		    Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query) ;
			var = new JToggleButton[]{P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P15};
			if(rs.next())
			{
				user.mallid = rs.getString(1);
			  int i = 0;
				  for(JToggleButton v : var)
				  {
					  System.out.println(rs.getString(3+i));
					  if (rs.getString(3+i).equals("Y")) {
						  v.setBackground(Color.red);
						  v.setEnabled(false);
					  }
					  i++;
				  }
			  }
			  btnbook.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opt = JOptionPane.showConfirmDialog(null, "Sure? You want to book ?", "Book My Spot Booking ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						
						if (opt == 0) {
							
							for(String s : user.selectedseats)
							{	System.out.println(s);
								user.carnumbers.add(JOptionPane.showInputDialog(this, "enter Car number for "+ s));							
							}user.selectedvar = selectedvar;
							billPayment1 obj  = new billPayment1(user);							
							obj.setVisible(true);
						}
						else {
							return;
						}
					}
				});
				btnbook.setBounds(326, 33, 85, 21);
				contentPane.add(btnbook);
				
				
			  
		      
	      } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}
}
