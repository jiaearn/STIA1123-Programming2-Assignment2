package my.husco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener, FocusListener {

    JButton login, cancel;
    JLabel label1, label2;
    JTextField userName;
    JPasswordField password;
    JCheckBox checkBox;

    public LoginPage() {

        label1 = new JLabel();
        label1.setText("Username : ");
        label1.setBounds(25, 10, 150, 50);
        add(label1);

        userName = new JTextField();
        userName.setText("Name & Pass: 123");
        userName.setForeground(Color.LIGHT_GRAY);

        userName.addFocusListener(this);
        userName.setBounds(95, 25, 150, 20);
        add(userName);

        label2 = new JLabel();
        label2.setBounds(25, 40, 150, 50);
        label2.setText("Password  : ");
        add(label2);

        password = new JPasswordField();
        password.setBounds(95, 55, 150, 20);
        add(password);

        checkBox = new JCheckBox("Show Password");
        checkBox.setBounds(25, 80, 150, 20);
        checkBox.addActionListener(this);
        add(checkBox);

        login = new JButton("LOGIN");
        login.setBounds(25, 110, 100, 30);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("CANCEL");
        cancel.setBounds(145, 110, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setResizable(false);
        setLayout(null);
        setTitle("Sign In");
        setSize(290, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        requestFocusInWindow();

    }

    public void actionPerformed(ActionEvent e) {

        String name = userName.getText();
        String passwordText = String.valueOf(password.getPassword());

        if (e.getSource() == login) {
            if (name.equals("123") && passwordText.equals("123")) {
                JOptionPane.showMessageDialog(this, "Login Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
                new MenuPage();
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == cancel) {
            QuitMenu quitMenu = new QuitMenu();
            quitMenu.quitMenu2();
            this.dispose();
        }

        if(checkBox.isSelected()) {
            password.setEchoChar((char)0);
        }
        else {
            password.setEchoChar('*');
        }

    }

    public static void main(String[] args) {
        new LoginPage();
    }

    @Override
    public void focusGained(FocusEvent e) {
        String hint = userName.getText();
        if (hint.equals("Name & Pass: 123")) {
            userName.setText("");
            userName.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        String hint = userName.getText();
        if (hint.equals("")) {
            userName.setText("Name & Pass: 123");
            userName.setForeground(Color.GRAY);
        }
    }

}
