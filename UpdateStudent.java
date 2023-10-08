package studentmanagmentsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class UpdateStudent extends JFrame {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs;

	private JPanel contentPane;
	private JTextField updateEntry;
	private JTextField nameU;
	private JTextField entryU;
	private JTextField emailU;
	private JTextField contactU;
	private JTextField homeU;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 656);
		contentPane = new JPanel();
//		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		
		nameU = new JTextField();
		nameU.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
        lblStudentName.setForeground(Color.BLACK);
        lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblStudentName.setBounds(127, 261, 140, 20);
        add(lblStudentName);

        JLabel lblEntryNumber = new JLabel("Entry Number");
        lblEntryNumber.setForeground(Color.BLACK);
        lblEntryNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEntryNumber.setBounds(127, 312, 116, 20);
        add(lblEntryNumber);

        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setForeground(Color.BLACK);
        lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEmailAddress.setBounds(127, 363, 116, 20);
        add(lblEmailAddress);

        JLabel lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setForeground(Color.BLACK);
        lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblContactNumber.setBounds(127, 414, 140, 20);
        add(lblContactNumber);

        JLabel lblHomeCity = new JLabel("Home City");
        lblHomeCity.setForeground(Color.BLACK);
        lblHomeCity.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblHomeCity.setBounds(127, 465, 116, 20);
        add(lblHomeCity);
        
        nameU = new JTextField();
        nameU.setBounds(310, 256, 237, 33);
        add(nameU);
        nameU.setColumns(10);

        entryU = new JTextField();
        entryU.setBounds(310, 307, 237, 33);
        add(entryU);
        entryU.setColumns(10);

        emailU = new JTextField();
        emailU.setBounds(310, 358, 237, 33);
        add(emailU);
        emailU.setColumns(10);

        contactU = new JTextField();
        contactU.setBounds(310, 409, 237, 33);
        add(contactU);
        contactU.setColumns(10);

        homeU = new JTextField();
        homeU.setBounds(310, 460, 237, 33);
        add(homeU);
        homeU.setColumns(10);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	
				
				try {
                                     Class.forName("com.mysql.cj.jdbc.Driver");
					String query = "UPDATE `student` SET name=?, entrynumber=?, email=?, contactnumber=?, homecity=? WHERE entrynumber=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "root1");
					pst=con.prepareStatement(query);
					
					String pid = updateEntry.getText();
					pst.setString(1, nameU.getText());
					pst.setString(2, entryU.getText());
					pst.setString(3, emailU.getText());
					pst.setString(4, contactU.getText());
					pst.setString(5, homeU.getText());
					pst.setString(6, pid);
					if(nameU.getText().equals("") || entryU.getText().equals("") || emailU.getText().equals("") || contactU.getText().equals("") || homeU.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all the details :");
					}
					else {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updated Successfully :");
						dispose();
						Menu menu = new Menu();
						menu.show();
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
				
				
				
				
				
			}
		});
		updateBtn.setForeground(Color.BLACK);
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(updateBtn);
                updateBtn.setBounds(300, 510, 120, 30);
		updateEntry = new JTextField();
		updateEntry.setBounds(190, 100, 237, 33);
		add(updateEntry);
		updateEntry.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String str = updateEntry.getText();
				try {
                                     //Class.forName("com.mysql.cj.jdbc.Driver");
                                     
					con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "root1");
					pst = con.prepareStatement("SELECT * FROM student where entrynumber = ?");
					pst.setString(1, str);
					rs = pst.executeQuery();
					if(rs.next()==true) {
						 String s = rs.getString(1);
						 String s1 = rs.getString(2);
						 String s2 = rs.getString(3);
						 String s3 = rs.getString(4);
						 String s4 = rs.getString(5);
						
						 nameU.setText(s);
						 entryU.setText(s1);
						 emailU.setText(s2);
						 contactU.setText(s3);
						 homeU.setText(s4);
					}
					
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(334, 164, 149, 33);
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.show();
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(143, 164, 149, 33);
		add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Search the \"Entry Number\"");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(180, 56, 283, 33);
		add(lblNewLabel);
                
           
                
                
		contentPane.setLayout(null);
	}
}
