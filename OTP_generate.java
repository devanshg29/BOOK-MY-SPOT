import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class OTP_generate extends JFrame {

	private JPanel contentPane;
	int otp = 0;
	public String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OTP_generate frame = new OTP_generate();
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
	public OTP_generate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Click Here to generate OTP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								Random random =new Random();
				otp=0;
				for(int i=0;i<4;i++)
					otp =  otp *10 + random.nextInt(10);
				JOptionPane.showMessageDialog(null, "Opt ::  "+ otp);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(110, 40, 208, 35);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if (otp ==  0)
					{
						JOptionPane.showMessageDialog(null, "Please Press OTP Generate Button ");
						textArea.setText("");
						return;
					}
					else
					{
						if(Integer.parseInt(textArea.getText())== otp)
						{
							setVisible(false);
							passwordUpdate obj = new passwordUpdate();
							obj.username = username;
							obj.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,"OTP does..... ");
						
							return;
						}
					}
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!(Character.isDigit(e.getKeyChar()))){
	                e.consume();
				}
				
				
			}
		});
		textArea.setBounds(159, 85, 108, 22);
		contentPane.add(textArea);
	}
}
