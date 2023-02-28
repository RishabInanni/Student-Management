package StudentManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("course");
		btnNewButton.setBackground(Color.RED);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new course().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnNewButton.setBounds(74, 255, 150, 88);
		contentPane.add(btnNewButton);
	
		
		
		JButton btnBatch = new JButton("Batch");
		btnBatch.setBackground(Color.BLUE);
		btnBatch.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnBatch.setBounds(325, 255, 150, 88);
		contentPane.add(btnBatch);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.setBackground(Color.MAGENTA);
		btnRegistration.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnRegistration.setBounds(568, 255, 150, 88);
		contentPane.add(btnRegistration);
	}
}
