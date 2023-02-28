package StudentManagement;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class registration extends JFrame {

	private JPanel contentPane;
	private JTextField f1;
	private JTextField f2;
	private JTextField f3;
	private JTextField f4;
	private JRadioButton r1;
	private JRadioButton r2;
	@SuppressWarnings("rawtypes")
	private JComboBox textcourses;
	@SuppressWarnings("rawtypes")
	private JComboBox textbatch;
	private JTextArea textArea;
	ResultSet rs,rs1,rs2;
	PreparedStatement preparedStatement, preparedStatement1,preparedStatement2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void batches() {
		 
		try {
			
			Connection connection = DBconnection.getConnection();
			String string = "select * from batch";
			 preparedStatement2 = connection.prepareStatement(string);
			 rs1 = preparedStatement2.executeQuery();
			while (rs1.next()) {
				String batches = rs1.getString("batch");
				textbatch.addItem(batches);
			}
			
			
		
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
	}
	
	public void  courses() {
	try {
			
			Connection connection = DBconnection.getConnection();
			String string = "select * from course";
			 preparedStatement1 = connection.prepareStatement(string);
			 rs2 = preparedStatement1.executeQuery();
			
			while (rs2.next()) {
				String courses = rs2.getString("coursename");
				textcourses.addItem(courses);
			}
			
			
		
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	
	public void setconnection() {
		
		 String firstname = f1.getText();
		 String lastname = f2.getText();
		 String nc = f3.getText();
		 String gender;
		 if(r1.isSelected()) {
			 gender="male";
		 }
		 else {
			 gender="female";
		 }
		 
		 String course =  textcourses.getSelectedItem().toString();
		 String batch =  textbatch.getSelectedItem().toString();
		 String telephone = f4.getText();
		 String address = textArea.getText();
		 
		 
		try {
			
			Connection connection = DBconnection.getConnection();
			String string = ("Insert into registration(firstname,lastname,nc,gender,course,batch,telephone,address) values(?,?,?,?,?,?,?,?)");
			PreparedStatement preparedStatement = connection.prepareStatement(string);
		
			preparedStatement.setString(1,firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, nc);
			preparedStatement.setString(4, gender);
			preparedStatement.setString(5, course);
			preparedStatement.setString(6, batch);
			preparedStatement.setString(7, telephone);
			preparedStatement.setString(8, address);
			
			int resultSet = preparedStatement.executeUpdate();
			
		
			f1.setText("");
			f2.setText("");
			f3.setText("");
			textcourses.setSelectedIndex(-1);
			textbatch.setSelectedIndex(-1);
            f4.setText("");
            textArea.setText("");
            f1.requestFocus();
			
			
			
			
			if(resultSet > 0) {
		
				JOptionPane.showMessageDialog(this, "registered successfully");
				
			}
			
		
			} catch (Exception e2) {
				// TODO: handle exception
			 
			}
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public registration() { 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 686, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 678, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("registration");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 26));
		lblNewLabel.setBounds(250, 28, 331, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("first name");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 129, 85, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("last name");
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_2.setBounds(33, 189, 85, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("nc");
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_3.setBounds(33, 263, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("gender");
		lblNewLabel_4.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_4.setBounds(33, 321, 85, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("course");
		lblNewLabel_5.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_5.setBounds(33, 388, 72, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("batch");
		lblNewLabel_6.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_6.setBounds(33, 459, 85, 22);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telephone");
		lblNewLabel_7.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_7.setBounds(33, 532, 85, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblNewLabel_8.setBounds(33, 598, 85, 14);
		contentPane.add(lblNewLabel_8);
		
		f1 = new JTextField();
		f1.setBounds(137, 128, 165, 23);
		contentPane.add(f1);
		f1.setColumns(10);
		
		f2 = new JTextField();
		f2.setColumns(10);
		f2.setBounds(137, 188, 165, 23);
		contentPane.add(f2);
		
		f3 = new JTextField();
		f3.setColumns(10);
		f3.setBounds(137, 258, 165, 23);
		contentPane.add(f3);
		
		 r1 = new JRadioButton("Male");
		r1.setBounds(135, 315, 111, 23);
		contentPane.add(r1);
		
	    r2 = new JRadioButton("Female");
		r2.setBounds(248, 315, 111, 23);
		contentPane.add(r2);
		
	    textbatch = new JComboBox();
		textbatch.setBounds(137, 457, 165, 22);
		contentPane.add(textbatch);
		
		f4 = new JTextField();
		f4.setBounds(137, 527, 165, 22);
		contentPane.add(f4);
		f4.setColumns(10);
		
		 textArea = new JTextArea();
		textArea.setBounds(137, 591, 165, 76);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setconnection();
			}
		});
		btnNewButton.setBounds(387, 296, 104, 61);
		contentPane.add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
				
			}
		});
		btnCancle.setBounds(518, 296, 104, 61);
		contentPane.add(btnCancle);
		
		 textcourses = new JComboBox();
		textcourses.setName("");
		textcourses.setBounds(137, 382, 165, 22);
		contentPane.add(textcourses);
		
		
		courses();
		batches();
	}
}
