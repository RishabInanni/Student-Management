package StudentManagement;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class course extends JFrame {

	private JPanel contentPane;
	private JTextField field1;
	private JTextField field2;
	private JButton btnNewButton;
	private JButton btnCancle;
	private JComboBox combo;

	String coursename,duration,time;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					course frame = new course();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setconnection() {
		boolean isadded = false;
		 coursename = field1.getText();
		 duration = field2.getText();
		 time =  combo.getSelectedItem().toString();
		 
		try {
			
			Connection connection = DBconnection.getConnection();
			String string = "Insert into course values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(string);
			
			
			
		
			preparedStatement.setString(1,coursename);
			preparedStatement.setString(2, duration);
			preparedStatement.setString(3, time);
			
			
			
			int resultSet = preparedStatement.executeUpdate();
			
			if(resultSet >0) {
				isadded = true;
				JOptionPane.showMessageDialog(this, "added successfully");
				
			}
		
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}

	/**
	 * Create the frame.
	 */
	public course() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("course");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(146, 213, 113, 23);
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("duration");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(146, 312, 113, 23);
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lblNewLabel_1);
		
		field1 = new JTextField();
		field1.setBounds(374, 216, 174, 23);
		contentPane.add(field1);
		field1.setColumns(10);
		
		field2 = new JTextField();
		field2.setBounds(374, 311, 174, 23);
		field2.setColumns(10);
		contentPane.add(field2);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setconnection();
			}
			
		});
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 22));
		btnNewButton.setBounds(195, 427, 106, 46);
		contentPane.add(btnNewButton);
		
		btnCancle = new JButton("cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnCancle.setFont(new Font("Sitka Heading", Font.BOLD, 22));
		btnCancle.setBounds(365, 427, 106, 46);
		contentPane.add(btnCancle);
		
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"year", "month", "week"}));
		combo.setBounds(581, 311, 75, 22);
		contentPane.add(combo);
	}
}
