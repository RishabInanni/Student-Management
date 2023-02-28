package StudentManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField username;
	private JPasswordField password;
	String userString,passwordString;
	
	ResultSet resultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setconnection() {
		
		 userString = username.getText();
		 passwordString = password.getText();
		 
		try {
			
			Connection connection = DBconnection.getConnection();
			String string = "select * from signup where username=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(string);
		
			preparedStatement.setString(1,userString );
			preparedStatement.setString(2, passwordString);
			
			
			 resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Main m=new Main();
				m.setVisible(true);
				this.dispose();
				
			}
			else {
				JOptionPane.showMessageDialog(this, "username or password donot match");
				username.setText("");
				password.setText("");
				username.requestFocus();
			}
		
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 721);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 11, 521, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(131, 48, 366, 37);
		panel.add(lblNewLabel);
		
		JLabel User = new JLabel("UserName");
		User.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		User.setBounds(49, 173, 149, 83);
		contentPane.add(User);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lblNewLabel_1.setBounds(49, 267, 131, 77);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(192, 199, 199, 35);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(190, 283, 201, 35);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setconnection();
			}
		});
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 11));
		btnNewButton.setBounds(244, 455, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setFont(new Font("Sitka Heading", Font.BOLD, 11));
		btnNewButton_1.setBounds(369, 455, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New User");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Newuser().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(109, 455, 114, 23);
		contentPane.add(btnNewButton_2);
	}
}
