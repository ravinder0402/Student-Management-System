package studentmanagmentsystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import studentmanagmentsystem.Menu;

public class RemoveStudent extends JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;
    private JPanel contentPane;
    private JTextField deleteEntry;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RemoveStudent frame = new RemoveStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RemoveStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400); // Adjusted the frame size
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);
        desktopPane.setBounds(10, 10, 464, 341); // Adjusted the bounds
        contentPane.add(desktopPane);

        deleteEntry = new JTextField();
        deleteEntry.setBounds(111, 40, 206, 29);
        desktopPane.add(deleteEntry);
        deleteEntry.setColumns(10);

        JButton deleteData = new JButton("Delete");
        deleteData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String query = "DELETE FROM student WHERE entrynumber=?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "root1");
                    pst = con.prepareStatement(query);
                    String pid = deleteEntry.getText();
                    pst.setString(1,pid);
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        dispose();
                        Menu menu = new Menu();
                        menu.show();
                        JOptionPane.showMessageDialog(null, "Deleted Successfully:)");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        deleteData.setForeground(Color.BLACK);
        deleteData.setBounds(130, 80, 167, 37); // Adjusted the bounds
        desktopPane.add(deleteData);
        deleteData.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton btnCancel = new JButton("Cancel"); // Renamed from btnNewButton_1 to btnCancel
        btnCancel.setForeground(Color.BLACK);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.show();
                dispose();
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.setBounds(130, 130, 167, 37); // Adjusted the bounds
        desktopPane.add(btnCancel);

        JLabel lblNewLabel = new JLabel("Enter the \"Entry Number\" of the student");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(10, 10, 408, 25);
        desktopPane.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.setLayout(null);
    }
}
