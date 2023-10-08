package studentmanagmentsystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 623);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);
        desktopPane.setBounds(10, 11, 414, 562);
        contentPane.add(desktopPane);

        JButton btnNewButton = new JButton("Add Student");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student studentDetails = new Student();
                studentDetails.show();
                dispose();
            }
        });
        btnNewButton.setBounds(32, 37, 287, 47);
        desktopPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Remove Existing Student");
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoveStudent remove = new RemoveStudent();
                remove.show();
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_1.setBounds(32, 113, 287, 52);
        desktopPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("View Students");
        btnNewButton_2.setForeground(Color.BLACK);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewStudent viewStudent = new ViewStudent();
                viewStudent.show();
                dispose();
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_2.setBounds(32, 195, 287, 52);
        desktopPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Update Existing Student");
        btnNewButton_3.setForeground(Color.BLACK);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateStudent updateStudent = new UpdateStudent();
                updateStudent.show();
                dispose();
            }
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_3.setBounds(32, 272, 287, 52);
        desktopPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Logout");
        btnNewButton_4.setForeground(Color.BLACK);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login logout = new Login();
                logout.show();
                dispose();
                JOptionPane.showMessageDialog(null, "Successfully logged out:)");
            }
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_4.setBounds(32, 348, 287, 47);
        desktopPane.add(btnNewButton_4);

        JLabel lblNewLabel = new JLabel("What do you want?");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel.setBounds(93, 5, 220, 27);
        desktopPane.add(lblNewLabel);
        contentPane.setLayout(null);

       

    }
}
