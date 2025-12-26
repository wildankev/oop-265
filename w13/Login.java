import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    private String correctUsername = "wilkev";
    private String correctPassword = "000";
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JFrame frame;

    public static void main(String[] args) {
        Login gui = new Login();
        gui.go();
    }

    public void go() {
        frame = new JFrame("Login System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");

        txtUsername = new JTextField(20);
        txtPassword = new JTextField(20);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(350, 150);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String inputUser = txtUsername.getText();
            String inputPass = txtPassword.getText();

            if (correctUsername.equals(inputUser) && correctPassword.equals(inputPass)) {
                JOptionPane.showMessageDialog(frame, "Login Berhasil! Selamat datang, " + inputUser);
            } else {
                JOptionPane.showMessageDialog(frame, "Login Gagal! Username atau Password salah", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }
}