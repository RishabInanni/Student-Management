package StudentManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Newuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
private JComboBox comboBox;
String userString,passwordString,chooseString;
	/**
	 * Launch the application.
	 */
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newuser frame = new Newuser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public boolean check() {
//		if(passwordField.getText()==passwordField_2.getText()) {
			String password = passwordField.getText();
			boolean exists = false;
			
//		}
//		else {
			
//		}
		
		
	try {
			
			Connection connection = DBconnection.getConnection();
			String string = "select * from signup where password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(string);
			
			
		
			preparedStatement.setString(1,password);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				exists = true;
			}
			else {
				exists = false;
			}
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
		return exists;
	}
	

	
	public void setconnection() {
		boolean isadded = false;
		
		 userString = textField.getText();
		 chooseString = comboBox.getSelectedItem().toString();
		 passwordString = passwordField.getText();
		 String pwdString =passwordField_2.getText();
		
		 if(passwordString.equals(pwdString)) {
			 
			 try {
					
					Connection connection = DBconnection.getConnection();
					String string = "Insert into signup(username,password,usertype) values(?,?,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(string);
				
					preparedStatement.setString(1,userString );
					preparedStatement.setString(2, passwordString);
					preparedStatement.setString(3, chooseString);
					
					int resultSet = preparedStatement.executeUpdate();
					System.out.println("lauda");
					if(resultSet >0) {
						isadded = true;
						
					}
				
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
			}

	else {
		JOptionPane.showMessageDialog(this, "password mismatched");
	}

	}	
	
	
	public boolean validation() {
		
		boolean issame = false;;
		
		 if((passwordField.getText()).equals(passwordField_2.getText())) {
			issame = true;
		 }

	else {
	   issame =false;
		JOptionPane.showMessageDialog(this, "password mismatched");
	}
      return issame;
	}	

		
		
	/**
	 * Create the frame.
	 */
	public Newuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		lblNewLabel.setBounds(42, 123, 181, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(42, 194, 181, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		lblNewLabel_2.setBounds(42, 276, 181, 43);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(177, 123, 280, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 196, 280, 34);
		contentPane.add(passwordField);
		
//		passwordField_1 = new JPasswordField();
//		passwordField_1.setBounds(404, 285, -127, 20);
//		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(177, 276, 280, 34);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Type");
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		lblNewLabel_3.setBounds(42, 362, 134, 34);
		contentPane.add(lblNewLabel_3);
		
		JList list = new JList();
		list.setBounds(355, 424, -180, -42);
		contentPane.add(list);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		comboBox.setBounds(186, 362, 271, 34);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(check()==false && validation()==true) {
				setconnection();
				JOptionPane.showMessageDialog(btnNewButton, "added successfully");
			}
			if(check() == true ) {
				JOptionPane.showMessageDialog(btnNewButton,"Password already exists");
			}
				
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnNewButton.setBounds(180, 468, 97, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(ABORT);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnNewButton_1.setBounds(321, 468, 97, 34);
		contentPane.add(btnNewButton_1);
	}
}

