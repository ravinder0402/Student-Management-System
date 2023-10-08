package studentmanagmentsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JDesktopPane;

public class Student extends JFrame {

    private JPanel contentPane;
    private JTextField sname;
    private JTextField sentry;
    private JTextField semail;
    private JTextField scontact;
    private JTextField shome;

    private Connection con = null;
    private PreparedStatement pst = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Student frame = new Student();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Student() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 620);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel studentDetails = new JLabel("Student Details");
        studentDetails.setForeground(Color.BLACK);
        studentDetails.setFont(new Font("Perpetua Titling MT", Font.BOLD, 22));
        studentDetails.setBounds(180, 10, 238, 37);
        contentPane.add(studentDetails);

        JLabel studentName = new JLabel("Student Name");
        studentName.setForeground(Color.BLACK);
        studentName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        studentName.setBounds(30, 80, 130, 25);
        contentPane.add(studentName);

        JLabel entryNumber = new JLabel("Entry Number");
        entryNumber.setForeground(Color.BLACK);
        entryNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        entryNumber.setBounds(30, 120, 130, 25);
        contentPane.add(entryNumber);

        JLabel emailAddress = new JLabel("Email Address");
        emailAddress.setForeground(Color.BLACK);
        emailAddress.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        emailAddress.setBounds(30, 160, 130, 25);
        contentPane.add(emailAddress);

        JLabel contactNumber = new JLabel("Contact Number");
        contactNumber.setForeground(Color.BLACK);
        contactNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        contactNumber.setBounds(30, 200, 150, 25);
        contentPane.add(contactNumber);

        sname = new JTextField();
        sname.setBounds(190, 80, 237, 25);
        contentPane.add(sname);
        sname.setColumns(10);

        sentry = new JTextField();
        sentry.setBounds(190, 120, 237, 25);
        contentPane.add(sentry);
        sentry.setColumns(10);

        semail = new JTextField();
        semail.setBounds(190, 160, 237, 25);
        contentPane.add(semail);
        semail.setColumns(10);

        scontact = new JTextField();
        scontact.setBounds(190, 200, 237, 25);
        contentPane.add(scontact);
        scontact.setColumns(10);

        JLabel homeCity = new JLabel("Home City");
        homeCity.setForeground(Color.BLACK);
        homeCity.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        homeCity.setBounds(30, 240, 130, 25);
        contentPane.add(homeCity);

        shome = new JTextField();
        shome.setBounds(190, 240, 237, 25);
        contentPane.add(shome);
        shome.setColumns(10);

        JButton submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String query = "INSERT INTO `student`(`name`, `entrynumber`, `email`, `contactnumber`, `homecity`) VALUES (?, ?, ?, ?, ?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "root1");
                    pst = con.prepareStatement(query);
                    pst.setString(1, sname.getText());
                    pst.setString(2, sentry.getText());
                    pst.setString(3, semail.getText());
                    pst.setString(4, scontact.getText());
                    pst.setString(5, shome.getText());
                    if (sname.getText().equals("") || sentry.getText().equals("") || semail.getText().equals("")
                            || scontact.getText().equals("") || shome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the details :(");
                    } else {
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Student added Successfully :)");
                        dispose();
                        Menu menu = new Menu();
                        menu.show();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));
        submit.setBounds(190, 300, 120, 30);
        contentPane.add(submit);

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
        btnCancel.setBounds(330, 300, 120, 30);
        contentPane.add(btnCancel);
    }
}
