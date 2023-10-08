package studentmanagmentsystem;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JPasswordField password;

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

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 459, 450);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel loginUsername = new JLabel("Username");
        loginUsername.setForeground(Color.BLACK);
        loginUsername.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        loginUsername.setBounds(60, 150, 100, 30);

        JLabel loginPassword = new JLabel("Password");
        loginPassword.setForeground(Color.BLACK);
        loginPassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        loginPassword.setBounds(60, 200, 100, 30);

        username = new JTextField();
        username.setColumns(10);
        username.setBounds(200, 150, 200, 30);

        password = new JPasswordField();
        password.setBounds(200, 200, 200, 30);

        JButton login = new JButton("Login");
        login.setForeground(Color.BLACK);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (username.getText().equals("admin") && password.getText().equals("admin123")) {
                    Menu menuPage = new Menu();
                    menuPage.show();
                    dispose();
                } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Username or Password :");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password :");
                }

            }
        });
        login.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        login.setBounds(180, 250, 100, 30);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.GRAY);
        desktopPane.setBounds(60, 47, 300, 50); 

        JLabel loginpage = new JLabel("Login");
        loginpage.setForeground(Color.BLACK);
        loginpage.setBounds(100, 20, 75, 27);
        desktopPane.add(loginpage);
        loginpage.setFont(new Font("Perpetua Titling MT", Font.BOLD, 22));

        contentPane.setLayout(null);
        contentPane.add(loginUsername);
        contentPane.add(username);
        contentPane.add(loginPassword);
        contentPane.add(password);
        contentPane.add(login);
        contentPane.add(desktopPane);  
    }
}
